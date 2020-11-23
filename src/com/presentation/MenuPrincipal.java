package com.presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JDesktopPane;
import javax.swing.JButton;

import com.application.IAgro;
import com.entities.Actividad;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class MenuPrincipal implements IFrame<Actividad>{

	private JFrame frame;
	JDesktopPane desktopPaneUsuarios;
	JDesktopPane desktopPaneFormularios;
	JDesktopPane desktopPaneCasillas;
	JDesktopPane desktopPaneActividades;
	
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
		
		desktopPaneFormularios = new JDesktopPane();
		desktopPaneFormularios.setBackground(new Color(173, 216, 230));
		desktopPaneFormularios.setBounds(250, 203, 116, 98);
		desktopPane.add(desktopPaneFormularios);
		desktopPaneFormularios.setVisible(false);
		
		JButton btnFuncionalidades = new JButton("");
		btnFuncionalidades.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/img/BotonFormularios.png")));
		btnFuncionalidades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				visibilidad(desktopPaneFormularios);
				
			}
		});
		btnFuncionalidades.setBounds(214, 133, 181, 59);
		desktopPane.add(btnFuncionalidades);
		
		JButton btnCrearFormularios = new JButton("");
		btnCrearFormularios.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/img/BotonCrear.png")));
		btnCrearFormularios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iagro.show(CrearFormulario.class);
			}
		});
		btnCrearFormularios.setBounds(6, 11, 100, 33);
		desktopPaneFormularios.add(btnCrearFormularios);
		
		JButton btnListarFormularios = new JButton("");
		btnListarFormularios.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/img/BotonListar.png")));
		btnListarFormularios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnListarFormularios.setBounds(6, 55, 100, 33);
		desktopPaneFormularios.add(btnListarFormularios);
		
		desktopPaneCasillas = new JDesktopPane();
		desktopPaneCasillas.setBackground(new Color(173, 216, 230));
		desktopPaneCasillas.setBounds(445, 203, 127, 52);
		desktopPane.add(desktopPaneCasillas);
		desktopPaneCasillas.setVisible(false);
		
		JButton btnRoles = new JButton("");
		btnRoles.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/img/BotonCasillas.png")));
		btnRoles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				visibilidad(desktopPaneCasillas);
				
			}
		});
		btnRoles.setBounds(416, 133, 181, 59);
		desktopPane.add(btnRoles);
		
		JButton btnCrearRoles = new JButton("");
		btnCrearRoles.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/img/BotonCrear.png")));
		btnCrearRoles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iagro.show(CrearCasilla.class);
			}
		});
		btnCrearRoles.setBounds(10, 11, 100, 33);
		desktopPaneCasillas.add(btnCrearRoles);
		
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
		
		JButton btnActividades = new JButton("");
		btnActividades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				visibilidad(desktopPaneActividades);
				
			}
		});
		btnActividades.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/img/BotonActividadesDeCampo.png")));
		btnActividades.setBounds(619, 133, 181, 59);
		desktopPane.add(btnActividades);
		
		desktopPaneActividades = new JDesktopPane();
		desktopPaneActividades.setBackground(new Color(173, 216, 230));
		desktopPaneActividades.setBounds(648, 203, 127, 52);
		desktopPane.add(desktopPaneActividades);
		
		JButton btnCrearActividad = new JButton("");
		btnCrearActividad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iagro.show(CrearActividad.class);
			}
		});
		btnCrearActividad.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/img/BotonCrear.png")));
		btnCrearActividad.setBounds(10, 11, 100, 33);
		desktopPaneActividades.add(btnCrearActividad);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setBounds(176, 0, 471, 480);
		desktopPane.add(lblFondo);
		lblFondo.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/img/MenuPrincipal.png")));
		
		
		
	}
	
	public void visibilidad(JDesktopPane visible) {
		
		desktopPaneUsuarios.setVisible(false);
		desktopPaneFormularios.setVisible(false);
		desktopPaneCasillas.setVisible(false);
		desktopPaneActividades.setVisible(false);
		visible.setVisible(true);

	}

	@Override
	public void setFields(Actividad o) {
		// TODO Auto-generated method stub
		
	}
}
