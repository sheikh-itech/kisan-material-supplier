package org.kisan.apis;

import org.kisan.dto.login.Login;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Hapheej
 *
 */

@RestController
@RequestMapping(value="/authorize/login")
public class LoginApi {

	@RequestMapping(value="/user", method=RequestMethod.POST, consumes="application/json")
	public Login registerKisan(@RequestBody Login login) {
		try {
			System.out.println(login);
		} catch(DuplicateKeyException mex) {
			return login;
		} catch(Exception ex) {
			return login;
		}
		
		return login;
	}
	
	@RequestMapping(value="/hello")
	public String hello() {
		return "hello";
	}
}
