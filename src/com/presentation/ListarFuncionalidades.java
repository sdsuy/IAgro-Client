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

public class ListarFuncionalidades implements IFrame<Funcionalidad> {

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

	@Override
	public void setFields(Funcionalidad o) {
		// TODO Auto-generated method stub
		
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
		
		funcionalidades = iagro.getFuncionalidades();
		String [] columnas = iagro.getColumnasFuncionalidad();
		
		int x = funcionalidades.size();
		int y = columnas.length;
		
		Object[][] datos = iagro.matrixFuncionalidades();
		
		ModeloTabla model = new ModeloTabla(columnas, datos);
		
		sorter = new TableRowSorter<ModeloTabla>(model);
		table = new JTable(model);
		table.setRowSorter(sorter);
		
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 246, 633, 161);
		desktopPane.add(scrollPane);
//		scrollPane.add();
		
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
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int selectedRow = table.getSelectedRow();
				Funcionalidad funcionalidadDelete = iagro.readFuncionalidad(table.getValueAt(selectedRow, 0).toString());
				boolean result = iagro.delete(funcionalidadDelete.getId(), Funcionalidad.class);
				if(result) {
					model.setData(iagro.matrixFuncionalidades());
					model.refresh();
					limpiar();
					JOptionPane.showMessageDialog(null, "Se logro eliminar la Funcionalidad","Exito",JOptionPane.DEFAULT_OPTION);
				}
				else {
					JOptionPane.showMessageDialog(null, "No se logro eliminar la Funcionalidad","Error",JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnEliminar.setBounds(478, 136, 165, 23);
		desktopPane.add(btnEliminar);
		
		JButton btnModificar = new JButton("Modificar Seleccionada");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table.getSelectedRow();
				Funcionalidad funcionalidadUpdate = iagro.readFuncionalidad(table.getValueAt(selectedRow, 0).toString());
				iagro.show(CrearFuncionalidad.class, funcionalidadUpdate);
				frame.dispose();
			}
		});
		btnModificar.setBounds(478, 194, 165, 23);
		desktopPane.add(btnModificar);
		
		JLabel lblFiltros = new JLabel("Filtrar");
		lblFiltros.setBounds(293, 120, 47, 14);
		desktopPane.add(lblFiltros);
		lblFiltros.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(312, 158, 86, 20);
		desktopPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		textFieldNombre.getDocument().addDocumentListener(
				new DocumentListener() {
					
					@Override
					public void removeUpdate(DocumentEvent e) {
						filterColumns();
					}
					
					@Override
					public void insertUpdate(DocumentEvent e) {
						filterColumns();
					}
					
					@Override
					public void changedUpdate(DocumentEvent e) {
						filterColumns();
					}
				});
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(202, 161, 100, 14);
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
		limpiar();
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
//        	filters.add(RowFilter.regexFilter(textFieldNombre.getText(), 1));
            rf = RowFilter.regexFilter(textFieldNombre.getText().toUpperCase(), 1);
//        	rf = RowFilter.andFilter(filters);
        } catch (java.util.regex.PatternSyntaxException e) {
            return;
        }
        sorter.setRowFilter(rf);
    }
    void limpiar() {
    	textFieldNombre.setText("");
    }
}
