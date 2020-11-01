package com.presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JDesktopPane;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.Font;
import javax.swing.JPanel;

public class MenuPrincipal {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal window = new MenuPrincipal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MenuPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 750, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JDesktopPane desktopPane = new JDesktopPane();
		frame.getContentPane().add(desktopPane, BorderLayout.CENTER);
		
		JButton btnUsuarios = new JButton("Usuarios");
		btnUsuarios.setBounds(30, 133, 182, 59);
		desktopPane.add(btnUsuarios);
		
		JButton btnFuncionalidades = new JButton("Funcionalidades");
		btnFuncionalidades.setBounds(279, 133, 182, 59);
		desktopPane.add(btnFuncionalidades);
		
		JButton btnRoles = new JButton("Roles");
		btnRoles.setBounds(527, 133, 182, 59);
		desktopPane.add(btnRoles);
		
		JDesktopPane desktopPaneUsuarios = new JDesktopPane();
		desktopPaneUsuarios.setBounds(75, 210, 100, 81);
		desktopPane.add(desktopPaneUsuarios);
		
		JButton btnAltaUsuario = new JButton("Alta");
		btnAltaUsuario.setBounds(6, 11, 89, 23);
		desktopPaneUsuarios.add(btnAltaUsuario);
		
		JButton btnListarUsuarios = new JButton("Listar");
		btnListarUsuarios.setBounds(6, 45, 89, 23);
		desktopPaneUsuarios.add(btnListarUsuarios);
		
		JDesktopPane desktopPaneFormularios = new JDesktopPane();
		desktopPaneFormularios.setBounds(321, 210, 100, 81);
		desktopPane.add(desktopPaneFormularios);
		
		JButton btnCrearFormularios = new JButton("Crear");
		btnCrearFormularios.setBounds(6, 11, 89, 23);
		desktopPaneFormularios.add(btnCrearFormularios);
		
		JButton btnListarFormularios = new JButton("Listar");
		btnListarFormularios.setBounds(6, 45, 89, 23);
		desktopPaneFormularios.add(btnListarFormularios);
		
		JDesktopPane desktopPaneCasillas = new JDesktopPane();
		desktopPaneCasillas.setBounds(562, 210, 127, 81);
		desktopPane.add(desktopPaneCasillas);
		
		JButton btnCrearCasillas = new JButton("Crear");
		btnCrearCasillas.setBounds(10, 11, 107, 23);
		desktopPaneCasillas.add(btnCrearCasillas);
		
		JButton btnListar = new JButton("Listar");
		btnListar.setBounds(10, 45, 107, 23);
		desktopPaneCasillas.add(btnListar);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setBounds(635, 11, 89, 23);
		desktopPane.add(btnLogout);
	}
}
