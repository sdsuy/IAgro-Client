package com.remote;

import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.entities.Rol;
import com.service.RolBeanRemote;

public class RolBo {
	
	private String context;
	private RolBeanRemote rolBean;
	
	public RolBo() {
		super();
		context = "ejb:/IAgro-Server/RolBean!com.service.RolBeanRemote";
		try {
			rolBean = (RolBeanRemote)InitialContext.doLookup(context);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean createRol(Rol rol) {
		return rolBean.create(rol);
	}
	
	public List<Rol> getRoles() {
		return rolBean.readAll();
	}

}
