package com.david.tutoriales.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.util.Assert;

import com.david.tutoriales.services.CRUD;

@Document(collection="historico")
public class Historico<E extends Entidad> {

	@Id
	private String id;
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private LocalDateTime date;

	private String usuarioEjecutor;
	
	private CRUD accion;
	
	private E entidad;
	
	private String className;
	
	public Historico(String id, LocalDateTime date, String usuarioEjecutor, CRUD accion,
			E entidad) {
		Assert.notNull(entidad);
		this.id = id;
		this.date = date;
		this.usuarioEjecutor = usuarioEjecutor;
		this.accion = accion;
		this.entidad = entidad;
		setClassName(entidad.getClass().getSimpleName());
	}
	

	public Historico(LocalDateTime date, String usuarioEjecutor, CRUD accion,
			E entidad) {
		Assert.notNull(entidad);
		this.date = date;
		this.usuarioEjecutor = usuarioEjecutor;
		this.accion = accion;
		this.entidad = entidad;
		setClassName(entidad.getClass().getSimpleName());
	}
	

	public Historico() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public String getUsuarioEjecutor() {
		return usuarioEjecutor;
	}

	public void setUsuarioEjecutor(String usuarioEjecutor) {
		this.usuarioEjecutor = usuarioEjecutor;
	}

	public CRUD getAccion() {
		return accion;
	}

	public void setAccion(CRUD accion) {
		this.accion = accion;
	}

	public E getEntidad() {
		return entidad;
	}

	public void setEntidad(E entidad) {
		this.entidad = entidad;
	}

	/**
	 * @return the className
	 */
	public String getClassName() {
		return className;
	}

	/**
	 * @param className the className to set
	 */
	public void setClassName(String className) {
		this.className = className;
	}


	@Override
	public String toString() {
		return "Historico [id=" + id + ", date=" + date + ", usuarioEjecutor="
				+ usuarioEjecutor + ", accion=" + accion + ", entidad="
				+ entidad + ", className=" + className + "]";
	}
	
	
	
}
