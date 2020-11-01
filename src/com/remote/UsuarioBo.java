package com.remote;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.service.UsuarioBeanRemote;

public class UsuarioBo {
	
	private String context;
	private UsuarioBeanRemote usuarioBean;

	public UsuarioBo() throws NamingException {
		super();
		context = "";
		usuarioBean = (UsuarioBeanRemote)InitialContext.doLookup(context);
	}
	
	

}
