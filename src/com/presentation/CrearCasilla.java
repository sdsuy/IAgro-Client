package com.presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JDesktopPane;
import java.awt.BorderLayout;
import javax.swing.JTextField;

import com.application.IAgro;
import com.entities.Casilla;
import com.entities.Roles;
import com.entities.Tipos;
import com.entities.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class CrearCasilla implements IFrame<Casilla> {

	private JFrame frame;
	private JTextField textFieldParametro;
	private JTextField textFieldUnidadDeMedida;
	private JTextArea textAreaDescripcion;
	private JButton btnGuardar;
	private JButton btnCancelar;
	private IAgro iagro;
	private Long id;
	private JComboBox comboBoxTipoDato;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrearCasilla window = new CrearCasilla();
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
	public CrearCasilla() {
		initialize();
	}
	/**
	 * Constructor con la aplicacion de IAgro inyectada.
	 */
	public CrearCasilla(IAgro iagro) {
		id = 0L;
		this.iagro = iagro;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 385);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setResizable(false);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(173, 216, 230));
		frame.getContentPane().add(desktopPane, BorderLayout.CENTER);
		
		textFieldParametro = new JTextField();
		textFieldParametro.setBounds(10, 70, 116, 26);
		desktopPane.add(textFieldParametro);
		textFieldParametro.setColumns(10);
		
		JLabel lblParametro = new JLabel("Parametro:");
		lblParametro.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblParametro.setBounds(10, 52, 86, 14);
		desktopPane.add(lblParametro);
		
		JLabel lblUnidadDeMedida = new JLabel("Unidad de medida:");
		lblUnidadDeMedida.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUnidadDeMedida.setBounds(10, 107, 150, 14);
		desktopPane.add(lblUnidadDeMedida);
		
		textAreaDescripcion = new JTextArea();
		textAreaDescripcion.setBounds(297, 71, 127, 207);
		desktopPane.add(textAreaDescripcion);
		
		JLabel lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDescripcion.setBounds(297, 52, 116, 14);
		desktopPane.add(lblDescripcion);
		
		JLabel lblTipoDeDato = new JLabel("Tipo de Dato:");
		lblTipoDeDato.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTipoDeDato.setBounds(10, 169, 98, 14);
		desktopPane.add(lblTipoDeDato);
		
		textFieldUnidadDeMedida = new JTextField();
		textFieldUnidadDeMedida.setColumns(10);
		textFieldUnidadDeMedida.setBounds(10, 132, 116, 26);
		desktopPane.add(textFieldUnidadDeMedida);
		
		btnGuardar = new JButton("");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textFieldUnidadDeMedida.getText().isEmpty() || comboBoxTipoDato.getToolkit().equals("") || textFieldParametro.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Debe completar todos lo campos Obligatorios","Error",JOptionPane.ERROR_MESSAGE);

				}else {
					Casilla casilla = new Casilla();
					casilla.setParametro(textFieldParametro.getText());
					casilla.setUnidadMedida(textFieldUnidadDeMedida.getText());
					casilla.setDescripcion(textAreaDescripcion.getText());
				
					String nomCasilla = comboBoxTipoDato.getSelectedItem().toString();
					casilla.setTipo(Tipos.valueOfTipos(nomCasilla));
					boolean result;
					
					if(id>0) {
						System.out.println("ID for update "+id);
						casilla.setId(id);
						result=iagro.update(casilla);
					}
					else {
						System.out.println("ID for create "+id);
						result=iagro.create(casilla);
					}
					if(result) {
						limpiar();
						JOptionPane.showMessageDialog(null, "Se ha creado la Casilla","Exito",JOptionPane.DEFAULT_OPTION);
					}
				
				}
			} 
			
		});
		btnGuardar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnGuardar.setIcon(new ImageIcon(CrearCasilla.class.getResource("/img/BotonGuardar (2).png")));
		btnGuardar.setBounds(54, 295, 137, 40);
		desktopPane.add(btnGuardar);
		
		btnCancelar = new JButton("");
		btnCancelar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int seleccion = JOptionPane.showOptionDialog(null, "Seguro desea Cancelar y salir al menu?",  null, JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, 
						null, new Object[] { "SI", "NO"},   
						   null);

						if (seleccion == 0) {
							limpiar();
							frame.dispose();
						}
			}
		});
		btnCancelar.setIcon(new ImageIcon(CrearCasilla.class.getResource("/img/BotonCancelar.png")));
		btnCancelar.setBounds(236, 295, 137, 40);
		desktopPane.add(btnCancelar);
		
		JLabel lblObligatorio_1 = new JLabel("*");
		lblObligatorio_1.setForeground(Color.RED);
		lblObligatorio_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblObligatorio_1.setBounds(118, 169, 17, 14);
		desktopPane.add(lblObligatorio_1);
		
		JLabel lblObligatorio_2 = new JLabel("*");
		lblObligatorio_2.setForeground(Color.RED);
		lblObligatorio_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblObligatorio_2.setBounds(149, 107, 17, 14);
		desktopPane.add(lblObligatorio_2);
		
		JLabel lblObligatorio_3 = new JLabel("*");
		lblObligatorio_3.setForeground(Color.RED);
		lblObligatorio_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblObligatorio_3.setBounds(92, 52, 17, 14);
		desktopPane.add(lblObligatorio_3);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(CrearCasilla.class.getResource("/img/CrearCasilla.png")));
		lblFondo.setBounds(120, 0, 184, 261);
		desktopPane.add(lblFondo);
		
		comboBoxTipoDato = new JComboBox();
		comboBoxTipoDato.setModel(new DefaultComboBoxModel(new String[] {"", Tipos.BOOLEAN.getTipo(), Tipos.DOUBLE.getTipo(), Tipos.INTEGER.getTipo(), Tipos.STRING.getTipo()}));
		comboBoxTipoDato.setBounds(10, 194, 116, 26);
		desktopPane.add(comboBoxTipoDato);
	}
	
	/**
	 * Start the application.
	 */
	@Override
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
	public void setFields(Casilla o) {
		// TODO Auto-generated method stub
		
	}
	
	public void limpiar() {
		textFieldParametro.setText("");
		textFieldUnidadDeMedida.setText("");
		textAreaDescripcion.setText("");
	}
}
