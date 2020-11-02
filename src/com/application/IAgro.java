package com.application;

import java.util.List;

import com.entities.Usuario;
import com.presentation.CrearFuncionalidad;
import com.presentation.CrearRol;
import com.presentation.AltaUsuario;
import com.presentation.Login;
import com.presentation.MenuPrincipal;
import com.remote.AuthBo;
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
	
	//***********************************************
	// Atributos para el manejo de la capa negocios
	//***********************************************
	
	private AuthBo auth; // autenticacion de usuarios
	private UsuarioBo usuarioBo; // usuarios
	
	private List<Usuario> usuarios; // listado de usuarios del sistema

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
		refreshUsuarios();
		if(usuarios.size() < 1) bootstrap();
		login.start(); // muestro la ventana de login con al menos 1 usuario por defecto cargado en la BD
	}
	
	//***********************************************
	// Metodos para el manejo de la capa presentacion
	//***********************************************
	
	public void menuPrincipal() {
		principal = new MenuPrincipal(this);
		principal.start();
	}
	
	public void altaUsuario() {
		altaUsuario = new AltaUsuario(this);
		altaUsuario.start();
	}
	
	public void crearRol() {
		crearRol = new CrearRol(this);
		crearRol.start();
	}
	
	public void crearFuncionalidad() {
		crearFuncionalidad = new CrearFuncionalidad(this);
		crearFuncionalidad.start();
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
	
	public void bootstrap() {
		auth.bootstrap();
		refreshUsuarios();
		login.mensajeEditarAdminPassword();
	}
	
	public boolean createUsuario(Usuario usuario) {
		return false;
	}

}
