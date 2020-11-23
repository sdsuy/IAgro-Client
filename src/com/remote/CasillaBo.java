package com.remote;

import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.entities.Casilla;
import com.service.CasillaBeanRemote;
import com.service.IBean;

public class CasillaBo implements IBean<Casilla> {
	
	private String context;
	private CasillaBeanRemote casillaBean;

	public CasillaBo() {
		super();
		context = "ejb:/IAgro-Server/CasillaBean!com.service.CasillaBeanRemote";
		try {
			casillaBean = (CasillaBeanRemote)InitialContext.doLookup(context);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public boolean create(Casilla o) {
		return casillaBean.create(o);
	}

	@Override
	public Casilla read(Long id) {
		return casillaBean.read(id);
	}

	@Override
	public List<Casilla> readAll() {
		return casillaBean.readAll();
	}

	@Override
	public boolean update(Casilla o) {
		return casillaBean.update(o);
	}

	@Override
	public boolean delete(Long id) {
		return casillaBean.delete(id);
	}
	
	

}
