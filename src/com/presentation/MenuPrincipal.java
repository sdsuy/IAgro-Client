package com.presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JDesktopPane;
import javax.swing.JButton;

import com.application.IAgro;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuPrincipal {

	private JFrame frame;
	JDesktopPane desktopPaneUsuarios;
	JDesktopPane desktopPaneFuncionalidades;
	JDesktopPane desktopPaneRoles;
	
	private IAgro iagro;

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
	 * Hago visible la ventana de Principal
	 */
	public void start() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame.setVisible(true);
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
	 * Create the application.
	 */
	public MenuPrincipal(IAgro iagro) {
		this.iagro = iagro;
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
		
		desktopPaneUsuarios = new JDesktopPane();
		desktopPaneUsuarios.setBounds(75, 210, 100, 81);
		desktopPane.add(desktopPaneUsuarios);
		desktopPaneUsuarios.setVisible(false);
		
		JButton btnUsuarios = new JButton("Usuarios");
		btnUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				visibilidad(desktopPaneUsuarios);
				
			}
		});
		btnUsuarios.setBounds(30, 133, 182, 59);
		desktopPane.add(btnUsuarios);
		
		JButton btnAltaUsuario = new JButton("Alta");
		btnAltaUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iagro.showAltaUsuario();
			}
		});
		btnAltaUsuario.setBounds(6, 11, 89, 23);
		desktopPaneUsuarios.add(btnAltaUsuario);
		
		JButton btnListarUsuarios = new JButton("Listar");
		btnListarUsuarios.setBounds(6, 45, 89, 23);
		desktopPaneUsuarios.add(btnListarUsuarios);
		
		desktopPaneFuncionalidades = new JDesktopPane();
		desktopPaneFuncionalidades.setBounds(321, 210, 100, 81);
		desktopPane.add(desktopPaneFuncionalidades);
		desktopPaneFuncionalidades.setVisible(false);
		
		JButton btnFuncionalidades = new JButton("Funcionalidades");
		btnFuncionalidades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				visibilidad(desktopPaneFuncionalidades);
				
			}
		});
		btnFuncionalidades.setBounds(279, 133, 182, 59);
		desktopPane.add(btnFuncionalidades);
		
		JButton btnCrearFuncionalidades = new JButton("Crear");
		btnCrearFuncionalidades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iagro.showCrearFuncionalidad();
			}
		});
		btnCrearFuncionalidades.setBounds(6, 11, 89, 23);
		desktopPaneFuncionalidades.add(btnCrearFuncionalidades);
		
		JButton btnListarFuncionalidades = new JButton("Listar");
		btnListarFuncionalidades.setBounds(6, 45, 89, 23);
		desktopPaneFuncionalidades.add(btnListarFuncionalidades);
		
		desktopPaneRoles = new JDesktopPane();
		desktopPaneRoles.setBounds(562, 210, 127, 81);
		desktopPane.add(desktopPaneRoles);
		desktopPaneRoles.setVisible(false);
		
		JButton btnRoles = new JButton("Roles");
		btnRoles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				visibilidad(desktopPaneRoles);
				
			}
		});
		btnRoles.setBounds(527, 133, 182, 59);
		desktopPane.add(btnRoles);
		
		JButton btnCrearRoles = new JButton("Crear");
		btnCrearRoles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iagro.showCrearRol();
			}
		});
		btnCrearRoles.setBounds(10, 11, 107, 23);
		desktopPaneRoles.add(btnCrearRoles);
		
		JButton btnListarRoles = new JButton("Listar");
		btnListarRoles.setBounds(10, 45, 107, 23);
		desktopPaneRoles.add(btnListarRoles);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iagro.logout();
				frame.dispose(); // cierro principal
			}
		});
		btnLogout.setBounds(635, 11, 89, 23);
		desktopPane.add(btnLogout);
		
		
		
	}
	
	public void visibilidad(JDesktopPane visible) {
		
		desktopPaneUsuarios.setVisible(false);
		desktopPaneFuncionalidades.setVisible(false);
		desktopPaneRoles.setVisible(false);
		visible.setVisible(true);

	}
}
