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
import javax.swing.DefaultListModel;
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
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

public class ModificarRol implements IFrame {

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
					ModificarRol window = new ModificarRol();
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
	public ModificarRol() {
		initialize();
	}
	
	/**
	 * 
	 * Constructor con la aplicacion de IAgro inyectada.
	 */
	public ModificarRol(IAgro iagro) {
		this.iagro = iagro;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 487, 377);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(173, 216, 230));
		frame.getContentPane().add(desktopPane, BorderLayout.CENTER);
		
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
		
		textAreaDescripcion = new JTextArea();
		textAreaDescripcion.setBounds(131, 140, 124, 97);
		desktopPane.add(textAreaDescripcion);
		
		JLabel lblFuncionalidades = new JLabel("Funcionalidades:");
		lblFuncionalidades.setBounds(291, 108, 132, 14);
		desktopPane.add(lblFuncionalidades);
		
		DefaultListModel<String> listModel = new DefaultListModel<>();
		for(Funcionalidad funcionalidad: iagro.getFuncionalidades()) {
			listModel.addElement(funcionalidad.getNombre());
		}
		
		JList listFuncionalidades = new JList(listModel);
		listFuncionalidades.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if(!e.getValueIsAdjusting()) {
					selectedNombresFuncionalidades = listFuncionalidades.getSelectedValuesList();
				}					
			}
		});
		listFuncionalidades.setBounds(291, 135, 170, 148);
		desktopPane.add(listFuncionalidades);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(textFieldNombre.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "No tiene todos los campos","Error",JOptionPane.ERROR_MESSAGE);
				}
				else {
					Rol rol = new Rol();
					rol.setNombre(textFieldNombre.getText().toUpperCase());
					rol.setDescripcion(textAreaDescripcion.getText().toUpperCase());
					rol.setFuncionalidades(selectedFuncionalidades(selectedNombresFuncionalidades));
					boolean result = iagro.create(rol);
					if(result) {
						JOptionPane.showConfirmDialog(null,"Creado rol con exito","Exito", JOptionPane.DEFAULT_OPTION);
						limpiarRol();
					}
					else {
						JOptionPane.showMessageDialog(null, "No se pudo crear el Rol","Error", JOptionPane.ERROR_MESSAGE);
					}
				
				}
			}
		});
		btnModificar.setBounds(149, 295, 106, 37);
		desktopPane.add(btnModificar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarRol();
			}
		});
		btnCancelar.setBounds(315, 295, 89, 37);
		desktopPane.add(btnCancelar);
		
		JLabel lblTitulo = new JLabel("Modificar Roles");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 29));
		lblTitulo.setBounds(10, 11, 451, 65);
		desktopPane.add(lblTitulo);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(ModificarRol.class.getResource("/img/IAgro icon.png")));
		lblFondo.setBounds(0, 0, 471, 338);
		desktopPane.add(lblFondo);
	}
	
	private List<Funcionalidad> selectedFuncionalidades(List<String> listaNombresFuncionalidades){
    	List<Funcionalidad> funcionalidades = new ArrayList<>();
    	for(String nombreFuncionalidad: listaNombresFuncionalidades) funcionalidades.add(iagro.readFuncionalidad(nombreFuncionalidad));
    	return funcionalidades;
    }
	
	public void limpiarRol() {
		textFieldNombre.setText("");
		textAreaDescripcion.setText("");
		listFuncionalidades.setToolTipText("");
	}

	
}
