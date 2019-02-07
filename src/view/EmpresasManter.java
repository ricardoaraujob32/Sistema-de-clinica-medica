package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ListIterator;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.ControladorMediatorImpl;
import model.Empresa;

public class EmpresasManter extends AbstractBoundaryManter<Empresa> {

	private JTextField txtCodigo;
	private JTextField txtNomeFantasia;
	private JTextField txtCnpj;
	private JTextField txtContato;
	private JTextField txtRazaoSocial;
	private JTextField txtTelefone;
	private JTextField txtSite;
	private JComboBox<String> cbxConvenio;

	public EmpresasManter() {
		setTitle("Manter Empresa");
		setBounds(100, 100, 599, 438);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(93, 72, 86, 20);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		JLabel lblCodigo = new JLabel("C�digo:");
		lblCodigo.setBounds(26, 75, 46, 14);
		contentPane.add(lblCodigo);
		
		JLabel lblNomeFantasia = new JLabel("Nome fantasia:");
		lblNomeFantasia.setBounds(10, 140, 73, 14);
		contentPane.add(lblNomeFantasia);
		
		txtNomeFantasia = new JTextField();
		txtNomeFantasia.setColumns(10);
		txtNomeFantasia.setBounds(93, 137, 86, 20);
		contentPane.add(txtNomeFantasia);
		
		JLabel lblCnpj = new JLabel("CNPJ:");
		lblCnpj.setBounds(48, 211, 46, 14);
		contentPane.add(lblCnpj);
		
		txtCnpj = new JTextField();
		txtCnpj.setColumns(10);
		txtCnpj.setBounds(93, 208, 86, 20);
		contentPane.add(txtCnpj);
		
		JLabel lblContato = new JLabel("Contato:");
		lblContato.setBounds(37, 283, 46, 14);
		contentPane.add(lblContato);
		
		txtContato = new JTextField();
		txtContato.setColumns(10);
		txtContato.setBounds(93, 280, 86, 20);
		contentPane.add(txtContato);
		
		JLabel lblConvenio = new JLabel("Conv�nio:");
		lblConvenio.setBounds(282, 75, 52, 14);
		contentPane.add(lblConvenio);
		
		JLabel lblRazaoSocial = new JLabel("Raz�o social:");
		lblRazaoSocial.setBounds(271, 140, 63, 14);
		contentPane.add(lblRazaoSocial);
		
		txtRazaoSocial = new JTextField();
		txtRazaoSocial.setColumns(10);
		txtRazaoSocial.setBounds(349, 137, 99, 20);
		contentPane.add(txtRazaoSocial);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(288, 211, 46, 14);
		contentPane.add(lblTelefone);
		
		txtTelefone = new JTextField();
		txtTelefone.setColumns(10);
		txtTelefone.setBounds(349, 208, 99, 20);
		contentPane.add(txtTelefone);
		
		JLabel lblSite = new JLabel("Site:");
		lblSite.setBounds(288, 283, 46, 14);
		contentPane.add(lblSite);
		
		txtSite = new JTextField();
		txtSite.setColumns(10);
		txtSite.setBounds(349, 280, 99, 20);
		contentPane.add(txtSite);
		
		cbxConvenio = new JComboBox<>();
		cbxConvenio.setEditable(true);
		cbxConvenio.setBounds(344, 72, 104, 20);
		contentPane.add(cbxConvenio);
		
		btnNovo.setBounds(26, 348, 89, 23);
		
		btnPrimeiro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Empresa primeiro = listaEntidades.peekFirst();
				
				exibirEntidade(primeiro);
			}
		});
		btnPrimeiro.setBounds(139, 348, 89, 23);
		
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ListIterator<Empresa> iterator = listaEntidades.listIterator();
				Empresa anterior;
				
				if ( iterator.hasPrevious() ) {
					anterior = iterator.previous();
					exibirEntidade(anterior);
				}		
			}
		});
		btnAnterior.setBounds(245, 348, 89, 23);
		
		btnProximo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ListIterator<Empresa> iterator = listaEntidades.listIterator();
				Empresa proximo;
				
				if ( iterator.hasNext() ) {
					proximo = iterator.next();
					exibirEntidade(proximo);
				}
			}
		});
		btnProximo.setBounds(374, 348, 89, 23);
		
		btnUltimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Empresa ultimo = listaEntidades.peekLast();

				exibirEntidade(ultimo);
			}
		});
		btnUltimo.setBounds(473, 348, 89, 23);
				
		mntmAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Empresa empresa = criarEntidade(true);
				
				ControladorMediatorImpl.getInstancia().alterarEmpresa(empresa);
			}
		});
		
		mntmSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Empresa empresa = criarEntidade(false);
				
				ControladorMediatorImpl.getInstancia().cadastrarEmpresa(empresa);
			}
		});
		
		mntmDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Empresa empresa = criarEntidade(true);
				
				ControladorMediatorImpl.getInstancia().deletarEmpresa(empresa);
			}
		});
	}
		
	@Override
	protected Empresa criarEntidade(boolean alterar) {
		Empresa empresa = new Empresa();
		
		if (alterar) {
			empresa.setCodigo( Integer.parseInt( txtCodigo.getText() ) );
		}
		
		//empresa.add( (String) cbxConvenio.getSelectedItem() );
		empresa.setNome( txtNomeFantasia.getText() );
		empresa.setRazaoSocial( txtRazaoSocial.getText() );
		empresa.setCnpj( txtCnpj.getText() );
		empresa.setTelefone( txtTelefone.getText() );
		empresa.setContato( txtContato.getText() );
		empresa.setSite( txtSite.getText() );
		
		return empresa;
	}

	@Override
	protected void exibirEntidade(Empresa empresa) {
		if (empresa != null) {
			txtCodigo.setText( Integer.toString( empresa.getCodigo() ) );
			
			txtNomeFantasia.setText( empresa.getNome() );
			txtRazaoSocial.setText( empresa.getRazaoSocial() );
			txtCnpj.setText( empresa.getCnpj() );
			txtTelefone.setText( empresa.getTelefone() );
			txtContato.setText( empresa.getContato() );
			txtSite.setText( empresa.getSite() );
		}	else {
			txtCodigo.setText("");
			cbxConvenio.setSelectedIndex(0);
			txtNomeFantasia.setText("");
			txtRazaoSocial.setText("");
			txtCnpj.setText("");
			txtTelefone.setText("");
			txtContato.setText("");
			txtSite.setText("");
		}
	}
}
