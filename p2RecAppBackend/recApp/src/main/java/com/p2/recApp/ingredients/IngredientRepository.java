package com.p2.recApp.ingredients;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;



/*************************************Works Cited*********************************************
 * Title: "Java Tutorial - Complete User Login and Registration Backend + Email Verification"
 * Author: Nelson (amigoscode)
 * Date: 1/17/21 (Accessed 12/29/21)
 * Code Version: Java 15
 * Availability: https://youtu.be/QwQuro7ekvc
 *********************************************************************************************/
@Repository
@Transactional(readOnly= true)
public interface IngredientRepository extends JpaRepository<Ingredient, Integer>{
	Optional<Ingredient> findById(Integer ingID);
	List<Ingredient> findByRecipe(String recipe);
	Optional<Ingredient> findByMealType(String mealType);

	
}
