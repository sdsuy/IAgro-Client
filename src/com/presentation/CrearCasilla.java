package com.presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JDesktopPane;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JComboBox;

public class CrearCasilla {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

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
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 385);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(173, 216, 230));
		frame.getContentPane().add(desktopPane, BorderLayout.CENTER);
		
		textField = new JTextField();
		textField.setBounds(10, 70, 116, 26);
		desktopPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Parametro:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 52, 86, 14);
		desktopPane.add(lblNewLabel);
		
		JLabel lblUnidadDeMedida = new JLabel("Unidad de medida:");
		lblUnidadDeMedida.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUnidadDeMedida.setBounds(10, 107, 150, 14);
		desktopPane.add(lblUnidadDeMedida);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(297, 71, 127, 207);
		desktopPane.add(textArea);
		
		JLabel lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDescripcion.setBounds(297, 52, 116, 14);
		desktopPane.add(lblDescripcion);
		
		JLabel lblTipoDeDato = new JLabel("Tipo de Dato:");
		lblTipoDeDato.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTipoDeDato.setBounds(10, 169, 150, 14);
		desktopPane.add(lblTipoDeDato);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(CrearCasilla.class.getResource("/img/CrearCasilla.png")));
		lblFondo.setBounds(120, 0, 184, 261);
		desktopPane.add(lblFondo);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(10, 132, 116, 26);
		desktopPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(10, 190, 116, 26);
		desktopPane.add(textField_2);
		
		JButton btnGuardar = new JButton("");
		btnGuardar.setIcon(new ImageIcon(CrearCasilla.class.getResource("/img/BotonGuardar (2).png")));
		btnGuardar.setBounds(10, 295, 137, 40);
		desktopPane.add(btnGuardar);
		
		JButton btnCancelar = new JButton("");
		btnCancelar.setIcon(new ImageIcon(CrearCasilla.class.getResource("/img/BotonCancelar.png")));
		btnCancelar.setBounds(287, 295, 137, 40);
		desktopPane.add(btnCancelar);
		
		JLabel lblTipoDeCasilla = new JLabel("Tipo de Casilla:");
		lblTipoDeCasilla.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTipoDeCasilla.setBounds(10, 227, 150, 14);
		desktopPane.add(lblTipoDeCasilla);
		
		JComboBox comboBoxTipo = new JComboBox();
		comboBoxTipo.setBounds(10, 252, 116, 26);
		desktopPane.add(comboBoxTipo);
	}
}
