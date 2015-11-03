package com.david.tutoriales;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.david.tutoriales.model.Usuario;
import com.david.tutoriales.services.UsuarioService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=AppTestConfig.class)
public class HistoricoTest {

	@Autowired
	private UsuarioService service;
	
	@Test
	public void test(){
		UserDetails credentilas = new User("DAVROMALC", "PASSWORD", new ArrayList<GrantedAuthority>(0));
		Authentication auth = new UsernamePasswordAuthenticationToken("DAVROMALC", credentilas);
		SecurityContextHolder.getContext().setAuthentication(auth);
		Usuario user = new Usuario();
		user.setUsername("DAVROMALC");
		user = service.save(user);
	}
	
}
