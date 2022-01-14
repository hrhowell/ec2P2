package com.p2.recApp.ingredients;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
/*************************************Works Cited*********************************************
 * Title: "Java Tutorial - Complete User Login and Registration Backend + Email Verification"
 * Author: Nelson (amigoscode)
 * Date: 1/17/21 (Accessed 12/29/21)
 * Code Version: Java 15
 * Availability: https://youtu.be/QwQuro7ekvc
 *********************************************************************************************/




@Entity
@Table(name="ingredients")

public class Ingredient  {
	
	@Override
	public String toString() {
		return "Ingredient [ingID=" + ingID + ", ingName=" + ingName + ", recipe=" + recipe + ", ingType=" + ingType
				+ ", mealType=" + mealType + "]";
	}

	@Id
	
	
	
	@GeneratedValue(
			strategy = GenerationType.IDENTITY
			)
	
	@Column(name="ingID")
	private Integer ingID;
	
	public Ingredient(Integer ingID, String ingName, String recipe, String ingType, String mealType) {
		super();
		this.ingID = ingID;
		this.ingName = ingName;
		this.recipe = recipe;
		this.ingType = ingType;
		this.mealType = mealType;
	}

	public Ingredient() {
		super();
	}

	

	public Integer getIngID() {
		return ingID;
	}

	public void setIngID(Integer ingID) {
		this.ingID = ingID;
	}

	public String getIngName() {
		return ingName;
	}

	public void setIngName(String ingName) {
		this.ingName = ingName;
	}

	public String getRecipe() {
		return recipe;
	}

	public void setRecipe(String recipe) {
		this.recipe = recipe;
	}

	public String getIngType() {
		return ingType;
	}

	public void setIngType(String ingType) {
		this.ingType = ingType;
	}

	public String getMealType() {
		return mealType;
	}

	public void setMealType(String mealType) {
		this.mealType = mealType;
	}

	@Column(name= "ing_name")
	public String ingName;
	
	@Column(name= "rec")
	private String recipe;
	
	@Column(name= "ing_type")
	private String ingType;
	
	@Column(name= "meal_type")
	private String mealType;
	
	

}
