package com.presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JToolBar;
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
	private JTextField textFieldNombUsuario;
	private JTextField textFieldPass;
	private JTextField textFieldInstituto;
	private JTextField textFieldCedula;
	private JTextField textFieldProfesion;
	private JTextField textFieldRepetirContrasenia;

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
	 * Create the application.
	 */
	public AltaUsuario() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 430, 528);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JDesktopPane desktopPane = new JDesktopPane();
		frame.getContentPane().add(desktopPane, BorderLayout.CENTER);
		
		JLabel lblRol = new JLabel("Rol:");
		lblRol.setBounds(149, 83, 25, 14);
		desktopPane.add(lblRol);
		
		JComboBox comboBoxRol = new JComboBox();
		comboBoxRol.setBounds(178, 79, 98, 22);
		desktopPane.add(comboBoxRol);
		
		JDesktopPane desktopPaneComun = new JDesktopPane();
		desktopPaneComun.setBounds(59, 108, 305, 184);
		desktopPane.add(desktopPaneComun);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(68, 14, 46, 14);
		desktopPaneComun.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(68, 45, 46, 14);
		desktopPaneComun.add(lblApellido);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(79, 74, 35, 14);
		desktopPaneComun.add(lblEmail);
		
		JLabel lblNombreDeUsuario = new JLabel("Nombre de usuario:");
		lblNombreDeUsuario.setBounds(16, 102, 98, 14);
		desktopPaneComun.add(lblNombreDeUsuario);
		
		JLabel lblContrasenia = new JLabel("Contrase\u00F1a:");
		lblContrasenia.setBounds(54, 131, 60, 14);
		desktopPaneComun.add(lblContrasenia);
		
		JLabel lblRepetirContrasenia = new JLabel("Repetir Contrase\u00F1a:");
		lblRepetirContrasenia.setBounds(16, 156, 98, 14);
		desktopPaneComun.add(lblRepetirContrasenia);
		
		textFieldNombUsuario = new JTextField();
		textFieldNombUsuario.setBounds(119, 99, 98, 20);
		desktopPaneComun.add(textFieldNombUsuario);
		textFieldNombUsuario.setColumns(10);
		
		textFieldPass = new JTextField();
		textFieldPass.setBounds(119, 128, 98, 20);
		desktopPaneComun.add(textFieldPass);
		textFieldPass.setColumns(10);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(119, 70, 176, 20);
		desktopPaneComun.add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		textApellido = new JTextField();
		textApellido.setBounds(119, 42, 98, 20);
		desktopPaneComun.add(textApellido);
		textApellido.setColumns(10);
		
		textNombre = new JTextField();
		textNombre.setBounds(119, 11, 98, 20);
		desktopPaneComun.add(textNombre);
		textNombre.setColumns(10);
		
		textFieldRepetirContrasenia = new JTextField();
		textFieldRepetirContrasenia.setColumns(10);
		textFieldRepetirContrasenia.setBounds(119, 153, 98, 20);
		desktopPaneComun.add(textFieldRepetirContrasenia);
		
		JDesktopPane desktopPaneAdministrador = new JDesktopPane();
		desktopPaneAdministrador.setBounds(59, 385, 305, 36);
		desktopPane.add(desktopPaneAdministrador);
		
		JLabel lblInstituto = new JLabel("Instituto:");
		lblInstituto.setBounds(65, 11, 46, 14);
		desktopPaneAdministrador.add(lblInstituto);
		
		textFieldInstituto = new JTextField();
		textFieldInstituto.setColumns(10);
		textFieldInstituto.setBounds(118, 8, 98, 20);
		desktopPaneAdministrador.add(textFieldInstituto);
		
		JDesktopPane desktopPaneExperto = new JDesktopPane();
		desktopPaneExperto.setBounds(59, 303, 305, 71);
		desktopPane.add(desktopPaneExperto);
		
		JLabel lblCedula = new JLabel("Cedula:");
		lblCedula.setBounds(74, 11, 37, 14);
		desktopPaneExperto.add(lblCedula);
		
		JLabel lblProfesion = new JLabel("Profesion:");
		lblProfesion.setBounds(62, 42, 49, 14);
		desktopPaneExperto.add(lblProfesion);
		
		textFieldCedula = new JTextField();
		textFieldCedula.setColumns(10);
		textFieldCedula.setBounds(118, 8, 98, 20);
		desktopPaneExperto.add(textFieldCedula);
		
		textFieldProfesion = new JTextField();
		textFieldProfesion.setColumns(10);
		textFieldProfesion.setBounds(118, 39, 98, 20);
		desktopPaneExperto.add(textFieldProfesion);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(149, 441, 106, 37);
		desktopPane.add(btnGuardar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(315, 455, 89, 23);
		desktopPane.add(btnCancelar);
	}
}
