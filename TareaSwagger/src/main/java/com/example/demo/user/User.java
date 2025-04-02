package com.example.demo.user;

import java.io.Serializable;

public class User implements Serializable{
	
	private String id;
	private String nick;
	private String name;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDescription() {
		return nick;
	}
	public void setDescription(String description) {
		this.nick = description;
	}
	public String getLanguaje() {
		return name;
	}
	public void setLanguaje(String languaje) {
		this.name = languaje;
	}

}
