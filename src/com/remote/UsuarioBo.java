package com.remote;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.service.UsuarioBeanRemote;

public class UsuarioBo {
	
	private String context;
	private UsuarioBeanRemote usuarioBean;

	public UsuarioBo() throws NamingException {
		super();
		context = "ejb:/IAgro-Server/UsuarioBean!com.service.UsuarioBeanRemote";
		usuarioBean = (UsuarioBeanRemote)InitialContext.doLookup(context);
	}
	
	

}
