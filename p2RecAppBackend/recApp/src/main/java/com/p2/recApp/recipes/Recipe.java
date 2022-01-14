package com.p2.recApp.recipes;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="recipes")
public class Recipe {

	@Id

	@GeneratedValue(
			strategy = GenerationType.IDENTITY
			)

	@Column(name="recID")
	private Integer recID;

	@Column(name= "rec_name")
	private String recName;
	
	@Column(name= "meal_type")
	private String mealType;

	@Column(name= "ing1")
	private String ing1;

	@Column(name= "ing2")
	private String ing2;

	@Column(name= "ing3")
	private String ing3;

	@Column(name= "ing4")
	private String ing4;

	@Column(name= "ing5")
	private String ing5;
	
	@Column(name= "status")
	private String status;

	public Integer getRecID() {
		return recID;
	}

	public void setRecID(Integer recID) {
		this.recID = recID;
	}

	public String getRecName() {
		return recName;
	}

	public void setRecName(String recName) {
		this.recName = recName;
	}

	public String getMealType() {
		return mealType;
	}

	public void setMealType(String mealType) {
		this.mealType = mealType;
	}

	public String getIng1() {
		return ing1;
	}

	public void setIng1(String ing1) {
		this.ing1 = ing1;
	}

	public String getIng2() {
		return ing2;
	}

	public void setIng2(String ing2) {
		this.ing2 = ing2;
	}

	public String getIng3() {
		return ing3;
	}

	public void setIng3(String ing3) {
		this.ing3 = ing3;
	}

	public String getIng4() {
		return ing4;
	}

	public void setIng4(String ing4) {
		this.ing4 = ing4;
	}

	public String getIng5() {
		return ing5;
	}

	public void setIng5(String ing5) {
		this.ing5 = ing5;
	}

	public String getStatus(String string) {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Recipe(Integer recID, String recName, String mealType, String ing1, String ing2, String ing3, String ing4,
			String ing5, String status) {
		super();
		this.recID = recID;
		this.recName = recName;
		this.mealType = mealType;
		this.ing1 = ing1;
		this.ing2 = ing2;
		this.ing3 = ing3;
		this.ing4 = ing4;
		this.ing5 = ing5;
		this.status = status;
	}

	public Recipe() {
		super();
	}

	
	
	public Recipe(String recName, String mealType, String ing1, String ing2, String ing3, String ing4, String ing5,
			String status) {
		super();
		this.recName = recName;
		this.mealType = mealType;
		this.ing1 = ing1;
		this.ing2 = ing2;
		this.ing3 = ing3;
		this.ing4 = ing4;
		this.ing5 = ing5;
		this.status = status;
	}

	
	@Override
	public String toString() {
		return "Recipe [recID=" + recID + ", recName=" + recName + ", mealType=" + mealType + ", ing1=" + ing1
				+ ", ing2=" + ing2 + ", ing3=" + ing3 + ", ing4=" + ing4 + ", ing5=" + ing5 + ", status=" + status
				+ "]";
	}

	
	
	
}