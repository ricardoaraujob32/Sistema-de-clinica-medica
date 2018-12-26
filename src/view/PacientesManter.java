package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.border.EmptyBorder;

import controller.ControladorMediatorImpl;
import controller.EstadosComboBoxModel;
import controller.PacientesController;
import model.Paciente;

public class PacientesManter extends AbstractBoundaryManter<Paciente> {

	private JTextField txtNome;
	private JTextField txtCodigo;
	private JSpinner spinDataNascimento;
	private JComboBox<String> cbxSexo;
	private JComboBox<String> cbxEmpresa;
	private JTextField txtRg;
	private JTextField txtCpf;
	private JComboBox<String> cbxEstado;
	private JTextField txtCidade;
	private JTextField txtBairro;
	private JTextField txtCep;
	private JTextField txtLogradouro;
	private JTextField txtNumero;
	private JTextField txtTelefone;
	private JTextField txtCelular;
	private JTextField txtEmail;

	public PacientesManter() {
		super();
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				controlador = new PacientesController();
				
			}
		});
		setTitle("Manter pacientes");
		setBounds(100, 100, 700, 408);
									
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 23, 46, 14);
		contentPane.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(57, 20, 338, 20);
		contentPane.add(txtNome);
		
		JLabel lblCodigo = new JLabel("Código:");
		lblCodigo.setBounds(444, 23, 46, 14);
		contentPane.add(lblCodigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(500, 20, 86, 20);
		contentPane.add(txtCodigo);
		
		JLabel lblDataNascimento = new JLabel("Data de nascimento:");
		lblDataNascimento.setBounds(10, 58, 109, 14);
		contentPane.add(lblDataNascimento);
		
		spinDataNascimento = new JSpinner();
		spinDataNascimento.setModel(new SpinnerDateModel(new Date(), null, null, Calendar.HOUR_OF_DAY));
		JSpinner.DateEditor de_spinDataNascimento = new JSpinner.DateEditor(spinDataNascimento, "dd/MM/yyyy");
        spinDataNascimento.setEditor(de_spinDataNascimento);
		spinDataNascimento.setBounds(129, 52, 86, 20);
		contentPane.add(spinDataNascimento);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(242, 58, 40, 14);
		contentPane.add(lblSexo);
		
		cbxSexo = new JComboBox<>();
		cbxSexo.setModel( new DefaultComboBoxModel<String>( new String[] {"Masculino", "Feminino", "Outro"} ) );
		cbxSexo.setBounds(280, 55, 86, 20);
		contentPane.add(cbxSexo);
		
		JLabel lblRg = new JLabel("RG:");
		lblRg.setBounds(10, 93, 46, 14);
		contentPane.add(lblRg);
		
		txtRg = new JTextField();
		txtRg.setBounds(57, 90, 158, 20);
		contentPane.add(txtRg);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(242, 93, 33, 14);
		contentPane.add(lblCpf);
		
		txtCpf = new JTextField();
		txtCpf.setBounds(280, 87, 176, 20);
		contentPane.add(txtCpf);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(478, 93, 46, 14);
		contentPane.add(lblEstado);
		
		cbxEstado = new JComboBox<>();
		cbxEstado.setModel( new EstadosComboBoxModel() );
		cbxEstado.setBounds(534, 90, 52, 20);
		contentPane.add(cbxEstado);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(10, 135, 46, 14);
		contentPane.add(lblCidade);
		
		txtCidade = new JTextField();
		txtCidade.setBounds(57, 132, 193, 20);
		contentPane.add(txtCidade);
		
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(271, 135, 46, 14);
		contentPane.add(lblBairro);
		
		txtBairro = new JTextField();
		txtBairro.setBounds(309, 132, 351, 20);
		contentPane.add(txtBairro);
		
		JLabel lblCep = new JLabel("CEP:");
		lblCep.setBounds(10, 177, 46, 14);
		contentPane.add(lblCep);
		
		txtCep = new JTextField();
		txtCep.setBounds(44, 174, 128, 20);
		contentPane.add(txtCep);
		
		JLabel lblLogradouro = new JLabel("Logradouro:");
		lblLogradouro.setBounds(186, 177, 64, 14);
		contentPane.add(lblLogradouro);
		
		txtLogradouro = new JTextField();
		txtLogradouro.setBounds(259, 174, 401, 20);
		contentPane.add(txtLogradouro);
		
		JLabel lblNumero = new JLabel("Número:");
		lblNumero.setBounds(10, 220, 46, 14);
		contentPane.add(lblNumero);
		
		txtNumero = new JTextField();
		txtNumero.setBounds(57, 217, 94, 20);
		contentPane.add(txtNumero);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(185, 220, 46, 14);
		contentPane.add(lblTelefone);
		
		txtTelefone = new JTextField();
		txtTelefone.setBounds(241, 217, 181, 20);
		contentPane.add(txtTelefone);
		
		JLabel lblCelular = new JLabel("Celular:");
		lblCelular.setBounds(444, 220, 46, 14);
		contentPane.add(lblCelular);
		
		txtCelular = new JTextField();
		txtCelular.setBounds(491, 217, 169, 20);
		contentPane.add(txtCelular);
		
		JLabel lblEmail = new JLabel("E-Mail:");
		lblEmail.setBounds(10, 258, 40, 14);
		contentPane.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(57, 255, 375, 20);
		contentPane.add(txtEmail);
		
		btnNovo.setBounds(10, 307, 89, 23);
		btnPrimeiro.setBounds(126, 307, 89, 23);
		btnAnterior.setBounds(278, 307, 89, 23);
		btnProximo.setBounds(432, 307, 89, 23);
		btnUltimo.setBounds(571, 307, 89, 23);
				
		JLabel lblEmpresa = new JLabel("Empresa:");
		lblEmpresa.setBounds(394, 58, 46, 14);
		contentPane.add(lblEmpresa);
		
		cbxEmpresa = new JComboBox<>();
		cbxEmpresa.setBounds(444, 55, 142, 20);
		contentPane.add(cbxEmpresa);
	}
		
	@Override
	protected Paciente criarEntidade(boolean usarCodigo) {
		Paciente paciente = new Paciente(); 
		
		paciente.setNome( txtNome.getText() );
		
		if (usarCodigo) {
			paciente.setCodigo( Integer.parseInt( txtCodigo.getText() ) );
		}
		
		paciente.setDataNascimento( (LocalDate) spinDataNascimento.getValue() );
		paciente.setSexo( (String) cbxSexo.getSelectedItem() );
		
		
		paciente.setRg( txtRg.getText() );
		
		
		return paciente;
	}

	@Override
	protected void exibirEntidade(Paciente paciente) {
		if (paciente != null) {
			txtNome.setText( paciente.getNome() );
			txtCodigo.setText( Integer.toString( paciente.getCodigo() ) );
			spinDataNascimento.setValue( new Date( paciente.getDataNascimento().toEpochDay() ) );			
			cbxSexo.setSelectedItem( paciente.getSexo() );
			
			
			txtRg.setText( paciente.getRg() );
			txtCpf.setText( paciente.getCpf() );
			cbxEstado.setSelectedItem( paciente.getEndereco().getEstado() );
			txtCidade.setText( paciente.getEndereco().getCidade() );
			txtBairro.setText( paciente.getEndereco().getBairro() );
			txtCep.setText( paciente.getEndereco().getCep() );
			txtLogradouro.setText( paciente.getEndereco().getLogradouro() );
			txtNumero.setText( paciente.getEndereco().getNumero() );
			txtTelefone.setText( paciente.getTelefone() );
			txtCelular.setText( paciente.getCelular() );
			txtEmail.setText( paciente.getEmail() );
		} else {
			txtNome.setText("");
			txtCodigo.setText("");
			spinDataNascimento.setValue( new Date() );
			cbxSexo.setSelectedIndex(0);
			cbxEmpresa.setSelectedIndex(0);
			txtRg.setText("");
			txtCpf.setText("");
			cbxEstado.setSelectedIndex(0);
			txtCidade.setText("");
			txtBairro.setText("");
			txtCep.setText("");
			txtLogradouro.setText("");
			txtNumero.setText("");
			txtTelefone.setText("");
			txtCelular.setText("");
			txtEmail.setText("");
		}
	}
}
