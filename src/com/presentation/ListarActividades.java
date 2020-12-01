package com.presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JDesktopPane;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableRowSorter;

import com.application.IAgro;
import com.entities.Actividad;
import com.entities.Formulario;
import com.entities.Usuario;

import java.awt.Component;
import java.awt.Cursor;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.table.TableModel;
import java.awt.Font;

public class ListarActividades implements IFrame<Formulario>{

	private JFrame frame;
	private IAgro iagro;
	private Long id;
	private JScrollPane scrollPaneRegistros;
	private JButton btnModificar;
	private JButton btnVolver;
	private List<Actividad> actividadesFormulario;
	private TableRowSorter<ModeloTabla> sorter;
	private TableRowSorter<ModeloTabla> sorterCasillas;
	private JTable tableRegistros;
	private JTable tableCasillas;
	private Formulario formulario;
	ModeloTabla model;
	ModeloTabla modelCasillas;
	Object[][] datos;
	private JScrollPane scrollPaneCasillas;
	
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
		
//		actividadesFormulario = formulario.getActividades();
		
		String [] columnas = iagro.getColumnasActividad();
		
//		int x = actividadesFormulario.size();
//		int y = columnas.length;
		
//		datos = iagro.matrixActividades();
		Object[][] falso = {
					{1, new Date()}
	            };
		
		model = new ModeloTabla(columnas, falso);
		
		sorter = new TableRowSorter<ModeloTabla>(model);
		
		tableRegistros = new JTable(model);
		tableRegistros.setRowSorter(sorter);
		
		scrollPaneRegistros = new JScrollPane(tableRegistros);
		scrollPaneRegistros.setCursor(new Cursor(Cursor.HAND_CURSOR));
		scrollPaneRegistros.setBounds(10, 116, 319, 175);
		desktopPane.add(scrollPaneRegistros);
		
		btnModificar = new JButton("");
		btnModificar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					
					iagro.show(ModificarActividad.class);
					frame.dispose();
					
					
					
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
		
        //modelCasillas = new ModeloTabla(columnas, datos);
		
		sorterCasillas = new TableRowSorter<ModeloTabla>(model);
		
		tableCasillas = new JTable(modelCasillas);
		tableCasillas.setRowSorter(sorterCasillas);
		
		scrollPaneCasillas = new JScrollPane(tableCasillas);
		scrollPaneCasillas.setBounds(339, 116, 334, 175);
		desktopPane.add(scrollPaneCasillas);
		
		JLabel lblActividadesRegistradas = new JLabel("Actividaes Registradas:");
		lblActividadesRegistradas.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblActividadesRegistradas.setBounds(74, 91, 166, 20);
		desktopPane.add(lblActividadesRegistradas);
		
		JLabel lblCasillas = new JLabel("Casillas:");
		lblCasillas.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCasillas.setBounds(475, 91, 71, 20);
		desktopPane.add(lblCasillas);
		
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
		actividadesFormulario = iagro.getActividadesByForm(o); // busco las actvidades del formulario pasado como argumento
		datos = iagro.matrixActividades(actividadesFormulario); // cargo los la matriz de datos con las actividades encontradas de ese formulario 
		model.setData(datos); // actualizo el modelo de la tabla con la nueva matriz
		model.refresh(); // refresco la tabla (antes de hacer visible el frame)
		
	}
}
