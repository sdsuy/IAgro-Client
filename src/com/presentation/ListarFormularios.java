package com.presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JDesktopPane;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.RowFilter;

import com.application.IAgro;
import com.entities.Formulario;
import com.entities.Usuario;

import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableRowSorter;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class ListarFormularios implements IFrame<Formulario> {

	private JFrame frame;
	private JTable table;
	List<Formulario> formularios;
	private TableRowSorter<ModeloTabla> sorter;
	
	private IAgro iagro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListarFormularios window = new ListarFormularios();
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
	public ListarFormularios() {
		initialize();
	}
	
	/**
	 * 
	 * Constructor con la aplicacion de IAgro inyectada.
	 */
	public ListarFormularios(IAgro iagro) {
		this.iagro = iagro;
		initialize();
	}

	@Override
	public void setFields(Formulario o) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 669, 430);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(173, 216, 230));
		frame.getContentPane().add(desktopPane, BorderLayout.CENTER);
		
		formularios = iagro.getFormulario();
		String [] columnas = iagro.getColumnasFormulario();
		
		int x = formularios.size();
		int y = columnas.length;
		
		Object[][] datos = iagro.matrixFormularios();
		
		ModeloTabla model = new ModeloTabla(columnas, datos);
		
		sorter = new TableRowSorter<ModeloTabla>(model);
		
		table = new JTable(model);
		table.setRowSorter(sorter);
		
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 72, 633, 161);
		desktopPane.add(scrollPane);
//		scrollPane.add();
		
		JButton btnMenu = new JButton("");
		btnMenu.setIcon(new ImageIcon(ListarFormularios.class.getResource("/img/BotonMenu.png")));
		btnMenu.setBounds(10, 11, 98, 33);
		desktopPane.add(btnMenu);
		
		
		
		
		JButton btnEliminar = new JButton("");
		btnEliminar.setIcon(new ImageIcon(ListarFormularios.class.getResource("/img/EliminarSeleccionado.png")));
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int selectedRow = table.getSelectedRow();
				Formulario formularioDelete = iagro.readFormulario(table.getValueAt(selectedRow, 2).toString());
				boolean result = iagro.delete(formularioDelete.getId_formulario(), Formulario.class);
				if(result) {
					model.setData(iagro.matrixFormularios());
					model.refresh();
					
					JOptionPane.showMessageDialog(null, "Se logro eliminar el Formulario","Exito",JOptionPane.DEFAULT_OPTION);
				}
				else {
					JOptionPane.showMessageDialog(null, "No se logro eliminar el Formulario","Error",JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnEliminar.setBounds(420, 270, 211, 42);
		desktopPane.add(btnEliminar);
		
		JButton btnMostrar = new JButton("");
		btnMostrar.setIcon(new ImageIcon(ListarFormularios.class.getResource("/img/BotonMostarSeleccionado.png")));
		btnMostrar.setBounds(10, 289, 211, 42);
		desktopPane.add(btnMostrar);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(ListarFormularios.class.getResource("/img/ListarFormularios.png")));
		lblFondo.setBounds(173, 0, 297, 391);
		desktopPane.add(lblFondo);
		
		JButton btnEliminar_1 = new JButton("");
		btnEliminar_1.setIcon(new ImageIcon(ListarFormularios.class.getResource("/img/Eliminar Casillas.png")));
		btnEliminar_1.setBounds(420, 323, 211, 42);
		desktopPane.add(btnEliminar_1);
	}
	
	
}
