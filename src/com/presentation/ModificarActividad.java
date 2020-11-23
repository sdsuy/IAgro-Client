package com.presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JToolBar;

import com.application.IAgro;
import com.entities.Actividad;

import java.awt.BorderLayout;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ModificarActividad implements IFrame<Actividad>{

	private JFrame frame;
	private Long id;
	private IAgro iagro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModificarActividad window = new ModificarActividad();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
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
	public ModificarActividad() {
		initialize();
	}
	
	/**
	 * Constructor con la aplicacion de IAgro inyectada.
	 */
	public ModificarActividad(IAgro iagro) {
		id = 0L;
		this.iagro = iagro;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 549, 447);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JDesktopPane desktopPane = new JDesktopPane();
		frame.getContentPane().add(desktopPane, BorderLayout.CENTER);
		
		JLabel lblNewLabel_1 = new JLabel("Aqui se mostrara todas las casillas del formulario asociado a la actividad de campo completadas con la info ingresada");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNewLabel_1.setBounds(10, 34, 494, 228);
		desktopPane.add(lblNewLabel_1);
		
		JButton btnGuardar = new JButton("");
		btnGuardar.setIcon(new ImageIcon(ModificarActividad.class.getResource("/img/BotonGuardar (2).png")));
		btnGuardar.setBounds(25, 336, 137, 38);
		desktopPane.add(btnGuardar);
		
		JButton btnCancelar = new JButton("");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				iagro.show(ListarActividades.class);
				frame.dispose();
			}
		});
		btnCancelar.setIcon(new ImageIcon(ModificarActividad.class.getResource("/img/BotonCancelar.png")));
		btnCancelar.setBounds(343, 336, 137, 38);
		desktopPane.add(btnCancelar);
	}

	

	@Override
	public void setFields(Actividad o) {
		// TODO Auto-generated method stub
		
	}
}
