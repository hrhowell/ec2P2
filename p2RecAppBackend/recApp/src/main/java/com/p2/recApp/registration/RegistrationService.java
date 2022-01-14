package com.p2.recApp.registration;

import org.springframework.stereotype.Service;

import com.p2.recApp.users.User;
import com.p2.recApp.users.UserRole;
import com.p2.recApp.users.UserService;

@Service
public class RegistrationService {
	
	private  UserService userService;

	private  EmailValidator emailValidator;
	
	public String register(RegistrationRequest request) {
	
		boolean isValidEmail = emailValidator.test(request.getEmail());
		if(!isValidEmail) {
			throw new IllegalStateException("email not valid");
		}
		return userService.signUpUser(
				new User(
						
						request.getFirstname(),
						request.getLastname(),
						request.getEmail(),
						request.getUsername(),
						request.getPassword(),
						UserRole.USER
						
						)
				);
	}

}
