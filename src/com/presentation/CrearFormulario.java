package com.presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JDesktopPane;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.SwingConstants;

import com.application.IAgro;
import com.entities.Formulario;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JComboBox;

public class CrearFormulario {

	private JFrame frame;
	private JTextField textFieldNombre;
	private Long id;
	private IAgro iagro;
	private JTextArea textArea;
	private JTextField textFieldMetodoDeMuetreo;
	private JTextField textFieldEstacionDeMuestreo;
	private JTextField textFieldDepartamento;
	private JTextField textFieldCantidad;
	private JTextField textFieldUbicacion;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrearFormulario window = new CrearFormulario();
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
	public CrearFormulario() {
		initialize();
	}
	
	/**
	 * Constructor con la aplicacion de IAgro inyectada.
	 */
	public CrearFormulario(IAgro iagro) {
		id = 0L;
		this.iagro = iagro;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 847, 453);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(173, 216, 230));
		frame.getContentPane().add(desktopPane, BorderLayout.CENTER);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(10, 111, 137, 31);
		desktopPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNombre.setBounds(10, 86, 67, 21);
		desktopPane.add(lblNombre);
		
		textArea = new JTextArea();
		textArea.setBounds(670, 247, 149, 158);
		desktopPane.add(textArea);
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDescripcion.setBounds(696, 222, 100, 21);
		desktopPane.add(lblDescripcion);
		
		JButton btnGuardar = new JButton("");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textFieldNombre.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Debe ingresar un nombre al Formulario","Error",JOptionPane.ERROR_MESSAGE);
	
				}
				else if(textFieldNombre.getText().contains("1")||
						textFieldNombre.getText().contains("2")||
						textFieldNombre.getText().contains("3")||
						textFieldNombre.getText().contains("4")||
						textFieldNombre.getText().contains("5")||
						textFieldNombre.getText().contains("6")||
						textFieldNombre.getText().contains("7")||
						textFieldNombre.getText().contains("8")||
						textFieldNombre.getText().contains("9")||
						textFieldNombre.getText().contains("0")) {
					JOptionPane.showMessageDialog(null, "Debe ingresar solamente Texto","Error",JOptionPane.ERROR_MESSAGE);
				}
				else if(textFieldNombre.getText().contains("!")||
						textFieldNombre.getText().contains("@")||
						textFieldNombre.getText().contains("~")||
						textFieldNombre.getText().contains("`")||
						textFieldNombre.getText().contains("#")||
						textFieldNombre.getText().contains("%")||
						textFieldNombre.getText().contains("^")||
						textFieldNombre.getText().contains("&")||
						textFieldNombre.getText().contains("*")) {
					JOptionPane.showMessageDialog(null, "Debe ingresar solamente Texto","Error",JOptionPane.ERROR_MESSAGE);
				}
				Formulario form = new Formulario();
				form.setNombre(textFieldNombre.getText().toUpperCase());
				form.setResumen(textArea.getText().toUpperCase());
					boolean result;
					if(id>0) {
						System.out.println("ID for update "+id);
						form.setId_formulario(id);
						result=iagro.update(form);
					}
					else {
						System.out.println("ID for create "+id);
						result=iagro.create(form);
					}
					if(result) {
						limpiar();
						JOptionPane.showMessageDialog(null, "Se ha creado el Formulario","Exito",JOptionPane.DEFAULT_OPTION);
					}
			}
		});
		btnGuardar.setIcon(new ImageIcon(CrearFormulario.class.getResource("/img/BotonGuardar (2).png")));
		btnGuardar.setBounds(358, 365, 137, 40);
		desktopPane.add(btnGuardar);
		
		JButton btnCancelar = new JButton("");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiar();
				
			}
		});
		btnCancelar.setIcon(new ImageIcon(CrearFormulario.class.getResource("/img/BotonCancelar.png")));
		btnCancelar.setBounds(197, 365, 137, 40);
		desktopPane.add(btnCancelar);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(CrearFormulario.class.getResource("/img/CrearFormulario.png")));
		lblFondo.setBounds(285, 11, 254, 261);
		desktopPane.add(lblFondo);
		
		JList listCasillas = new JList();
		listCasillas.setBounds(505, 247, 149, 158);
		desktopPane.add(listCasillas);
		
		JLabel lblCasillas = new JLabel("Casillas");
		lblCasillas.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCasillas.setBounds(549, 222, 74, 21);
		desktopPane.add(lblCasillas);
		
		JComboBox comboBoxTipo = new JComboBox();
		comboBoxTipo.setBounds(505, 164, 149, 31);
		desktopPane.add(comboBoxTipo);
		
		JLabel lblTipoDeMuestreo = new JLabel("Tipo de Muestreo:");
		lblTipoDeMuestreo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTipoDeMuestreo.setBounds(505, 138, 137, 21);
		desktopPane.add(lblTipoDeMuestreo);
		
		JLabel lblMtodoDeMuestreo = new JLabel("M\u00E9todo de Muestreo:");
		lblMtodoDeMuestreo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMtodoDeMuestreo.setBounds(10, 150, 166, 21);
		desktopPane.add(lblMtodoDeMuestreo);
		
		textFieldMetodoDeMuetreo = new JTextField();
		textFieldMetodoDeMuetreo.setColumns(10);
		textFieldMetodoDeMuetreo.setBounds(10, 176, 137, 31);
		desktopPane.add(textFieldMetodoDeMuetreo);
		
		JLabel lblEstacionDeMuestreo = new JLabel("Estaci\u00F3n de Muestreo:");
		lblEstacionDeMuestreo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEstacionDeMuestreo.setBounds(10, 218, 166, 21);
		desktopPane.add(lblEstacionDeMuestreo);
		
		textFieldEstacionDeMuestreo = new JTextField();
		textFieldEstacionDeMuestreo.setColumns(10);
		textFieldEstacionDeMuestreo.setBounds(10, 244, 137, 31);
		desktopPane.add(textFieldEstacionDeMuestreo);
		
		JLabel lblDepartamento = new JLabel("Depatamento:");
		lblDepartamento.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDepartamento.setBounds(201, 218, 166, 21);
		desktopPane.add(lblDepartamento);
		
		textFieldDepartamento = new JTextField();
		textFieldDepartamento.setColumns(10);
		textFieldDepartamento.setBounds(201, 244, 137, 31);
		desktopPane.add(textFieldDepartamento);
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCantidad.setBounds(201, 86, 166, 21);
		desktopPane.add(lblCantidad);
		
		textFieldCantidad = new JTextField();
		textFieldCantidad.setColumns(10);
		textFieldCantidad.setBounds(201, 112, 137, 31);
		desktopPane.add(textFieldCantidad);
		
		JLabel lblUbicacion = new JLabel("Ubicaci\u00F3n:");
		lblUbicacion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUbicacion.setBounds(201, 150, 166, 21);
		desktopPane.add(lblUbicacion);
		
		textFieldUbicacion = new JTextField();
		textFieldUbicacion.setColumns(10);
		textFieldUbicacion.setBounds(201, 176, 137, 31);
		desktopPane.add(textFieldUbicacion);
		
		JLabel lblImagen = new JLabel("Im\u00E1gen:");
		lblImagen.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblImagen.setBounds(706, 138, 166, 21);
		desktopPane.add(lblImagen);
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.setBounds(701, 167, 89, 23);
		desktopPane.add(btnNewButton);
	}
	public void limpiar() {
		textFieldNombre.setText("");
		textArea.setText("");

	}
}
