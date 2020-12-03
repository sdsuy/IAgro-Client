package com.presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JDesktopPane;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

import com.application.IAgro;
import com.entities.Actividad;
import com.entities.Formulario;
import com.entities.Informacion;
import com.entities.Roles;

import java.awt.Cursor;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JComboBox;

public class ListarActividades implements IFrame<Formulario>{

	private JFrame frame;
	private IAgro iagro;
	private Long id;
	private JScrollPane scrollPaneRegistros;
	private JButton btnModificar;
	private JButton btnVolver;
	private List<Actividad> actividadesFormulario;
//	private TableRowSorter<ModeloTabla> sorter;
//	private TableRowSorter<ModeloTabla> sorterCasillas;
	private JTable tableRegistros;
	private JTable tableCasillas;
	private Formulario formulario;
	ModeloTabla model;
//	ModeloTabla modelCasillas;
	Object[][] datos;
	private JScrollPane scrollPaneCasillas;
	private JComboBox comboBoxFormulario;
	private Actividad selectedActividad;
	List<Informacion> informaciones;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListarActividades window = new ListarActividades();
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
	public ListarActividades() {
		initialize();
	}
	/**
	 * Constructor con la aplicacion de IAgro inyectada.
	 */
	public ListarActividades(IAgro iagro) {
		this.iagro = iagro;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 689, 446);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setResizable(false);
		
		JDesktopPane desktopPane = new JDesktopPane();
		frame.getContentPane().add(desktopPane, BorderLayout.CENTER);
		
		
		

		
        //modelCasillas = new ModeloTabla(columnas, datos);
		
//		sorterCasillas = new TableRowSorter<ModeloTabla>(model);
		
		// --- Tabla para las casillas y la INFO
		
		String [] columnasCasillas = {"PARAMETRO", "UNIDAD", "DESCRIPCION", "TIPO", "VALORES INGRESADOS"};
		
//		Object[][] datosCasillas = {
//	            {"PARAMETRO", "UNIDAD DE MEDIDA", "DESCRIPCION", "TIPO", "I'm a string"},
//	            {"PARAMETRO", "UNIDAD DE MEDIDA", "DESCRIPCION", "TIPO", new Date()},
//	            {"PARAMETRO", "UNIDAD DE MEDIDA", "DESCRIPCION", "TIPO", new Integer(123)},
//	            {"PARAMETRO", "UNIDAD DE MEDIDA", "DESCRIPCION", "TIPO", new Double(123.45)},
//	            {"PARAMETRO", "UNIDAD DE MEDIDA", "DESCRIPCION", "TIPO", Boolean.TRUE}};
		Object[][] datosCasillas = {{"", "", "", "", ""}};
		
		ModeloActividad modeloCasillas = new ModeloActividad(columnasCasillas, datosCasillas);
		
		tableCasillas = new JTable(modeloCasillas) {

//          private static final long serialVersionUID = 1L;
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
		
		// --- FIN
//		tableCasillas.setRowSorter(sorterCasillas);
		
		scrollPaneCasillas = new JScrollPane(tableCasillas);
		scrollPaneCasillas.setBounds(339, 152, 334, 139);
		desktopPane.add(scrollPaneCasillas);
		
		
		
//		actividadesFormulario = formulario.getActividades();
		
		String [] columnas = iagro.getColumnasActividad();
		
//		int x = actividadesFormulario.size();
//		int y = columnas.length;
		
//		datos = iagro.matrixActividades();
		Object[][] falso = {
					{1, new Date()}
	            };
		
		model = new ModeloTabla(columnas, falso);
		
//		sorter = new TableRowSorter<ModeloTabla>(model);
		
		tableRegistros = new JTable(model);
//		tableRegistros.setRowSorter(sorter);
		
		scrollPaneRegistros = new JScrollPane(tableRegistros);
		scrollPaneRegistros.setCursor(new Cursor(Cursor.HAND_CURSOR));
		scrollPaneRegistros.setBounds(10, 152, 319, 139);
		desktopPane.add(scrollPaneRegistros);
		
		tableRegistros.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				
				try {
					if (!iagro.getAuthUser().getRol().getRol().equals(Roles.ADMINISTRADOR)) {
						JOptionPane.showMessageDialog(null, "Solo los usuarios Administradores pueden modificar Usuarios","Error",JOptionPane.ERROR_MESSAGE);
					}
					
					else {
						int selectedRow = tableRegistros.getSelectedRow();
						String fecha = tableRegistros.getValueAt(selectedRow, 1).toString();
//						Long idLing = Long.valueOf(idString);
						System.out.println(fecha);

						DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd / HH:mm:ss"); // debe tener el mismo formato del matrix
						
						selectedActividad = actividadesFormulario.stream()
								.filter(a -> a.getFechaHora().format(formatter).equals(fecha))
								.collect(Collectors.toList())
								.get(0);
						System.out.println("Seleccion: " + selectedActividad.getFechaHora());
						selectedActividad = iagro.getActividadById(selectedActividad);
						for(Informacion info: selectedActividad.getInfo()) {
							System.out.println(info.getValor());
						}
//						Usuario usuarioUpdate = (Usuario) iagro.read(idLing, Usuario.class);
//						iagro.show(AltaUsuario.class, usuarioUpdate);;
//						frame.dispose();
						
						informaciones = selectedActividad.getInfo();
						Object[][] datosCasillas = new Object[informaciones.size()][columnasCasillas.length];
						for(Informacion informacion: informaciones) {
							datosCasillas[(informaciones.indexOf(informacion))][0] = informacion.getCasilla().getParametro().toString();
							try {
								datosCasillas[(informaciones.indexOf(informacion))][1] = informacion.getCasilla().getUnidadMedida().toString();
							} catch (NullPointerException ex) {
								datosCasillas[(informaciones.indexOf(informacion))][1] = "";
							}
							try {
								datosCasillas[(informaciones.indexOf(informacion))][2] = informacion.getCasilla().getDescripcion().toString();
							} catch (NullPointerException ex) {
								datosCasillas[(informaciones.indexOf(informacion))][2] = "";
							}
							
							datosCasillas[(informaciones.indexOf(informacion))][3] = informacion.getCasilla().getTipo().getTipo().toString();
//							datosCasillas[(informaciones.indexOf(informacion))][4] = informacion.getValor();
							switch(informacion.getCasilla().getTipo()) {
							case INTEGER:
								datosCasillas[(informaciones.indexOf(informacion))][4] = Integer.parseInt(informacion.getValor());
								break;
							case STRING:
								datosCasillas[(informaciones.indexOf(informacion))][4] = informacion.getValor();
								break;
							case DOUBLE:
								datosCasillas[(informaciones.indexOf(informacion))][4] = Double.parseDouble(informacion.getValor());
								break;
							case BOOLEAN:
								datosCasillas[(informaciones.indexOf(informacion))][4] = Boolean.parseBoolean(informacion.getValor());
								break;
							}
						}
						modeloCasillas.setDatos(datosCasillas);
						modeloCasillas.refresh();
					}
				} catch (IndexOutOfBoundsException ex) {
					System.out.println("Seleccionar elemento de la lista");
//					JOptionPane.showMessageDialog(null, "Debe seleccinar una Actividad para modificar","Error",JOptionPane.ERROR_MESSAGE);
				}

				
				
				
			}
		});
		
		btnModificar = new JButton("");
		btnModificar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					
//					iagro.show(ModificarActividad.class);
//					frame.dispose();
					boolean result;
					for(int i = 0; i < modeloCasillas.getRowCount(); i++) {
						informaciones.get(i).setCasilla(iagro.readCasilla(modeloCasillas.getValueAt(i, 0).toString())); // busco la casillas por la primer columna (parametro que unique)
						informaciones.get(i).setValor(modeloCasillas.getValueAt(i, 4).toString()); // guardo el valor nuevo
					}
					selectedActividad.setInfo(informaciones);
					selectedActividad.setForm(formulario);
					selectedActividad.setUsuario(iagro.getAuthUser());
					
					result = iagro.update(selectedActividad);
					if(result) {
						JOptionPane.showMessageDialog(null, "Se modifica con exito","Exito",JOptionPane.DEFAULT_OPTION);
					}
					else {
						JOptionPane.showMessageDialog(null, "Existe un error","Error",JOptionPane.ERROR_MESSAGE);
					}
					
					
				} catch (IndexOutOfBoundsException ex) {
					JOptionPane.showMessageDialog(null, "Debe seleccinar una actividad para modificar","Error",JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnModificar.setIcon(new ImageIcon(ListarActividades.class.getResource("/img/BotonModificarSeleccionada.png")));
		btnModificar.setBounds(222, 320, 229, 42);
		desktopPane.add(btnModificar);
		
		btnVolver = new JButton("");
		btnVolver.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				iagro.show(ListarFormularios.class);
				frame.dispose();
			}
		});
		btnVolver.setIcon(new ImageIcon(ListarActividades.class.getResource("/img/BotonVolver.png")));
		btnVolver.setBounds(10, 363, 92, 33);
		desktopPane.add(btnVolver);
		
		JLabel lblActividadesRegistradas = new JLabel("Actividaes Registradas:");
		lblActividadesRegistradas.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblActividadesRegistradas.setBounds(76, 121, 166, 20);
		desktopPane.add(lblActividadesRegistradas);
		
		JLabel lblCasillas = new JLabel("Casillas:");
		lblCasillas.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCasillas.setBounds(472, 121, 71, 20);
		desktopPane.add(lblCasillas);
		
		JLabel lblFormulario = new JLabel("Formulario:");
		lblFormulario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFormulario.setBounds(241, 79, 88, 20);
		desktopPane.add(lblFormulario);
		
		comboBoxFormulario = new JComboBox();
		comboBoxFormulario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				formulario = iagro.readFormulario(comboBoxFormulario.getSelectedItem().toString()); 
				formulario = (Formulario) iagro.read(formulario.getId(), Formulario.class);
				
				actividadesFormulario = iagro.getActividadesByForm(formulario); // busco las actvidades del formulario seleccionado en el combobox
				datos = iagro.matrixActividades(actividadesFormulario); // cargo los la matriz de datos con las actividades encontradas de ese formulario 
				model.setData(datos); // actualizo el modelo de la tabla con la nueva matriz
				model.refresh(); // refresco la tabla (antes de hacer visible el frame)
				
			}
		});
		comboBoxFormulario.setBounds(339, 80, 112, 22);
		desktopPane.add(comboBoxFormulario);
		
		List<Formulario> formularios = iagro.getFormulario();
		for (Formulario form : formularios) {
			comboBoxFormulario.addItem(form.getNombre());
		}
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(ListarActividades.class.getResource("/img/ActividadesDeCampo.png")));
		lblFondo.setBounds(95, 0, 486, 414);
		desktopPane.add(lblFondo);
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
	public void setFields(Formulario o) {
		
//		formulario = (Formulario) iagro.read(o.getId(), Formulario.class);
		
		
	}
}
