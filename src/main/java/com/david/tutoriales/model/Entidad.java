/**
 * 
 */
package com.david.tutoriales.model;

import java.time.LocalDateTime;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;


/**
 * @author David
 *
 */
@MappedSuperclass
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Entidad {

	@Version
	private long version;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long Id;
	
	private String usuarioInsercion;

	private String usuarioModificacion;
	
	private String usuarioBorrado;
	
	private LocalDateTime fechaInsercion;
	
	private LocalDateTime fechaBorrado;
	
	private LocalDateTime fechaModificacion;
	
	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getUsuarioInsercion() {
		return usuarioInsercion;
	}

	public void setUsuarioInsercion(String usuarioInsercion) {
		this.usuarioInsercion = usuarioInsercion;
	}

	public String getUsuarioModificacion() {
		return usuarioModificacion;
	}

	public void setUsuarioModificacion(String usuarioModificacion) {
		this.usuarioModificacion = usuarioModificacion;
	}

	public LocalDateTime getFechaInsercion() {
		return fechaInsercion;
	}

	public void setFechaInsercion(LocalDateTime fechaInsercion) {
		this.fechaInsercion = fechaInsercion;
	}

	public LocalDateTime getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(LocalDateTime fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	/**
	 * @return the fechaBorrado
	 */
	public LocalDateTime getFechaBorrado() {
		return fechaBorrado;
	}

	/**
	 * @param fechaBorrado the fechaBorrado to set
	 */
	public void setFechaBorrado(LocalDateTime fechaBorrado) {
		this.fechaBorrado = fechaBorrado;
	}

	/**
	 * @return the usuarioBorrado
	 */
	public String getUsuarioBorrado() {
		return usuarioBorrado;
	}

	/**
	 * @param usuarioBorrado the usuarioBorrado to set
	 */
	public void setUsuarioBorrado(String usuarioBorrado) {
		this.usuarioBorrado = usuarioBorrado;
	}

	
}
