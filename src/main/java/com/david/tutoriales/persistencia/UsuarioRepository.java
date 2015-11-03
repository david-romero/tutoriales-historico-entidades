/**
 * 
 */
package com.david.tutoriales.persistencia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.david.tutoriales.model.Usuario;

/**
 * @author David
 *
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

}
