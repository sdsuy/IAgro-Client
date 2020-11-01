package com.remote;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.service.FuncionalidadBeanRemote;

public class FuncionalidadBo {
	
	private String context;
	
	private FuncionalidadBeanRemote funcionalidadBean;
	
	public FuncionalidadBo() throws NamingException {
		super();
		context="ejb:/IAgro-Server/FuncionalidadBean!com.service.FuncionalidadBeanRemote";
		funcionalidadBean = (FuncionalidadBeanRemote)InitialContext.doLookup(context);
	}

}
