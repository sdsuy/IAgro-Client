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
		desktopPaneUsuarios.setBounds(44, 203, 110, 98);
		desktopPane.add(desktopPaneUsuarios);
		desktopPaneUsuarios.setVisible(false);
		
		JButton btnUsuarios = new JButton("");
		btnUsuarios.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/img/BotonUsuarios.png")));
		btnUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				visibilidad(desktopPaneUsuarios);
				
			}
		});
		btnUsuarios.setBounds(10, 133, 181, 59);
		desktopPane.add(btnUsuarios);
		
		JButton btnAltaUsuario = new JButton("");
		btnAltaUsuario.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/img/BotonAlta.png")));
		btnAltaUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iagro.show(AltaUsuario.class);
			}
		});
		btnAltaUsuario.setBounds(6, 11, 100, 33);
		desktopPaneUsuarios.add(btnAltaUsuario);
		
		JButton btnListarUsuarios = new JButton("");
		btnListarUsuarios.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/img/BotonListar.png")));
		btnListarUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iagro.show(ListarUsuarios.class);
			}
		});
		btnListarUsuarios.setBounds(6, 55, 100, 33);
		desktopPaneUsuarios.add(btnListarUsuarios);
		
		desktopPaneFuncionalidades = new JDesktopPane();
		desktopPaneFuncionalidades.setBackground(new Color(173, 216, 230));
		desktopPaneFuncionalidades.setBounds(250, 203, 116, 98);
		desktopPane.add(desktopPaneFuncionalidades);
		desktopPaneFuncionalidades.setVisible(false);
		
		JButton btnFuncionalidades = new JButton("");
		btnFuncionalidades.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/img/BotonFormularios.png")));
		btnFuncionalidades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				visibilidad(desktopPaneFuncionalidades);
				
			}
		});
		btnFuncionalidades.setBounds(214, 133, 181, 59);
		desktopPane.add(btnFuncionalidades);
		
		JButton btnCrearFuncionalidades = new JButton("");
		btnCrearFuncionalidades.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/img/BotonCrear.png")));
		btnCrearFuncionalidades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iagro.show(CrearFormulario.class);
			}
		});
		btnCrearFuncionalidades.setBounds(6, 11, 100, 33);
		desktopPaneFuncionalidades.add(btnCrearFuncionalidades);
		
		JButton btnListarFuncionalidades = new JButton("");
		btnListarFuncionalidades.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/img/BotonListar.png")));
		btnListarFuncionalidades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnListarFuncionalidades.setBounds(6, 55, 100, 33);
		desktopPaneFuncionalidades.add(btnListarFuncionalidades);
		
		desktopPaneRoles = new JDesktopPane();
		desktopPaneRoles.setBackground(new Color(173, 216, 230));
		desktopPaneRoles.setBounds(445, 203, 127, 52);
		desktopPane.add(desktopPaneRoles);
		desktopPaneRoles.setVisible(false);
		
		JButton btnRoles = new JButton("");
		btnRoles.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/img/BotonCasillas.png")));
		btnRoles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				visibilidad(desktopPaneRoles);
				
			}
		});
		btnRoles.setBounds(416, 133, 181, 59);
		desktopPane.add(btnRoles);
		
		JButton btnCrearRoles = new JButton("");
		btnCrearRoles.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/img/BotonCrear.png")));
		btnCrearRoles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnCrearRoles.setBounds(10, 11, 100, 33);
		desktopPaneRoles.add(btnCrearRoles);
		
		JButton btnLogout = new JButton("");
		btnLogout.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/img/BotonLogOut.png")));
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iagro.logout();
				frame.dispose(); // cierro principal
			}
		});
		btnLogout.setBounds(700, 11, 100, 33);
		desktopPane.add(btnLogout);
		
		JButton btnActividadesDeCamp = new JButton("");
		btnActividadesDeCamp.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/img/BotonActividadesDeCampo.png")));
		btnActividadesDeCamp.setBounds(619, 133, 181, 59);
		desktopPane.add(btnActividadesDeCamp);
		
		JDesktopPane desktopPane_1 = new JDesktopPane();
		desktopPane_1.setBackground(new Color(173, 216, 230));
		desktopPane_1.setBounds(648, 203, 127, 52);
		desktopPane.add(desktopPane_1);
		
		JButton btnCrearActividad = new JButton("");
		btnCrearActividad.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/img/BotonCrear.png")));
		btnCrearActividad.setBounds(10, 11, 100, 33);
		desktopPane_1.add(btnCrearActividad);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setBounds(176, 0, 471, 480);
		desktopPane.add(lblFondo);
		lblFondo.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/img/MenuPrincipal.png")));
		
		
		
	}
	
	public void visibilidad(JDesktopPane visible) {
		
		desktopPaneUsuarios.setVisible(false);
		desktopPaneFuncionalidades.setVisible(false);
		desktopPaneRoles.setVisible(false);
		visible.setVisible(true);

	}
}
