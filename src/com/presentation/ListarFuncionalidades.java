package com.presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JDesktopPane;
import java.awt.BorderLayout;
import java.awt.ScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import com.application.IAgro;

import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.SwingConstants;

public class ListarFuncionalidades implements IFrame {

	private JFrame frame;
	private JTable table;
	private JTextField textField;
	
	private IAgro iagro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListarFuncionalidades window = new ListarFuncionalidades();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * 
	 * Hago visible la ventana de Listar Funcionalidades
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
	public ListarFuncionalidades() {
		initialize();
	}
	
	/**
	 * 
	 * Constructor con la aplicacion de IAgro inyectada.
	 */
	public ListarFuncionalidades(IAgro iagro) {
		this.iagro = iagro;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 669, 456);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(173, 216, 230));
		frame.getContentPane().add(desktopPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setBounds(10, 246, 633, 161);
		
		
		ScrollPane scrollPane = new ScrollPane();
		scrollPane.setBounds(10, 246, 633, 161);
		desktopPane.add(scrollPane);
		scrollPane.add(table);
		
		JButton btnMenu = new JButton("Menu");
		btnMenu.setBounds(10, 11, 80, 23);
		desktopPane.add(btnMenu);
		
		JButton btnListarTodo = new JButton("Listar Todas");
		btnListarTodo.setBounds(10, 149, 108, 39);
		desktopPane.add(btnListarTodo);
		
		JButton btnEliminar = new JButton("Eliminar Seleccionada");
		btnEliminar.setBounds(478, 136, 165, 23);
		desktopPane.add(btnEliminar);
		
		JButton btnModificar = new JButton("Modificar Seleccionada");
		btnModificar.setBounds(478, 194, 165, 23);
		desktopPane.add(btnModificar);
		
		JButton btnBuscar1 = new JButton("Buscar");
		btnBuscar1.setBounds(356, 157, 89, 23);
		desktopPane.add(btnBuscar1);
		
		JLabel lblFiltros = new JLabel("Filtrar");
		lblFiltros.setBounds(293, 120, 47, 14);
		desktopPane.add(lblFiltros);
		lblFiltros.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		textField = new JTextField();
		textField.setBounds(254, 158, 86, 20);
		desktopPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(189, 161, 100, 14);
		desktopPane.add(lblNombre);
		
		JLabel lblTitulo = new JLabel("Funcionalidades");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 29));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(151, 15, 350, 94);
		desktopPane.add(lblTitulo);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(ListarFuncionalidades.class.getResource("/img/IAgro icon.png")));
		lblFondo.setBounds(0, 0, 653, 417);
		desktopPane.add(lblFondo);
	}
}
