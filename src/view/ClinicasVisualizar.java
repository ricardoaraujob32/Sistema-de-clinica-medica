package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ClinicasVisualizar extends AbstractBoundaryVisualizar {

	public ClinicasVisualizar() {
		super();
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				
			}
		});
		setResizable(false);
		setTitle("Visualizar clínicas");
		setBounds(100, 100, 452, 225);
		
		scrollPane.setBounds(10, 11, 416, 140);		
		table.setModel( controlador.getClinicasController() );
		
		btnEditar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new ClinicasManter().setVisible(true);
			}
		});
		btnEditar.setBounds(337, 162, 89, 23);
	}
}