package com.presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JDesktopPane;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;

import com.application.IAgro;
import com.entities.Actividad;
import com.entities.Usuario;

import java.awt.Component;
import java.awt.Cursor;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListarActividades implements IFrame<Actividad>{

	private JFrame frame;
	private IAgro iagro;
	private Long id;
	private JScrollPane scrollPane;
	private JButton btnModificar;
	private JButton btnVolver;
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
		frame.setBounds(100, 100, 668, 446);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JDesktopPane desktopPane = new JDesktopPane();
		frame.getContentPane().add(desktopPane, BorderLayout.CENTER);
		
		scrollPane = new JScrollPane((Component) null);
		scrollPane.setCursor(new Cursor(Cursor.HAND_CURSOR));
		scrollPane.setBounds(10, 116, 633, 175);
		desktopPane.add(scrollPane);
		
		btnModificar = new JButton("");
		btnModificar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				iagro.show(ModificarActividad.class);
				frame.dispose();
			}
		});
		btnModificar.setIcon(new ImageIcon(ListarActividades.class.getResource("/img/BotonModificarSeleccionada.png")));
		btnModificar.setBounds(204, 320, 229, 42);
		desktopPane.add(btnModificar);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(ListarActividades.class.getResource("/img/ActividadesDeCampo.png")));
		lblFondo.setBounds(91, 0, 486, 414);
		desktopPane.add(lblFondo);
		
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
