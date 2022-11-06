package org.kisan.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kisan.security.util.AuthenticationUtil;
import org.kisan.services.KisanAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.SignatureException;

@Service
public class KisanRequestHandler extends OncePerRequestFilter {

    @Autowired
    private KisanAuthService userDetailsService;

    @Autowired
    private AuthenticationUtil authUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {

        final String authorizationHeader = request.getHeader("f-friendly");

        String username = "";
        String token = "";

        if (authorizationHeader != null && authorizationHeader.startsWith("fKisan+")) {
        	
        	token = authorizationHeader.substring(7);
            try {
            	username = authUtil.extractUsername(token);
            } catch (IllegalArgumentException ex) {
                logger.error("An error occured during getting username from token", ex);
            } catch (ExpiredJwtException ex) {
                logger.warn("The token is expired and not valid anymore");
            } catch(SignatureException ex){
                logger.error("Authentication Failed. Username or Password not valid.");
            } catch(Exception ex) {
            	logger.error("Server error", ex);
            }
        }

        if (!username.isBlank() && SecurityContextHolder.getContext().getAuthentication() == null) {

            UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);

            if (authUtil.validateToken(token, userDetails)) {

                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());
                usernamePasswordAuthenticationToken
                        .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }
        chain.doFilter(request, response);
    }
    
    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException 
    {
    	String path = request.getRequestURI();
    	
    	return (path.indexOf("/kisan")>10 || path.indexOf("/authenticate")>10);
    }
}
