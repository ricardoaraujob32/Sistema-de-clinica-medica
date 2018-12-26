package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.ListIterator;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Controlador;

public abstract class AbstractBoundaryManter<E> extends JDialog implements BoundaryManter<E> {
	
	protected JPanel contentPane;
	protected JButton btnNovo;
	protected JButton btnPrimeiro;
	protected JButton btnAnterior;
	protected JButton btnProximo;
	protected JButton btnUltimo;
	protected JMenuBar menuBar;
	protected JMenu mnOpcoes;
	protected JMenuItem mntmAlterar;
	protected JMenuItem mntmSalvar;
	protected JMenuItem mntmDeletar;
	protected LinkedList<E> listaEntidades;
	protected Controlador<E> controlador;
	
	/**
	 * Create the dialog.
	 */
	public AbstractBoundaryManter() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModalityType(ModalityType.APPLICATION_MODAL);
		setResizable(false);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
				
		btnNovo = new JButton("Novo");
		btnNovo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				exibirEntidade(null);
			}
		});
		contentPane.add(btnNovo);
		
		btnPrimeiro = new JButton("Primeiro");
		btnPrimeiro.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				E primeiro = listaEntidades.peekFirst();
				
				exibirEntidade(primeiro);
			}
		});
		contentPane.add(btnPrimeiro);
		
		btnAnterior = new JButton("Anterior");
		btnAnterior.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ListIterator<E> iterator = listaEntidades.listIterator();
				E anterior;
				
				if ( iterator.hasPrevious() ) {
					anterior = iterator.previous();
					exibirEntidade(anterior);
				}	
			}
		});
		contentPane.add(btnAnterior);
		
		btnProximo = new JButton("Próximo");
		btnProximo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ListIterator<E> iterator = listaEntidades.listIterator();
				E proximo;
				
				if ( iterator.hasNext() ) {
					proximo = iterator.next();
					exibirEntidade(proximo);
				}
			}
		});
		contentPane.add(btnProximo);
		
		btnUltimo = new JButton("Último");
		btnUltimo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				E ultimo = listaEntidades.peekLast();

				exibirEntidade(ultimo);
			}
		});
		contentPane.add(btnUltimo);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnOpcoes = new JMenu("Opções");
		menuBar.add(mnOpcoes);
		
		mntmAlterar = new JMenuItem("Alterar");
		mntmAlterar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				E entidade = criarEntidade(true);
				
				controlador.alterar(entidade);
			}
		});
		mnOpcoes.add(mntmAlterar);
		
		mntmSalvar = new JMenuItem("Salvar");
		mntmSalvar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				E entidade = criarEntidade(false);
				
				controlador.cadastrar(entidade);
			}
		});
		mnOpcoes.add(mntmSalvar);
		
		mntmDeletar = new JMenuItem("Deletar");
		mntmDeletar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				E entidade = criarEntidade(true);
				
				controlador.deletar(entidade);
			}
		});
		mnOpcoes.add(mntmDeletar);
	}
}
