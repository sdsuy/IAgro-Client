package com.presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JDesktopPane;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JList;
import java.awt.Color;

public class ListarCasillas {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListarCasillas window = new ListarCasillas();
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
	public ListarCasillas() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 299, 522);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(173, 216, 230));
		frame.getContentPane().add(desktopPane, BorderLayout.CENTER);
		
		JButton btnEliminar = new JButton("");
		btnEliminar.setIcon(new ImageIcon(ListarCasillas.class.getResource("/img/EliminarSeleccionado.png")));
		btnEliminar.setBounds(38, 430, 211, 42);
		desktopPane.add(btnEliminar);
		
		JButton btnVolver = new JButton("");
		btnVolver.setIcon(new ImageIcon(ListarCasillas.class.getResource("/img/BotonVolver.png")));
		btnVolver.setBounds(10, 11, 98, 33);
		desktopPane.add(btnVolver);
		
		JList list = new JList();
		list.setBounds(27, 155, 232, 250);
		desktopPane.add(list);
	}

}
