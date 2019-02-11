package com.wordpress.ricardoanalistadesistemas.sistemadeclinicamedica.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.swing.table.DefaultTableModel;

public class ConsultasVisualizar extends AbstractBoundaryVisualizar {

	/**
	 * Create the frame.
	 */
	public ConsultasVisualizar() {
		super();
		setTitle("Ver hist�rico do paciente");
		setBounds(100, 100, 600, 423);
		
		scrollPane.setBounds(15, 16, 564, 320);
				
		btnEditar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new ConsultasManter().setVisible(true);
			}
		});
		btnEditar.setBounds(508, 347, 61, 23);
		
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Paciente", "Especialidade", "Data", "Hor�rio", "M�dico", "Cl�nica"
			}
		) {
			Class<?>[] columnTypes = new Class[] {
				String.class, String.class, LocalDate.class, LocalTime.class, String.class, String.class
			};
			public Class<?> getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});		
	}

}
