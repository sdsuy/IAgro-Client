package com.presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JToolBar;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableRowSorter;

import com.application.IAgro;
import com.entities.Actividad;
import com.entities.Casilla;
import com.entities.Formulario;
import com.entities.Informacion;
import com.entities.Usuario;

import java.awt.BorderLayout;
import java.awt.Cursor;

import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import java.awt.Component;

public class CrearActividad implements IFrame<Actividad> {

	private JFrame frame;
	private IAgro iagro;
	private Long id;
	private JComboBox comboBoxFormulario;
	private JButton btnGuardar;
	private JButton btnCancelar;
	private Formulario formulario;
	List<Casilla> casillas;
//	private TableRowSorter<ModeloTabla> sorter;
	private JTable table;
	private JScrollPane scrollPane;
	private ModeloActividad model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrearActividad window = new CrearActividad();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CrearActividad() {
		initialize();
	}
	
	/**
	 * Constructor con la aplicacion de IAgro inyectada.
	 */
	public CrearActividad(IAgro iagro) {
		id = 0L;
		this.iagro = iagro;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 549, 506);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setResizable(false);
		
		JDesktopPane desktopPane = new JDesktopPane();
		frame.getContentPane().add(desktopPane, BorderLayout.CENTER);
		
		JLabel lblFormulario = new JLabel("Formulario:");
		lblFormulario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFormulario.setBounds(138, 97, 91, 14);
		desktopPane.add(lblFormulario);
		
		btnCancelar = new JButton("");
		btnCancelar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnCancelar.setIcon(new ImageIcon(AltaUsuario.class.getResource("/img/BotonCancelar.png")));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int seleccion = JOptionPane.showOptionDialog(null, "Seguro desea Cancelar y salir al menu?",  null, JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, 
						null, new Object[] { "SI", "NO"},   
						   null);

						if (seleccion == 0) {
							
							frame.dispose();
						}
						   
				
			}
		});
		btnCancelar.setBounds(286, 416, 147, 40);
		desktopPane.add(btnCancelar);
		
		JDesktopPane desktopPane_1 = new JDesktopPane();
		desktopPane_1.setBounds(10, 129, 523, 240);
		desktopPane.add(desktopPane_1);
		
		casillas = iagro.getCasillas();
//		String [] columnas = iagro.getColumnasCasilla();
		String [] columnas = {"PARAMETRO", "UNIDAD", "DESCRIPCION", "TIPO", "INGRESE VALOR"};
		
//		int x = casillas.size();
		//int y = columnas.length;
		
//		Object[][] datos = iagro.matrixCasillas();
		Object[][] datos = {
	            {"PARAMETRO", "UNIDAD DE MEDIDA", "DESCRIPCION", "TIPO", "I'm a string"},
	            {"PARAMETRO", "UNIDAD DE MEDIDA", "DESCRIPCION", "TIPO", new Date()},
	            {"PARAMETRO", "UNIDAD DE MEDIDA", "DESCRIPCION", "TIPO", new Integer(123)},
	            {"PARAMETRO", "UNIDAD DE MEDIDA", "DESCRIPCION", "TIPO", new Double(123.45)},
	            {"PARAMETRO", "UNIDAD DE MEDIDA", "DESCRIPCION", "TIPO", Boolean.TRUE}};
//		
//		ModeloTabla model = new ModeloTabla(columnas, datos);
		model = new ModeloActividad(columnas, datos);
		
		//sorter = new TableRowSorter<ModeloTabla>(model);
		
//		table = new JTable(model);
		//table.setRowSorter(sorter);
//		table = new JTable(datos, columnas) {
		table = new JTable(model) {

//            private static final long serialVersionUID = 1L;
            private Class editingClass;

            @Override
            public TableCellRenderer getCellRenderer(int row, int column) {
                editingClass = null;
                int modelColumn = convertColumnIndexToModel(column);
                if (modelColumn == 4) {
                    Class rowClass = getModel().getValueAt(row, modelColumn).getClass();
                    return getDefaultRenderer(rowClass);
                } else {
                    return super.getCellRenderer(row, column);
                }
            }

            @Override
            public TableCellEditor getCellEditor(int row, int column) {
                editingClass = null;
                int modelColumn = convertColumnIndexToModel(column);
                if (modelColumn == 4) {
                    editingClass = getModel().getValueAt(row, modelColumn).getClass();
                    return getDefaultEditor(editingClass);
                } else {
                    return super.getCellEditor(row, column);
                }
            }
            //  This method is also invoked by the editor when the value in the editor
            //  component is saved in the TableModel. The class was saved when the
            //  editor was invoked so the proper class can be created.

            @Override
            public Class getColumnClass(int column) {
                return editingClass != null ? editingClass : super.getColumnClass(column);
            }
        };
		
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 0, 523, 240);
		desktopPane_1.add(scrollPane);
		
		comboBoxFormulario = new JComboBox();
		comboBoxFormulario.addItem("");
		comboBoxFormulario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(comboBoxFormulario.getSelectedItem());
				formulario = iagro.readFormulario(comboBoxFormulario.getSelectedItem().toString()); // busco el formulario por nombre en la memoria
				formulario = (Formulario) iagro.read(formulario.getId(), Formulario.class); // busco el formulario por id con todas las casillas
				List<Casilla> casillas = formulario.getCasillas();
				Object[][] datos = new Object[casillas.size()][columnas.length];
				for(Casilla casilla: casillas) {
					datos[(casillas.indexOf(casilla))][0] = casilla.getParametro().toString();
					try {
						datos[(casillas.indexOf(casilla))][1] = casilla.getUnidadMedida().toString();
					} catch (NullPointerException ex) {
						datos[(casillas.indexOf(casilla))][1] = "";
					}
					try {
						datos[(casillas.indexOf(casilla))][2] = casilla.getDescripcion().toString();
					} catch (NullPointerException ex) {
						datos[(casillas.indexOf(casilla))][2] = "";
					}
					
					datos[(casillas.indexOf(casilla))][3] = casilla.getTipo().getTipo().toString();
					switch(casilla.getTipo()) {
					case INTEGER:
						datos[(casillas.indexOf(casilla))][4] = new Integer(0);
						break;
					case STRING:
						datos[(casillas.indexOf(casilla))][4] = "";
						break;
					case DOUBLE:
						datos[(casillas.indexOf(casilla))][4] = new Double(0.0);
						break;
					case BOOLEAN:
						datos[(casillas.indexOf(casilla))][4] = Boolean.TRUE;
						break;
					}
				}
				model.setDatos(datos);
				model.refresh();
			}
		});
		comboBoxFormulario.setCursor(new Cursor(Cursor.HAND_CURSOR));
		comboBoxFormulario.setBounds(253, 95, 134, 22);
		desktopPane.add(comboBoxFormulario);
		
		List<Formulario> formularios = iagro.getFormulario();
		for (Formulario form : formularios) {
			comboBoxFormulario.addItem(form.getNombre());
		}
		
		btnGuardar = new JButton("");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int counter = 0;
				
				for(int i = 0; i < model.getRowCount(); i++) {
					
					if(model.getValueAt(i, 4).toString().equals("")) {
						counter++;
						JOptionPane.showMessageDialog(null, "Debe rellenar todas las casillas que se muestran","Error",JOptionPane.ERROR_MESSAGE);
						
						if(counter > 0) {
							break;
						}
						
					}
					
					else {
						
						boolean result;
						Actividad actividad = new Actividad();
						List<Informacion> informaciones = new ArrayList<>();
			
						for(int i2 = 0; i2 < model.getRowCount(); i2++) {
							Informacion informacion = new Informacion();
							informacion.setCasilla(iagro.readCasilla(model.getValueAt(i2, 0).toString()));
							informacion.setValor(model.getValueAt(i2, 4).toString());
							informaciones.add(informacion);
						}
						actividad.setInfo(informaciones);
						actividad.setForm(formulario);
						actividad.setUsuario(iagro.getAuthUser());
						
						result=iagro.create(actividad);
						if(result) {
							JOptionPane.showMessageDialog(null, "Se creo con exito","Exito",JOptionPane.DEFAULT_OPTION);
						}
						else {
							JOptionPane.showMessageDialog(null, "Existe un error","Error",JOptionPane.ERROR_MESSAGE);
						}
						
					}
				}
				
				
			}
		});
		btnGuardar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnGuardar.setIcon(new ImageIcon(CrearActividad.class.getResource("/img/BotonGuardar (2).png")));
		btnGuardar.setBounds(69, 416, 137, 40);
		desktopPane.add(btnGuardar);
		
	}

	@Override
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

	@Override
	public void setFields(Actividad o) {
		// TODO Auto-generated method stub
		
	}
}
