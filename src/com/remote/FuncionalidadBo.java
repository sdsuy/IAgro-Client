package com.remote;

import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.entities.Funcionalidad;
import com.service.FuncionalidadBeanRemote;
import com.service.IBean;

public class FuncionalidadBo implements IBean<Funcionalidad> {
	
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

	@Override
	public boolean create(Funcionalidad o) {
		return funcionalidadBean.create(o);
	}

	@Override
	public Funcionalidad read(Long id) {
		return funcionalidadBean.read(id);
	}

	@Override
	public List<Funcionalidad> readAll() {
		return funcionalidadBean.readAll();
	}

	@Override
	public boolean update(Funcionalidad o) {
		return funcionalidadBean.update(o);
	}

	@Override
	public boolean delete(Long id) {
		return funcionalidadBean.delete(id);
	}

}
