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
import com.entities.Rol;
import com.presentation.ListarUsuarios.ModeloTabla;

import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class ListarRoles implements IFrame {

	private JFrame frame;
	private JTable table;
	private JTextField textFieldNombre;
	List<Rol> roles;
	private TableRowSorter<ModeloTabla> sorter;
	
	private IAgro iagro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListarRoles window = new ListarRoles();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 *
	 * Hago visible la ventana de Listar Roles
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
	public ListarRoles() {
		initialize();
	}
	
	/**
	 * 
	 * Constructor con la aplicacion de IAgro inyectada.
	 * @return 
	 */
	public ListarRoles(IAgro iagro) {
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
		
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(173, 216, 230));
		frame.getContentPane().add(desktopPane, BorderLayout.CENTER);
		
		roles = iagro.getRoles();
		String[] columnas = iagro.getColumnasRoles();
		
		int x = roles.size();
		int y = columnas.length;
		
		Object[][] datos = new Object[x][y];
		
		for (Rol rol : roles) {
			datos[(roles.indexOf(rol))][0] = rol.getNombre();
			datos[(roles.indexOf(rol))][1] = rol.getDescripcion();
		}
		
		ModeloTabla model = new ModeloTabla(columnas, datos);
		
		sorter = new TableRowSorter<ModeloTabla>(model);
		table = new JTable(model);
		table.setRowSorter(sorter);
//		table.setBounds(10, 246, 633, 161);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 246, 633, 161);
//		scrollPane.add();
		desktopPane.add(scrollPane);
		
		JButton btnMenu = new JButton("Menu");
		btnMenu.setBounds(10, 11, 84, 23);
		desktopPane.add(btnMenu);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarRoles();
			}
		});
		btnLimpiar.setBounds(10, 149, 108, 39);
		desktopPane.add(btnLimpiar);
		
		JButton btnEliminar = new JButton("Eliminar Seleccionado");
		btnEliminar.setBounds(478, 136, 165, 23);
		desktopPane.add(btnEliminar);
		
		JButton btnModificar = new JButton("Modificar Seleccionado");
		btnModificar.setBounds(478, 194, 165, 23);
		desktopPane.add(btnModificar);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(258, 174, 86, 20);
		desktopPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel lblFiltros = new JLabel("Filtrar");
		lblFiltros.setBounds(285, 149, 47, 14);
		desktopPane.add(lblFiltros);
		lblFiltros.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(154, 177, 100, 14);
		desktopPane.add(lblNombre);
		
		JButton btnBuscar1 = new JButton("Buscar");
		btnBuscar1.setBounds(354, 173, 89, 23);
		desktopPane.add(btnBuscar1);
		
		JLabel lblTitulo = new JLabel("Roles");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 29));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(135, 32, 370, 81);
		desktopPane.add(lblTitulo);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(ListarRoles.class.getResource("/img/IAgro icon.png")));
		lblFondo.setBounds(0, 0, 653, 417);
		desktopPane.add(lblFondo);
	}
	
	public void limpiarRoles() {
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
