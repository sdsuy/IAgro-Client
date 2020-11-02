package com.application;

import java.util.List;

import com.entities.Usuario;
<<<<<<< HEAD
<<<<<<< HEAD
import com.presentation.CrearFuncionalidad;
import com.presentation.CrearRol;
=======
import com.presentation.AltaUsuario;
>>>>>>> d167de756ff046365799dd633bfec463d21387b2
=======
import com.presentation.AltaUsuario;
>>>>>>> origin/master
import com.presentation.Login;
import com.presentation.MenuPrincipal;
import com.remote.AuthBo;
import com.remote.UsuarioBo;

public class IAgro {
	
<<<<<<< HEAD
<<<<<<< HEAD
	private Login login; // capa presentacion de login
	private MenuPrincipal principal; // capa presentacion de menu principal
	private CrearRol crearRol; // capa presentacion de menu crear rol
	private CrearFuncionalidad crearFuncionalidad; // capa presentacion de menu crear rol
=======
=======
>>>>>>> origin/master
	//***********************************************
	// Atributos para el manejo de la capa presentacion
	//***********************************************
	
	private Login login; // login
	private MenuPrincipal principal; // menu principal
	private AltaUsuario altaUsuario; // alta usuario
	
	//***********************************************
	// Atributos para el manejo de la capa negocios
	//***********************************************
<<<<<<< HEAD
>>>>>>> d167de756ff046365799dd633bfec463d21387b2
=======
>>>>>>> origin/master
	
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
	
	//**********************************************
	// Metodos para el manejo de la capa de negocios
	//**********************************************
	
	public void login(String username, String password) {
		auth.login(username, password);
	}
	
	public void crearRol() {
		crearRol = new CrearRol(this);
		crearRol.start();
	}
	
	public void crearFuncionalidad() {
		crearFuncionalidad = new CrearFuncionalidad(this);
		crearFuncionalidad.start();
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

}
