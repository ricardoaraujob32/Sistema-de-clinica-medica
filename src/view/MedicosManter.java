package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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
import controller.MedicosController;
import model.Medico;

public class MedicosManter extends JFrame {
	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtCodigo;
	private JTextField txtRg;
	private JTextField txtCpf;
	private JTextField txtCidade;
	private JTextField txtBairro;
	private JTextField txtCep;
	private JTextField txtLogradouro;
	private JTextField txtNumero;
	private JTextField txtTelefone;
	private JTextField txtCelular;
	private JTextField txtCrm;
	private JTextField txtEmail;
	private JSpinner spinDataNascimento;
	private JComboBox<String> cbxSexo;
	private JComboBox<String> cbxEstado;
	private JButton btnNovo;
	private JButton btnPrimeiro;	
	private JButton btnAnterior;	
	private JButton btnProximo;	
	private JButton btnUltimo;
	private MedicosController medicosController;
	private LinkedList<Medico> listaMedicos;
	
	public MedicosManter() {
            addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowOpened(WindowEvent arg0) {
                            medicosController = new MedicosController();
                            listaMedicos = ( LinkedList<Medico> ) medicosController.getListaMedicos();
                    }
            });
            setTitle("Manter m�dicos");
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setBounds(100, 100, 700, 408);

            JMenuBar menuBar = new JMenuBar();
            setJMenuBar(menuBar);

            JMenu mnOpcoes = new JMenu("Op��es");
            menuBar.add(mnOpcoes);

            JMenuItem mntmAlterar = new JMenuItem("Alterar");
            mntmAlterar.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                            List<String> lista = criarLista(true);

                            ControladorMediatorImpl.getInstancia().alterarMedico(lista);
                    }
            });
            mnOpcoes.add(mntmAlterar);

            JMenuItem mntmSalvar = new JMenuItem("Salvar");
            mntmSalvar.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                            List<String> lista = criarLista(false);

                            ControladorMediatorImpl.getInstancia().cadastrarMedico(lista);
                    }
            });
            mnOpcoes.add(mntmSalvar);

            JMenuItem mntmDeletar = new JMenuItem("Deletar");
            mntmDeletar.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                            int codigo = Integer.parseInt( txtCodigo.getText() );
                            ControladorMediatorImpl.getInstancia().deletarMedico(codigo);
                    }
            });
            mnOpcoes.add(mntmDeletar);

            contentPane = new JPanel();
            contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
            setContentPane(contentPane);
            contentPane.setLayout(null);

            JLabel lblNome = new JLabel("Nome:");
            lblNome.setBounds(10, 23, 46, 14);
            contentPane.add(lblNome);

            txtNome = new JTextField();
            txtNome.setBounds(57, 20, 338, 20);
            contentPane.add(txtNome);
            txtNome.setColumns(10);

            JLabel lblCodigo = new JLabel("C�digo:");
            lblCodigo.setBounds(444, 23, 46, 14);
            contentPane.add(lblCodigo);

            txtCodigo = new JTextField();
            txtCodigo.setBounds(500, 20, 86, 20);
            contentPane.add(txtCodigo);
            txtCodigo.setColumns(10);

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

            cbxSexo = new JComboBox<String>();
            cbxSexo.setModel( new DefaultComboBoxModel<String>( new String[] {"Masculino", "Feminino", "Outro"} ) );
            cbxSexo.setBounds(280, 55, 86, 20);
            contentPane.add(cbxSexo);

            JLabel lblRg = new JLabel("RG:");
            lblRg.setBounds(10, 93, 46, 14);
            contentPane.add(lblRg);

            txtRg = new JTextField();
            txtRg.setBounds(57, 90, 158, 20);
            contentPane.add(txtRg);
            txtRg.setColumns(10);

            JLabel lblCpf = new JLabel("CPF:");
            lblCpf.setBounds(242, 93, 33, 14);
            contentPane.add(lblCpf);

            txtCpf = new JTextField();
            txtCpf.setBounds(280, 87, 176, 20);
            contentPane.add(txtCpf);
            txtCpf.setColumns(10);

            JLabel lblEstado = new JLabel("Estado:");
            lblEstado.setBounds(478, 93, 46, 14);
            contentPane.add(lblEstado);

            cbxEstado = new JComboBox<String>();
            cbxEstado.setModel( new EstadosComboBoxModel() );
            cbxEstado.setBounds(534, 90, 52, 20);
            contentPane.add(cbxEstado);

            JLabel lblCidade = new JLabel("Cidade:");
            lblCidade.setBounds(10, 135, 46, 14);
            contentPane.add(lblCidade);

            txtCidade = new JTextField();
            txtCidade.setBounds(57, 132, 193, 20);
            contentPane.add(txtCidade);
            txtCidade.setColumns(10);

            JLabel lblBairro = new JLabel("Bairro:");
            lblBairro.setBounds(271, 135, 46, 14);
            contentPane.add(lblBairro);

            txtBairro = new JTextField();
            txtBairro.setBounds(309, 132, 351, 20);
            contentPane.add(txtBairro);
            txtBairro.setColumns(10);

            JLabel lblCep = new JLabel("CEP:");
            lblCep.setBounds(10, 177, 46, 14);
            contentPane.add(lblCep);

            txtCep = new JTextField();
            txtCep.setBounds(44, 174, 128, 20);
            contentPane.add(txtCep);
            txtCep.setColumns(10);

            JLabel lblLogradouro = new JLabel("Logradouro:");
            lblLogradouro.setBounds(186, 177, 64, 14);
            contentPane.add(lblLogradouro);

            txtLogradouro = new JTextField();
            txtLogradouro.setBounds(259, 174, 401, 20);
            contentPane.add(txtLogradouro);
            txtLogradouro.setColumns(10);

            JLabel lblNumero = new JLabel("N�mero:");
            lblNumero.setBounds(10, 220, 46, 14);
            contentPane.add(lblNumero);

            txtNumero = new JTextField();
            txtNumero.setBounds(65, 217, 94, 20);
            contentPane.add(txtNumero);
            txtNumero.setColumns(10);

            JLabel lblTelefone = new JLabel("Telefone:");
            lblTelefone.setBounds(185, 220, 46, 14);
            contentPane.add(lblTelefone);

            txtTelefone = new JTextField();
            txtTelefone.setBounds(241, 217, 181, 20);
            contentPane.add(txtTelefone);
            txtTelefone.setColumns(10);

            JLabel lblCelular = new JLabel("Celular:");
            lblCelular.setBounds(444, 220, 46, 14);
            contentPane.add(lblCelular);

            txtCelular = new JTextField();
            txtCelular.setBounds(491, 217, 169, 20);
            contentPane.add(txtCelular);
            txtCelular.setColumns(10);

            JLabel lblCrm = new JLabel("CRM:");
            lblCrm.setBounds(10, 258, 46, 14);
            contentPane.add(lblCrm);

            txtCrm = new JTextField();
            txtCrm.setBounds(67, 255, 121, 20);
            contentPane.add(txtCrm);
            txtCrm.setColumns(10);

            JLabel lblEmail = new JLabel("E-Mail:");
            lblEmail.setBounds(235, 258, 40, 14);
            contentPane.add(lblEmail);

            txtEmail = new JTextField();
            txtEmail.setBounds(285, 255, 375, 20);
            contentPane.add(txtEmail);
            txtEmail.setColumns(10);

            btnNovo = new JButton("Novo");
            btnNovo.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                            exibirEntidade(null);
                    }
            });
            btnNovo.setBounds(10, 307, 89, 23);
            contentPane.add(btnNovo);

            btnPrimeiro = new JButton("Primeiro");
            btnPrimeiro.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                            Medico primeiro = listaMedicos.peekFirst();

                            exibirEntidade(primeiro);
                    }
            });
            btnPrimeiro.setBounds(126, 307, 89, 23);
            contentPane.add(btnPrimeiro);

            btnAnterior = new JButton("Anterior");
            btnAnterior.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                            ListIterator<Medico> iterator = listaMedicos.listIterator();
                            Medico anterior;

                            if ( iterator.hasPrevious() ) {
                                    anterior = iterator.previous();
                                    exibirEntidade(anterior);
                            }
                    }
            });
            btnAnterior.setBounds(278, 307, 89, 23);
            contentPane.add(btnAnterior);

            btnProximo = new JButton("Pr�ximo");
            btnProximo.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                            ListIterator<Medico> iterator = listaMedicos.listIterator();
                            Medico proximo;

                            if ( iterator.hasNext() ) {
                                    proximo = iterator.next();
                                    exibirEntidade(proximo);
                            }
                    }
            });
            btnProximo.setBounds(432, 307, 89, 23);
            contentPane.add(btnProximo);

            btnUltimo = new JButton("�ltimo");
            btnUltimo.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                            Medico ultimo = listaMedicos.peekLast();

                            exibirEntidade(ultimo);
                    }
            });
            btnUltimo.setBounds(571, 307, 89, 23);
            contentPane.add(btnUltimo);
	}
	
	private List<String> criarLista(boolean alterar) {
		List<String> lista = new ArrayList<>();
		
		lista.add( txtNome.getText() );
		
		if (alterar) {
			lista.add( txtCodigo.getText() );
		}
		
		lista.add( (String) spinDataNascimento.getValue() );
		
		char sexo;
		switch ( (String) cbxSexo.getSelectedItem() ) {
			case "Masculino":
				sexo = 'M';
			break;

			case "Feminino":
				sexo = 'F';
			break;

			default:
				sexo = 'O';
			break;
		}
		
		lista.add( Character.toString(sexo) );
		lista.add( txtRg.getText() );
		lista.add( txtCpf.getText() );
		lista.add( (String) cbxEstado.getSelectedItem() );
		lista.add( txtCidade.getText() );
		lista.add( txtBairro.getText() );
		lista.add( txtCep.getText() );
		lista.add( txtLogradouro.getText() );
		lista.add( txtNumero.getText() );
		lista.add( txtTelefone.getText() );
		lista.add( txtCelular.getText() );
		lista.add( txtCrm.getText() );
		lista.add( txtEmail.getText() );
		
		return lista;
	}
	
	private void exibirEntidade(Medico medico) {
		if (medico != null) {
			txtNome.setText( medico.getNome() );
			txtCodigo.setText( Integer.toString( medico.getCodigo() ) );
			spinDataNascimento.setValue( new Date( medico.getDataNascimento().toEpochDay() ) );
			
			String sexo = "";
			
			switch ( medico.getSexo() ) {
			case 'M':
				sexo = "Masculino";
				break;

			case 'F':
				sexo = "Feminino";
				break;

			default:
				sexo = "Outro";
				break;
			}
			
			cbxSexo.setSelectedItem(sexo);
			txtRg.setText( medico.getRg() );
			txtCpf.setText( medico.getCpf() );
			cbxEstado.setSelectedItem( medico.getEndereco().getEstado() );
			txtCidade.setText( medico.getEndereco().getCidade() );
			txtBairro.setText( medico.getEndereco().getBairro() );
			txtCep.setText( medico.getEndereco().getCep() );
			txtLogradouro.setText( medico.getEndereco().getLogradouro() );
			txtNumero.setText( medico.getEndereco().getNumero() );
			txtTelefone.setText( medico.getTelefone() );
			txtCelular.setText( medico.getCelular() );
			txtCrm.setText( medico.getCrm() );
			txtEmail.setText( medico.getEmail() );
		} else {
			txtNome.setText("");
			txtCodigo.setText("");
			spinDataNascimento.setValue( new Date() );
			cbxSexo.setSelectedIndex(0);
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
			txtCrm.setText("");
			txtEmail.setText("");
		}
	}
        
        public static void main(String[] args) {
            new MedicosManter().setVisible(true);
        }

}
