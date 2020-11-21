package com.presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JDesktopPane;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JList;
import java.awt.Color;
import javax.swing.JLabel;

public class AgregarCasillas {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgregarCasillas window = new AgregarCasillas();
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
	public AgregarCasillas() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 299, 479);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(173, 216, 230));
		frame.getContentPane().add(desktopPane, BorderLayout.CENTER);
		
		JButton btnAgregar = new JButton("");
		btnAgregar.setIcon(new ImageIcon(AgregarCasillas.class.getResource("/img/BotonAgregarSeleccionada.png")));
		btnAgregar.setBounds(27, 384, 232, 42);
		desktopPane.add(btnAgregar);
		
		JButton btnVolver = new JButton("");
		btnVolver.setIcon(new ImageIcon(AgregarCasillas.class.getResource("/img/BotonVolver.png")));
		btnVolver.setBounds(10, 11, 98, 33);
		desktopPane.add(btnVolver);
		
		JList list = new JList();
		list.setBounds(27, 112, 232, 250);
		desktopPane.add(list);
		
		JLabel lblTitulo = new JLabel("");
		lblTitulo.setIcon(new ImageIcon(AgregarCasillas.class.getResource("/img/ListarCasillas.png")));
		lblTitulo.setBounds(86, 55, 124, 70);
		desktopPane.add(lblTitulo);
	}

}
