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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Usuario [");
		if (username != null) {
			builder.append("username=");
			builder.append(username);
			builder.append(", ");
		}
		builder.append("getVersion()=");
		builder.append(getVersion());
		builder.append(", ");
		if (getId() != null) {
			builder.append("getId()=");
			builder.append(getId());
			builder.append(", ");
		}
		if (getUsuarioInsercion() != null) {
			builder.append("getUsuarioInsercion()=");
			builder.append(getUsuarioInsercion());
			builder.append(", ");
		}
		if (getUsuarioModificacion() != null) {
			builder.append("getUsuarioModificacion()=");
			builder.append(getUsuarioModificacion());
			builder.append(", ");
		}
		if (getFechaInsercion() != null) {
			builder.append("getFechaInsercion()=");
			builder.append(getFechaInsercion());
			builder.append(", ");
		}
		if (getFechaModificacion() != null) {
			builder.append("getFechaModificacion()=");
			builder.append(getFechaModificacion());
			builder.append(", ");
		}
		if (getFechaBorrado() != null) {
			builder.append("getFechaBorrado()=");
			builder.append(getFechaBorrado());
			builder.append(", ");
		}
		if (getUsuarioBorrado() != null) {
			builder.append("getUsuarioBorrado()=");
			builder.append(getUsuarioBorrado());
		}
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
