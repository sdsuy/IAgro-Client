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
import com.entities.Usuario;

import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class ListarUsuarios implements IFrame {

	private JFrame frame;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	List<Usuario> usuarios;
	
	IAgro iagro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListarUsuarios window = new ListarUsuarios();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Launch the application.
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
	public ListarUsuarios() {
		initialize();
	}

	/**
	 * Create the application.
	 */
	public ListarUsuarios(IAgro iagro) {
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
		frame.getContentPane().add(desktopPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setBounds(10, 246, 633, 161);
		
		
		ScrollPane scrollPane = new ScrollPane();
		scrollPane.setBounds(10, 246, 633, 161);
		desktopPane.add(scrollPane);
		scrollPane.add(table);
		
		JButton btnMenu = new JButton("Menu");
		btnMenu.setBounds(10, 11, 84, 23);
		desktopPane.add(btnMenu);
		
		JButton btnListarTodo = new JButton("Listar Todos");
		btnListarTodo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnListarTodo.setBounds(10, 149, 108, 39);
		desktopPane.add(btnListarTodo);
		
		JDesktopPane desktopPaneFiltros = new JDesktopPane();
		desktopPaneFiltros.setBounds(128, 103, 340, 129);
		desktopPane.add(desktopPaneFiltros);
		
		JLabel lblFiltros = new JLabel("Filtrar");
		lblFiltros.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblFiltros.setBounds(141, 5, 47, 14);
		desktopPaneFiltros.add(lblFiltros);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 33, 100, 14);
		desktopPaneFiltros.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(10, 57, 100, 14);
		desktopPaneFiltros.add(lblApellido);
		
		JLabel lblNombreDeUsuario = new JLabel("Nombre de Usuario:");
		lblNombreDeUsuario.setBounds(10, 82, 125, 14);
		desktopPaneFiltros.add(lblNombreDeUsuario);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(145, 31, 86, 20);
		desktopPaneFiltros.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(145, 55, 86, 20);
		desktopPaneFiltros.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(145, 80, 86, 20);
		desktopPaneFiltros.add(textField_2);
		
		JButton btnBuscar1 = new JButton("Buscar");
		btnBuscar1.setBounds(241, 30, 89, 23);
		desktopPaneFiltros.add(btnBuscar1);
		
		JButton btnBuscar2 = new JButton("Buscar");
		btnBuscar2.setBounds(241, 54, 89, 23);
		desktopPaneFiltros.add(btnBuscar2);
		
		JButton btnBuscar3 = new JButton("Buscar");
		btnBuscar3.setBounds(241, 79, 89, 23);
		desktopPaneFiltros.add(btnBuscar3);
		
		JLabel lblRol = new JLabel("Rol:");
		lblRol.setBounds(10, 107, 100, 14);
		desktopPaneFiltros.add(lblRol);
		
		JComboBox comboBoxRol = new JComboBox();
		comboBoxRol.setBounds(145, 104, 86, 22);
		desktopPaneFiltros.add(comboBoxRol);
		
		JButton btnBuscar4 = new JButton("Buscar");
		btnBuscar4.setBounds(241, 104, 89, 23);
		desktopPaneFiltros.add(btnBuscar4);
		
		JButton btnEliminar = new JButton("Eliminar Seleccionado");
		btnEliminar.setBounds(478, 138, 165, 23);
		desktopPane.add(btnEliminar);
		
		JButton btnModificar = new JButton("Modificar Seleccionado");
		btnModificar.setBounds(478, 192, 165, 23);
		desktopPane.add(btnModificar);
	}
}
