package com.presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JDesktopPane;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JList;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import com.application.IAgro;
import com.entities.Actividad;
import com.entities.Casilla;

import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditarCasillas implements IFrame<Casilla>{

	private JFrame frame;
	private Long id;
	private IAgro iagro;
	private JButton btnAgregar;
	private JButton btnGuardar;
	private JList list;
	private JCheckBox chckbxMetodo;
	private JCheckBox chckbxEstacion;
	private JCheckBox chckbxDepartamento;
	private JCheckBox chckbxUbicacion;
	private JCheckBox chckbxImagen;
	private JButton btnCancelar;
	private JButton btnAgregar_1;
	private JList list_1;

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
	public EditarCasillas() {
		initialize();
	}
	
	/**
	 * Constructor con la aplicacion de IAgro inyectada.
	 */
	public EditarCasillas(IAgro iagro) {
		id = 0L;
		this.iagro = iagro;
		initialize();
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 731, 516);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(173, 216, 230));
		frame.getContentPane().add(desktopPane, BorderLayout.CENTER);
		
		btnAgregar = new JButton("");
		btnAgregar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnAgregar.setIcon(new ImageIcon(EditarCasillas.class.getResource("/img/BotonAgregarSeleccionada.png")));
		btnAgregar.setBounds(455, 293, 232, 42);
		desktopPane.add(btnAgregar);
		
		list = new JList();
		list.setBounds(199, 127, 232, 144);
		desktopPane.add(list);
		
		JLabel lblTitulo = new JLabel("");
		lblTitulo.setIcon(new ImageIcon(EditarCasillas.class.getResource("/img/ListarCasillas.png")));
		lblTitulo.setBounds(293, 17, 124, 70);
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
		
		JLabel lblUbicacin = new JLabel("Ubicaci\u00F3n");
		lblUbicacin.setBounds(37, 207, 124, 14);
		desktopPane.add(lblUbicacin);
		
		JLabel lblImgen = new JLabel("Im\u00E1gen");
		lblImgen.setBounds(37, 232, 124, 14);
		desktopPane.add(lblImgen);
		
		chckbxMetodo = new JCheckBox("New check box");
		chckbxMetodo.setCursor(new Cursor(Cursor.HAND_CURSOR));
		chckbxMetodo.setEnabled(false);
		chckbxMetodo.setSelected(true);
		chckbxMetodo.setBounds(10, 127, 21, 23);
		desktopPane.add(chckbxMetodo);
		
		chckbxEstacion = new JCheckBox("New check box");
		chckbxEstacion.setCursor(new Cursor(Cursor.HAND_CURSOR));
		chckbxEstacion.setEnabled(false);
		chckbxEstacion.setSelected(true);
		chckbxEstacion.setBounds(10, 152, 21, 23);
		desktopPane.add(chckbxEstacion);
		
		chckbxDepartamento = new JCheckBox("New check box");
		chckbxDepartamento.setCursor(new Cursor(Cursor.HAND_CURSOR));
		chckbxDepartamento.setEnabled(false);
		chckbxDepartamento.setSelected(true);
		chckbxDepartamento.setBounds(10, 177, 21, 23);
		desktopPane.add(chckbxDepartamento);
		
		chckbxUbicacion = new JCheckBox("New check box");
		chckbxUbicacion.setCursor(new Cursor(Cursor.HAND_CURSOR));
		chckbxUbicacion.setBounds(10, 202, 21, 23);
		desktopPane.add(chckbxUbicacion);
		
		chckbxImagen = new JCheckBox("New check box");
		chckbxImagen.setCursor(new Cursor(Cursor.HAND_CURSOR));
		chckbxImagen.setBounds(10, 228, 21, 23);
		desktopPane.add(chckbxImagen);
		
		JLabel lblObligatorio = new JLabel("*");
		lblObligatorio.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblObligatorio.setForeground(Color.RED);
		lblObligatorio.setBounds(160, 131, 15, 14);
		desktopPane.add(lblObligatorio);
		
		JLabel lblObligatorio_1 = new JLabel("*");
		lblObligatorio_1.setForeground(Color.RED);
		lblObligatorio_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblObligatorio_1.setBounds(165, 156, 15, 14);
		desktopPane.add(lblObligatorio_1);
		
		JLabel lblObligatorio_2 = new JLabel("*");
		lblObligatorio_2.setForeground(Color.RED);
		lblObligatorio_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblObligatorio_2.setBounds(140, 181, 15, 14);
		desktopPane.add(lblObligatorio_2);
		
		btnGuardar = new JButton("");
		btnGuardar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnGuardar.setIcon(new ImageIcon(EditarCasillas.class.getResource("/img/BotonGuardar (2).png")));
		btnGuardar.setBounds(455, 426, 137, 40);
		desktopPane.add(btnGuardar);
		
		btnCancelar = new JButton("");
		btnCancelar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				iagro.show(ListarFormularios.class);
				frame.dispose();
			}
		});
		btnCancelar.setIcon(new ImageIcon(EditarCasillas.class.getResource("/img/BotonCancelar.png")));
		btnCancelar.setBounds(107, 426, 137, 40);
		desktopPane.add(btnCancelar);
		
		btnAgregar_1 = new JButton("");
		btnAgregar_1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnAgregar_1.setIcon(new ImageIcon(EditarCasillas.class.getResource("/img/BotonEliminarSeleccionada.png")));
		btnAgregar_1.setBounds(199, 293, 232, 42);
		desktopPane.add(btnAgregar_1);
		
		JLabel lblCasillasFormulario = new JLabel("Casillas del Formulario:");
		lblCasillasFormulario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCasillasFormulario.setBounds(227, 98, 177, 21);
		desktopPane.add(lblCasillasFormulario);
		
		list_1 = new JList();
		list_1.setBounds(455, 130, 232, 144);
		desktopPane.add(list_1);
		
		JLabel lblCasillasDisponibles = new JLabel("Casillas Disponibles:");
		lblCasillasDisponibles.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCasillasDisponibles.setBounds(492, 99, 156, 21);
		desktopPane.add(lblCasillasDisponibles);
	}
	
	@Override
	public void setFields(Casilla o) {
		
		
	}
	
	

	

	
}
