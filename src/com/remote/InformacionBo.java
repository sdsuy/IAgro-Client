package com.remote;

import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.entities.Informacion;
import com.service.IBean;
import com.service.InformacionBeanRemote;

public class InformacionBo implements IBean<Informacion>{
	
	private String context;
	private InformacionBeanRemote informacionBean;
	
	public InformacionBo() {
		super();
		context = "ejb:/IAgro-Server/InformacionBean!com.service.InformacionBeanRemote";
		try {
			informacionBean = (InformacionBeanRemote)InitialContext.doLookup(context);
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean create(Informacion o) {
		return informacionBean.create(o);
	}

	@Override
	public Informacion read(Long id) {
		return informacionBean.read(id);
	}

	@Override
	public List<Informacion> readAll() {
		return informacionBean.readAll();
	}

	@Override
	public boolean update(Informacion o) {
		return informacionBean.update(o);
	}

	@Override
	public boolean delete(Long id) {
		return informacionBean.delete(id);
	}

}
