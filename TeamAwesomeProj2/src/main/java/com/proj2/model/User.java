package com.proj2.model;

public class User {
	
	private int id; 
	private String username;
	private Privileges privileges; 
	private String email; 
	private String password;
	private String newUsername;
	private String newPassword;
	
	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User(int id, String username, Privileges privileges, String email) {
		super();
		this.id = id;  
		this.username = username;
		this.privileges = privileges; 
		this.email = email;
	}
	
	public String getNewUsername() {
		return newUsername;
	}

	public void setNewUsername(String newUsername) {
		this.newUsername = newUsername;
	}

	public User() {
		super(); 
	}

	public int getId() {
		return id; 
	}
	
	public void setId(int id) {
		this.id = id; 
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Privileges getPrivileges() {
		return privileges; 
	}
	
	public void setPrivileges(Privileges privileges) {
		this.privileges = privileges; 
	}
	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", privileges=" + privileges + ", email=" + email
				+ ", password=" + password + ", newUsername=" + newUsername + ", newPassword=" + newPassword + "]";
	}
	
	private String wordFit(String word, int len) {
		if(word == null) word = ""; 
		while(word.length() < len) {
			word += " "; 
		}
		return word.substring(0, len); 
	}
}
