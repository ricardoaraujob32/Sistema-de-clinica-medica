package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controller.ControladorMediatorImpl;

public class JanelaInicial extends JFrame {
	
	private JPanel contentPane;

	public JanelaInicial() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
//				Controlador.getInstancia().fecharConexao();
			}
		});
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 434, 21);
		contentPane.add(menuBar);
		
		JMenu mnVer = new JMenu("Ver");
		menuBar.add(mnVer);
		
		JMenuItem mntmClinicas = new JMenuItem("Clínicas");
		mntmClinicas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ClinicasVisualizar().setVisible(true);
			}
		});
		mnVer.add(mntmClinicas);
		
		JMenuItem mntmConsultas = new JMenuItem("Consultas");
		mntmConsultas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ConveniosVisualizar().setVisible(true);
			}
		});
		mnVer.add(mntmConsultas);
		
		JMenuItem mntmConvenios = new JMenuItem("Convênios");
		mntmConvenios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ConveniosVisualizar().setVisible(true);
			}
		});
		mnVer.add(mntmConvenios);
		
		JMenuItem mntmEmpresas = new JMenuItem("Empresas");
		mntmEmpresas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new EmpresasVisualizar().setVisible(true);
			}
		});
		mnVer.add(mntmEmpresas);
		
		JMenuItem mntmEspecialidades = new JMenuItem("Especialidades");
		mntmEspecialidades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new EspecialidadesVisualizar().setVisible(true);
			}
		});
		mnVer.add(mntmEspecialidades);
		
		JMenuItem mntmMedicos = new JMenuItem("Médicos");
		mntmMedicos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MedicosVisualizar().setVisible(true);
			}
		});
		mnVer.add(mntmMedicos);
		
		JMenuItem mntmPacientes = new JMenuItem("Pacientes");
		mntmPacientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new PacientesVisualizar().setVisible(true);
			}
		});
		mnVer.add(mntmPacientes);
		
		JLabel lblNewLabel = new JLabel("Bem-vindo ao sistema de clínica médica");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(103, 119, 214, 36);
		contentPane.add(lblNewLabel);
	}

}
