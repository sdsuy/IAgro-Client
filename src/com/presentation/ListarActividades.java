package com.presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JDesktopPane;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;

import com.entities.Actividad;
import com.entities.Usuario;

import java.awt.Component;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ListarActividades implements IFrame<Actividad>{

	private JFrame frame;

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
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setFields(Actividad o) {
		// TODO Auto-generated method stub
		
	}
}
