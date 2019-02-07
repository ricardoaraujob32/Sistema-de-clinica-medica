/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Controlador;
import controller.EstadosComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.Clinica;

/**
 *
 * @author ricardobalduino
 */
public class ClinicasManter extends JPanel implements TituloJanela<Clinica> {
    private JTextField txtCodigo;
    private JTextField txtCidade;
    private JTextField txtBairro;
    private JTextField txtCep;
    private JTextField txtLogradouro;
    private JTextField txtNumero;
    private JComboBox<String> cbxEstado;

    public ClinicasManter() {
        JLabel lblCodigo = new JLabel("Código:");
        lblCodigo.setBounds(10, 11, 46, 14);
        add(lblCodigo);

        txtCodigo = new JTextField();
        txtCodigo.setBounds(52, 8, 64, 20);
        add(txtCodigo);

        JLabel lblEstado = new JLabel("Estado:");
        lblEstado.setBounds(141, 11, 46, 14);
        add(lblEstado);

        cbxEstado = new JComboBox<String>();
        cbxEstado.setModel( new EstadosComboBoxModel() );
        cbxEstado.setBounds(197, 8, 46, 20);
        add(cbxEstado);

        JLabel lblCidade = new JLabel("Cidade:");
        lblCidade.setBounds(253, 11, 46, 14);
        add(lblCidade);

        txtCidade = new JTextField();
        txtCidade.setBounds(300, 8, 151, 20);
        add(txtCidade);
        txtCidade.setColumns(10);

        JLabel lblBairro = new JLabel("Bairro:");
        lblBairro.setBounds(10, 48, 46, 14);
        add(lblBairro);

        txtBairro = new JTextField();
        txtBairro.setBounds(52, 45, 124, 20);
        add(txtBairro);
        txtBairro.setColumns(10);

        JLabel lblCep = new JLabel("CEP:");
        lblCep.setBounds(197, 48, 32, 14);
        add(lblCep);

        txtCep = new JTextField();
        txtCep.setBounds(239, 45, 112, 20);
        add(txtCep);
        txtCep.setColumns(10);

        JLabel lblLogradouro = new JLabel("Logradouro:");
        lblLogradouro.setBounds(10, 89, 64, 14);
        add(lblLogradouro);

        txtLogradouro = new JTextField();
        txtLogradouro.setBounds(84, 86, 236, 20);
        add(txtLogradouro);
        txtLogradouro.setColumns(10);

        JLabel lblNumero = new JLabel("Número:");
        lblNumero.setBounds(366, 89, 46, 14);
        add(lblNumero);

        txtNumero = new JTextField();
        txtNumero.setBounds(422, 86, 86, 20);
        add(txtNumero);
        txtNumero.setColumns(10);
    }
        
    @Override
    public String getTituloJanela() {
        return "Manter clínicas";
    }

    @Override
    public Clinica gravarNaEntidade(boolean usarCodigo) {
        Clinica c = new Clinica();
		
        if (usarCodigo) {
            c.setCodigo( Integer.parseInt( txtCodigo.getText() ) );
        }

        c.getEndereco().setEstado( (String) cbxEstado.getSelectedItem() );
        c.getEndereco().setCidade( txtCidade.getText() );
        c.getEndereco().setBairro( txtBairro.getText() );
        c.getEndereco().setCep( txtCep.getText() );
        c.getEndereco().setLogradouro( txtLogradouro.getText() );
        c.getEndereco().setNumero( txtNumero.getText() );

        return c;
    }

    @Override
    public void lerDaEntidade(Clinica c) {
        if (c != null) {
            txtCodigo.setText( Integer.toString( c.getCodigo() ) );
            cbxEstado.setSelectedItem( c.getEndereco().getEstado() );
            txtCidade.setText( c.getEndereco().getCidade() );
            txtBairro.setText( c.getEndereco().getBairro() );
            txtCep.setText( c.getEndereco().getCep() );
            txtLogradouro.setText( c.getEndereco().getLogradouro() );
            txtNumero.setText( c.getEndereco().getNumero() );
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

    @Override
    public Controlador<Clinica> getControlador() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
