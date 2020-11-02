package com.presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JToolBar;

import com.application.IAgro;
import com.entities.Rol;
import com.entities.Usuario;

import java.awt.BorderLayout;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;

public class AltaUsuario {

	private JFrame frame;
	private JTextField textNombre;
	private JTextField textApellido;
	private JTextField textFieldEmail;
	private JTextField textFieldPass;
	private JTextField textFieldCedula;
	private JTextField textFieldRepetirContrasenia;
	
	private IAgro iagro;
	private JTextField textFieldNickname;
	

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
		frame.setBounds(100, 100, 631, 460);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JDesktopPane desktopPane = new JDesktopPane();
		frame.getContentPane().add(desktopPane, BorderLayout.CENTER);
		desktopPane.setLayout(null);
		
		JLabel lblRol = new JLabel("Rol:");
		lblRol.setBounds(149, 83, 25, 14);
		desktopPane.add(lblRol);
		
		JComboBox comboBoxRol = new JComboBox();
		comboBoxRol.setBounds(178, 79, 98, 22);
		desktopPane.add(comboBoxRol);
		
		iagro.refreshRoles();//trae en memoria
		List<Rol> roles = iagro.getRoles();
		for (Rol rol : roles) {
			comboBoxRol.addItem(rol.getNombre());
		}
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(149, 365, 106, 37);
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Patr�n para validar el email
		        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
		                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		        
		        Matcher mather = pattern.matcher(textFieldEmail.getText());
		      
		        //controlamos si hay algun campo vacio
		        if(textNombre.getText().isEmpty() || textApellido.getText().isEmpty() || textFieldEmail.getText().isEmpty() ||
		        		textFieldPass.getText().isEmpty() || textFieldRepetirContrasenia.getText().isEmpty() ||
		        		comboBoxRol.getToolkit().equals("") || textFieldNickname.getText().isEmpty()) {
		        	
		        	JOptionPane.showMessageDialog(null, "Debe rellenar todos los campos obligatorios","Error",JOptionPane.ERROR_MESSAGE);
		       
		        }//controlamos si el mail tiene un formato invalido
		        else if (mather.find() == false) {
					JOptionPane.showMessageDialog(null, "El Email que ingreso no tiene formato valido","Error",JOptionPane.ERROR_MESSAGE);
		        }
		        
		        else if(textFieldPass.getText().length()<8 || !(
		        		textFieldPass.getText().contains("0") ||
		        		textFieldPass.getText().contains("1") ||
		        		textFieldPass.getText().contains("2") ||
		        		textFieldPass.getText().contains("3") ||
		        		textFieldPass.getText().contains("4") ||
		        		textFieldPass.getText().contains("5") ||
		        		textFieldPass.getText().contains("6") ||
		        		textFieldPass.getText().contains("7") ||
		        		textFieldPass.getText().contains("8") ||
		        		textFieldPass.getText().contains("9"))) {
		        	
					JOptionPane.showMessageDialog(null, "El largo de la clave debe ser mayor o igual a 8 caracteres","Error",JOptionPane.ERROR_MESSAGE);

		        }
		        else {
		        	String repClave = "";
		        	
		        	String nomRol = comboBoxRol.getSelectedItem().toString();
		        	
		        	iagro.readRol(nomRol);
		        	Usuario user = new Usuario();
		        	user.setRol(iagro.readRol(nomRol));
		        	user.setApellido(textApellido.getText());
		        	user.setNombre(textNombre.getText());
		        	user.setDocumento(textFieldCedula.getText());
		        	user.setClave(textFieldPass.getText());
		        	user.setEmail(textFieldEmail.getText());
		        	user.setClave(textFieldPass.getText());
		        	user.setNickname(textFieldNickname.getText());
		        	iagro.createUsuario(user);
		        	JOptionPane.showConfirmDialog(null, "Se ha guardado correctamente el usuario","Listo",JOptionPane.DEFAULT_OPTION);
		        	limpiar();
		        	
		        	
		        }
			}
		});
		desktopPane.add(btnGuardar);
		
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
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiar();
			}
		});
		btnCancelar.setBounds(300, 365, 106, 37);
		desktopPane.add(btnCancelar);
		
		textFieldNickname = new JTextField();
		textFieldNickname.setColumns(10);
		textFieldNickname.setBounds(178, 280, 98, 20);
		desktopPane.add(textFieldNickname);
		
		JLabel lblNewLabel = new JLabel("Nickname");
		lblNewLabel.setBounds(98, 282, 61, 16);
		desktopPane.add(lblNewLabel);
	}
	
	public void limpiar() {
		textFieldNickname.setText("");
		textFieldCedula.setText("");
		textFieldPass.setText("");
		textFieldRepetirContrasenia.setText("");
		textFieldEmail.setText("");
		textApellido.setText("");
		textNombre.setText("");
		
	}
}
