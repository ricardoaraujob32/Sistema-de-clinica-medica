package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import controller.EspecialidadesController;

public class EspecialidadesVisualizar extends AbstractBoundaryVisualizar {

	/**
	 * Create the frame.
	 */
	public EspecialidadesVisualizar() {
		setTitle("Visualizar especialidades");
		setBounds(100, 100, 450, 232);
		
		scrollPane.setBounds(10, 11, 414, 124);
		
		controlador = new EspecialidadesController();

		table.setModel( (TableModel) controlador);
		scrollPane.setViewportView(table);
		
		btnEditar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new EspecialidadesManter().setVisible(true);
			}
		});
		btnEditar.setBounds(335, 159, 89, 23);
	}

}
