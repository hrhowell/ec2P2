package com.p2.recApp.shopinglist;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
import java.util.Objects;

@Component
@Entity
@Table(name="shopingList")
public class ShopingList {
	
	@Id

	@GeneratedValue(
			strategy = GenerationType.IDENTITY
			)

	@Column(name="listID")
	private Integer listID;
	
	@Column(name= "username")
	private String username;

	@Column(name= "ingredient_name")
	private String ingredientName;
	

	public ShopingList() {
		super();
	}
	

	public ShopingList(String username, String ingredientName) {
		super();
		this.username = username;
		this.ingredientName = ingredientName;
	}


	public ShopingList(Integer listID, String ingredientName, String username) {
		super();
		this.listID = listID;
		this.ingredientName = ingredientName;
		this.username = username;
	}

	@Override
	public String toString() {
		return "ShopingList [recID=" + listID + ", ingredientName=" + ingredientName + ", username=" + username + "]";
	}

	public Integer getRecID() {
		return listID;
	}

	public void setRecID(Integer recID) {
		this.listID = recID;
	}

	public String getIngredientName() {
		return ingredientName;
	}

	public void setIngredientName(String ingredientName) {
		this.ingredientName = ingredientName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
 
	
	

}
