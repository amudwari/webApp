package com.signup;

import java.sql.Timestamp;

public class Signup {
	
	private String username;
	private String password;
	private String name;
	private String email;
	private String mobile;
	private String gender;
	private int pid;
	Timestamp doe;

	
	public Signup(){
		
	}
	
	public Signup(String username, String password, String email,String name,String mobile, String gender) {
		this.username = username;
		this.password = password;
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.gender = gender;
		
	}


	
	public Timestamp getDoe() {
		return doe;
	}

	public void setDoe(Timestamp pid) {
		this.doe = doe;
	}	
	
	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getMobile() {
		return mobile;
	}

	public String getGender() {
		return gender;
	}

	@Override
	public String toString() {
		return "signup [username=" + username + ", password=" + password + ", email=" + email + ", name=" + name
				+ ", mobile=" + mobile + ", gender=" + gender + "]";
	}

}
