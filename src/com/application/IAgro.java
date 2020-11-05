package com.application;

import java.util.List;
import java.util.stream.Collectors;

import com.entities.Funcionalidad;
import com.entities.Rol;
import com.entities.Usuario;
import com.presentation.CrearFuncionalidad;
import com.presentation.CrearRol;
import com.presentation.IFrame;
import com.presentation.ListarFuncionalidades;
import com.presentation.ListarRoles;
import com.presentation.ListarUsuarios;
import com.presentation.AltaUsuario;
import com.presentation.Login;
import com.presentation.MenuPrincipal;
import com.remote.AuthBo;
import com.remote.FuncionalidadBo;
import com.remote.RolBo;
import com.remote.UsuarioBo;
import com.service.IBean;

public class IAgro {
	
	//***********************************************
	// Atributos para el manejo de la capa presentacion
	//***********************************************
	
	private Login login; // login
	private MenuPrincipal principal; // menu principal
	private AltaUsuario altaUsuario; // alta usuario
	private CrearRol crearRol; // crear rol
	private CrearFuncionalidad crearFuncionalidad; // crear rol
	private ListarUsuarios listarUsuarios; // listar usuarios
	private ListarRoles listarRoles; // listar roles
	private ListarFuncionalidades listarFuncionalidades; // listar funcionalidades
	
	//***********************************************
	// Atributos para el manejo de la capa negocios
	//***********************************************
	
	private AuthBo auth; // autenticacion de usuarios
	private UsuarioBo usuarioBo; // usuarios
	private RolBo rolBo; // roles
	private FuncionalidadBo funcionalidadBo; // funcionalidades

	//***********************************************
	// Listados ultra pesados con todos los datos para que la busqueda sea rapida
	//***********************************************
	
	private List<Usuario> usuarios; // listado de usuarios del sistema
	private List<Rol> roles; // listado de roles del sistema
	private List<Funcionalidad> funcionalidades; // listado de funcionalidades del sistema

	/**
	 * 
	 * Main IAgro donde todo comienza...
	 * @param args
	 */
	public static void main(String[] args) {
		IAgro iagro = new IAgro(); // Se crea una instancia
		iagro.start();
	}
	
	/**
	 * 
	 * Constructor de IAgro con la UI inicial de login sin mostrarla
	 */
	public IAgro() {
		login = new Login(this); // Inyecto esta instancia a login
	}
	
	/**
	 * 
	 * Metodo para arrancar IAgro con la capa de negocios inicial y mostrando login
	 */
	private void start() {
		auth = new AuthBo();
		usuarioBo = new UsuarioBo();
		rolBo = new RolBo();
		funcionalidadBo = new FuncionalidadBo();
		refresh(Usuario.class);
		if(usuarios.size() < 1) bootstrap();
		login.start(); // muestro la ventana de login con al menos 1 usuario por defecto cargado en la BD
	}
	
	//***********************************************
	// Metodos para el manejo de la capa presentacion
	//***********************************************
	
	public void menuPrincipal() {
		principal = new MenuPrincipal(this);
		refresh(Rol.class);
		refresh(Funcionalidad.class);
		principal.start();
	}
	
	public void show(Class c) {
		IFrame frame = getFrame(c);
		frame.start();
	}
	
	private IFrame getFrame(Class c) {
		if(c.equals(AltaUsuario.class)) {
			altaUsuario = new AltaUsuario(this);
			return altaUsuario;
		} else if(c.equals(CrearRol.class)) {
			crearRol = new CrearRol(this);
			return crearRol;
		} else if(c.equals(CrearFuncionalidad.class)) {
			crearFuncionalidad = new CrearFuncionalidad(this);
			return crearFuncionalidad;
		} else if(c.equals(ListarUsuarios.class)) {
			listarUsuarios = new ListarUsuarios(this);
			return listarUsuarios;
		} else if(c.equals(ListarRoles.class)) {
			listarRoles = new ListarRoles(this);
			return listarRoles;
		} else if(c.equals(ListarFuncionalidades.class)) {
			listarFuncionalidades = new ListarFuncionalidades(this);
			return listarFuncionalidades;
		}
		return null;
	}
	public String [] getColumnas(){
		String [] columnas = {"ID","NOMBRE","APELLIDO","DOCUMENTO","CLAVE","NICKNAME","EMAIL","ROL"};
		return columnas;
	}
	
	public String[] getColumnasRoles() {
		String[] columnas = {"NOMBRE","DESCRIPCION"};
		return columnas;
	}
	
	public String [] getColumnasFuncionalidad() {
		String [] columnas = {"NOMBRE","DESCRIPCION"};
		return columnas;
	}
	
	//**********************************************
	// Metodos para el manejo de la capa de negocios
	//**********************************************
	
	public void login(String username, String password) {
		auth.login(username, password);
	}
	
	public void logout() {
		auth.logout();
		login.limpiar();
		login.start();
	}
	
	public void bootstrap() {
		auth.bootstrap();
		refresh(Usuario.class);
		login.mensajeEditarAdminPassword();
	}
	
	public boolean create(Object o) {
		IBean bean = getBean(o.getClass());
		boolean result =  bean.create(o);
		if(result) refresh(o.getClass());
		return result;
	}
	
	public boolean update(Object o) {
		IBean bean = getBean(o.getClass());
		boolean result =  bean.update(o);
		if(result) refresh(o.getClass());
		return result;
	}
	
	public boolean delete(Long id, Class c) {
		IBean bean = getBean(c);
		boolean result =  bean.delete(id);
		if(result) refresh(c);
		return result;
	}
	
	private void refresh(Class c) {
		IBean bean = getBean(c);
		if(c.equals(Usuario.class)) {
			usuarios = bean.readAll();
		} else if(c.equals(Rol.class)) {
			roles = bean.readAll();
		} else if(c.equals(Funcionalidad.class)) {
			funcionalidades = bean.readAll();
		}
	}
	
	private IBean getBean(Class c) {
		if(c.equals(Usuario.class)) {
			return usuarioBo;
		} else if(c.equals(Rol.class)) {
			return rolBo;
		} else if(c.equals(Funcionalidad.class)) {
			return funcionalidadBo;
		}
		return null;
	}
	
	public Usuario getAuthUser() {
		return auth.getAuthUser();
	}
	
	public List<Usuario> getUsuarios() {
		return usuarios;
	}
	
	public List<Rol> getRoles() {
		return roles;
	}
	
	public List<Funcionalidad> getFuncionalidades() {
		return funcionalidades;
	}
	
	public Usuario readUsuario(String documento) {
		Usuario usuario = usuarios.stream()
				.filter(u -> u.getDocumento().equals(documento))
				.collect(Collectors.toList())
				.get(0);
		return usuario;
	}
	
	public Rol readRol(String nombre) {
		Rol rol = roles.stream()
				.filter(r -> r.getNombre().equals(nombre))
				.collect(Collectors.toList())
				.get(0);
		return rol;
	}
	
	public Funcionalidad readFuncionalidad(String nombre) {
		Funcionalidad funcionalidad = funcionalidades.stream()
				.filter(f -> f.getNombre().equals(nombre))
				.collect(Collectors.toList())
				.get(0);
		return funcionalidad;
	}
	
	public Object[][] matrixFuncionalidades() {
		Object[][] datos = new Object[funcionalidades.size()][2];
		for (Funcionalidad funcionalidad : funcionalidades) {
			datos[(funcionalidades.indexOf(funcionalidad))][0] = funcionalidad.getNombre();
			datos[(funcionalidades.indexOf(funcionalidad))][1] = funcionalidad.getDescripcion();
		}
		return datos;
	}

}
