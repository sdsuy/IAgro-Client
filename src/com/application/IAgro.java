package com.application;

import java.util.List;
import java.util.stream.Collectors;

import com.entities.Funcionalidad;
import com.entities.Rol;
import com.entities.Usuario;
import com.presentation.CrearFuncionalidad;
import com.presentation.CrearRol;
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
		refreshUsuarios();
		if(usuarios.size() < 1) bootstrap();
		login.start(); // muestro la ventana de login con al menos 1 usuario por defecto cargado en la BD
	}
	
	//***********************************************
	// Metodos para el manejo de la capa presentacion
	//***********************************************
	
	public void menuPrincipal() {
		principal = new MenuPrincipal(this);
		refreshRoles();
		refreshFuncionalidades();
		principal.start();
	}
	
	public void showAltaUsuario() {
		altaUsuario = new AltaUsuario(this);
		altaUsuario.start();
	}
	
	public void showCrearRol() {
		crearRol = new CrearRol(this);
		crearRol.start();
	}
	
	public void showCrearFuncionalidad() {
		crearFuncionalidad = new CrearFuncionalidad(this);
		crearFuncionalidad.start();
	}
	
	public void showListarUsuarios() {
		listarUsuarios = new ListarUsuarios(this);
		listarUsuarios.start();
	}
	
	public void showListarRoles() {
		listarRoles = new ListarRoles(this);
		listarRoles.start();
	}
	
	public void showListarFuncionalidades() {
		listarFuncionalidades = new ListarFuncionalidades(this);
		listarFuncionalidades.start();
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
	
	public Usuario getAuthUser() {
		return auth.getAuthUser();
	}
	
	public void refreshUsuarios() {
		usuarios = usuarioBo.getUsuarios(); // actualizo la lista usuarios local
	}
	
	public void refreshRoles() {
		roles = rolBo.getRoles(); // actualizo la lista roles local
	}
	
	public void refreshFuncionalidades() {
		funcionalidades = funcionalidadBo.getFuncionalidades(); // actualizo la lista funcionalidades local
	}
	
	public void bootstrap() {
		auth.bootstrap();
		refreshUsuarios();
		login.mensajeEditarAdminPassword();
	}
	
	public boolean createUsuario(Usuario usuario) {
		boolean result = usuarioBo.createUsuario(usuario);
		if(result) refreshUsuarios();
		return result;
	}
	
	public boolean createRol(Rol rol) {
		boolean result = rolBo.createRol(rol);
		if(result) refreshRoles();
		return result;
	}
	
	public boolean createFuncionalidad(Funcionalidad funcionalidad) {
		boolean result = funcionalidadBo.createFuncionalidad(funcionalidad);
		if(result) refreshFuncionalidades();
		return result;
	}
	
	public boolean updateUsuario(Usuario usuario) {
		boolean result = usuarioBo.updateUsuario(usuario);
		if(result) refreshUsuarios();
		return result;
	}
	
	public boolean updateRol(Rol rol) {
		boolean result = rolBo.updateRol(rol);
		if(result) refreshRoles();
		return result;
	}
	
	public boolean updateFuncionalidad(Funcionalidad funcionalidad) {
		boolean result = funcionalidadBo.updateFuncionalidad(funcionalidad);
		if(result) refreshFuncionalidades();
		return result;
	}
	
	public boolean deleteUsuario(Long id) {
		boolean result = usuarioBo.deleteUsuario(id);
		if(result) refreshUsuarios();
		return result;
	}
	
	public boolean deleteRol(Long id) {
		boolean result = rolBo.deleteRol(id);
		if(result) refreshRoles();
		return result;
	}
	
	public boolean deleteFuncionalidad(Long id) {
		boolean result = funcionalidadBo.deleteFuncionalidad(id);
		if(result) refreshFuncionalidades();
		return result;
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
	
	public Usuario readUsuario(String nombre) {
		Usuario usuario = usuarios.stream()
				.filter(u -> u.getNombre().equals(nombre))
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

}
