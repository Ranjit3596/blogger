package com.ranjit.blogger.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;

@Entity
@Table(name="users")
public class UsersEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userid;
	
	@Column(name="user_name",nullable = false,length = 100)
	private String name;
	
	@Column(name="user_eamil",nullable = false,length = 50)
	private String email;
	
	@Column(name="user_password",nullable = false,length = 50)
	private String password;
	
	@Column(name="user_about",nullable = false,length = 500)
	private String about;

	

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public UsersEntity(Integer userid, String name, String email, String password, String about) {
		super();
		this.userid = userid;
		this.name = name;
		this.email = email;
		this.password = password;
		this.about = about;
	}
	
	 
}
