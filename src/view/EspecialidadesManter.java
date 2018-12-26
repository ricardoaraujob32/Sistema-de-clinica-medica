package view;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import model.Especialidade;

public class EspecialidadesManter extends AbstractBoundaryManter<Especialidade> {

	private JTextField txtCodigo;
	private JTextArea txtAreaDescricao;

	public EspecialidadesManter() {
		setTitle("Manter especialidades");
		setBounds(100, 100, 521, 300);
				
		JLabel lblCodigo = new JLabel("Código:");
		lblCodigo.setBounds(10, 11, 46, 14);
		contentPane.add(lblCodigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(66, 8, 86, 20);
		contentPane.add(txtCodigo);
		
		JLabel lblDescricao = new JLabel("Descrição:");
		lblDescricao.setBounds(10, 36, 58, 14);
		contentPane.add(lblDescricao);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 61, 481, 131);
		contentPane.add(scrollPane);
		
		txtAreaDescricao = new JTextArea();
		scrollPane.setViewportView(txtAreaDescricao);
		
		btnNovo.setBounds(10, 206, 89, 23);
		btnPrimeiro.setBounds(109, 206, 89, 23);
		btnAnterior.setBounds(208, 206, 89, 23);
		btnProximo.setBounds(307, 206, 89, 23);
		btnUltimo.setBounds(402, 206, 89, 23);
	}
		
	@Override
	protected Especialidade criarEntidade(boolean usarCodigo) {
		Especialidade e = new Especialidade();
		
		if (usarCodigo) {
			e.setCodigo( Integer.parseInt( txtCodigo.getText() ) );
		}
		
		e.setDescricao( txtAreaDescricao.getText() );
		
		return e;
	}

	@Override
	protected void exibirEntidade(Especialidade especialidade) {
		if (especialidade != null) {
			txtCodigo.setText( Integer.toString( especialidade.getCodigo() ) );
			txtAreaDescricao.setText( especialidade.getDescricao() );
		} else {
			txtCodigo.setText("");
			txtAreaDescricao.setText("");
		}
	}
}
