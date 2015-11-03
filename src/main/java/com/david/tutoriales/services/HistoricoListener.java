package com.david.tutoriales.services;

import java.time.LocalDateTime;

import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.david.tutoriales.config.DbConfigHistoricos;
import com.david.tutoriales.model.Entidad;
import com.david.tutoriales.model.Historico;

@Service
public class HistoricoListener<E extends Entidad> {

	// For Annotation
	ApplicationContext ctx = new AnnotationConfigApplicationContext(
			DbConfigHistoricos.class);
	MongoOperations mongoOperation = (MongoOperations) ctx
			.getBean("mongoTemplate");

	@PrePersist
	void onPrePersist(E entidad) {
		entidad.setFechaInsercion(LocalDateTime.now());
		entidad.setUsuarioInsercion(SecurityContextHolder.getContext()
				.getAuthentication().getName());
	}

	@PostPersist
	void onPostPersist(E entidad) {
		persistirHistorico(CRUD.CREATE, entidad);
	}

	@PostLoad
	void onPostLoad(E entidad) {
		persistirHistorico(CRUD.READ, entidad);
	}

	@PreUpdate
	void onPreUpdate(E entidad) {
		entidad.setFechaModificacion(LocalDateTime.now());
		entidad.setUsuarioModificacion(SecurityContextHolder.getContext()
				.getAuthentication().getName());
	}

	@PostUpdate
	void onPostUpdate(E entidad) {
		persistirHistorico(CRUD.UPDATE, entidad);
	}

	@PreRemove
	void onPreRemove(E entidad) {
		entidad.setFechaBorrado(LocalDateTime.now());
		entidad.setUsuarioBorrado(SecurityContextHolder.getContext()
				.getAuthentication().getName());
	}

	@PostRemove
	void onPostRemove(E entidad) {
		persistirHistorico(CRUD.DELETE, entidad);
	}

	private void persistirHistorico(CRUD accion, E entidad) {
		Historico<E> his = new Historico<E>(LocalDateTime.now(),
				SecurityContextHolder.getContext().getAuthentication()
						.getName(), accion, entidad);
		mongoOperation.save(his);
	}

}
