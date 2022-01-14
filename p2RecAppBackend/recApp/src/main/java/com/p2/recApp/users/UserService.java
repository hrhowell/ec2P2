package com.p2.recApp.users;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import static org.apache.http.entity.ContentType.*;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.p2.recApp.bucket.BucketName;
import com.p2.recApp.filestore.FileStore;

import lombok.AllArgsConstructor;
/*************************************Works Cited*********************************************
 * Title: "Java Tutorial - Complete User Login and Registration Backend + Email Verification"
 * Author: Nelson (amigoscode)
 * Date: 1/17/21 (Accessed 12/29/21)
 * Code Version: Java 15
 * Availability: https://youtu.be/QwQuro7ekvc
 * 
 * Title: "Spring Boot Tutorial | Spring Boot Full Stack with React.js | Full Course | 2021"
 * Author: Nelson (amigoscode)
 * Date: 3/28/20 (Accessed 12/29/21)
 * Code Version: Java 15
 * Availability: https://youtu.be/i-hoSg8iRG0
 *********************************************************************************************/

@Service


public class UserService/* implements UserDetailsService*/ {



	private final FileStore fileStore;
	private final UserRepository userRepository;
	private String username;
	private String password;
	private String email;
	private String firstname;
	private String lastname;
	private String profile_pic;
	
	
	public String signUpUser(User user) {

		boolean userExists = userRepository.findByEmail(user.getEmail()).isPresent();

		if(userExists) {
			throw new IllegalStateException("email taken");
		}

		
		userRepository.save(user);

		

		return "user added!";
	}
	
	public String updateUser(User user) {
		
		boolean userExists = userRepository.findByEmail(user.getEmail()).isPresent();
		
		System.out.println("userExists:*********************************" + userExists);

		if(!userExists) {
			throw new IllegalStateException("user doesn't exist");
		}
		
		String username = user.getUsername();
		String password = user.getPassword();
		String email = user.getEmail();
		String firstname = user.getFirstname();
		String lastname = user.getLastname();
		//String profile_pic = this.profile_pic;
		
		user.setUsername(username);
		user.setPassword(password);
		user.setEmail(email);
		user.setFirstname(firstname);
		user.setLastname(lastname);
		
		userRepository.save(user);
		
		return "updated";
	}

	@Autowired
	public UserService(UserRepository userRepository, FileStore fileStore) {
		this.fileStore = fileStore;
		this.userRepository = userRepository;
	}

	List <User> getUserProfiles(){

		return userRepository.findAll();
	}
	

	void uploadUserProfileImage(Integer userID, MultipartFile file) {
        // 1. Check if image is not empty
        isFileEmpty(file);
        // 2. If file is an image
        isImage(file);

        // 3. The user exists in our database
        User user = getUserProfileOrThrow(userID);
        
        // 4. Grab some metadata from file if any
        Map<String, String> metadata = extractMetadata(file);

        // 5. Store the image in s3 and update database (userProfileImageLink) with s3 image link
        String path = String.format("%s/%s", BucketName.PROFILE_IMAGE.getBucketName(), user.getUserID());
        String filename = String.format("%s-%s", file.getOriginalFilename(), UUID.randomUUID());
        
        try {
        	
            fileStore.save(path, filename, Optional.of(metadata), file.getInputStream());
            user.setProfile_pic(filename);
            userRepository.save(user);
            
           System.out.println(filename);
           System.out.println(path);
          ;
          System.out.println(user.getProfile_pic());
          
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }

    }
	
	  byte[] downloadUserProfileImage(Integer userID) {
	        User user = getUserProfileOrThrow(userID);

	        String path = String.format("%s/%s",
	                BucketName.PROFILE_IMAGE.getBucketName(),
	                user.getUserID());
	        System.out.println(user);
	        System.out.println(path);
	        System.out.println(user.getProfile_pic());
	        return user.getProfile_pic()
	                .map(key -> fileStore.download(path, key))
	                .orElse(new byte[0]);

	    }
		
		
		private Map<String, String> extractMetadata(MultipartFile file) {
	        Map<String, String> metadata = new HashMap<>();
	        metadata.put("Content-Type", file.getContentType());
	        metadata.put("Content-Length", String.valueOf(file.getSize()));
	        return metadata;
	    }
		
		//throws an exception about string to integer
		  private User getUserProfileOrThrow(Integer userID) {
		        return userRepository
		                .findById(userID)
		                .orElseThrow(() -> new IllegalStateException(String.format("User profile %s not found", userID)));
		    }
		  private void isImage(MultipartFile file) {
		        if (!Arrays.asList(
		                IMAGE_JPEG.getMimeType(),
		                IMAGE_PNG.getMimeType(),
		                IMAGE_GIF.getMimeType()).contains(file.getContentType())) {
		            throw new IllegalStateException("File must be an image [" + file.getContentType() + "]");
		        }
		    }

		    private void isFileEmpty(MultipartFile file) {
		        if (file.isEmpty()) {
		            throw new IllegalStateException("Cannot upload empty file [ " + file.getSize() + "]");
		        }
		    }


	

}