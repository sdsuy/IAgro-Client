package com.presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JToolBar;

import com.application.IAgro;
import com.entities.Actividad;
import com.entities.Usuario;

import java.awt.BorderLayout;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CrearActividad implements IFrame<Actividad> {

	private JFrame frame;
	private IAgro iagro;
	private Long id;
	private JComboBox comboBoxFormulario;
	private JScrollPane scrollPane;
	private JButton btnGuardar;
	private JButton btnCancelar;

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
		
		JDesktopPane desktopPane = new JDesktopPane();
		frame.getContentPane().add(desktopPane, BorderLayout.CENTER);
		
		JLabel lblFormulario = new JLabel("Formulario:");
		lblFormulario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFormulario.setBounds(10, 97, 91, 14);
		desktopPane.add(lblFormulario);
		
		comboBoxFormulario = new JComboBox();
		comboBoxFormulario.setBounds(111, 95, 134, 22);
		desktopPane.add(comboBoxFormulario);
		
		JDesktopPane desktopPane_1 = new JDesktopPane();
		desktopPane_1.setBounds(10, 154, 513, 243);
		desktopPane.add(desktopPane_1);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 513, 243);
		desktopPane_1.add(scrollPane);
		
		btnGuardar = new JButton("");
		btnGuardar.setIcon(new ImageIcon(CrearActividad.class.getResource("/img/BotonGuardar (2).png")));
		btnGuardar.setBounds(69, 416, 137, 40);
		desktopPane.add(btnGuardar);
		
		btnCancelar = new JButton("");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		btnCancelar.setIcon(new ImageIcon(CrearActividad.class.getResource("/img/BotonCancelar.png")));
		btnCancelar.setBounds(321, 416, 137, 40);
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
