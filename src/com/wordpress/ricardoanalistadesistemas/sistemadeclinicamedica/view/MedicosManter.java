/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wordpress.ricardoanalistadesistemas.sistemadeclinicamedica.view;

import com.wordpress.ricardoanalistadesistemas.sistemadeclinicamedica.controller.EstadosComboBoxModel;
import com.wordpress.ricardoanalistadesistemas.sistemadeclinicamedica.controller.MedicosController;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import com.wordpress.ricardoanalistadesistemas.sistemadeclinicamedica.model.Entidade;
import com.wordpress.ricardoanalistadesistemas.sistemadeclinicamedica.model.Medico;

/**
 *
 * @author ricardobalduino
 */
public class MedicosManter extends AbstractBoundaryManter<Medico> {
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
    
    public MedicosManter() {
        controlador = new MedicosController();
        
        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(10, 23, 46, 14);
        add(lblNome);

        txtNome = new JTextField();
        txtNome.setBounds(57, 20, 338, 20);
        add(txtNome);
        txtNome.setColumns(10);

        JLabel lblCodigo = new JLabel("Código:");
        lblCodigo.setBounds(444, 23, 46, 14);
        add(lblCodigo);

        txtCodigo = new JTextField();
        txtCodigo.setBounds(500, 20, 86, 20);
        add(txtCodigo);
        txtCodigo.setColumns(10);

        JLabel lblDataNascimento = new JLabel("Data de nascimento:");
        lblDataNascimento.setBounds(10, 58, 109, 14);
        add(lblDataNascimento);

        spinDataNascimento = new JSpinner();
        spinDataNascimento.setModel(new SpinnerDateModel(new Date(), null, null, Calendar.HOUR_OF_DAY));
        JSpinner.DateEditor de_spinDataNascimento = new JSpinner.DateEditor(spinDataNascimento, "dd/MM/yyyy");
        spinDataNascimento.setEditor(de_spinDataNascimento);
        spinDataNascimento.setBounds(129, 52, 86, 20);
        add(spinDataNascimento);

        JLabel lblSexo = new JLabel("Sexo:");
        lblSexo.setBounds(242, 58, 40, 14);
        add(lblSexo);

        cbxSexo = new JComboBox<>();
        cbxSexo.setModel( new DefaultComboBoxModel<>( new String[] {"Masculino", "Feminino", "Outro"} ) );
        cbxSexo.setBounds(280, 55, 86, 20);
        add(cbxSexo);

        JLabel lblRg = new JLabel("RG:");
        lblRg.setBounds(10, 93, 46, 14);
        add(lblRg);

        txtRg = new JTextField();
        txtRg.setBounds(57, 90, 158, 20);
        add(txtRg);
        txtRg.setColumns(10);

        JLabel lblCpf = new JLabel("CPF:");
        lblCpf.setBounds(242, 93, 33, 14);
        add(lblCpf);

        txtCpf = new JTextField();
        txtCpf.setBounds(280, 87, 176, 20);
        add(txtCpf);
        txtCpf.setColumns(10);

        JLabel lblEstado = new JLabel("Estado:");
        lblEstado.setBounds(478, 93, 46, 14);
        add(lblEstado);

        cbxEstado = new JComboBox<>();
        cbxEstado.setModel( new EstadosComboBoxModel() );
        cbxEstado.setBounds(534, 90, 52, 20);
        add(cbxEstado);

        JLabel lblCidade = new JLabel("Cidade:");
        lblCidade.setBounds(10, 135, 46, 14);
        add(lblCidade);

        txtCidade = new JTextField();
        txtCidade.setBounds(57, 132, 193, 20);
        add(txtCidade);
        txtCidade.setColumns(10);

        JLabel lblBairro = new JLabel("Bairro:");
        lblBairro.setBounds(271, 135, 46, 14);
        add(lblBairro);

        txtBairro = new JTextField();
        txtBairro.setBounds(309, 132, 351, 20);
        add(txtBairro);
        txtBairro.setColumns(10);

        JLabel lblCep = new JLabel("CEP:");
        lblCep.setBounds(10, 177, 46, 14);
        add(lblCep);

        txtCep = new JTextField();
        txtCep.setBounds(44, 174, 128, 20);
        add(txtCep);
        txtCep.setColumns(10);

        JLabel lblLogradouro = new JLabel("Logradouro:");
        lblLogradouro.setBounds(186, 177, 64, 14);
        add(lblLogradouro);

        txtLogradouro = new JTextField();
        txtLogradouro.setBounds(259, 174, 401, 20);
        add(txtLogradouro);
        txtLogradouro.setColumns(10);

        JLabel lblNumero = new JLabel("Número:");
        lblNumero.setBounds(10, 220, 46, 14);
        add(lblNumero);

        txtNumero = new JTextField();
        txtNumero.setBounds(65, 217, 94, 20);
        add(txtNumero);
        txtNumero.setColumns(10);

        JLabel lblTelefone = new JLabel("Telefone:");
        lblTelefone.setBounds(185, 220, 46, 14);
        add(lblTelefone);

        txtTelefone = new JTextField();
        txtTelefone.setBounds(241, 217, 181, 20);
        add(txtTelefone);
        txtTelefone.setColumns(10);

        JLabel lblCelular = new JLabel("Celular:");
        lblCelular.setBounds(444, 220, 46, 14);
        add(lblCelular);

        txtCelular = new JTextField();
        txtCelular.setBounds(491, 217, 169, 20);
        add(txtCelular);
        txtCelular.setColumns(10);

        JLabel lblCrm = new JLabel("CRM:");
        lblCrm.setBounds(10, 258, 46, 14);
        add(lblCrm);

        txtCrm = new JTextField();
        txtCrm.setBounds(67, 255, 121, 20);
        add(txtCrm);
        txtCrm.setColumns(10);

        JLabel lblEmail = new JLabel("E-Mail:");
        lblEmail.setBounds(235, 258, 40, 14);
        add(lblEmail);

        txtEmail = new JTextField();
        txtEmail.setBounds(285, 255, 375, 20);
        add(txtEmail);
        txtEmail.setColumns(10);
    }
    
    @Override
    public String getTituloJanela(){
        return "Manter médicos";
    }

    @Override
    public Medico gravarNaEntidade(boolean usarCodigo) {
        Medico m = new Medico();
		
        if (usarCodigo) {
            m.setCodigo( Integer.parseInt( txtCodigo.getText() ) );
        }

        m.setNome(txtNome.getText() );
        m.setDataNascimento( (LocalDate) spinDataNascimento.getValue() );
        m.setSexo( (String) cbxSexo.getSelectedItem());
        m.setRg( txtRg.getText() );
        m.setCpf( txtCpf.getText() );
        m.getEndereco().setEstado( (String) cbxEstado.getSelectedItem() );
        m.getEndereco().setCidade( txtCidade.getText() );
        m.getEndereco().setBairro( txtBairro.getText() );
        m.getEndereco().setCep( txtCep.getText() );
        m.getEndereco().setLogradouro( txtLogradouro.getText() );
        m.getEndereco().setNumero( txtNumero.getText() );
        m.setTelefone( txtTelefone.getText() );
        m.setCelular( txtCelular.getText() );
        m.setCrm( txtCrm.getText() );
        m.setEmail( txtEmail.getText() );

        return m;
    }

    @Override
    public void lerDaEntidade(Entidade e) {
        if (e != null) {
            Medico m = (Medico) e;
            
            txtNome.setText( m.getNome() );
            txtCodigo.setText( Integer.toString( m.getCodigo() ) );
            spinDataNascimento.setValue( new Date( m.getDataNascimento().toEpochDay() ) );
            cbxSexo.setSelectedItem( m.getSexo() );
            txtRg.setText( m.getRg() );
            txtCpf.setText( m.getCpf() );
            cbxEstado.setSelectedItem( m.getEndereco().getEstado() );
            txtCidade.setText( m.getEndereco().getCidade() );
            txtBairro.setText( m.getEndereco().getBairro() );
            txtCep.setText( m.getEndereco().getCep() );
            txtLogradouro.setText( m.getEndereco().getLogradouro() );
            txtNumero.setText( m.getEndereco().getNumero() );
            txtTelefone.setText( m.getTelefone() );
            txtCelular.setText( m.getCelular() );
            txtCrm.setText( m.getCrm() );
            txtEmail.setText( m.getEmail() );
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
}
