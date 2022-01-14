package com.p2.recApp.users;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/*************************************Works Cited*********************************************
 * Title: "Spring Boot Tutorial | Spring Boot Full Stack with React.js | Full Course | 2021"
 * Author: Nelson (amigoscode)
 * Date: 3/28/20 (Accessed 12/29/21)
 * Code Version: Java 15
 * Availability: https://youtu.be/i-hoSg8iRG0
 *********************************************************************************************/

@RestController
@RequestMapping("/api/v1/users")
@CrossOrigin("*")
public class UserController {
	

	private UserRepository userRepository;
	private final UserService userService;
	
	@Autowired
	public UserController(UserService userService, UserRepository userRepository) {
		this.userService = userService;
		this.userRepository = userRepository;
	}
	
	@GetMapping
	public List<User> getUserProfiles(){
		return userService.getUserProfiles();
		
		//do the request body thing
		
	}
	
//	@GetMapping("/{userID}")
//	public Optional<User> getUserByID(@PathVariable("userID") Integer userID){
//		return userRepository.findById(userID);
//		
//		//do the request body thing
//		
//	}
	@GetMapping("/{username}")
	public Optional<User> getUserByUsername(@PathVariable("username") String username){
		return userRepository.findByUsername(username);
		
		//do the request body thing
		
	}
	//this throws an error with the conversion of json to an integer, but doesn't crash the program 
	@PostMapping(
			path = "{userID}/image/upload",
			consumes = MediaType.MULTIPART_FORM_DATA_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	public void uploadUserProfileImage(@PathVariable("userID") Integer userID,
									   @RequestParam("file") MultipartFile file) {
		
		System.out.println(userID);

//		Integer userID = Integer.parseUnsignedInt(userIDS);
		userService.uploadUserProfileImage(userID, file);
		
	}
	
	 @GetMapping("{userID}/image/download")
	    public byte[] downloadUserProfileImage(@PathVariable("userID") Integer userID) {
		 	System.out.println("hello from download");
	        return userService.downloadUserProfileImage(userID);
	    }
	
	
}
