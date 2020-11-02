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

public class CrearRol {

	private JFrame frame;
	private JTextField textFieldNombre;
	
	private IAgro iagro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrearRol window = new CrearRol();
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
	public CrearRol() {
		initialize();
	}
	
	/**
	 * 
	 * Constructor con la aplicacion de IAgro inyectada.
	 */
	public CrearRol(IAgro iagro) {
		this.iagro = iagro;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 430, 377);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JDesktopPane desktopPane = new JDesktopPane();
		frame.getContentPane().add(desktopPane, BorderLayout.CENTER);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(149, 295, 106, 37);
		desktopPane.add(btnGuardar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(315, 309, 89, 23);
		desktopPane.add(btnCancelar);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(86, 108, 124, 20);
		desktopPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 111, 46, 14);
		desktopPane.add(lblNombre);
		
		JLabel lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setBounds(10, 136, 71, 14);
		desktopPane.add(lblDescripcion);
		
		JTextArea textAreaDescripcion = new JTextArea();
		textAreaDescripcion.setBounds(86, 139, 124, 97);
		desktopPane.add(textAreaDescripcion);
		
		JLabel lblFuncionalidades = new JLabel("Funcionalidades:");
		lblFuncionalidades.setBounds(291, 95, 89, 14);
		desktopPane.add(lblFuncionalidades);
		
		JTextArea textAreaFuncionalidades = new JTextArea();
		textAreaFuncionalidades.setBounds(253, 117, 151, 153);
		desktopPane.add(textAreaFuncionalidades);
	}
}
