package com.p2.recApp.login;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.amazonaws.services.cognitoidp.model.UserNotFoundException;
import com.p2.recApp.configuration.ConfigClass;
import com.p2.recApp.users.*;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
@RestController
//@RequestMapping("/api/v1/login")
//@RequestMapping("/api")
@CrossOrigin("*")
public class LoginController {
	public static String userPassword = " ";
	@Autowired
	private UserService userService;
//	private PostRepository postRepository;
	@Autowired
	public UserRepository userRepository;
	
	//public UserService userService;
	
	User user;
	String userRol="";
	
	@GetMapping("/users")
	public List<User> login() {
		return this.userRepository.findAll();
	}

	
	//public User user;
	//9090/users/1/test
	@PostMapping("/users/login/{username}/{password}")
	public String login1(@PathVariable String username, @PathVariable String password) {
		
		
//		AnnotationConfigApplicationContext  context = new AnnotationConfigApplicationContext(ConfigClass.class);
//		LoginPOJO login = context.getBean("loginPOJO", LoginPOJO.class);
//		login.loginData();
		
		Optional<User> uname = userRepository.findByUsername(username);
		User user = uname.get();
		String name = user.getFirstname();
		
		System.out.println(" username ***********: "+ user);
		userPassword = user.getPassword();
		
		if(user.getPassword().equals(password)) {
			UserRole role = user.getUserRole();
			if(role.equals(UserRole.ADMIN)){
				return "ADMIN";
			}else {
//				return "ok";
				return name;
			}
			
		}else {
			return "no";		
		}
		
	}

	
	//public User user;
		//9090/users/1/test
		@PostMapping("/users/loginWithStatus/{username}/{password}")
		public String loginWithStatus(@PathVariable String username, @PathVariable String password) {
			Optional<User> uname = userRepository.findByUsername(username);
			//Optional<User> upassword = userRepository.findByPassword(password);
			
			User user = uname.get();
			System.out.println(" username ***********: "+ user);
//			if(user.getUserRol().equals("admin")) {
//				userRol = "admin";
//			}else {
//				userRol = "user";		
//			}
			
			if(user.getPassword().equals(password)) {
				return "ok";
			}else {
				return "no";		
			}
			
		}
	//public User user;
	//9090/users?id=1&username=test
	@GetMapping("/users/req")
	public Optional<User> login2(@RequestParam int id, @RequestParam String username) {
		return this.userRepository.findByUserID(id);
	}
	
	
	@PostMapping("/users/login")
	//@MessageMapping("/users/login")
    public String getUserLogin(@RequestBody User user) {
		System.out.println("User:____________" + user);
		System.out.println(" username ***********: "+ user.getUsername());
		//System.out.println("User:____________" + user);
        Optional<User> userData = userRepository.findByUsername(user.getUsername());
        User _user = userData.get();
        //System.out.println(" username ***********: "+ user.getUsername());
        
        return "ok";
	}
	
	@PostMapping("/users/signup/{firstname}/{lastname}/{email}/{username}/{password}")
	//@MessageMapping("/users/signup")
    public String userSignup(@PathVariable String firstname, @PathVariable String lastname, @PathVariable String email, @PathVariable String username, @PathVariable String password) {
		User user = new User(firstname, lastname, email, username, password);
		//UserRole userRole = "USER;
		user.setUserRole(UserRole.USER);
		
		userRepository.save(user);
		//userService.signUpUser(user);
		System.out.println("User:____________" + user);
		System.out.println(" username ***********: "+ user.getUsername());
//        Optional<User> userData = userRepository.findByUsername(user.getUsername());
//        User _user = userData.get();
        //System.out.println(" username ***********: "+ user.getUsername());
        
        return "ok";
	}
	
	@PostMapping("/users/UpdateProfile/{firstname}/{lastname}/{email}/{username}/{password}")
	//@MessageMapping("/users/signup")
    public String UpdateProfile(@PathVariable String firstname, @PathVariable String lastname, @PathVariable String email, @PathVariable String username, @PathVariable String password) {
		
		User user = new User(firstname, lastname, email, username, password);
		System.out.println("Update_User:____________" + user);
		
		String update = userService.updateUser(user);
		System.out.println("update:____________" + update);

//		if(update.equals("updated")) {
//			return "ok";
//		}
		System.out.println("User:____________" + user);
		System.out.println(" username ***********: "+ user.getUsername());
              
        return "ok";
	}
		
}
