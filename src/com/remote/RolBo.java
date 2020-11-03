package com.remote;

import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.entities.Rol;
import com.service.IBean;
import com.service.RolBeanRemote;

public class RolBo implements IBean<Rol> {
	
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

	@Override
	public boolean create(Rol o) {
		return rolBean.create(o);
	}

	@Override
	public Rol read(Long id) {
		return rolBean.read(id);
	}

	@Override
	public List<Rol> readAll() {
		return rolBean.readAll();
	}

	@Override
	public boolean update(Rol o) {
		return rolBean.update(o);
	}

	@Override
	public boolean delete(Long id) {
		return rolBean.delete(id);
	}

}
