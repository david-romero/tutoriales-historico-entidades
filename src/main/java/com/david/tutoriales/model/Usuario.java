package com.david.tutoriales.model;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;

import com.david.tutoriales.services.HistoricoListener;

@Entity(name="usuarios")
@EntityListeners(value=HistoricoListener.class)
public class Usuario extends Entidad {

	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	
	
}
