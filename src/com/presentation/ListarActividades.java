package com.presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JDesktopPane;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.JButton;

public class ListarActividades {

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
		frame.setBounds(100, 100, 668, 424);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JDesktopPane desktopPane = new JDesktopPane();
		frame.getContentPane().add(desktopPane, BorderLayout.CENTER);
		
		JScrollPane scrollPane = new JScrollPane((Component) null);
		scrollPane.setBounds(10, 165, 633, 136);
		desktopPane.add(scrollPane);
		
		JButton btnNewButton = new JButton("Modificar Seleccionada");
		btnNewButton.setBounds(31, 331, 170, 23);
		desktopPane.add(btnNewButton);
	}
}
