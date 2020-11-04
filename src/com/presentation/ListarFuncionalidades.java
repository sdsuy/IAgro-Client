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
import javax.swing.RowFilter;

import com.application.IAgro;
import com.entities.Funcionalidad;

import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableRowSorter;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class ListarFuncionalidades implements IFrame {

	private JFrame frame;
	private JTable table;
	private JTextField textFieldNombre;
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
		
		funcionalidades = iagro.getFuncionalidades();
		String [] columnas = iagro.getColumnasFuncionalidad();
		
		int x = funcionalidades.size();
		int y = columnas.length;
		
		Object[][] datos = new Object[x][y];
		
		for (Funcionalidad funcionalidad : funcionalidades) {
			datos[(funcionalidades.indexOf(funcionalidad))][0] = funcionalidad.getNombre();
			datos[(funcionalidades.indexOf(funcionalidad))][1] = funcionalidad.getDescripcion();
		}
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		ModeloTabla model = new ModeloTabla(columnas, datos);
		
		sorter = new TableRowSorter<ModeloTabla>(model);
		
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(173, 216, 230));
		frame.getContentPane().add(desktopPane, BorderLayout.CENTER);
		
		table = new JTable(model);
		table.setBounds(10, 246, 633, 161);
		
		
		ScrollPane scrollPane = new ScrollPane();
		scrollPane.setBounds(10, 246, 633, 161);
		desktopPane.add(scrollPane);
		scrollPane.add(table);
		
		JButton btnMenu = new JButton("Menu");
		btnMenu.setBounds(10, 11, 80, 23);
		desktopPane.add(btnMenu);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarFuncionalidad();
			}
		});
		btnLimpiar.setBounds(10, 149, 108, 39);
		desktopPane.add(btnLimpiar);
		
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
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(254, 158, 86, 20);
		desktopPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
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
	
	public void limpiarFuncionalidad() {
		textFieldNombre.setText("");
	}
	
	class ModeloTabla extends AbstractTableModel {
    	
    	private String[] columnNames;
    	private Object[][] data;

    	public ModeloTabla(String[] columnNames, Object[][] data) {
			super();
			this.columnNames = columnNames;
			this.data = data;
		}

		public int getColumnCount() {
    		return columnNames.length;
    	}

    	public int getRowCount() {
    		return data.length;
    	}

    	public String getColumnName(int col) {
    		return columnNames[col];
    	}

		public Object getValueAt(int row, int col) {
    		return data[row][col];
    	}
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
//            rf = RowFilter.regexFilter(textNombre.getText(), 1);
        	rf = RowFilter.andFilter(filters);
        } catch (java.util.regex.PatternSyntaxException e) {
            return;
        }
        sorter.setRowFilter(rf);
    }
}
