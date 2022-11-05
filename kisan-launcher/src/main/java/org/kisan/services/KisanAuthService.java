package org.kisan.services;

import java.util.Optional;

import org.kisan.dao.repos.UserRepository;
import org.kisan.dto.beans.UserDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class KisanAuthService implements UserDetailsService {

	@Autowired
	private UserRepository userRepo;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<UserDetail> user = userRepo.findByUsername(username);
		user.orElseThrow(()->new UsernameNotFoundException("User Not Found: "+username));
		return user.get();
	}
}
