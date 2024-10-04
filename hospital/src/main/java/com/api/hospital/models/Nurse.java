package com.api.hospital.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Nurse {

    @JsonProperty("nombre")
    private String nombre;

    @JsonProperty("username")
    private String username;
    
    @JsonProperty("password")
    private String password;

    public Nurse(String nombre, String username, String password) {
        this.nombre = nombre;
        this.username = username;
        this.password = password;
    }

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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
    
}
