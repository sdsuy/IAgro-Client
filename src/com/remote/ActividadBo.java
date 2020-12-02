package com.remote;

import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.entities.Actividad;
import com.service.ActividadBeanRemote;
import com.service.IBean;

public class ActividadBo implements IBean<Actividad> {
	
	private String context;
	private ActividadBeanRemote actividadBean;
	
	public ActividadBo() {
		super();
		context = "ejb:/IAgro-Server/ActividadBean!com.service.ActividadBeanRemote";
		try {
			actividadBean = (ActividadBeanRemote)InitialContext.doLookup(context);
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean create(Actividad o) {
		return actividadBean.create(o);
	}

	@Override
	public Actividad read(Long id) {
		return actividadBean.read(id);
	}

	@Override
	public List<Actividad> readAll() {
		return actividadBean.readAll();
	}
	
	public List<Actividad> readAllByForm(Long id) {
		return actividadBean.readAllByForm(id);
	}
	
	public Actividad readOneAndCasillasEInfo(Long id) {
		return actividadBean.readOneAndCasillasEInfo(id);
	}

	@Override
	public boolean update(Actividad o) {
		return actividadBean.update(o);
	}

	@Override
	public boolean delete(Long id) {
		return actividadBean.delete(id);
	}

}
