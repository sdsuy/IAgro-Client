package com.presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JDesktopPane;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JList;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JCheckBox;

public class EditarCasillas {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditarCasillas window = new EditarCasillas();
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
	public EditarCasillas() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 521, 516);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(173, 216, 230));
		frame.getContentPane().add(desktopPane, BorderLayout.CENTER);
		
		JButton btnAgregar = new JButton("");
		btnAgregar.setIcon(new ImageIcon(EditarCasillas.class.getResource("/img/BotonAgregarSeleccionada.png")));
		btnAgregar.setBounds(263, 336, 232, 42);
		desktopPane.add(btnAgregar);
		
		JList list = new JList();
		list.setBounds(263, 112, 232, 163);
		desktopPane.add(list);
		
		JLabel lblTitulo = new JLabel("");
		lblTitulo.setIcon(new ImageIcon(EditarCasillas.class.getResource("/img/ListarCasillas.png")));
		lblTitulo.setBounds(183, 31, 124, 70);
		desktopPane.add(lblTitulo);
		
		JLabel lblCasillasObligatorias = new JLabel("Casillas Default:");
		lblCasillasObligatorias.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCasillasObligatorias.setBounds(10, 99, 124, 21);
		desktopPane.add(lblCasillasObligatorias);
		
		JLabel lblNewLabel = new JLabel("M\u00E9todo de Muestreo");
		lblNewLabel.setBounds(37, 131, 124, 14);
		desktopPane.add(lblNewLabel);
		
		JLabel lblEstacinDeMuestreo = new JLabel("Estaci\u00F3n de Muestreo");
		lblEstacinDeMuestreo.setBounds(37, 156, 124, 14);
		desktopPane.add(lblEstacinDeMuestreo);
		
		JLabel lblDepartamento = new JLabel("Departamento");
		lblDepartamento.setBounds(37, 181, 124, 14);
		desktopPane.add(lblDepartamento);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(37, 206, 124, 14);
		desktopPane.add(lblCantidad);
		
		JLabel lblUbicacin = new JLabel("Ubicaci\u00F3n");
		lblUbicacin.setBounds(37, 231, 124, 14);
		desktopPane.add(lblUbicacin);
		
		JLabel lblImgen = new JLabel("Im\u00E1gen");
		lblImgen.setBounds(37, 256, 124, 14);
		desktopPane.add(lblImgen);
		
		JCheckBox chckbxMetodo = new JCheckBox("New check box");
		chckbxMetodo.setSelected(true);
		chckbxMetodo.setBounds(10, 127, 21, 23);
		desktopPane.add(chckbxMetodo);
		
		JCheckBox chckbxEstacion = new JCheckBox("New check box");
		chckbxEstacion.setSelected(true);
		chckbxEstacion.setBounds(10, 152, 21, 23);
		desktopPane.add(chckbxEstacion);
		
		JCheckBox chckbxDepartamento = new JCheckBox("New check box");
		chckbxDepartamento.setSelected(true);
		chckbxDepartamento.setBounds(10, 177, 21, 23);
		desktopPane.add(chckbxDepartamento);
		
		JCheckBox chckbxCantidad = new JCheckBox("New check box");
		chckbxCantidad.setBounds(10, 201, 21, 23);
		desktopPane.add(chckbxCantidad);
		
		JCheckBox chckbxUbicacion = new JCheckBox("New check box");
		chckbxUbicacion.setBounds(10, 226, 21, 23);
		desktopPane.add(chckbxUbicacion);
		
		JCheckBox chckbxImagen = new JCheckBox("New check box");
		chckbxImagen.setBounds(10, 252, 21, 23);
		desktopPane.add(chckbxImagen);
		
		JLabel lblObligatorio = new JLabel("*");
		lblObligatorio.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblObligatorio.setForeground(Color.RED);
		lblObligatorio.setBounds(137, 131, 15, 14);
		desktopPane.add(lblObligatorio);
		
		JLabel lblObligatorio_1 = new JLabel("*");
		lblObligatorio_1.setForeground(Color.RED);
		lblObligatorio_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblObligatorio_1.setBounds(146, 156, 15, 14);
		desktopPane.add(lblObligatorio_1);
		
		JLabel lblObligatorio_2 = new JLabel("*");
		lblObligatorio_2.setForeground(Color.RED);
		lblObligatorio_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblObligatorio_2.setBounds(110, 181, 15, 14);
		desktopPane.add(lblObligatorio_2);
		
		JLabel lblObligatorio_3 = new JLabel("*");
		lblObligatorio_3.setForeground(Color.RED);
		lblObligatorio_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblObligatorio_3.setBounds(86, 206, 15, 14);
		desktopPane.add(lblObligatorio_3);
		
		JLabel lblObligatorio_4 = new JLabel("*");
		lblObligatorio_4.setForeground(Color.RED);
		lblObligatorio_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblObligatorio_4.setBounds(86, 231, 15, 14);
		desktopPane.add(lblObligatorio_4);
		
		JLabel lblObligatorio_5 = new JLabel("*");
		lblObligatorio_5.setForeground(Color.RED);
		lblObligatorio_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblObligatorio_5.setBounds(74, 256, 15, 14);
		desktopPane.add(lblObligatorio_5);
		
		JButton btnGuardar = new JButton("");
		btnGuardar.setIcon(new ImageIcon(EditarCasillas.class.getResource("/img/BotonGuardar (2).png")));
		btnGuardar.setBounds(313, 426, 137, 40);
		desktopPane.add(btnGuardar);
		
		JButton btnCancelar = new JButton("");
		btnCancelar.setIcon(new ImageIcon(EditarCasillas.class.getResource("/img/BotonCancelar.png")));
		btnCancelar.setBounds(58, 426, 137, 40);
		desktopPane.add(btnCancelar);
		
		JButton btnAgregar_1 = new JButton("");
		btnAgregar_1.setIcon(new ImageIcon(EditarCasillas.class.getResource("/img/BotonEliminarSeleccionada.png")));
		btnAgregar_1.setBounds(263, 283, 232, 42);
		desktopPane.add(btnAgregar_1);
	}
}
