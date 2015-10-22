package com.natcorp.userWebForm;

public class userObject {
private String username;
private String name;
private String password;

	public userObject() {
		// TODO Auto-generated constructor stub
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		if(username != null && !username.isEmpty()){
		this.username = username;
		} else {
			this.username = "INVALID USERNAME";
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
