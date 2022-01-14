package com.p2.recApp.registration;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/registration")
@AllArgsConstructor

public class ResgistrationController {
	
	private RegistrationService registrationService;
	
	public String register(@RequestBody RegistrationRequest request) {
		
		return registrationService.register(request);
		
	}

}
