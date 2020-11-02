package com.remote;

import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.entities.Usuario;
import com.service.UsuarioBeanRemote;

public class UsuarioBo {
	
	private String context;
	private UsuarioBeanRemote usuarioBean;

	public UsuarioBo() {
		super();
		context = "ejb:/IAgro-Server/UsuarioBean!com.service.UsuarioBeanRemote";
		try {
			usuarioBean = (UsuarioBeanRemote)InitialContext.doLookup(context);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean createUsuario(Usuario usuario) {
		return usuarioBean.create(usuario);
	}
	
	public List<Usuario> getUsuarios() {
		return usuarioBean.readAll();
	}

}
