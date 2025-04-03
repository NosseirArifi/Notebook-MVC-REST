package com.example.demo.user;

import java.io.Serializable;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class User implements Serializable{
	

	@NotEmpty
	@Size(min = 1, max = 5)
	private String id;
	@NotBlank
	private String nick;
	@NotEmpty
	@Size(min = 1, max = 5)
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
