package com.presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JDesktopPane;
import java.awt.BorderLayout;
import javax.swing.JTextField;

import com.entities.Casilla;
import com.entities.Usuario;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JComboBox;

public class CrearCasilla implements IFrame<Casilla> {

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
		lblTipoDeDato.setBounds(10, 169, 98, 14);
		desktopPane.add(lblTipoDeDato);
		
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
		btnGuardar.setBounds(54, 295, 137, 40);
		desktopPane.add(btnGuardar);
		
		JButton btnCancelar = new JButton("");
		btnCancelar.setIcon(new ImageIcon(CrearCasilla.class.getResource("/img/BotonCancelar.png")));
		btnCancelar.setBounds(236, 295, 137, 40);
		desktopPane.add(btnCancelar);
		
		JLabel lblTipoDeMuestreo = new JLabel("Tipo de Muestreo:");
		lblTipoDeMuestreo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTipoDeMuestreo.setBounds(10, 227, 129, 14);
		desktopPane.add(lblTipoDeMuestreo);
		
		JComboBox comboBoxTipo = new JComboBox();
		comboBoxTipo.setBounds(10, 252, 116, 26);
		desktopPane.add(comboBoxTipo);
		
		JLabel lblObligatorio = new JLabel("*");
		lblObligatorio.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblObligatorio.setForeground(Color.RED);
		lblObligatorio.setBounds(149, 227, 17, 14);
		desktopPane.add(lblObligatorio);
		
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
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setFields(Casilla o) {
		// TODO Auto-generated method stub
		
	}
}
