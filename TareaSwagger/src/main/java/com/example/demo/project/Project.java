package com.example.demo.project;

import java.io.Serializable;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class Project implements Serializable{
	
	@NotBlank
    @Size(min = 0, max = 5)
	private String id;
	@NotBlank
    @Size(min = 10, max = 50)
	private String description;
	
	private String languaje;
	
	private boolean open;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLanguaje() {
		return languaje;
	}
	public void setLanguaje(String languaje) {
		this.languaje = languaje;
	}
	public boolean isOpen() {
		return open;
	}
	public void setOpen(boolean open) {
		this.open = open;
	}
	
	
}
