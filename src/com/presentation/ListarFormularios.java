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
import java.awt.Cursor;

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
	private JTextField textFieldNombre;
	private JScrollPane scrollPane;
	private JButton btnMenu;
	private JButton btnEliminar;
	private JButton btnEliminarCasillas;
	private JButton btnLimpiar;
	private JButton btnActividades;

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
		frame.setBounds(100, 100, 669, 422);
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
		
		
		scrollPane = new JScrollPane(table);
		scrollPane.setCursor(new Cursor(Cursor.HAND_CURSOR));
		scrollPane.setBounds(10, 115, 633, 136);
		desktopPane.add(scrollPane);
//		scrollPane.add();
		
		btnMenu = new JButton("");
		btnMenu.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limpiar();
				frame.dispose();
			}
		});
		btnMenu.setIcon(new ImageIcon(ListarFormularios.class.getResource("/img/BotonMenu.png")));
		btnMenu.setBounds(10, 11, 98, 33);
		desktopPane.add(btnMenu);
		
		
		
		
		btnEliminar = new JButton("");
		btnEliminar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnEliminar.setIcon(new ImageIcon(ListarFormularios.class.getResource("/img/EliminarSeleccionado.png")));
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int selectedRow = table.getSelectedRow();
				Formulario formularioDelete = iagro.readFormulario(table.getValueAt(selectedRow, 1).toString());
				boolean result = iagro.delete(formularioDelete.getId(), Formulario.class);
				if(result) {
					model.setData(iagro.matrixFormularios());
					model.refresh();
					limpiar();
					
					JOptionPane.showMessageDialog(null, "Se logro eliminar el Formulario","Exito",JOptionPane.DEFAULT_OPTION);
				}
				else {
					JOptionPane.showMessageDialog(null, "No se logro eliminar el Formulario","Error",JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnEliminar.setBounds(432, 296, 211, 42);
		desktopPane.add(btnEliminar);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(ListarFormularios.class.getResource("/img/ListarFormularios.png")));
		lblFondo.setBounds(185, 0, 297, 391);
		desktopPane.add(lblFondo);
		
		btnEliminarCasillas = new JButton("");
		btnEliminarCasillas.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnEliminarCasillas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				iagro.show(EditarCasillas.class);
				frame.dispose();
			}
		});
		btnEliminarCasillas.setIcon(new ImageIcon(ListarFormularios.class.getResource("/img/BotonEditarCasillas.png")));
		btnEliminarCasillas.setBounds(10, 262, 185, 42);
		desktopPane.add(btnEliminarCasillas);
		
		JLabel lblFiltros = new JLabel("Filtrar");
		lblFiltros.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFiltros.setBounds(85, 67, 47, 14);
		desktopPane.add(lblFiltros);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(30, 94, 66, 14);
		desktopPane.add(lblNombre);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setColumns(10);
		textFieldNombre.setBounds(95, 91, 86, 20);
		desktopPane.add(textFieldNombre);
		
		textFieldNombre.getDocument().addDocumentListener(
				new DocumentListener() {

					@Override
					public void insertUpdate(DocumentEvent e) {
						filterColumns();
						
					}

					@Override
					public void removeUpdate(DocumentEvent e) {
						filterColumns();
						
					}

					@Override
					public void changedUpdate(DocumentEvent e) {
						filterColumns();
						
					}
					
				});
		
		btnLimpiar = new JButton("");
		btnLimpiar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnLimpiar.setIcon(new ImageIcon(ListarFormularios.class.getResource("/img/BotonLimpiar.png")));
		btnLimpiar.setBounds(532, 73, 100, 35);
		desktopPane.add(btnLimpiar);
		
		btnActividades = new JButton("Actividades de campo");
		btnActividades.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnActividades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				iagro.show(ListarActividades.class);
				frame.dispose();
			}
		});
		btnActividades.setBounds(7, 315, 188, 42);
		desktopPane.add(btnActividades);
	}
	 /** 
     * Update the row filter regular expression from the expression in
     * the text box.
     */
    private void filterColumns() {
        RowFilter<ModeloTabla, Object> rf = null;
        //If current expression doesn't parse, don't update.
        try {
        	List<RowFilter<Object, Object>> filters = new ArrayList<RowFilter<Object, Object>>(1);
        	filters.add(RowFilter.regexFilter(textFieldNombre.getText(), 1));
        	
        	rf = RowFilter.andFilter(filters);
        	
		} catch (java.util.regex.PatternSyntaxException e) {
			return;
		}
        sorter.setRowFilter(rf);
    }
	
	public void limpiar() {
		textFieldNombre.setText("");

	}
}
