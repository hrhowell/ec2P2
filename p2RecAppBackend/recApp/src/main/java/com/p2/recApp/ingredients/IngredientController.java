package com.p2.recApp.ingredients;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.p2.recApp.shopinglist.ShopingList;
import com.p2.recApp.shopinglist.ShopingListRepository;
import com.p2.recApp.users.User;
import com.p2.recApp.users.UserService;

@RestController
@RequestMapping("/api/v1/recipes")
@CrossOrigin("*")
public class IngredientController {
	
//	public List<Ingredient> userIngredient = new ArrayList<>();
//	public Recipe userRecipe = new Recipe();
	ShopingListRepository shopingListRepository;
	
	private final IngredientService ingredientService;
//	private ArrayList<Recipe> recipes = new ArrayList<>();
	private Recipe pancakes;
	private Recipe boba_tea;
	private Recipe punch;
	private Recipe orange_juice;
	private Recipe latte;
	private Recipe pavlova;
	private Recipe black_forest_gelato_with_ganache;
	private Recipe lemon_tart;
	private Recipe hummus;
	private Recipe fruit_stars;
	private Recipe celery_boats;
	private Recipe pad_thai;
	private Recipe pasta;
	private Recipe hamburger;
	private Recipe salad;
	private Recipe curry;
	private Recipe bento;
	private Recipe avocado_toast;
	private Recipe granola;
	@Autowired
	public IngredientController(IngredientService ingredientService, ShopingListRepository shopingListRepository) {
		this.ingredientService = ingredientService;
		this.shopingListRepository = shopingListRepository;
	}
	
	@GetMapping
	public List<Ingredient> getAllIng(){
		return ingredientService.getAllIng();
	}
	
//	@GetMapping("/{recipe}")
	@GetMapping("/{recipe}/{username}")
	public List<Ingredient> getByRec(@PathVariable("recipe") String recipe, @PathVariable String username){
//		return ingredientService.getByRec(recipe);
		List<Ingredient> newRecipe = ingredientService.getByRec(recipe);

//		ShopingList shopinglist = new ShopingList();
		for(Ingredient a: newRecipe) {
			ShopingList shopinglist = new ShopingList(username, a.ingName );
//			shopinglist.setUsername(username);
//			shopinglist.setIngredientName(a.ingName); 
			shopingListRepository.save(shopinglist);
			System.out.println("shopinglist" + shopinglist);
		}
		
		return newRecipe;
		
	}
	
//	public ArrayList<Recipe> recipes(){
//		
//		Recipe pancakes = new Recipe("pancakes");
//		recipes.add(pancakes);
//		Recipe granola = new Recipe("granola");
//		recipes.add(granola);
//		Recipe avocado_toast = new Recipe("avocado_toast");
//		recipes.add(avocado_toast);
//		Recipe bento = new Recipe("bento");
//		recipes.add(bento);
//		Recipe curry = new Recipe("curry");
//		recipes.add(curry);
//		Recipe salad = new Recipe("salad");
//		recipes.add(salad);
//		Recipe hamburger = new Recipe("hamburger");
//		recipes.add(hamburger);
//		Recipe pasta = new Recipe("pasta");
//		recipes.add(pasta);
//		Recipe pad_thai = new Recipe("pad_thai");
//		recipes.add(pad_thai);
//		Recipe celery_boats = new Recipe("celery_boats");
//		recipes.add(celery_boats);
//		Recipe fruit_stars = new Recipe("fruit_stars");
//		recipes.add(fruit_stars);
//		Recipe hummus = new Recipe("hummus");
//		recipes.add(hummus);
//		Recipe lemon_tart = new Recipe("lemon_tart");
//		recipes.add(lemon_tart);
//		Recipe black_forest_gelato_with_ganache = new Recipe("black_forest_gelato_with_ganache");
//		recipes.add(black_forest_gelato_with_ganache);
//		Recipe pavlova = new Recipe("pavlova");
//		recipes.add(pavlova);
//		Recipe latte = new Recipe("latte");
//		recipes.add(latte);
//		Recipe orange_juice = new Recipe("orange_juice");
//		recipes.add(orange_juice);
//		Recipe punch = new Recipe("punch");
//		recipes.add(punch);
//		Recipe boba_tea = new Recipe("boba_tea");
//		recipes.add(boba_tea);
//		System.out.println("Recipes from the list************************" + recipes);
//		return recipes;
//		
//	}
	
	@PostMapping("/all-recipes/{temprecipe}")
	public boolean getAllRec(@PathVariable String temprecipe){
		ArrayList<String> recipes = new ArrayList<String>();
		recipes.add("pancakes");
		recipes.add("granola");
		recipes.add("avocado_toast");
		recipes.add("bento");
		recipes.add("curry");
		recipes.add("salad");
		recipes.add("hamburger");
		recipes.add("pasta");
		recipes.add("pad_thai");
		recipes.add("celery_boats");
		recipes.add("fruit_stars");
		recipes.add("hummus");
		recipes.add("lemon_tart");
		recipes.add("black_forest_gelato_with_ganache");
		recipes.add("pavlova");
		recipes.add("latte");
		recipes.add("orange_juice");
		recipes.add("punch");
		recipes.add("boba_tea");
		
		
		System.out.println("Recipes from the list************************" + temprecipe);
		boolean temp = recipes.contains(temprecipe);
		System.out.println("Recipes************************" + temp);
		return temp;
	}
	
}
