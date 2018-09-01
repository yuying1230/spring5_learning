package com.lovestory;

public class HelloSpring {
	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void sayHello() {
		System.out.println(this.username + " says Hello Spring!");
	}
}
