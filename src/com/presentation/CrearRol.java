package com.presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JToolBar;

import com.application.IAgro;
import com.entities.Funcionalidad;
import com.entities.Rol;
import com.service.FuncionalidadBean;
import com.service.RolBean;

import java.awt.BorderLayout;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class CrearRol {

	private JFrame frame;
	private JTextField textFieldNombre;
	private JTextArea textAreaDescripcion;
	private JList listFuncionalidades;
	
	private List<String> selectedNombresFuncionalidades = new ArrayList<>();

	
	
	
	private IAgro iagro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrearRol window = new CrearRol();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * 
	 * Hago visible la ventana de Login
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
	public CrearRol() {
		initialize();
	}
	
	/**
	 * 
	 * Constructor con la aplicacion de IAgro inyectada.
	 */
	public CrearRol(IAgro iagro) {
		this.iagro = iagro;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 579, 377);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JDesktopPane desktopPane = new JDesktopPane();
		frame.getContentPane().add(desktopPane, BorderLayout.CENTER);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(textFieldNombre.getText().isEmpty() || textAreaDescripcion.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "No tiene todos los campos","Error",JOptionPane.ERROR_MESSAGE);
				}
				else {
					Rol rol = new Rol();
					rol.setNombre(textFieldNombre.getText().toUpperCase());
					rol.setDescripcion(textAreaDescripcion.getText().toUpperCase());
					rol.setFuncionalidades(null);
					iagro.createRol(rol);
				
				}
			}
		});
		btnGuardar.setBounds(149, 295, 106, 37);
		desktopPane.add(btnGuardar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(315, 295, 89, 37);
		desktopPane.add(btnCancelar);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(131, 108, 124, 20);
		desktopPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 111, 89, 14);
		desktopPane.add(lblNombre);
		
		JLabel lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setBounds(10, 136, 89, 14);
		desktopPane.add(lblDescripcion);
		
		JTextArea textAreaDescripcion = new JTextArea();
		textAreaDescripcion.setBounds(131, 140, 124, 97);
		desktopPane.add(textAreaDescripcion);
		
		JLabel lblFuncionalidades = new JLabel("Funcionalidades:");
		lblFuncionalidades.setBounds(291, 108, 132, 14);
		desktopPane.add(lblFuncionalidades);
		
		JList listFuncionalidades = new JList();
		listFuncionalidades.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if(!e.getValueIsAdjusting()) {
					
					selectedNombresFuncionalidades = listFuncionalidades.getSelectedValuesList();

				}
					
			}
		});
		listFuncionalidades.setBounds(291, 135, 170, 148);
		desktopPane.add(listFuncionalidades);
	}
	private LinkedList<Funcionalidad> selectedFuncionalidades(List<String> listaNombresFuncionalidades){
    	LinkedList<Funcionalidad> funcionalidades = new LinkedList<>();
    	for(String nombreFuncionalidad: listaNombresFuncionalidades) {
    		//iagro.(nombreFuncionalidad);
    		//funcionalidades.add(funcionalidad);
    	}
    	return funcionalidades;
    }

	
}
