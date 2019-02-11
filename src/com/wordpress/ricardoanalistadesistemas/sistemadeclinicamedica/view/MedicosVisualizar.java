package com.wordpress.ricardoanalistadesistemas.sistemadeclinicamedica.view;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;

import com.wordpress.ricardoanalistadesistemas.sistemadeclinicamedica.controller.ControladorMediatorImpl;
import com.wordpress.ricardoanalistadesistemas.sistemadeclinicamedica.controller.MedicosController;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MedicosVisualizar extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private ControladorMediatorImpl controladorMediatorImpl;

	public MedicosVisualizar() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				
			}
		});
		setResizable(false);
		setTitle("Visualizar m�dicos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 950, 634);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		controladorMediatorImpl = ControladorMediatorImpl.getInstancia();
		
		table = new JTable( controladorMediatorImpl.getMedicosController() );
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.getColumnModel().getColumn(0).setPreferredWidth(52);
		table.getColumnModel().getColumn(0).setMinWidth(40);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setMinWidth(100);
		table.getColumnModel().getColumn(2).setPreferredWidth(120);
		table.getColumnModel().getColumn(2).setMinWidth(60);
		table.getColumnModel().getColumn(3).setPreferredWidth(50);
		table.getColumnModel().getColumn(3).setMinWidth(50);
		table.getColumnModel().getColumn(4).setPreferredWidth(50);
		table.getColumnModel().getColumn(4).setMinWidth(50);
		table.getColumnModel().getColumn(5).setPreferredWidth(50);
		table.getColumnModel().getColumn(5).setMinWidth(50);
		table.getColumnModel().getColumn(6).setPreferredWidth(82);
		table.getColumnModel().getColumn(6).setMinWidth(50);
		table.getColumnModel().getColumn(7).setPreferredWidth(72);
		table.getColumnModel().getColumn(8).setPreferredWidth(64);
		table.getColumnModel().getColumn(9).setPreferredWidth(52);
		table.getColumnModel().getColumn(10).setPreferredWidth(47);
		table.setBounds(10, 235, 1800, 223);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(0, 0, 934, 536);
		contentPane.add(scrollPane);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setViewportView(table);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MedicosManter().setVisible(true);
			}
		});
		btnEditar.setBounds(835, 561, 89, 23);
		contentPane.add(btnEditar);
	}
}
