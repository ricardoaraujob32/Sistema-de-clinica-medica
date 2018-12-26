package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.ControladorMediatorImpl;
import model.Convenio;

public class ConveniosManter extends JFrame {

	private JPanel contentPane;
	private JTextField txtCodigo;
	private JTextField txtNomeFantasia;
	private JTextField txtCnpj;
	private JTextField txtContato;
	private JTextField txtRazaoSocial;
	private JTextField txtTelefone;
	private JTextField txtSite;
	private ControladorMediatorImpl controladorMediatorImpl;
	private LinkedList<Convenio> listaConvenios;

	public ConveniosManter() {
		setTitle("Manter convênio");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 574, 369);
		
		controladorMediatorImpl = ControladorMediatorImpl.getInstancia();
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnOpcoes = new JMenu("Opções");
		menuBar.add(mnOpcoes);
		
		JMenuItem mntmAlterar = new JMenuItem("Alterar");
		mntmAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				List<String> lista = criarLista(true);
				
				controladorMediatorImpl.alterarConvenio(lista);
			}
		});
		mnOpcoes.add(mntmAlterar);
		
		JMenuItem mntmSalvar = new JMenuItem("Salvar");
		mntmSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				List<String> lista = criarLista(false);
				
				controladorMediatorImpl.cadastrarConvenio(lista);
			}
		});
		mnOpcoes.add(mntmSalvar);
		
		JMenuItem mntmDeletar = new JMenuItem("Deletar");
		mntmDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int codigo = Integer.parseInt( txtCodigo.getText() );
				
				controladorMediatorImpl.deletarConvenio(codigo);
			}
		});
		mnOpcoes.add(mntmDeletar);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNovo = new JButton("Novo");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				exibirEntidade(null);
			}
		});
		btnNovo.setBounds(10, 279, 89, 23);
		contentPane.add(btnNovo);
		
		JButton btnPrimeiro = new JButton("Primeiro");
		btnPrimeiro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Convenio primeiro = listaConvenios.peekFirst();
				
				exibirEntidade(primeiro);
			}
		});
		btnPrimeiro.setBounds(120, 279, 89, 23);
		contentPane.add(btnPrimeiro);
		
		JButton btnAnterior = new JButton("Anterior");
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ListIterator<Convenio> iterator = listaConvenios.listIterator();
				Convenio anterior;
				
				if ( iterator.hasPrevious() ) {
					anterior = iterator.previous();
					exibirEntidade(anterior);
				}				
			}
		});
		btnAnterior.setBounds(219, 279, 89, 23);
		contentPane.add(btnAnterior);
		
		JButton btnProximo = new JButton("Próximo");
		btnProximo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ListIterator<Convenio> iterator = listaConvenios.listIterator();
				Convenio proximo;
				
				if ( iterator.hasNext() ) {
					proximo = iterator.next();
					exibirEntidade(proximo);
				}
			}
		});
		btnProximo.setBounds(326, 279, 89, 23);
		contentPane.add(btnProximo);
		
		JButton btnUltimo = new JButton("Último");
		btnUltimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Convenio ultimo = listaConvenios.peekLast();
				
				exibirEntidade(ultimo);
			}
		});
		btnUltimo.setBounds(443, 279, 89, 23);
		contentPane.add(btnUltimo);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(96, 70, 89, 20);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		JLabel lblCodigo = new JLabel("Código");
		lblCodigo.setBounds(40, 73, 46, 14);
		contentPane.add(lblCodigo);
		
		JLabel lblNomeFantasia = new JLabel("Nome fantasia");
		lblNomeFantasia.setBounds(12, 104, 74, 35);
		contentPane.add(lblNomeFantasia);
		
		txtNomeFantasia = new JTextField();
		txtNomeFantasia.setColumns(10);
		txtNomeFantasia.setBounds(96, 111, 160, 20);
		contentPane.add(txtNomeFantasia);
		
		JLabel lblCpnj = new JLabel("CPNJ");
		lblCpnj.setBounds(40, 150, 46, 14);
		contentPane.add(lblCpnj);
		
		txtCnpj = new JTextField();
		txtCnpj.setColumns(10);
		txtCnpj.setBounds(96, 147, 101, 20);
		contentPane.add(txtCnpj);
		
		JLabel lblContato = new JLabel("Contato");
		lblContato.setBounds(40, 198, 46, 14);
		contentPane.add(lblContato);
		
		txtContato = new JTextField();
		txtContato.setColumns(10);
		txtContato.setBounds(96, 195, 160, 20);
		contentPane.add(txtContato);
		
		JLabel lblRazaoSocial = new JLabel("Razão Social");
		lblRazaoSocial.setBounds(280, 73, 68, 14);
		contentPane.add(lblRazaoSocial);
		
		txtRazaoSocial = new JTextField();
		txtRazaoSocial.setColumns(10);
		txtRazaoSocial.setBounds(358, 70, 174, 20);
		contentPane.add(txtRazaoSocial);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(302, 107, 46, 14);
		contentPane.add(lblTelefone);
		
		txtTelefone = new JTextField();
		txtTelefone.setColumns(10);
		txtTelefone.setBounds(358, 104, 125, 20);
		contentPane.add(txtTelefone);
		
		JLabel lblSite = new JLabel("Site");
		lblSite.setBounds(319, 150, 29, 14);
		contentPane.add(lblSite);
		
		txtSite = new JTextField();
		txtSite.setColumns(10);
		txtSite.setBounds(358, 144, 174, 20);
		contentPane.add(txtSite);
	}
	
	private List<String> criarLista(boolean alterar){
		List<String> lista = new ArrayList<>();
		
		if (alterar) {
			lista.add( txtCodigo.getText() );
		}
		
		lista.add( txtNomeFantasia.getText() );
		lista.add( txtRazaoSocial.getText() );
		lista.add( txtCnpj.getText() );
		lista.add( txtTelefone.getText() );
		lista.add( txtContato.getText() );
		lista.add( txtSite.getText() );
		
		return lista;
	}
	
	private void exibirEntidade(Convenio convenio) {
		if (convenio != null) {
			txtCodigo.setText( Integer.toString( convenio.getCodigo() ) );
			txtNomeFantasia.setText( convenio.getNome() );
			txtRazaoSocial.setText( convenio.getRazaoSocial() );
			txtCnpj.setText( convenio.getCnpj() );
			txtTelefone.setText( convenio.getTelefone() );
			txtContato.setText( convenio.getContato() );
			txtSite.setText( convenio.getSite() );
		}	else {
			txtCodigo.setText("");
			txtNomeFantasia.setText("");
			txtRazaoSocial.setText("");
			txtCnpj.setText("");
			txtTelefone.setText("");
			txtContato.setText("");
			txtSite.setText("");
		}
	}
}
