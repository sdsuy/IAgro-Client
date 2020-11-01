package com.presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JDesktopPane;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.application.IAgro;

import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login {

	private JFrame frame;
	private JTextField textFieldUser;
	private JPasswordField passwordFieldPass;
	
	private IAgro iagro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {
		initialize();
	}
	
	/**
	 * 
	 * Constructor con la aplicacion de IAgro inyectada.
	 */
	public Login(IAgro iagro) {
		this.iagro = iagro;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 750, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JDesktopPane desktopPane = new JDesktopPane();
		frame.getContentPane().add(desktopPane, BorderLayout.CENTER);
		
		textFieldUser = new JTextField();
		textFieldUser.setBounds(339, 223, 92, 24);
		desktopPane.add(textFieldUser);
		textFieldUser.setColumns(10);
		
		passwordFieldPass = new JPasswordField();
		passwordFieldPass.setColumns(10);
		passwordFieldPass.setBounds(339, 259, 92, 24);
		desktopPane.add(passwordFieldPass);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = textFieldUser.getText();
				String password = passwordFieldPass.getText();
				iagro.login(username, password); // seteo el usuario autenticado
				if(iagro.getAuthUser() != null) { // si se encuentra un usuario
					System.out.println(iagro.getAuthUser().getNombre());
				} else {
					// TODO:
					// error en caso de no encontrar un usuario
					System.out.println("Usuario no encontrado");
				}
			}
		});
		btnEntrar.setBounds(331, 335, 89, 23);
		desktopPane.add(btnEntrar);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(Login.class.getResource("/img/Login colaborativo.png")));
		lblFondo.setBounds(0, 0, 734, 461);
		desktopPane.add(lblFondo);
	}
}
