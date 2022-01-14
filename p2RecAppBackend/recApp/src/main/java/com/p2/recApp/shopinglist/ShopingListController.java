package com.p2.recApp.shopinglist;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.p2.recApp.ingredients.Ingredient;
import com.p2.recApp.ingredients.IngredientService;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class ShopingListController {
	
	ShopingListRepository shopingListRepository;
	
	@Autowired
	public ShopingListController(ShopingListRepository shopingListRepository) {
		
		this.shopingListRepository = shopingListRepository;
	}
	
	@GetMapping("/shopinglist/{username}")
	public List<ShopingList> getShopingList( @PathVariable String username){
		List<ShopingList> shopinglist = shopingListRepository.findByUsername(username);
		return shopinglist;
	}
	
}
