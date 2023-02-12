package com.ranjit.blogger.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;



public class Users {

	private Integer userid;
	
	@NotEmpty
	@Size(min = 4,message = "User must be minimum 4 character")
	private String name;
	
	@NotEmpty
	@Email
	private String email;
	
	@NotEmpty
	@Size(min = 6,message = "Password must be minimum 6 character")
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$")
	private String password;
	
	@NotEmpty
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
	
	public Users(Integer userid, @NotEmpty @Size(min = 4, message = "User must be minimum 4 character") String name,
			@NotEmpty @Email String email,
			@NotEmpty @Size(min = 6, message = "Password must be minimum 6 character") @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$") String password,
			@NotEmpty String about) {
		super();
		this.userid = userid;
		this.name = name;
		this.email = email;
		this.password = password;
		this.about = about;
	}
	public Users() {}
}
