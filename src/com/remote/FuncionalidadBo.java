package com.remote;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.service.FuncionalidadBeanRemote;

public class FuncionalidadBo {
	
	private String context;
	
	private FuncionalidadBeanRemote funcionalidadBean;
	
	public FuncionalidadBo() throws NamingException {
		super();
		context="";
		funcionalidadBean = (FuncionalidadBeanRemote)InitialContext.doLookup(context);
	}

}
