package com.p2.recApp.users;

import java.util.Collection;
import java.util.Collections;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
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
//this is lombok, it generates getters and setters with annotations

//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
@ToString
@Entity
@Table(name="users")
public class User /*implements UserDetails*/{
	
//	this sets a PK on the ID, sets up a sequence and says it
//	increases by 1 and gives it to the generated value
	
	

	@Id
	@SequenceGenerator(
			name="user_sequence",
			sequenceName = "user_sequence",
			allocationSize = 1
			)
	
	
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE, 
			generator= "user_sequence"
			)
	
	private Integer userID;
	
	@Column(name="firstname")
	private String firstname;
	
	@Column(name="lastname")
	private String lastname;
	
	@Column(name="email")
	private String email;
	
	@Column(name="username")
	
	@JsonProperty("username")
	private String username;
	
	@Column(name="password")
	
	@JsonProperty("password")
	private String password;
	
	//s3 key
	@Column(name="profile_pic")
	private String profile_pic;
	@Column(name="fav_rec")
	private String fav_rec;
	
	//this has to do with security and login in the tutorial JAVA complete backend 
	@Column(name="locked")
	private Boolean locked = false;
	@Column(name="enabled")
	private Boolean enabled = false;
	
	@Enumerated(EnumType.STRING)
	@Column(name="user_role")
	//private UserRole userRole;
	private UserRole userRole;
	
	
	
	//constructor with everything but ID
	public User(String firstname, 
				String lastname,
				String email,
				String username,
				String password,
				String profile_pic,
				String fav_rec,
				UserRole userRole) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.username = username;
		this.password = password;
		this.profile_pic =profile_pic;
		this.fav_rec = fav_rec;
		this.userRole = userRole;
	}
	
	 public Integer getUserID() {
	        return userID;
	    }

	
	

	public Optional<String> getProfile_pic() {
		return Optional.ofNullable(profile_pic);
	}

	public void setProfile_pic(String profile_pic) {
		this.profile_pic = profile_pic;
	}
	


	@Override
	public int hashCode() {
		return Objects.hash(email, enabled, fav_rec, firstname, lastname, locked, password, profile_pic, userID,
				userRole, username);
	}
	
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return 
				Objects.equals(email, other.email)
				&& Objects.equals(enabled, other.enabled)
				&& Objects.equals(fav_rec, other.fav_rec) 
				&& Objects.equals(firstname, other.firstname)
				&& Objects.equals(lastname, other.lastname) 
				&& Objects.equals(locked, other.locked)
				&& Objects.equals(password, other.password) 
				&& Objects.equals(profile_pic, other.profile_pic)
				&& Objects.equals(userID, other.userID) 
				&& userRole == other.userRole
				&& Objects.equals(username, other.username);
	}

	public User(String firstname, String lastname, String email, String username, String password, UserRole userRole) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.username = username;
		this.password = password;
		this.userRole = userRole;
	}
	

	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	

	public User(Integer userID, String firstname, String lastname, String email, String username, String password,
			String profile_pic, String fav_rec, Boolean locked, Boolean enabled, UserRole userRole) {
		super();
		this.userID = userID;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.username = username;
		this.password = password;
		this.profile_pic = profile_pic;
		this.fav_rec = fav_rec;
		this.locked = locked;
		this.enabled = enabled;
		this.userRole = userRole;
	}

	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		
		return this.email;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFav_rec() {
		return fav_rec;
	}

	public void setFav_rec(String fav_rec) {
		this.fav_rec = fav_rec;
	}

	public Boolean getLocked() {
		return locked;
	}

	public void setLocked(Boolean locked) {
		this.locked = locked;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public UserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}

	public User(String firstname, String lastname, String email, String username, String password) {
//		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.username = username;
		this.password = password;
	}

	public User() {
		super();
	}

	public void setEmail(String email2) {
		// TODO Auto-generated method stub
		
	}
	
	
}
