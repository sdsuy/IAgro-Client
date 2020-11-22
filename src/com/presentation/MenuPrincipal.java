package com.presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JDesktopPane;
import javax.swing.JButton;

import com.application.IAgro;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

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
		frame.setBounds(100, 100, 826, 519);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(173, 216, 230));
		frame.getContentPane().add(desktopPane, BorderLayout.CENTER);
		
		desktopPaneUsuarios = new JDesktopPane();
		desktopPaneUsuarios.setBackground(new Color(173, 216, 230));
		desktopPaneUsuarios.setBounds(51, 210, 100, 81);
		desktopPane.add(desktopPaneUsuarios);
		desktopPaneUsuarios.setVisible(false);
		
		JButton btnUsuarios = new JButton("Usuarios");
		btnUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				visibilidad(desktopPaneUsuarios);
				
			}
		});
		btnUsuarios.setBounds(10, 133, 182, 59);
		desktopPane.add(btnUsuarios);
		
		JButton btnAltaUsuario = new JButton("Alta");
		btnAltaUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iagro.show(AltaUsuario.class);
			}
		});
		btnAltaUsuario.setBounds(6, 11, 89, 23);
		desktopPaneUsuarios.add(btnAltaUsuario);
		
		JButton btnListarUsuarios = new JButton("Listar");
		btnListarUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iagro.show(ListarUsuarios.class);
			}
		});
		btnListarUsuarios.setBounds(6, 45, 89, 23);
		desktopPaneUsuarios.add(btnListarUsuarios);
		
		desktopPaneFuncionalidades = new JDesktopPane();
		desktopPaneFuncionalidades.setBackground(new Color(173, 216, 230));
		desktopPaneFuncionalidades.setBounds(255, 210, 100, 81);
		desktopPane.add(desktopPaneFuncionalidades);
		desktopPaneFuncionalidades.setVisible(false);
		
		JButton btnFuncionalidades = new JButton("Formularios");
		btnFuncionalidades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				visibilidad(desktopPaneFuncionalidades);
				
			}
		});
		btnFuncionalidades.setBounds(214, 133, 182, 59);
		desktopPane.add(btnFuncionalidades);
		
		JButton btnCrearFuncionalidades = new JButton("Crear");
		btnCrearFuncionalidades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnCrearFuncionalidades.setBounds(6, 11, 89, 23);
		desktopPaneFuncionalidades.add(btnCrearFuncionalidades);
		
		JButton btnListarFuncionalidades = new JButton("Listar");
		btnListarFuncionalidades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnListarFuncionalidades.setBounds(6, 45, 89, 23);
		desktopPaneFuncionalidades.add(btnListarFuncionalidades);
		
		desktopPaneRoles = new JDesktopPane();
		desktopPaneRoles.setBackground(new Color(173, 216, 230));
		desktopPaneRoles.setBounds(444, 211, 127, 44);
		desktopPane.add(desktopPaneRoles);
		desktopPaneRoles.setVisible(false);
		
		JButton btnRoles = new JButton("Casillas");
		btnRoles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				visibilidad(desktopPaneRoles);
				
			}
		});
		btnRoles.setBounds(416, 133, 182, 59);
		desktopPane.add(btnRoles);
		
		JButton btnCrearRoles = new JButton("Crear");
		btnCrearRoles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnCrearRoles.setBounds(10, 11, 107, 23);
		desktopPaneRoles.add(btnCrearRoles);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iagro.logout();
				frame.dispose(); // cierro principal
			}
		});
		btnLogout.setBounds(726, 11, 89, 23);
		desktopPane.add(btnLogout);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/img/MenuPrincipal.png")));
		lblFondo.setBounds(177, 0, 471, 480);
		desktopPane.add(lblFondo);
		
		JButton btnActividadesDeCamp = new JButton("Actividades de Camp");
		btnActividadesDeCamp.setBounds(619, 133, 182, 59);
		desktopPane.add(btnActividadesDeCamp);
		
		JDesktopPane desktopPane_1 = new JDesktopPane();
		desktopPane_1.setBackground(new Color(173, 216, 230));
		desktopPane_1.setBounds(641, 210, 138, 44);
		desktopPane.add(desktopPane_1);
		
		JButton btnCrearActividad = new JButton("Crear");
		btnCrearActividad.setBounds(27, 11, 89, 23);
		desktopPane_1.add(btnCrearActividad);
		
		
		
	}
	
	public void visibilidad(JDesktopPane visible) {
		
		desktopPaneUsuarios.setVisible(false);
		desktopPaneFuncionalidades.setVisible(false);
		desktopPaneRoles.setVisible(false);
		visible.setVisible(true);

	}
}
