//package com.p2.recApp.login;
//
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//import javax.persistence.ManyToOne;
//
//import com.amazonaws.services.appstream.model.User;
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.p2.recApp.users.*;
//
//@Entity
//public class Post {
//	
//	@Id
//	@GeneratedValue
//	private Integer id;
//	//private String description;
//	
//	@ManyToOne(fetch=FetchType.LAZY)
//	@JsonIgnore
//	User user;
//	
//	public Integer getId() {
//		return id;
//	}
//
//	public void setId(Integer id) {
//		this.id = id;
//	}
//
////	public String getDescription() {
////		return description;
////	}
////
////	public void setDescription(String description) {
////		this.description = description;
////	}
//
//	public User getUser() {
//		return user;
//	}
//
//	public void setUser( User user2) {
//		this.user = user2;
//	}
//
//	@Override
//	public String toString() {
//		return String.format("Post [id=%s, description=%s]", id/* description*/);
//	}
//	
//}
