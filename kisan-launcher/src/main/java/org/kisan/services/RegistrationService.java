package org.kisan.services;

import javax.validation.ConstraintViolationException;

import org.kisan.dao.repos.UserRepository;
import org.kisan.dto.beans.UserDetail;
import org.kisan.exceptions.DuplicateUsernameException;
import org.kisan.security.util.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

	@Autowired
	private PasswordEncoder encoder;
	@Autowired
	private UserRepository userRepo;
	
	public UserDetail registerUserDetails(UserDetail user) throws Exception {
		
		UserDetail response = null;
		ValidationUtil.validateUser(user);
		user.setPassword(encoder.encode(user.getPassword()));
		try {
			response = userRepo.save(user);
			
		} catch(Exception ex) {
			
			if(ex.getCause() instanceof ConstraintViolationException)
				filterErrorMessage(user, ex.getCause());
			throw new Exception("Not able to save user detail");
		}
		
		return response;
	}

	private void genarateErrorMessageForUser(UserDetail user, String error) throws Exception {
		error = error.toLowerCase();
		if(error.contains(user.getUsername()) || error.contains("username"))
			throw new DuplicateUsernameException("Duplicate username");
		throw new Exception(error);
	}
	
	private void filterErrorMessage(UserDetail user, Throwable th) throws Exception {
		
		String message=null, error=null;
		if(th.getCause()!=null)
			message = th.getCause().getMessage();
		error = (message!=null) ? message.substring(0, message.indexOf(";")) : "Constraint violation problem";
		
		genarateErrorMessageForUser(user, error);
	}
}
