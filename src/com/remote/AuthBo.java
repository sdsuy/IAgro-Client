package com.remote;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.entities.Usuario;
import com.service.AuthBeanRemote;

public class AuthBo {
	
	private String context;
	private AuthBeanRemote authBean;
	
	public AuthBo() {
		super();
		context = "ejb:/IAgro-Server/AuthBean!com.service.AuthBeanRemote?stateful";
		try {
			authBean = (AuthBeanRemote)InitialContext.doLookup(context);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void login(String username, String password) {
		authBean.login(username, password);
	}
	
	public Usuario getAuthUser() {
		return authBean.getAuthUser();
	}
	
	public void bootstrap() {
		authBean.bootstrap();
	}

}
