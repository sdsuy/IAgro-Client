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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Font;

public class AltaUsuario implements IFrame<Usuario> {

	private JFrame frame;
	private JTextField textNombre;
	private JTextField textApellido;
	private JTextField textFieldEmail;
	private JPasswordField passwordFieldPass;
	private JPasswordField passwordFieldRepetirContrasenia;
	private JTextField textFieldCedula;
	
	
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
		frame.setBounds(100, 100, 432, 460);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(173, 216, 230));
		frame.getContentPane().add(desktopPane, BorderLayout.CENTER);
		desktopPane.setLayout(null);
		
		JLabel lblRol = new JLabel("Rol:");
		lblRol.setBounds(112, 83, 56, 14);
		desktopPane.add(lblRol);
		
		JComboBox comboBoxRol = new JComboBox();
		comboBoxRol.setBounds(178, 79, 98, 22);
		desktopPane.add(comboBoxRol);
		
		// iagro.refresh(Rol.class);//trae en memoria // no seria necesario porque los carga menu principal
		List<Rol> roles = iagro.getRoles();
		for (Rol rol : roles) {
			comboBoxRol.addItem(rol.getNombre());
		}
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(74, 365, 106, 37);
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Patr�n para validar el email
		        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
		                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		        
		        Matcher mather = pattern.matcher(textFieldEmail.getText());
		      
		        //controlamos si hay algun campo vacio
		        if(textNombre.getText().isEmpty() || textApellido.getText().isEmpty() || textFieldEmail.getText().isEmpty() ||
		        		passwordFieldPass.getText().isEmpty() || passwordFieldRepetirContrasenia.getText().isEmpty() ||
		        		comboBoxRol.getToolkit().equals("") || textFieldNickname.getText().isEmpty()) {
		        	
		        	JOptionPane.showMessageDialog(null, "Debe rellenar todos los campos obligatorios","Error",JOptionPane.ERROR_MESSAGE);
		       
		        }//controlamos si el mail tiene un formato invalido
		        else if (mather.find() == false) {
					JOptionPane.showMessageDialog(null, "El Email que ingreso no tiene formato valido","Error",JOptionPane.ERROR_MESSAGE);
		        }
		        
		        else if(passwordFieldPass.getText().length()<8 || !(
		        		passwordFieldPass.getText().contains("0") ||
		        		passwordFieldPass.getText().contains("1") ||
		        		passwordFieldPass.getText().contains("2") ||
		        		passwordFieldPass.getText().contains("3") ||
		        		passwordFieldPass.getText().contains("4") ||
		        		passwordFieldPass.getText().contains("5") ||
		        		passwordFieldPass.getText().contains("6") ||
		        		passwordFieldPass.getText().contains("7") ||
		        		passwordFieldPass.getText().contains("8") ||
		        		passwordFieldPass.getText().contains("9"))) {
		        	
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
		        	user.setClave(passwordFieldPass.getText());
		        	user.setEmail(textFieldEmail.getText());
		        	user.setClave(passwordFieldPass.getText());
		        	user.setNickname(textFieldNickname.getText());
		        	
		        	//Compruebo que la contrasenias sean iguales.
		        	repClave=passwordFieldRepetirContrasenia.getText();
		        	if(repClave.equals(passwordFieldPass.getText())){
		        	
		        		boolean result = iagro.create(user);
		        		if(result) {
		        		limpiar();
		        		JOptionPane.showConfirmDialog(null, "Se ha guardado correctamente el usuario","Exito",JOptionPane.DEFAULT_OPTION);
		        		}
		        		else {
		        		JOptionPane.showMessageDialog(null, "Se produjo un error","Error",JOptionPane.ERROR_MESSAGE);
		        		}
		        	}
		        	else {
		        		JOptionPane.showMessageDialog(null, "Su clave no coincide","Error",JOptionPane.ERROR_MESSAGE);
		        	}
		        	
		        	
		        }
			}
		});
		desktopPane.add(btnGuardar);
		
		textNombre = new JTextField();
		textNombre.setBounds(178, 108, 98, 20);
		desktopPane.add(textNombre);
		textNombre.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(92, 111, 76, 14);
		desktopPane.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(92, 138, 76, 14);
		desktopPane.add(lblApellido);
		
		textApellido = new JTextField();
		textApellido.setBounds(178, 135, 98, 20);
		desktopPane.add(textApellido);
		textApellido.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(102, 166, 66, 14);
		desktopPane.add(lblEmail);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(178, 163, 176, 20);
		desktopPane.add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		JLabel lblContrasenia = new JLabel("Contrase\u00F1a:");
		lblContrasenia.setBounds(74, 223, 94, 14);
		desktopPane.add(lblContrasenia);
		
		passwordFieldPass = new JPasswordField();
		passwordFieldPass.setBounds(178, 220, 98, 20);
		desktopPane.add(passwordFieldPass);
		passwordFieldPass.setColumns(10);
		
		JLabel lblRepetirContrasenia = new JLabel("Repetir Contrase\u00F1a:");
		lblRepetirContrasenia.setBounds(39, 251, 129, 14);
		desktopPane.add(lblRepetirContrasenia);
		
		passwordFieldRepetirContrasenia = new JPasswordField();
		passwordFieldRepetirContrasenia.setBounds(178, 248, 98, 20);
		desktopPane.add(passwordFieldRepetirContrasenia);
		passwordFieldRepetirContrasenia.setColumns(10);
		
		JLabel lblCedula = new JLabel("Cedula:");
		lblCedula.setBounds(92, 191, 69, 14);
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
		btnCancelar.setBounds(242, 365, 106, 37);
		desktopPane.add(btnCancelar);
		
		textFieldNickname = new JTextField();
		textFieldNickname.setColumns(10);
		textFieldNickname.setBounds(178, 280, 98, 20);
		desktopPane.add(textFieldNickname);
		
		JLabel lblNombreDeUsuario = new JLabel("lNombre De Usuario:");
		lblNombreDeUsuario.setBounds(39, 282, 129, 16);
		desktopPane.add(lblNombreDeUsuario);
		
		JLabel lblTitulo = new JLabel("Alta de Usuario");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 29));
		lblTitulo.setBounds(112, 15, 256, 57);
		desktopPane.add(lblTitulo);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(AltaUsuario.class.getResource("/img/IAgro icon.png")));
		lblFondo.setBounds(0, 0, 416, 421);
		desktopPane.add(lblFondo);
	}
	
	public void limpiar() {
		textFieldNickname.setText("");
		textFieldCedula.setText("");
		passwordFieldPass.setText("");
		passwordFieldRepetirContrasenia.setText("");
		textFieldEmail.setText("");
		textApellido.setText("");
		textNombre.setText("");
		
	}

	@Override
	public void setFields(Usuario o) {
		// TODO Auto-generated method stub
		
	}
}
