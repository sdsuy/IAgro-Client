package com.presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JDesktopPane;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;

import com.application.IAgro;
import com.entities.Actividad;
import com.entities.Usuario;

import java.awt.Component;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListarActividades implements IFrame<Actividad>{

	private JFrame frame;
	private IAgro iagro;
	private Long id;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListarActividades window = new ListarActividades();
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
	public ListarActividades() {
		initialize();
	}
	/**
	 * Constructor con la aplicacion de IAgro inyectada.
	 */
	public ListarActividades(IAgro iagro) {
		this.iagro = iagro;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 668, 446);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JDesktopPane desktopPane = new JDesktopPane();
		frame.getContentPane().add(desktopPane, BorderLayout.CENTER);
		
		JScrollPane scrollPane = new JScrollPane((Component) null);
		scrollPane.setBounds(10, 116, 633, 175);
		desktopPane.add(scrollPane);
		
		JButton btnModificar = new JButton("");
		btnModificar.setIcon(new ImageIcon(ListarActividades.class.getResource("/img/BotonModificarSeleccionada.png")));
		btnModificar.setBounds(20, 321, 229, 42);
		desktopPane.add(btnModificar);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(ListarActividades.class.getResource("/img/ActividadesDeCampo.png")));
		lblFondo.setBounds(91, 0, 486, 414);
		desktopPane.add(lblFondo);
		
		JButton btnMenu = new JButton("");
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				frame.dispose();
			}
		});
		btnMenu.setIcon(new ImageIcon(ListarActividades.class.getResource("/img/BotonMenu.png")));
		btnMenu.setBounds(0, 11, 92, 33);
		desktopPane.add(btnMenu);
	}

	@Override
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

	@Override
	public void setFields(Actividad o) {
		// TODO Auto-generated method stub
		
	}
}