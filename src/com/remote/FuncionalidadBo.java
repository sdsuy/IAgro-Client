package com.remote;

import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.entities.Funcionalidad;
import com.service.FuncionalidadBeanRemote;

public class FuncionalidadBo {
	
	private String context;
	
	private FuncionalidadBeanRemote funcionalidadBean;
	
	public FuncionalidadBo() {
		super();
		context="ejb:/IAgro-Server/FuncionalidadBean!com.service.FuncionalidadBeanRemote";
		try {
			funcionalidadBean = (FuncionalidadBeanRemote)InitialContext.doLookup(context);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean createFuncionalidad(Funcionalidad funcionalidad) {
		return funcionalidadBean.create(funcionalidad);
	}
	
	public boolean updateFuncionalidad(Funcionalidad funcionalidad) {
		return funcionalidadBean.update(funcionalidad);
	}
	
	public List<Funcionalidad> getFuncionalidades() {
		return funcionalidadBean.readAll();
	}

}
