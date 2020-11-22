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

public class CrearFormulario implements IFrame<Formulario> {

	private JFrame frame;
	private JTextField textFieldNombre;
	private Long id;
	private IAgro iagro;
	private JTextArea textArea;
	

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
		frame.setBounds(100, 100, 499, 368);
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
		textArea.setBounds(321, 111, 149, 158);
		desktopPane.add(textArea);
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDescripcion.setBounds(347, 86, 100, 21);
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
				else {
				Formulario form = new Formulario();
				form.setNombre(textFieldNombre.getText().toUpperCase());
				form.setResumen(textArea.getText().toUpperCase());
					boolean result;
					
					if(id>0) {
						System.out.println("ID for update "+id);
						form.setId(id);
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
			}
		});
		btnGuardar.setIcon(new ImageIcon(CrearFormulario.class.getResource("/img/BotonGuardar (2).png")));
		btnGuardar.setBounds(288, 283, 137, 40);
		desktopPane.add(btnGuardar);
		
		JButton btnCancelar = new JButton("");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiar();
				
			}
		});
		btnCancelar.setIcon(new ImageIcon(CrearFormulario.class.getResource("/img/BotonCancelar.png")));
		btnCancelar.setBounds(63, 283, 137, 40);
		desktopPane.add(btnCancelar);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(CrearFormulario.class.getResource("/img/CrearFormulario.png")));
		lblFondo.setBounds(122, 11, 254, 261);
		desktopPane.add(lblFondo);
		
		JComboBox comboBoxTipo = new JComboBox();
		comboBoxTipo.setBounds(10, 179, 137, 31);
		desktopPane.add(comboBoxTipo);
		
		JLabel lblTipoDeMuestreo = new JLabel("Tipo de Muestreo:");
		lblTipoDeMuestreo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTipoDeMuestreo.setBounds(10, 153, 137, 21);
		desktopPane.add(lblTipoDeMuestreo);
		
		JButton btnMenu = new JButton("");
		btnMenu.setIcon(new ImageIcon(CrearFormulario.class.getResource("/img/BotonMenu.png")));
		btnMenu.setBounds(10, 11, 98, 33);
		desktopPane.add(btnMenu);
		
		JLabel lblObligatorio = new JLabel("*");
		lblObligatorio.setForeground(Color.RED);
		lblObligatorio.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblObligatorio.setBounds(79, 86, 17, 14);
		desktopPane.add(lblObligatorio);
		
		JLabel lblObligatorio_1 = new JLabel("*");
		lblObligatorio_1.setForeground(Color.RED);
		lblObligatorio_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblObligatorio_1.setBounds(142, 154, 17, 14);
		desktopPane.add(lblObligatorio_1);
	}
	public void limpiar() {
		textFieldNombre.setText("");
		textArea.setText("");

	}

	@Override
	public void setFields(Formulario o) {
		
		
	}
}
