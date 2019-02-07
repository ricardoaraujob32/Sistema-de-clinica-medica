/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Controlador;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import model.Especialidade;

/**
 *
 * @author ricardobalduino
 */
public class EspecialidadesManterJPanel extends JPanel implements TituloJanela<Especialidade>{
    private JTextField txtCodigo;
    private JTextArea txtAreaDescricao;
    
    public EspecialidadesManterJPanel() {
        JLabel lblCodigo = new JLabel("Código:");
        lblCodigo.setBounds(10, 11, 46, 14);
        add(lblCodigo);

        txtCodigo = new JTextField();
        txtCodigo.setBounds(66, 8, 86, 20);
        add(txtCodigo);

        JLabel lblDescricao = new JLabel("Descrição:");
        lblDescricao.setBounds(10, 36, 58, 14);
        add(lblDescricao);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBounds(10, 61, 481, 131);
        add(scrollPane);

        txtAreaDescricao = new JTextArea();
        scrollPane.setViewportView(txtAreaDescricao);
    }

    @Override
    public String getTituloJanela() {
        return "Manter especialidades";
    }

    @Override
    public Especialidade gravarNaEntidade() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void lerDaEntidade(Especialidade e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Controlador<Especialidade> getControlador() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
