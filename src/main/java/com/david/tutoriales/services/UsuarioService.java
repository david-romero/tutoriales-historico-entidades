/**
 * 
 */
package com.david.tutoriales.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.david.tutoriales.model.Usuario;
import com.david.tutoriales.persistencia.UsuarioRepository;

/**
 * @author David
 *
 */
@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;
	
	public Usuario save(Usuario usuario){
		return repository.save(usuario);
	}
	
	public Usuario load(Long id){
		long idUsuarioCreado = id;
		Assert.isTrue(idUsuarioCreado > 0);
		return repository.findOne(idUsuarioCreado);
	}
	
	public void delete(Usuario usuario){
		repository.delete(usuario);
	}
	
}
