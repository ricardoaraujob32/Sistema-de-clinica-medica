package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.ControladorMediatorImpl;
import controller.EstadosComboBoxModel;
import model.Clinica;
import model.Medico;

public class ClinicasManter extends AbstractBoundaryManter<Clinica> {

	private JTextField txtCodigo;
	private JTextField txtCidade;
	private JTextField txtBairro;
	private JTextField txtCep;
	private JTextField txtLogradouro;
	private JTextField txtNumero;
	private JComboBox<String> cbxEstado;

	public ClinicasManter() {
		setTitle("Manter clínicas");
		setBounds(100, 100, 534, 234);
				
		mntmAlterar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Clinica clinica = criarEntidade(true);
				
				ControladorMediatorImpl.getInstancia().alterarClinica(clinica);
			}
		});
		
		mntmSalvar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Clinica clinica = criarEntidade(false);
				
				ControladorMediatorImpl.getInstancia().cadastrarClinica(clinica);
			}
		});
		
		mntmDeletar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Clinica clinica = criarEntidade(true);
				
				ControladorMediatorImpl.getInstancia().deletarClinica(clinica);
			}
		});
				
		JLabel lblCodigo = new JLabel("Código:");
		lblCodigo.setBounds(10, 11, 46, 14);
		contentPane.add(lblCodigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(52, 8, 64, 20);
		contentPane.add(txtCodigo);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(141, 11, 46, 14);
		contentPane.add(lblEstado);
		
		cbxEstado = new JComboBox<>();
		cbxEstado.setModel( new EstadosComboBoxModel() );
		cbxEstado.setBounds(197, 8, 46, 20);
		contentPane.add(cbxEstado);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(253, 11, 46, 14);
		contentPane.add(lblCidade);
		
		txtCidade = new JTextField();
		txtCidade.setBounds(300, 8, 151, 20);
		contentPane.add(txtCidade);
		txtCidade.setColumns(10);
		
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(10, 48, 46, 14);
		contentPane.add(lblBairro);
		
		txtBairro = new JTextField();
		txtBairro.setBounds(52, 45, 124, 20);
		contentPane.add(txtBairro);
		txtBairro.setColumns(10);
		
		JLabel lblCep = new JLabel("CEP:");
		lblCep.setBounds(197, 48, 32, 14);
		contentPane.add(lblCep);
		
		txtCep = new JTextField();
		txtCep.setBounds(239, 45, 112, 20);
		contentPane.add(txtCep);
		txtCep.setColumns(10);
		
		JLabel lblLogradouro = new JLabel("Logradouro:");
		lblLogradouro.setBounds(10, 89, 64, 14);
		contentPane.add(lblLogradouro);
		
		txtLogradouro = new JTextField();
		txtLogradouro.setBounds(84, 86, 236, 20);
		contentPane.add(txtLogradouro);
		txtLogradouro.setColumns(10);
		
		JLabel lblNumero = new JLabel("Número:");
		lblNumero.setBounds(366, 89, 46, 14);
		contentPane.add(lblNumero);
		
		txtNumero = new JTextField();
		txtNumero.setBounds(422, 86, 86, 20);
		contentPane.add(txtNumero);
		txtNumero.setColumns(10);
		
		btnNovo.setBounds(10, 131, 89, 23);
		
		btnPrimeiro.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Clinica primeiro = listaEntidades.peekFirst();
				
				exibirEntidade(primeiro);
			}
		});
		btnPrimeiro.setBounds(116, 131, 89, 23);
		
		btnAnterior.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ListIterator<Clinica> iterator = listaEntidades.listIterator();
				Clinica anterior;
				
				if ( iterator.hasPrevious() ) {
					anterior = iterator.previous();
					exibirEntidade(anterior);
				}
			}
		});
		btnAnterior.setBounds(215, 131, 89, 23);
		
		btnProximo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ListIterator<Clinica> iterator = listaEntidades.listIterator();
				Clinica proximo;
				
				if ( iterator.hasNext() ) {
					proximo = iterator.next();
					exibirEntidade(proximo);
				}
			}
		});
		btnProximo.setBounds(315, 131, 89, 23);
		
		btnUltimo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Clinica ultimo = listaEntidades.peekLast();
				
				exibirEntidade(ultimo);
			}
		});
		btnUltimo.setBounds(419, 131, 89, 23);
	}
		
	@Override
	public Clinica criarEntidade(boolean usarCodigo) {
		Clinica clinica = new Clinica();
		
		if (usarCodigo) {
			clinica.setCodigo( Integer.parseInt( txtCodigo.getText() ) );
		}
		
		clinica.getEndereco().setEstado( (String) cbxEstado.getSelectedItem() );
		clinica.getEndereco().setCidade( txtCidade.getText() );
		clinica.getEndereco().setBairro( txtBairro.getText() );
		clinica.getEndereco().setCep( txtCep.getText() );
		clinica.getEndereco().setLogradouro( txtLogradouro.getText() );
		clinica.getEndereco().setNumero( txtNumero.getText() );
		
		return clinica;
	}

	@Override
	public void exibirEntidade(Clinica clinica) {
		if (clinica != null) {
			txtCodigo.setText( Integer.toString( clinica.getCodigo() ) );
			cbxEstado.setSelectedItem( clinica.getEndereco().getEstado() );
			txtCidade.setText( clinica.getEndereco().getCidade() );
			txtBairro.setText( clinica.getEndereco().getBairro() );
			txtCep.setText( clinica.getEndereco().getCep() );
			txtLogradouro.setText( clinica.getEndereco().getLogradouro() );
			txtNumero.setText( clinica.getEndereco().getNumero() );
		} else {
			txtCodigo.setText("");
			cbxEstado.setSelectedIndex(0);
			txtCidade.setText("");
			txtBairro.setText("");
			txtCep.setText("");
			txtLogradouro.setText("");
			txtNumero.setText("");
		}
	}
}
