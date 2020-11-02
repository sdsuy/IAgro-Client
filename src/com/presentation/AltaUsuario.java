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

public class AltaUsuario {

	private JFrame frame;
	private JTextField textNombre;
	private JTextField textApellido;
	private JTextField textFieldEmail;
	private JTextField textFieldPass;
	private JTextField textFieldCedula;
	private JTextField textFieldRepetirContrasenia;
	
	private IAgro iagro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AltaUsuario window = new AltaUsuario();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Start the application.
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
	public AltaUsuario() {
		initialize();
	}
	
	/**
	 * Create the application with IAgro.
	 */
	public AltaUsuario(IAgro iagro) {
		this.iagro = iagro;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 430, 377);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JDesktopPane desktopPane = new JDesktopPane();
		frame.getContentPane().add(desktopPane, BorderLayout.CENTER);
		
		JLabel lblRol = new JLabel("Rol:");
		lblRol.setBounds(149, 83, 25, 14);
		desktopPane.add(lblRol);
		
		JComboBox comboBoxRol = new JComboBox();
		comboBoxRol.setBounds(178, 79, 98, 22);
		desktopPane.add(comboBoxRol);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(149, 295, 106, 37);
		desktopPane.add(btnGuardar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(315, 309, 89, 23);
		desktopPane.add(btnCancelar);
		
		textNombre = new JTextField();
		textNombre.setBounds(178, 108, 98, 20);
		desktopPane.add(textNombre);
		textNombre.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(128, 111, 46, 14);
		desktopPane.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(128, 138, 46, 14);
		desktopPane.add(lblApellido);
		
		textApellido = new JTextField();
		textApellido.setBounds(178, 135, 98, 20);
		desktopPane.add(textApellido);
		textApellido.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(139, 166, 35, 14);
		desktopPane.add(lblEmail);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(178, 163, 176, 20);
		desktopPane.add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		JLabel lblContrasenia = new JLabel("Contrase\u00F1a:");
		lblContrasenia.setBounds(112, 223, 60, 14);
		desktopPane.add(lblContrasenia);
		
		textFieldPass = new JTextField();
		textFieldPass.setBounds(178, 220, 98, 20);
		desktopPane.add(textFieldPass);
		textFieldPass.setColumns(10);
		
		JLabel lblRepetirContrasenia = new JLabel("Repetir Contrase\u00F1a:");
		lblRepetirContrasenia.setBounds(74, 251, 98, 14);
		desktopPane.add(lblRepetirContrasenia);
		
		textFieldRepetirContrasenia = new JTextField();
		textFieldRepetirContrasenia.setBounds(178, 248, 98, 20);
		desktopPane.add(textFieldRepetirContrasenia);
		textFieldRepetirContrasenia.setColumns(10);
		
		JLabel lblCedula = new JLabel("Cedula:");
		lblCedula.setBounds(132, 195, 37, 14);
		desktopPane.add(lblCedula);
		
		textFieldCedula = new JTextField();
		textFieldCedula.setBounds(178, 192, 98, 20);
		desktopPane.add(textFieldCedula);
		textFieldCedula.setColumns(10);
	}
}
