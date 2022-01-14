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

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/email")
public class EmailController {
 
	
	private IngredientService ingredientService;
	private EmailSenderService emailSenderService;
	
	@Autowired
	public EmailController(EmailSenderService emailSenderService, IngredientService ingredientService) {
		this.ingredientService = ingredientService;
		this.emailSenderService = emailSenderService;
	}
	
	@PostMapping("/email-sent") 
	public String EmailInfo() {
		emailSenderService.sendSimpleEmail("qwinkypoo@gmail.com",
				"We are very sorry for this inconvience but don't worry, we got you!\n\nHere is your password: password\n\nThank you,\nThymeCrunch Tech Team",
				"Lost Password");
		return "redirect:/login";
	}
	
//	public void sendRecipeEmail(String toEmail, String body, String subject) 
	@PostMapping("/recipe-email-sent/{userEmail}/{recipeName}") 
	public String RecipeEmailInfo( @PathVariable String userEmail, @PathVariable String recipeName) {

		List<Ingredient> userRecipe = ingredientService.getByRec(recipeName);
		String temp = " ";
		
		for(Ingredient a: userRecipe) {
			temp +=a.ingName + "\n";
			System.out.println(a.ingName);
		}
		
		System.out.println("temp++++++++" + temp);
		emailSenderService.sendRecipeEmail(userEmail, temp,
				"Yummmmy! Enjoy!");
		return "redirect:/login";
//		return "ok";
	}
	
	@PostMapping("/signup-email-sent/{userEmail}") 
	public String SignUpEmailInfo(@PathVariable String userEmail) {
		emailSenderService.sendSignUpEmail(userEmail,
				"We are very excited to have you be apart of the Thyme crunch experience and cant wait for you to experience all of the wonder things we have to offer, \nThymeCrunch Tech Team",
				"Congrats!!");
		return "redirect:/login";
//		return "ok";
	}
}	


