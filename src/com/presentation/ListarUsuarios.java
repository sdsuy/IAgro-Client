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
import com.entities.Rol;
import com.entities.Usuario;

import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableRowSorter;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.DefaultComboBoxModel;

public class ListarUsuarios implements IFrame<Usuario> {

	private JFrame frame;
	private JTable table;
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JTextField textFieldNickname;
	List<Usuario> usuarios;
	private TableRowSorter<ModeloTabla> sorter;
	
	private JComboBox comboBoxRol;
	
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
		
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(173, 216, 230));
		frame.getContentPane().add(desktopPane, BorderLayout.CENTER);
		
		usuarios = iagro.getUsuarios();
		String[] columnas = iagro.getColumnas();
		
		int x = usuarios.size();
		int y = columnas.length;
		
		Object[][] datos = iagro.matrixUsuarios();
		
		ModeloTabla model = new ModeloTabla(columnas, datos);
		
		sorter = new TableRowSorter<ModeloTabla>(model);
		table = new JTable(model);
		table.setRowSorter(sorter);
//		table.setBounds(10, 246, 633, 161);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 246, 633, 161);
		desktopPane.add(scrollPane);
//		scrollPane.add(table);
		
		JButton btnMenu = new JButton("");
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				frame.dispose();
			}
		});
		btnMenu.setIcon(new ImageIcon(ListarUsuarios.class.getResource("/img/BotonMenu.png")));
		btnMenu.setBounds(10, 11, 100, 34);
		desktopPane.add(btnMenu);
		
		JButton btnLimpiar = new JButton("");
		btnLimpiar.setIcon(new ImageIcon(ListarUsuarios.class.getResource("/img/BotonLimpiar.png")));
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarFiltros();
			}
		});
		btnLimpiar.setBounds(10, 156, 100, 35);
		desktopPane.add(btnLimpiar);
		
		JButton btnEliminar = new JButton("");
		btnEliminar.setIcon(new ImageIcon(ListarUsuarios.class.getResource("/img/EliminarSeleccionado.png")));
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table.getSelectedRow();
				Usuario userDelete = iagro.readUsuario(table.getValueAt(selectedRow, 3).toString());
				boolean result = iagro.delete(userDelete.getId(), Usuario.class);
				if(result) {
					model.setData(iagro.matrixUsuarios());
					model.refresh();
					limpiarFiltros();
					JOptionPane.showMessageDialog(null, "Se logro eliminar el Usuario","Exito",JOptionPane.DEFAULT_OPTION);
				}
				else {
					JOptionPane.showMessageDialog(null, "No se logro eliminar El Usuario","Error",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnEliminar.setBounds(448, 105, 201, 44);
		desktopPane.add(btnEliminar);
		
		JButton btnModificar = new JButton("");
		btnModificar.setIcon(new ImageIcon(ListarUsuarios.class.getResource("/img/BotonModificarSeleccionado.png")));
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table.getSelectedRow();
				Usuario usuarioUpdate = iagro.readUsuario(table.getValueAt(selectedRow, 3).toString());
				iagro.show(AltaUsuario.class, usuarioUpdate);;
				frame.dispose();
			}
		});
		btnModificar.setBounds(448, 166, 201, 44);
		desktopPane.add(btnModificar);
		
		JLabel lblFiltros = new JLabel("Filtrar");
		lblFiltros.setBounds(277, 105, 47, 14);
		desktopPane.add(lblFiltros);
		lblFiltros.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(202, 132, 100, 14);
		desktopPane.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(202, 156, 100, 14);
		desktopPane.add(lblApellido);
		
		JLabel lblNombreDeUsuario = new JLabel("Nombre de Usuario:");
		lblNombreDeUsuario.setBounds(202, 181, 125, 14);
		desktopPane.add(lblNombreDeUsuario);
		
		JLabel lblRol = new JLabel("Rol:");
		lblRol.setBounds(202, 206, 100, 14);
		desktopPane.add(lblRol);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(337, 130, 86, 20);
		desktopPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
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
		
		textFieldApellido = new JTextField();
		textFieldApellido.setBounds(337, 154, 86, 20);
		desktopPane.add(textFieldApellido);
		textFieldApellido.setColumns(10);
		
		textFieldApellido.getDocument().addDocumentListener(
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
		
		textFieldNickname = new JTextField();
		textFieldNickname.setBounds(337, 179, 86, 20);
		desktopPane.add(textFieldNickname);
		textFieldNickname.setColumns(10);
		
		textFieldNickname.getDocument().addDocumentListener(
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
//		String[]rol ={""};
		
		comboBoxRol = new JComboBox();
		comboBoxRol.setModel(new DefaultComboBoxModel(new String[] {"Elegir Rol", "Administrador", "Experto", "Comun"}));
//		comboBoxRol.setModel(new DefaultComboBoxModel(new String[] {""}));
		comboBoxRol.setBounds(337, 203, 101, 22);
		desktopPane.add(comboBoxRol);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(ListarUsuarios.class.getResource("/img/Usuarios.png")));
		lblFondo.setBounds(188, 11, 280, 224);
		desktopPane.add(lblFondo);
		comboBoxRol.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				filterColumns();
				
			}
		});
	}
	 
	 /** 
	     * Update the row filter regular expression from the expression in
	     * the text box.
	     */
	    private void filterColumns() {
	        RowFilter<ModeloTabla, Object> rf = null;
	        //If current expression doesn't parse, don't update.
	        try {
	        	List<RowFilter<Object, Object>> filters = new ArrayList<RowFilter<Object, Object>>(4);
	        	filters.add(RowFilter.regexFilter(textFieldNombre.getText(), 1)); // .toUpperCase() CUANDO GUARDE UPPERCASE
	        	filters.add(RowFilter.regexFilter(textFieldApellido.getText(), 2)); // .toUpperCase() CUANDO GUARDE UPPERCASE
	        	filters.add(RowFilter.regexFilter(textFieldNickname.getText(), 5)); // .toUpperCase() CUANDO GUARDE UPPERCASE
	        	filters.add(RowFilter.regexFilter(comboBoxRol.getSelectedItem().toString(), 7));
//	        	filters.add(RowFilter.regexFilter(comboBoxRol.getActionListeners().toString(), 4));
//	            rf = RowFilter.regexFilter(textNombre.getText(), 1);
	        	rf = RowFilter.andFilter(filters);
	        } catch (java.util.regex.PatternSyntaxException e) {
	            return;
	        }
	        sorter.setRowFilter(rf);
	    }
	    
	    private void limpiarFiltros() {
	    	textFieldNombre.setText("");
	    	textFieldApellido.setText("");
	    	textFieldNickname.setText("");
	    }

		@Override
		public void setFields(Usuario o) {
			// TODO Auto-generated method stub
			
		}
}
