package com.remote;

import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.entities.Formulario;
import com.service.FormularioBeanRemote;
import com.service.IBean;

public class FormularioBo implements IBean<Formulario> {
	
	private String context;
	private FormularioBeanRemote formularioBean;

	public FormularioBo() {
		super();
		context = "";
		try {
			formularioBean = (FormularioBeanRemote)InitialContext.doLookup(context);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public boolean create(Formulario o) {
		return formularioBean.create(o);
	}

	@Override
	public Formulario read(Long id) {
		return formularioBean.read(id);
	}

	@Override
	public List<Formulario> readAll() {
		return formularioBean.readAll();
	}

	@Override
	public boolean update(Formulario o) {
		return formularioBean.update(o);
	}

	@Override
	public boolean delete(Long id) {
		return formularioBean.delete(id);
	}

}
