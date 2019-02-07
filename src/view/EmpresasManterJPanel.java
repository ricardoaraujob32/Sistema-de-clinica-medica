/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Controlador;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.Empresa;

/**
 *
 * @author ricardobalduino
 */
public class EmpresasManterJPanel extends JPanel implements TituloJanela<Empresa> {
    private JTextField txtCodigo;
    private JTextField txtNomeFantasia;
    private JTextField txtCnpj;
    private JTextField txtContato;
    private JTextField txtRazaoSocial;
    private JTextField txtTelefone;
    private JTextField txtSite;
    private JComboBox<String> cbxConvenio;

    public EmpresasManterJPanel() {
        txtCodigo = new JTextField();
        txtCodigo.setBounds(93, 72, 86, 20);
        add(txtCodigo);
        txtCodigo.setColumns(10);

        JLabel lblCodigo = new JLabel("Código:");
        lblCodigo.setBounds(26, 75, 46, 14);
        add(lblCodigo);

        JLabel lblNomeFantasia = new JLabel("Nome fantasia:");
        lblNomeFantasia.setBounds(10, 140, 73, 14);
        add(lblNomeFantasia);

        txtNomeFantasia = new JTextField();
        txtNomeFantasia.setColumns(10);
        txtNomeFantasia.setBounds(93, 137, 86, 20);
        add(txtNomeFantasia);

        JLabel lblCnpj = new JLabel("CNPJ:");
        lblCnpj.setBounds(48, 211, 46, 14);
        add(lblCnpj);

        txtCnpj = new JTextField();
        txtCnpj.setColumns(10);
        txtCnpj.setBounds(93, 208, 86, 20);
        add(txtCnpj);

        JLabel lblContato = new JLabel("Contato:");
        lblContato.setBounds(37, 283, 46, 14);
        add(lblContato);

        txtContato = new JTextField();
        txtContato.setColumns(10);
        txtContato.setBounds(93, 280, 86, 20);
        add(txtContato);

        JLabel lblConvenio = new JLabel("Convênio:");
        lblConvenio.setBounds(282, 75, 52, 14);
        add(lblConvenio);

        JLabel lblRazaoSocial = new JLabel("Razão social:");
        lblRazaoSocial.setBounds(271, 140, 63, 14);
        add(lblRazaoSocial);

        txtRazaoSocial = new JTextField();
        txtRazaoSocial.setColumns(10);
        txtRazaoSocial.setBounds(349, 137, 99, 20);
        add(txtRazaoSocial);

        JLabel lblTelefone = new JLabel("Telefone:");
        lblTelefone.setBounds(288, 211, 46, 14);
        add(lblTelefone);

        txtTelefone = new JTextField();
        txtTelefone.setColumns(10);
        txtTelefone.setBounds(349, 208, 99, 20);
        add(txtTelefone);

        JLabel lblSite = new JLabel("Site:");
        lblSite.setBounds(288, 283, 46, 14);
        add(lblSite);

        txtSite = new JTextField();
        txtSite.setColumns(10);
        txtSite.setBounds(349, 280, 99, 20);
        add(txtSite);

        cbxConvenio = new JComboBox<String>();
        cbxConvenio.setEditable(true);
        cbxConvenio.setBounds(344, 72, 104, 20);
        add(cbxConvenio);
    }

    @Override
    public String getTituloJanela() {
        return "Manter Empresa";
    }

    @Override
    public Empresa gravarNaEntidade() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void lerDaEntidade(Empresa e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Controlador<Empresa> getControlador() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
