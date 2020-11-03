package com.remote;

import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.entities.Usuario;
import com.service.IBean;
import com.service.UsuarioBeanRemote;

public class UsuarioBo implements IBean<Usuario> {
	
	private String context;
	private UsuarioBeanRemote usuarioBean;

	public UsuarioBo() {
		super();
		context = "ejb:/IAgro-Server/UsuarioBean!com.service.UsuarioBeanRemote";
		try {
			usuarioBean = (UsuarioBeanRemote)InitialContext.doLookup(context);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public boolean create(Usuario o) {
		return usuarioBean.create(o);
	}

	@Override
	public Usuario read(Long id) {
		return usuarioBean.read(id);
	}

	@Override
	public List<Usuario> readAll() {
		return usuarioBean.readAll();
	}

	@Override
	public boolean update(Usuario o) {
		return usuarioBean.update(o);
	}

	@Override
	public boolean delete(Long id) {
		return usuarioBean.delete(id);
	}

}
