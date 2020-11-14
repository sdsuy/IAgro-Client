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
import com.entities.Funcionalidad;
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

public class ListarFormularios implements IFrame<Funcionalidad> {

	private JFrame frame;
	private JTable table;
	List<Funcionalidad> funcionalidades;
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
	public void setFields(Funcionalidad o) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 669, 395);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(173, 216, 230));
		frame.getContentPane().add(desktopPane, BorderLayout.CENTER);
		
		funcionalidades = iagro.getFuncionalidades();
		String [] columnas = iagro.getColumnasFuncionalidad();
		
//		int x = funcionalidades.size();
//		int y = columnas.length;
		
		Object[][] datos = iagro.matrixFuncionalidades();
		
		ModeloTabla model = new ModeloTabla(columnas, datos);
		
		sorter = new TableRowSorter<ModeloTabla>(model);
		
		table = new JTable(model);
		table.setRowSorter(sorter);
		
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 73, 633, 161);
		desktopPane.add(scrollPane);
//		scrollPane.add();
		
		JButton btnMenu = new JButton("Menu");
		btnMenu.setBounds(10, 11, 80, 23);
		desktopPane.add(btnMenu);
		
		
		
		
		JButton btnEliminar = new JButton("Eliminar Seleccionado");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int selectedRow = table.getSelectedRow();
				Funcionalidad funcionalidadDelete = iagro.readFuncionalidad(table.getValueAt(selectedRow, 0).toString());
				boolean result = iagro.delete(funcionalidadDelete.getId(), Funcionalidad.class);
				if(result) {
					model.setData(iagro.matrixFuncionalidades());
					model.refresh();
					
					JOptionPane.showMessageDialog(null, "Se logro eliminar la Funcionalidad","Exito",JOptionPane.DEFAULT_OPTION);
				}
				else {
					JOptionPane.showMessageDialog(null, "No se logro eliminar la Funcionalidad","Error",JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnEliminar.setBounds(478, 282, 165, 31);
		desktopPane.add(btnEliminar);
		
		JLabel lblTitulo = new JLabel("Formularios");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 29));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(137, 0, 350, 94);
		desktopPane.add(lblTitulo);
		
		JButton btnMostrar = new JButton("Mostrar Seleccionado");
		btnMostrar.setBounds(10, 282, 153, 31);
		desktopPane.add(btnMostrar);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(ListarFormularios.class.getResource("/img/IAgro icon.png")));
		lblFondo.setBounds(0, 0, 653, 356);
		desktopPane.add(lblFondo);
	}
	
	
}
