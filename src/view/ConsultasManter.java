package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.border.EmptyBorder;

import model.Consulta;

public class ConsultasManter extends AbstractBoundaryManter<Consulta> {

	private JTextField txtCodigo;
	private JComboBox<String> cbxClinica;
	private JComboBox<String> cbxPaciente;
	private JComboBox<String> cbxMedico;
	private JComboBox<String> cbxEspecialidade;
	private JSpinner spinData;
	private JSpinner spinHorario;
	private JComboBox<String> cbxDuracao;
	private JComboBox<String> cbxTipo;
	private JTextArea txtAreaSintomas;
	private JTextArea txtAreaPossivelMolestia;
	private JTextArea txtAreaPrescricao;

	public ConsultasManter() {
		super();
		setTitle("Manter consultas");
		setBounds(100, 100, 1000, 613);
		
		mntmAlterar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		mntmSalvar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		mntmDeletar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		JLabel lblCodigo = new JLabel("Código:");
		lblCodigo.setBounds(10, 33, 46, 14);
		contentPane.add(lblCodigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(66, 30, 86, 20);
		contentPane.add(txtCodigo);
		
		JLabel lblClinicas = new JLabel("Clínica:");
		lblClinicas.setBounds(10, 71, 46, 14);
		contentPane.add(lblClinicas);
				
		cbxClinica = new JComboBox<>();
		cbxClinica.setBounds(66, 68, 168, 20);
		contentPane.add(cbxClinica);
		
		JLabel lblPaciente = new JLabel("Paciente:");
		lblPaciente.setBounds(244, 71, 46, 14);
		contentPane.add(lblPaciente);
		
		cbxPaciente = new JComboBox<>();
		cbxPaciente.setBounds(300, 68, 168, 20);
		contentPane.add(cbxPaciente);
		
		JLabel lblMedico = new JLabel("Médico:");
		lblMedico.setBounds(478, 71, 38, 14);
		contentPane.add(lblMedico);
		
		cbxMedico = new JComboBox<>();
		cbxMedico.setBounds(526, 68, 168, 20);
		contentPane.add(cbxMedico);
		
		JLabel lblEspecialidade = new JLabel("Especialidade:");
		lblEspecialidade.setBounds(704, 71, 74, 14);
		contentPane.add(lblEspecialidade);
		
		cbxEspecialidade = new JComboBox<>();
		cbxEspecialidade.setBounds(788, 68, 168, 20);
		contentPane.add(cbxEspecialidade);
		
		JLabel lblData = new JLabel("Data:");
		lblData.setBounds(10, 110, 46, 14);
		contentPane.add(lblData);
		
		spinData = new JSpinner();
		spinData.setModel(new SpinnerDateModel(new Date(), null, null, Calendar.HOUR_OF_DAY));
		JSpinner.DateEditor de1 = new JSpinner.DateEditor(spinData, "dd/MM/yyyy");
        spinData.setEditor(de1);
		spinData.setBounds(66, 107, 86, 20);
		contentPane.add(spinData);
		
		JLabel lblHorario = new JLabel("Horário:");
		lblHorario.setBounds(244, 110, 46, 14);
		contentPane.add(lblHorario);
		
		spinHorario = new JSpinner();
		spinHorario.setModel(new SpinnerDateModel(new Date(1528601807649L), null, null, Calendar.HOUR_OF_DAY));
		JSpinner.DateEditor de2 = new JSpinner.DateEditor(spinHorario, "hh:mm");
        spinHorario.setEditor(de2);
		spinHorario.setBounds(300, 107, 98, 20);
		contentPane.add(spinHorario);
		
		JLabel lblDuracao = new JLabel("Duração:");
		lblDuracao.setBounds(478, 110, 46, 14);
		contentPane.add(lblDuracao);
		
		cbxDuracao = new JComboBox<>();
		cbxDuracao.setModel(new DefaultComboBoxModel<String>(new String[] {"00:15", "00:30", "00:45", "01:00"}));
		cbxDuracao.setBounds(526, 107, 62, 20);
		contentPane.add(cbxDuracao);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(732, 110, 46, 14);
		contentPane.add(lblTipo);
		
		cbxTipo = new JComboBox<>();
		cbxTipo.setBounds(788, 107, 98, 20);
		contentPane.add(cbxTipo);
		
		JLabel lblSintomas = new JLabel("Síntomas:");
		lblSintomas.setBounds(385, 144, 62, 14);
		contentPane.add(lblSintomas);
		
		JLabel lblPossivelMolestia = new JLabel("Possível moléstia:");
		lblPossivelMolestia.setBounds(370, 265, 98, 14);
		contentPane.add(lblPossivelMolestia);
		
		JLabel lblPrescricao = new JLabel("Prescrição:");
		lblPrescricao.setBounds(385, 406, 62, 14);
		contentPane.add(lblPrescricao);
						
		btnNovo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		btnNovo.setBounds(10, 538, 150, 23);
		
		btnPrimeiro.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		btnPrimeiro.setBounds(210, 538, 150, 23);
		
		btnAnterior.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		btnAnterior.setBounds(415, 538, 150, 23);
		
		btnProximo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		btnProximo.setBounds(611, 538, 150, 23);
		
		btnUltimo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		btnUltimo.setBounds(806, 538, 150, 23);
		
		JScrollPane scrollSintomas = new JScrollPane();
		scrollSintomas.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollSintomas.setBounds(10, 169, 946, 74);
		contentPane.add(scrollSintomas);
		
		txtAreaSintomas = new JTextArea();
		scrollSintomas.setViewportView(txtAreaSintomas);
		
		JScrollPane scrollPossivelMolestia = new JScrollPane();
		scrollPossivelMolestia.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPossivelMolestia.setBounds(10, 290, 946, 74);
		contentPane.add(scrollPossivelMolestia);
		
		txtAreaPossivelMolestia = new JTextArea();
		scrollPossivelMolestia.setViewportView(txtAreaPossivelMolestia);
		
		JScrollPane scrollPrescricao = new JScrollPane();
		scrollPrescricao.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPrescricao.setBounds(10, 431, 946, 74);
		contentPane.add(scrollPrescricao);
		
		txtAreaPrescricao = new JTextArea();
		scrollPrescricao.setViewportView(txtAreaPrescricao);
	}
	
	@Override
	protected Consulta criarEntidade(boolean usarCodigo) {
		Consulta consulta = new Consulta();
		
		if (usarCodigo) {
			consulta.setCodigo( Integer.parseInt( txtCodigo.getText() ) );
		}
		
		consulta.add( (String) cbxClinica.getSelectedItem() );
		consulta.add( (String) cbxPaciente.getSelectedItem() );
		consulta.add( (String) cbxMedico.getSelectedItem() );
		consulta.add( (String) cbxEspecialidade.getSelectedItem() );
		consulta.add( (String) spinData.getValue() );
		consulta.add( (String) spinHorario.getValue() );
		consulta.add( (String) cbxDuracao.getSelectedItem() );
		consulta.add( (String) cbxTipo.getSelectedItem() );
		consulta.add( txtAreaSintomas.getText() );
		consulta.add( txtAreaPossivelMolestia.getText() );
		consulta.add( txtAreaPrescricao.getText() );
		
		return consulta;
	}

	@Override
	protected void exibirEntidade(Consulta consulta) {
		txtCodigo.setText( Integer.toString( consulta.getCodigo() ) );
		
	}
}
