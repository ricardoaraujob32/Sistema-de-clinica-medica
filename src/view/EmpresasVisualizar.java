package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

import controller.ControladorMediatorImpl;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EmpresasVisualizar extends AbstractBoundaryVisualizar {

	public EmpresasVisualizar() {
		super();
		setTitle("Visualizar empresas");
		setBounds(100, 100, 550, 300);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		controlador = ControladorMediatorImpl.getInstancia();
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new EmpresasManter().setVisible(true);
			}
		});
		btnEditar.setBounds(435, 227, 89, 23);
		contentPane.add(btnEditar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 11, 514, 196);
		contentPane.add(scrollPane);
		
		table.setModel( controlador.getEmpresasController() );
	}

}
