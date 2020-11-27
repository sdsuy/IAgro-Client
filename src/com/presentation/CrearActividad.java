package com.presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JToolBar;

import com.application.IAgro;
import com.entities.Actividad;
import com.entities.Formulario;
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
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class CrearActividad implements IFrame<Actividad> {

	private JFrame frame;
	private IAgro iagro;
	private Long id;
	private JComboBox comboBoxFormulario;
	private JButton btnGuardar;
	private JButton btnCancelar;
	private Formulario formulario;

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
		lblFormulario.setBounds(10, 97, 91, 14);
		desktopPane.add(lblFormulario);
	
		
		comboBoxFormulario = new JComboBox();
		comboBoxFormulario.setCursor(new Cursor(Cursor.HAND_CURSOR));
		comboBoxFormulario.setBounds(111, 95, 134, 22);
		desktopPane.add(comboBoxFormulario);
		
		List<Formulario> formularios = iagro.getFormulario();
		for (Formulario form : formularios) {
			comboBoxFormulario.addItem(form.getNombre());
		}
		
		btnGuardar = new JButton("");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnGuardar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnGuardar.setIcon(new ImageIcon(CrearActividad.class.getResource("/img/BotonGuardar (2).png")));
		btnGuardar.setBounds(69, 416, 137, 40);
		desktopPane.add(btnGuardar);
		
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
		btnCancelar.setBounds(260, 397, 147, 37);
		desktopPane.add(btnCancelar);
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
