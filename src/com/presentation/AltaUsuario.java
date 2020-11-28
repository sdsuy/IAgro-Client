package com.presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JToolBar;

import com.application.IAgro;
import com.entities.Rol;
import com.entities.Roles;
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
import java.awt.Cursor;

import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;

public class AltaUsuario implements IFrame<Usuario> {

	private JFrame frame;
	private JTextField textNombre;
	private JTextField textApellido;
	private JTextField textFieldEmail;
	private JPasswordField passwordFieldPass;
	private JPasswordField passwordFieldRepetirContrasenia;
	private JTextField textFieldCedula;
	private JButton btnGuardar;
	private JComboBox comboBoxRol;
	private JLabel lblProfesion;
	private JLabel lblInstituto;
	private JLabel lblCedula;
	private JLabel lblObligatorio;
	private JLabel lblObligatorio_1;
	private JLabel lblObligatorio_2;
	private JLabel lblObligatorio_3;
	private JLabel lblObligatorio_4;
	private JLabel lblObligatorio_5;
	private JLabel lblObligatorio_6;
	private JLabel lblObligatorio_7;
	private JLabel lblFondo;
	private JButton btnVolver;
	
	private IAgro iagro;
	private JTextField textFieldNickname;
	private Long id;
	private JTextField textFieldProfesion;
	private JTextField textFieldInstituto;
	private JButton btnCancelar;
	
	

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
	
	@Override
	public void setFields(Usuario o) {
		id = o.getId();
		comboBoxRol.getSelectedIndex();
		comboBoxRol.setSelectedItem(o.getRol().getRol().name());
		textNombre.setText(o.getNombre());
		textApellido.setText(o.getApellido());
		passwordFieldPass.setText(o.getClave());
		textFieldNickname.setText(o.getNickname());
		lblFondo.setIcon(new ImageIcon(AltaUsuario.class.getResource("/img/ModificarUsuario.png")));
		btnVolver.setVisible(true);
		
		if (comboBoxRol.getSelectedItem().equals(Roles.EXPERTO.name())) {
			textFieldCedula.setText(o.getDocumento());
			textFieldProfesion.setText(o.getProfesion());
		}
		
		else if (comboBoxRol.getSelectedItem().toString() == Roles.ADMINISTRADOR.name()) {
			textFieldCedula.setText(o.getDocumento());
			textFieldInstituto.setText(o.getInstituto());
		}
		
		else if (o.getEmail() != null) {
			textFieldEmail.setText(o.getEmail());
		}
		
		
		
		
		
		
		

		
	}
		
	

	/**
	 * Create the application.
	 */
	public AltaUsuario() {
		initialize();
	}
	
	/**
	 * Constructor con la aplicacion de IAgro inyectada.
	 */
	public AltaUsuario(IAgro iagro) {
		id = 0L;
		this.iagro = iagro;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 442, 480);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setResizable(false);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(173, 216, 230));
		frame.getContentPane().add(desktopPane, BorderLayout.CENTER);
		desktopPane.setLayout(null);
		
		JLabel lblRol = new JLabel("Rol:");
		lblRol.setBounds(112, 83, 56, 14);
		desktopPane.add(lblRol);
		
		System.out.println(Roles.COMUN.toString());
		
		comboBoxRol = new JComboBox();
		comboBoxRol.setModel(new DefaultComboBoxModel(new String[] {"", Roles.COMUN.name(), Roles.EXPERTO.name(), Roles.ADMINISTRADOR.name()}));
		comboBoxRol.setCursor(new Cursor(Cursor.HAND_CURSOR));
		comboBoxRol.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//Mostramos diferentes entradas de datos segun el tipo de usuario a crear
				if (comboBoxRol.getSelectedItem().equals(Roles.EXPERTO.name())) {
					visibilidadUsuario("Experto");
				}
				
				else if (comboBoxRol.getSelectedItem().toString() == Roles.ADMINISTRADOR.name()) {
					visibilidadUsuario("Administrador");
				}
				
				else if (comboBoxRol.getSelectedItem().toString() == Roles.COMUN.name()) {
					visibilidadUsuario("Comun");
				}
			}
		});
		comboBoxRol.setBounds(178, 79, 114, 22);
		desktopPane.add(comboBoxRol);
		
		
		btnGuardar = new JButton("");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//Cuadro de dialogo si/no
				int seleccion = JOptionPane.showOptionDialog(null, "Seguro desea guardar los cambios?",  null, JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, 
						null, new Object[] { "SI", "NO"},   
						   null);
				
				//si el usuari apreta si
				if (seleccion == 0) {
					
					boolean errorComun = false; 
					boolean errorExperto = false;
					boolean errorAdministrador = false;
					
		
					
					//controlamos si hay algun campo vacio SEGUN EL ROL
					switch(comboBoxRol.getSelectedItem().toString()) {
					
					case "COMUN" :
						
						if(textNombre.getText().isEmpty() || textApellido.getText().isEmpty() ||
				        		passwordFieldPass.getText().isEmpty() || passwordFieldRepetirContrasenia.getText().isEmpty() ||
				        		comboBoxRol.getToolkit().equals("") || textFieldNickname.getText().isEmpty()) {
							
							errorComun = true;
				        	
				        	//JOptionPane.showMessageDialog(null, "Debe rellenar todos los campos obligatorios","Error",JOptionPane.ERROR_MESSAGE);
				       
				        }
					break;//comun
					
					case "EXPERTO" :
						
						if(textNombre.getText().isEmpty() || textApellido.getText().isEmpty() ||
				        		passwordFieldPass.getText().isEmpty() || passwordFieldRepetirContrasenia.getText().isEmpty() ||
				        		comboBoxRol.getToolkit().equals("") || textFieldNickname.getText().isEmpty() || textFieldCedula.getText().isEmpty() 
				        		|| textFieldProfesion.getText().isEmpty()) {
							
							errorExperto = true;
				        	
				        	//JOptionPane.showMessageDialog(null, "Debe rellenar todos los campos obligatorios","Error",JOptionPane.ERROR_MESSAGE);
				       
				        }
					break;//experto
					
					case "ADMINISTRADOR" :
						
						if(textNombre.getText().isEmpty() || textApellido.getText().isEmpty() ||
				        		passwordFieldPass.getText().isEmpty() || passwordFieldRepetirContrasenia.getText().isEmpty() ||
				        		comboBoxRol.getToolkit().equals("") || textFieldNickname.getText().isEmpty() || textFieldCedula.getText().isEmpty()  
				        		|| textFieldInstituto.getText().isEmpty()) {
							
							errorAdministrador = true;
				        	
				        	//JOptionPane.showMessageDialog(null, "Debe rellenar todos los campos obligatorios","Error",JOptionPane.ERROR_MESSAGE);
				       
				        }
					break;//administrador
					
					
					}//fin del switch
					
					
					
					//controlamos si el mail tiene un formato invalido
					
					// Patron para validar el email
			        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
			        
			        Matcher mather = pattern.matcher(textFieldEmail.getText());
					
			        if (!textFieldEmail.getText().isEmpty() && mather.find() == false) {
			        	
			        	
			        	
						JOptionPane.showMessageDialog(null, "El Email que ingreso no tiene formato valido","Error",JOptionPane.ERROR_MESSAGE);
			        }//fin verificar mail
			        
			        //verificacion de pass
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

			        }//fin verificar pass
			        
			        
			        else if(errorComun == true || errorExperto == true || errorAdministrador == true) {
			        	JOptionPane.showMessageDialog(null, "Debe rellenar todos los campos obligatorios","Error",JOptionPane.ERROR_MESSAGE);
			        }
			        
			        //si no se encontro un error sigue aqui
			        
			        else {
			        	
			        	String repClave = "";
			        	
			        	String nomRol = comboBoxRol.getSelectedItem().toString();
			        	
//			        	iagro.readRol(nomRol);
			        	Usuario user = new Usuario();
//			        	user.setRol(iagro.readRol(nomRol));
			        	// seteo el rol con el enumerado que tenga el valor seleccionado en el combobox de roles
			        	user.setRol(Roles.valueOf(nomRol));
			        	user.setApellido(textApellido.getText().toUpperCase());
			        	user.setNombre(textNombre.getText().toUpperCase());
			        	user.setDocumento(textFieldCedula.getText().toUpperCase());
                        user.setClave(passwordFieldPass.getText());
			        	user.setEmail(textFieldEmail.getText().toUpperCase());
			        	user.setClave(passwordFieldPass.getText());
			        	user.setNickname(textFieldNickname.getText().toUpperCase());
			        	user.setProfesion(textFieldProfesion.getText().toUpperCase());
			        	user.setInstituto(textFieldInstituto.getText().toUpperCase());
			        	
			        	
			        	//Compruebo que la contrasenias sean iguales.
			        	repClave=passwordFieldRepetirContrasenia.getText();
			        	if(repClave.equals(passwordFieldPass.getText())){
			        	
			        		boolean result;
			        		if (id > 0) {
								System.out.println("ID for update: " + id);
								user.setId(id);
								result = iagro.update(user);
							} else {
								System.out.println("ID for update: " + id);
								result = iagro.create(user);
							}
			        		if(result) {
			        		limpiar();
			        		JOptionPane.showConfirmDialog(null, "Se ha guardado correctamente el usuario","Exito",JOptionPane.DEFAULT_OPTION);
			        		}
			        		else {
			        		JOptionPane.showMessageDialog(null, "Se produjo un error","Error",JOptionPane.ERROR_MESSAGE);
			        		}
			        	}//fin de comprobar pass iguales
			        	
			        	else {
			        		JOptionPane.showMessageDialog(null, "Su clave no coincide","Error",JOptionPane.ERROR_MESSAGE);
			        	}
			        	
			        	
			        	
			        	
			        	
			        	
			        	
			        	
			        }// fin del si no se encontro un error
					
					
					
					
				}
				
				
				
				
			}
		});
		btnGuardar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnGuardar.setIcon(new ImageIcon(AltaUsuario.class.getResource("/img/BotonGuardar (2).png")));
		btnGuardar.setBounds(10, 397, 147, 37);
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
		
		lblCedula = new JLabel("Cedula:");
		lblCedula.setBounds(99, 280, 69, 14);
		desktopPane.add(lblCedula);
		lblCedula.setVisible(false);
		
		textFieldCedula = new JTextField();
		textFieldCedula.setBounds(178, 277, 98, 20);
		desktopPane.add(textFieldCedula);
		textFieldCedula.setColumns(10);
		textFieldCedula.setVisible(false);
		
		btnCancelar = new JButton("");
		btnCancelar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnCancelar.setIcon(new ImageIcon(AltaUsuario.class.getResource("/img/BotonCancelar.png")));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int seleccion = JOptionPane.showOptionDialog(null, "Seguro desea Cancelar y salir al menu?",  null, JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, 
						null, new Object[] { "SI", "NO"},   
						   null);

						if (seleccion == 0) {
							limpiar();
							frame.dispose();
						}
						   
				
			}
		});
		btnCancelar.setBounds(260, 397, 147, 37);
		desktopPane.add(btnCancelar);
		
		textFieldNickname = new JTextField();
		textFieldNickname.setColumns(10);
		textFieldNickname.setBounds(178, 191, 98, 20);
		desktopPane.add(textFieldNickname);
		
		JLabel lblNombreDeUsuario = new JLabel("Nombre De Usuario:");
		lblNombreDeUsuario.setBounds(39, 193, 129, 16);
		desktopPane.add(lblNombreDeUsuario);
		
		lblProfesion = new JLabel("Profesi\u00F3n:");
		lblProfesion.setBounds(91, 311, 66, 14);
		desktopPane.add(lblProfesion);
		lblProfesion.setVisible(false);
		
		textFieldProfesion = new JTextField();
		textFieldProfesion.setCursor(new Cursor(Cursor.TEXT_CURSOR));
		textFieldProfesion.setBounds(178, 308, 98, 20);
		desktopPane.add(textFieldProfesion);
		textFieldProfesion.setColumns(10);
		textFieldProfesion.setVisible(false);
		
		lblInstituto = new JLabel("Instituto:");
		lblInstituto.setBounds(92, 311, 66, 14);
		desktopPane.add(lblInstituto);
		lblInstituto.setVisible(false);
		
		textFieldInstituto = new JTextField();
		textFieldInstituto.setBounds(178, 308, 98, 20);
		desktopPane.add(textFieldInstituto);
		textFieldInstituto.setColumns(10);
		textFieldInstituto.setVisible(false);
		
		lblObligatorio = new JLabel("*");
		lblObligatorio.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblObligatorio.setForeground(Color.RED);
		lblObligatorio.setBounds(302, 79, 20, 14);
		desktopPane.add(lblObligatorio);
		
		lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(AltaUsuario.class.getResource("/img/CrearUsuario.png")));
		lblFondo.setBounds(74, -39, 371, 441);
		desktopPane.add(lblFondo);
		
		lblObligatorio_1 = new JLabel("*");
		lblObligatorio_1.setForeground(Color.RED);
		lblObligatorio_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblObligatorio_1.setBounds(286, 111, 20, 14);
		desktopPane.add(lblObligatorio_1);
		
		lblObligatorio_2 = new JLabel("*");
		lblObligatorio_2.setForeground(Color.RED);
		lblObligatorio_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblObligatorio_2.setBounds(286, 138, 20, 14);
		desktopPane.add(lblObligatorio_2);
		
		lblObligatorio_3 = new JLabel("*");
		lblObligatorio_3.setForeground(Color.RED);
		lblObligatorio_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblObligatorio_3.setBounds(286, 194, 20, 14);
		desktopPane.add(lblObligatorio_3);
		
		lblObligatorio_4 = new JLabel("*");
		lblObligatorio_4.setForeground(Color.RED);
		lblObligatorio_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblObligatorio_4.setBounds(286, 223, 20, 14);
		desktopPane.add(lblObligatorio_4);
		
		lblObligatorio_5 = new JLabel("*");
		lblObligatorio_5.setForeground(Color.RED);
		lblObligatorio_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblObligatorio_5.setBounds(286, 251, 20, 14);
		desktopPane.add(lblObligatorio_5);
		
		lblObligatorio_6 = new JLabel("*");
		lblObligatorio_6.setForeground(Color.RED);
		lblObligatorio_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblObligatorio_6.setBounds(286, 280, 20, 14);
		desktopPane.add(lblObligatorio_6);
		lblObligatorio_6.setVisible(false);
		
		
		lblObligatorio_7 = new JLabel("*");
		lblObligatorio_7.setForeground(Color.RED);
		lblObligatorio_7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblObligatorio_7.setBounds(286, 311, 20, 14);
		desktopPane.add(lblObligatorio_7);
		lblObligatorio_7.setVisible(false);
		
		btnVolver = new JButton("");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				iagro.show(ListarFormularios.class);
				frame.dispose();
				
			}
		});
		btnVolver.setIcon(new ImageIcon(AltaUsuario.class.getResource("/img/BotonVolver.png")));
		btnVolver.setBounds(10, 353, 92, 33);
		desktopPane.add(btnVolver);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("New check box");
		chckbxNewCheckBox.setBounds(302, 218, 128, 23);
		desktopPane.add(chckbxNewCheckBox);
		btnVolver.setVisible(false);
		
		
		
		
	}
	
	public void limpiar() {
		textFieldNickname.setText("");
		textFieldCedula.setText("");
		passwordFieldPass.setText("");
		passwordFieldRepetirContrasenia.setText("");
		textFieldEmail.setText("");
		textApellido.setText("");
		textNombre.setText("");
		textFieldCedula.setText("");
		textFieldProfesion.setText("");
		textFieldInstituto.setText("");
		
	}
	
	
	public void visibilidadUsuario (String tipoUsuario) {
		
		if (tipoUsuario.equals("Experto")) {
			lblInstituto.setVisible(false);
			textFieldInstituto.setVisible(false);
			
			lblCedula.setVisible(true);
			textFieldCedula.setVisible(true);
			lblObligatorio_6.setVisible(true);
			
			lblProfesion.setVisible(true);
			textFieldProfesion.setVisible(true);
			lblObligatorio_7.setVisible(true);
		}
		
		else if (tipoUsuario.equals("Administrador")) {
			lblProfesion.setVisible(false);
			textFieldProfesion.setVisible(false);
			
			lblCedula.setVisible(true);
			textFieldCedula.setVisible(true);
			lblObligatorio_6.setVisible(true);
			
			lblInstituto.setVisible(true);
			textFieldInstituto.setVisible(true);
			lblObligatorio_7.setVisible(true);
		}
		
		else if (tipoUsuario.equals("Comun")) {
			lblInstituto.setVisible(false);
			textFieldInstituto.setVisible(false);
			
			lblCedula.setVisible(false);
			textFieldCedula.setVisible(false);
			lblObligatorio_6.setVisible(false);
			
			lblProfesion.setVisible(false);
			textFieldProfesion.setVisible(false);
			lblObligatorio_7.setVisible(false);
		}
		
	}
}
