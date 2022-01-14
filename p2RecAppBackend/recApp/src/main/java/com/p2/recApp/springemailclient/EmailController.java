package com.p2.recApp.springemailclient;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.p2.recApp.ingredients.Ingredient;
import com.p2.recApp.ingredients.IngredientService;
import com.p2.recApp.login.LoginController;
import com.p2.recApp.shopinglist.ShopingList;
import com.p2.recApp.shopinglist.ShopingListRepository;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/email")
public class EmailController {
 
	
	private IngredientService ingredientService;
	private EmailSenderService emailSenderService;
	public ShopingListRepository shopingListRepository;
	
	@Autowired
	public EmailController(EmailSenderService emailSenderService, IngredientService ingredientService, ShopingListRepository shopingListRepository) {
		this.ingredientService = ingredientService;
		this.emailSenderService = emailSenderService;
		this.shopingListRepository = shopingListRepository;
	}
	
	@PostMapping("/email-sent/{email}") 
	public String EmailInfo( @PathVariable String email) {
		String password  = LoginController.userPassword;
		String temp = "We are very sorry for this inconvience but don't worry, we got you!\n\nHere is your password: "+ password +"\n\nThank you,\nThymeCrunch Tech Team";
		emailSenderService.sendSimpleEmail(email,
				temp,
				"Lost Password");
//		return "redirect:/login";
		return "ok";
	}
	
//	public void sendRecipeEmail(String toEmail, String body, String subject) 
	@PostMapping("/recipe-email-sent/{email}/{recipeName}") 
	public String RecipeEmailInfo( @PathVariable String email, @PathVariable String recipeName) {

		List<Ingredient> userRecipe = ingredientService.getByRec(recipeName);
		String temp = " ";
		
		for(Ingredient a: userRecipe) {
			temp +=a.ingName + "\n";
			System.out.println(a.ingName);
		}
		
		System.out.println("temp++++++++" + temp);
		System.out.println("userEmail ##################" + email);
		emailSenderService.sendRecipeEmail(email, temp,
				"Yummmmy! Enjoy!");
//		return "redirect:/home";
		return "ok";
	}
	
//	public void sendRecipeEmail(String toEmail, String body, String subject) 
	@PostMapping("/shoppinglist-email-sent/{email}/{username}") 
	public String ShopingListEmailInfo( @PathVariable String email, @PathVariable String username) {
		
		List<ShopingList> shopinglist = shopingListRepository.findByUsername(username);
		
		String temp = " ";
		
		for(ShopingList a: shopinglist) {
			temp +=a.getIngredientName() + "\n";
		}
		
		System.out.println("list++++++++" + temp);
		System.out.println("email++++++++" + email);
		emailSenderService.sendRecipeEmail(email, temp,
				"Yummmmy! Enjoy!");
		shopingListRepository.deleteByUsername(username);
		return "ok";
	}
	
	
	@PostMapping("/signup-email-sent/{userEmail}") 
	public String SignUpEmailInfo(@PathVariable String userEmail) {
		emailSenderService.sendSignUpEmail(userEmail,
				"We are very excited to have you be apart of the Thyme crunch experience and cant wait for you to experience all of the wonder things we have to offer, \nThymeCrunch Tech Team",
				"Congrats!!");
//		return "redirect:/login";
		return "ok";
	}
}	


