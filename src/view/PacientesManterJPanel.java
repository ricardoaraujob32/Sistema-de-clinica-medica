/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Controlador;
import controller.EstadosComboBoxModel;
import java.util.Calendar;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import model.Paciente;

/**
 *
 * @author ricardobalduino
 */
public class PacientesManterJPanel extends JPanel implements TituloJanela<Paciente> {
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
    
    public PacientesManterJPanel() {
        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(10, 23, 46, 14);
        add(lblNome);

        txtNome = new JTextField();
        txtNome.setBounds(57, 20, 338, 20);
        add(txtNome);

        JLabel lblCodigo = new JLabel("Código:");
        lblCodigo.setBounds(444, 23, 46, 14);
        add(lblCodigo);

        txtCodigo = new JTextField();
        txtCodigo.setBounds(500, 20, 86, 20);
        add(txtCodigo);

        JLabel lblDataNascimento = new JLabel("Data de nascimento:");
        lblDataNascimento.setBounds(10, 58, 109, 14);
        add(lblDataNascimento);

        spinDataNascimento = new JSpinner();
        spinDataNascimento.setModel(new SpinnerDateModel(new Date(), null, null, Calendar.HOUR_OF_DAY));
        JSpinner.DateEditor de = new JSpinner.DateEditor(spinDataNascimento, "dd/MM/yyyy");
        spinDataNascimento.setEditor(de);
        spinDataNascimento.setBounds(129, 52, 86, 20);
        add(spinDataNascimento);

        JLabel lblSexo = new JLabel("Sexo:");
        lblSexo.setBounds(242, 58, 40, 14);
        add(lblSexo);

        cbxSexo = new JComboBox<String>();
        cbxSexo.setModel( new DefaultComboBoxModel<String>( new String[] {"Masculino", "Feminino", "Outro"} ) );
        cbxSexo.setBounds(280, 55, 86, 20);
        add(cbxSexo);

        JLabel lblRg = new JLabel("RG:");
        lblRg.setBounds(10, 93, 46, 14);
        add(lblRg);

        txtRg = new JTextField();
        txtRg.setBounds(57, 90, 158, 20);
        add(txtRg);

        JLabel lblCpf = new JLabel("CPF:");
        lblCpf.setBounds(242, 93, 33, 14);
        add(lblCpf);

        txtCpf = new JTextField();
        txtCpf.setBounds(280, 87, 176, 20);
        add(txtCpf);

        JLabel lblEstado = new JLabel("Estado:");
        lblEstado.setBounds(478, 93, 46, 14);
        add(lblEstado);

        cbxEstado = new JComboBox<String>();
        cbxEstado.setModel( new EstadosComboBoxModel() );
        cbxEstado.setBounds(534, 90, 52, 20);
        add(cbxEstado);

        JLabel lblCidade = new JLabel("Cidade:");
        lblCidade.setBounds(10, 135, 46, 14);
        add(lblCidade);

        txtCidade = new JTextField();
        txtCidade.setBounds(57, 132, 193, 20);
        add(txtCidade);

        JLabel lblBairro = new JLabel("Bairro:");
        lblBairro.setBounds(271, 135, 46, 14);
        add(lblBairro);

        txtBairro = new JTextField();
        txtBairro.setBounds(309, 132, 351, 20);
        add(txtBairro);

        JLabel lblCep = new JLabel("CEP:");
        lblCep.setBounds(10, 177, 46, 14);
        add(lblCep);

        txtCep = new JTextField();
        txtCep.setBounds(44, 174, 128, 20);
        add(txtCep);

        JLabel lblLogradouro = new JLabel("Logradouro:");
        lblLogradouro.setBounds(186, 177, 64, 14);
        add(lblLogradouro);

        txtLogradouro = new JTextField();
        txtLogradouro.setBounds(259, 174, 401, 20);
        add(txtLogradouro);

        JLabel lblNumero = new JLabel("Número:");
        lblNumero.setBounds(10, 220, 46, 14);
        add(lblNumero);

        txtNumero = new JTextField();
        txtNumero.setBounds(57, 217, 94, 20);
        add(txtNumero);

        JLabel lblTelefone = new JLabel("Telefone:");
        lblTelefone.setBounds(185, 220, 46, 14);
        add(lblTelefone);

        txtTelefone = new JTextField();
        txtTelefone.setBounds(241, 217, 181, 20);
        add(txtTelefone);

        JLabel lblCelular = new JLabel("Celular:");
        lblCelular.setBounds(444, 220, 46, 14);
        add(lblCelular);

        txtCelular = new JTextField();
        txtCelular.setBounds(491, 217, 169, 20);
        add(txtCelular);

        JLabel lblEmail = new JLabel("E-Mail:");
        lblEmail.setBounds(10, 258, 40, 14);
        add(lblEmail);

        txtEmail = new JTextField();
        txtEmail.setBounds(57, 255, 375, 20);
        add(txtEmail);

        JLabel lblEmpresa = new JLabel("Empresa:");
        lblEmpresa.setBounds(394, 58, 46, 14);
        add(lblEmpresa);

        cbxEmpresa = new JComboBox<String>();
        cbxEmpresa.setBounds(444, 55, 142, 20);
        add(cbxEmpresa);
    }    

    @Override
    public String getTituloJanela() {
        return "Manter pacientes";
    }

    @Override
    public Paciente gravarNaEntidade() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void lerDaEntidade(Paciente p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Controlador<Paciente> getControlador() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
