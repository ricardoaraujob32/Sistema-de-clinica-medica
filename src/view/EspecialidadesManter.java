/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import model.Entidade;
import model.Especialidade;

/**
 *
 * @author ricardobalduino
 */
public class EspecialidadesManter extends AbstractBoundaryManter<Especialidade> {
    private JTextField txtCodigo;
    private JTextArea txtAreaDescricao;
    
    public EspecialidadesManter() {
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
    public Especialidade gravarNaEntidade(boolean usarCodigo) {
        Especialidade e = new Especialidade();
		
        if (usarCodigo) {
            e.setCodigo( Integer.parseInt( txtCodigo.getText() ) );
        }

        e.setDescricao( txtAreaDescricao.getText() );

        return e;
    }

    @Override
    public void lerDaEntidade(Entidade e) {
        if (e != null) {
            Especialidade esp = (Especialidade) e;
            
            txtCodigo.setText( Integer.toString( e.getCodigo() ) );
            txtAreaDescricao.setText( esp.getDescricao() );
        } else {
            txtCodigo.setText("");
            txtAreaDescricao.setText("");
        }
    }
}
