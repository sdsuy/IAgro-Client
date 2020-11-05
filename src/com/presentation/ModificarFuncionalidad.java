package com.presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JToolBar;

import com.application.IAgro;
import com.entities.Funcionalidad;

import java.awt.BorderLayout;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;

public class ModificarFuncionalidad implements IFrame<Funcionalidad> {

	private JFrame frame;
	private JTextField textNombre;
	private JTextArea textArea;
	
	private IAgro iagro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModificarFuncionalidad window = new ModificarFuncionalidad();
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
	public ModificarFuncionalidad() {
		initialize();
	}
	
	/**
	 * 
	 * Constructor con la aplicacion de IAgro inyectada.
	 */
	public ModificarFuncionalidad(IAgro iagro) {
		this.iagro = iagro;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 371, 377);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(173, 216, 230));
		frame.getContentPane().add(desktopPane, BorderLayout.CENTER);
		
		textNombre = new JTextField();
		textNombre.setBounds(10, 133, 113, 31);
		desktopPane.add(textNombre);
		textNombre.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(37, 111, 65, 14);
		desktopPane.add(lblNombre);
		
		JLabel lblNewLabel = new JLabel("Descripcion:");
		lblNewLabel.setBounds(235, 111, 83, 14);
		desktopPane.add(lblNewLabel);
		
		textArea = new JTextArea();
		textArea.setBounds(191, 136, 154, 120);
		desktopPane.add(textArea);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(textNombre.getText().isEmpty() || textArea.getText().isEmpty()) {
	
					JOptionPane.showMessageDialog(null, "No tiene todos lo campos","Error",JOptionPane.ERROR_MESSAGE);
				}
				
				else {
					Funcionalidad funcionalidad = new Funcionalidad();
					funcionalidad.setNombre(textNombre.getText().toUpperCase());
					funcionalidad.setDescripcion(textArea.getText().toUpperCase());
					boolean result = iagro.create(funcionalidad);
					if(result) {
						JOptionPane.showMessageDialog(null, "Se creo con exito la funcionalidad","Exito",JOptionPane.DEFAULT_OPTION);
						limpiar();
					}
					else {
						JOptionPane.showMessageDialog(null,"No se pudo crear la funcionalidad","Error", JOptionPane.ERROR_MESSAGE);
					}
					
				}
			}
		});
		btnModificar.setBounds(110, 290, 106, 37);
		desktopPane.add(btnModificar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiar();
			}
		});
		btnCancelar.setBounds(228, 290, 106, 37);
		desktopPane.add(btnCancelar);
		
		JLabel lblTitulo = new JLabel("Modificar Funcionalidades");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 29));
		lblTitulo.setBounds(0, 11, 355, 71);
		desktopPane.add(lblTitulo);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(ModificarFuncionalidad.class.getResource("/img/IAgro icon.png")));
		lblFondo.setBounds(0, 0, 355, 338);
		desktopPane.add(lblFondo);
	}
	
	public void limpiar() {
		textNombre.setText("");
		textArea.setText("");
	}

	@Override
	public void setFields(Funcionalidad o) {
		// TODO Auto-generated method stub
		
	}
}
