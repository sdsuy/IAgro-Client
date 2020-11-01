package com.application;

import com.presentation.Login;

public class IAgro {
	
	private Login login; // capa presentacion de login

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
		login.start(); // muestro la ventana de login con al menos 1 usuario por defecto cargado en la BD
	}

}
