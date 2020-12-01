package com.presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JDesktopPane;
import javax.swing.JButton;

import com.application.IAgro;
import com.entities.Actividad;
import com.service.AuthBean;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class MenuPrincipal  {

	private JFrame frame;
	JDesktopPane desktopPaneUsuarios;
	JDesktopPane desktopPaneFormularios;
	JDesktopPane desktopPaneCasillas;
	JDesktopPane desktopPaneActividades;
	private JButton btnAltaUsuario;
	private JButton btnListarUsuarios;
	private JButton btnFormularios;
	private JButton btnCrearFormularios;
	private JButton btnCasillas;
	private JButton btnListarFormularios;
	private JButton btnCrearCasillas;
	private JButton btnLogout;
	private JButton btnActividades;
	private JButton btnCrearActividad;
	private JButton btnUsuarios;
	
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
		frame.setResizable(false);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(173, 216, 230));
		frame.getContentPane().add(desktopPane, BorderLayout.CENTER);
		
		desktopPaneUsuarios = new JDesktopPane();
		desktopPaneUsuarios.setBackground(new Color(173, 216, 230));
		desktopPaneUsuarios.setBounds(44, 203, 110, 98);
		desktopPane.add(desktopPaneUsuarios);
		desktopPaneUsuarios.setVisible(false);
		
		btnUsuarios = new JButton("");
		btnUsuarios.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnUsuarios.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/img/BotonUsuarios.png")));
		btnUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				visibilidad(desktopPaneUsuarios);
				visibilidadUsuarios();
				
			}
		});
		btnUsuarios.setBounds(10, 133, 181, 59);
		desktopPane.add(btnUsuarios);
		
		btnAltaUsuario = new JButton("");
		btnAltaUsuario.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnAltaUsuario.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/img/BotonAlta.png")));
		btnAltaUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iagro.show(AltaUsuario.class);
			}
		});
		btnAltaUsuario.setBounds(6, 11, 100, 33);
		desktopPaneUsuarios.add(btnAltaUsuario);
		
		btnListarUsuarios = new JButton("");
		btnListarUsuarios.setCursor(new Cursor(Cursor.HAND_CURSOR));
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
		
		btnFormularios = new JButton("");
		btnFormularios.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnFormularios.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/img/BotonFormularios.png")));
		btnFormularios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				visibilidad(desktopPaneFormularios);
				visibilidadFormularios();
				
			}
		});
		btnFormularios.setBounds(214, 133, 181, 59);
		desktopPane.add(btnFormularios);
		
		
		btnCrearFormularios = new JButton("");
		btnCrearFormularios.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnCrearFormularios.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/img/BotonCrear.png")));
		btnCrearFormularios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iagro.show(CrearFormulario.class);
			}
		});
		btnCrearFormularios.setBounds(6, 11, 100, 33);
		desktopPaneFormularios.add(btnCrearFormularios);
		
		btnListarFormularios = new JButton("");
		btnListarFormularios.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnListarFormularios.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/img/BotonListar.png")));
		btnListarFormularios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iagro.show(ListarFormularios.class);
			}
		});
		btnListarFormularios.setBounds(6, 55, 100, 33);
		desktopPaneFormularios.add(btnListarFormularios);
		
		desktopPaneCasillas = new JDesktopPane();
		desktopPaneCasillas.setBackground(new Color(173, 216, 230));
		desktopPaneCasillas.setBounds(445, 203, 127, 52);
		desktopPane.add(desktopPaneCasillas);
		desktopPaneCasillas.setVisible(false);
		
		btnCasillas = new JButton("");
		btnCasillas.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnCasillas.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/img/BotonCasillas.png")));
		btnCasillas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				visibilidad(desktopPaneCasillas);
				visibilidadCasillas();
				
			}
		});
		btnCasillas.setBounds(416, 133, 181, 59);
		desktopPane.add(btnCasillas);
		
		btnCrearCasillas = new JButton("");
		btnCrearCasillas.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnCrearCasillas.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/img/BotonCrear.png")));
		btnCrearCasillas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				iagro.show(CrearCasilla.class);
			}
		});
		btnCrearCasillas.setBounds(10, 11, 100, 33);
		desktopPaneCasillas.add(btnCrearCasillas);
		
		btnLogout = new JButton("");
		btnLogout.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnLogout.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/img/BotonLogOut.png")));
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iagro.logout();
				frame.dispose(); // cierro principal
			}
		});
		btnLogout.setBounds(700, 11, 100, 33);
		desktopPane.add(btnLogout);
		
		btnActividades = new JButton("");
		btnActividades.setCursor(new Cursor(Cursor.HAND_CURSOR));
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
		desktopPaneActividades.setBounds(648, 203, 127, 98);
		desktopPane.add(desktopPaneActividades);
		
		btnCrearActividad = new JButton("");
		btnCrearActividad.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnCrearActividad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iagro.show(CrearActividad.class);
			}
		});
		btnCrearActividad.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/img/BotonCrear.png")));
		btnCrearActividad.setBounds(10, 11, 100, 33);
		desktopPaneActividades.add(btnCrearActividad);
		
		JButton btnListarActividades = new JButton("");
		btnListarActividades.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/img/BotonListar.png")));
		btnListarActividades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				iagro.show(ListarActividades.class);
				
			}
		});
		btnListarActividades.setBounds(10, 55, 100, 33);
		desktopPaneActividades.add(btnListarActividades);
		
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
	
	public void visibilidadUsuarios() {
		
		if (!iagro.getAuthUser().getRol().getRol().name().equals("ADMINISTRADOR")) {
			
			btnAltaUsuario.setEnabled(false);
			btnListarUsuarios.setEnabled(false);
			
		}
		
	}
	
    public void visibilidadFormularios() {
    	
        if(iagro.getAuthUser().getRol().getRol().name().equals("ADMINISTRADOR") || iagro.getAuthUser().getRol().getRol().name().equals("EXPERTO")) {
    		
    		//No hacemos nada
    		
    	}
        
        else {
        	btnCrearFormularios.setEnabled(false);
    	}
		
    	
		
	}
    
    public void visibilidadCasillas() {
    	
    	if(iagro.getAuthUser().getRol().getRol().name().equals("ADMINISTRADOR") || iagro.getAuthUser().getRol().getRol().name().equals("EXPERTO")) {
    		
    		//No hacemos nada
    		
    	}
    	
    	else {
    		btnCrearCasillas.setEnabled(false);
    	}
		
		
	}
}
