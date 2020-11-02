package com.presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JToolBar;

import com.application.IAgro;

import java.awt.BorderLayout;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class CrearFuncionalidad {

	private JFrame frame;
	private JTextField textNombre;
	
	private IAgro iagro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrearFuncionalidad window = new CrearFuncionalidad();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * 
	 * Hago visible la ventana de Login
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
	public CrearFuncionalidad() {
		initialize();
	}
	
	/**
	 * 
	 * Constructor con la aplicacion de IAgro inyectada.
	 */
	public CrearFuncionalidad(IAgro iagro) {
		this.iagro = iagro;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 357, 377);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JDesktopPane desktopPane = new JDesktopPane();
		frame.getContentPane().add(desktopPane, BorderLayout.CENTER);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(110, 290, 106, 37);
		desktopPane.add(btnGuardar);
		
		textNombre = new JTextField();
		textNombre.setBounds(10, 133, 98, 20);
		desktopPane.add(textNombre);
		textNombre.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(37, 111, 46, 14);
		desktopPane.add(lblNombre);
		
		JLabel lblNewLabel = new JLabel("Descripcion:");
		lblNewLabel.setBounds(224, 111, 60, 14);
		desktopPane.add(lblNewLabel);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(177, 131, 154, 120);
		desktopPane.add(textArea);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(228, 290, 106, 37);
		desktopPane.add(btnCancelar);
	}
}
