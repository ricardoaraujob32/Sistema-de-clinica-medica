package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ControladorMediatorImpl;
import model.AlocacaoMedicos;
import model.Medico;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AlocacaoMedicosManter extends JFrame {

	private JPanel contentPane;
	private JComboBox cbxClinica;
	private JComboBox cbxEspecialidade;
	private JComboBox cbxMedico;
	private JSpinner spinHorarioInicio;
	private JSpinner spinHorarioFim;
	private JButton btnVerEscalaMedico;

	public AlocacaoMedicosManter() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
			}
		});
		setTitle("Manter aloca��o de m�dicos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 618, 192);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnOpcoes = new JMenu("Op��es");
		menuBar.add(mnOpcoes);
		
		JMenuItem mntmAlterar = new JMenuItem("Alterar");
		mntmAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				List<String> lista = criarLista(true);

				ControladorMediatorImpl.getInstancia().alterarAlocacaoMedicos(lista);
			}
		});
		mnOpcoes.add(mntmAlterar);
		
		JMenuItem mntmSalvar = new JMenuItem("Salvar");
		mntmSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<String> lista = criarLista(false);
				
				ControladorMediatorImpl.getInstancia().cadastrarAlocacaoMedicos(lista);
			}
		});
		mnOpcoes.add(mntmSalvar);
		
		JMenuItem mntmDeletar = new JMenuItem("Deletar");
		mntmDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				codigo = Integer.parseInt( txtCodigo.getText() );
//				new Controlador().deletarPaciente(codigo);
			}
		});
		mnOpcoes.add(mntmDeletar);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblClnica = new JLabel("Cl�nica:");
		lblClnica.setBounds(10, 11, 46, 14);
		contentPane.add(lblClnica);
		
		cbxClinica = new JComboBox<>();
		cbxClinica.setBounds(66, 8, 120, 20);
		contentPane.add(cbxClinica);
		
		JLabel lblEspecialidade = new JLabel("Especialidade:");
		lblEspecialidade.setBounds(202, 11, 74, 14);
		contentPane.add(lblEspecialidade);
		
		cbxEspecialidade = new JComboBox<>();
		cbxEspecialidade.setBounds(286, 8, 120, 20);
		contentPane.add(cbxEspecialidade);
		
		JLabel lblMedico = new JLabel("M�dico:");
		lblMedico.setBounds(416, 11, 46, 14);
		contentPane.add(lblMedico);
		
		cbxMedico = new JComboBox<>();
		cbxMedico.setBounds(472, 8, 120, 20);
		contentPane.add(cbxMedico);
		
		JLabel lblHorarioInicio = new JLabel("Hor�rio (In�cio):");
		lblHorarioInicio.setBounds(10, 51, 83, 14);
		contentPane.add(lblHorarioInicio);
		
		spinHorarioInicio = new JSpinner();
		spinHorarioInicio.setBounds(98, 48, 93, 20);
		contentPane.add(spinHorarioInicio);
		
		JLabel lblHorarioFim = new JLabel("Hor�rio (Fim):");
		lblHorarioFim.setBounds(255, 51, 74, 14);
		contentPane.add(lblHorarioFim);
		
		spinHorarioFim = new JSpinner();
		spinHorarioFim.setBounds(339, 48, 90, 20);
		contentPane.add(spinHorarioFim);
		
		btnVerEscalaMedico = new JButton("Ver escala do m�dico");
		btnVerEscalaMedico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnVerEscalaMedico.setBounds(454, 98, 138, 23);
		contentPane.add(btnVerEscalaMedico);
	}
	
	private List<String> criarLista(boolean alterar) {
		List<String> lista = new ArrayList<>();
		
		lista.add( (String) cbxClinica.getSelectedItem() );
		lista.add( (String) cbxEspecialidade.getSelectedItem() );
		lista.add( (String) cbxMedico.getSelectedItem() );
		lista.add( (String) spinHorarioInicio.getValue() );
		lista.add( (String) spinHorarioFim.getValue() );
		
		return lista;
	}
	
	private void exibirEntidade(AlocacaoMedicos alocacaoMedicos) {
		if (alocacaoMedicos != null) {
			
			
			
		} else {
			cbxClinica.setSelectedIndex(0);
			cbxEspecialidade.setSelectedIndex(0);
			cbxMedico.setSelectedIndex(0);
			spinHorarioInicio.setValue( new Date() );
			spinHorarioFim.setValue( new Date() );
		}
	}
}
