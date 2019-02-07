/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Controlador;
import java.util.Calendar;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import model.Consulta;

/**
 *
 * @author ricardobalduino
 */
public class ConsultasManterJPanel extends JPanel implements TituloJanela<Consulta> {
    private JTextField txtCodigo;
    private JComboBox<String> cbxClinica;
    private JComboBox<String> cbxPaciente;
    private JComboBox<String> cbxMedico;
    private JComboBox<String> cbxEspecialidade;
    private JSpinner spinData;
    private JSpinner spinHorario;
    private JComboBox<String> cbxDuracao;
    private JComboBox<String> cbxTipo;
    private JTextArea txtAreaSintomas;
    private JTextArea txtAreaPossivelMolestia;
    private JTextArea txtAreaPrescricao;
    
    public ConsultasManterJPanel() {
        JLabel lblCodigo = new JLabel("Código:");
        lblCodigo.setBounds(10, 33, 46, 14);
        add(lblCodigo);

        txtCodigo = new JTextField();
        txtCodigo.setBounds(66, 30, 86, 20);
        add(txtCodigo);

        JLabel lblClinicas = new JLabel("Clínica:");
        lblClinicas.setBounds(10, 71, 46, 14);
        add(lblClinicas);

        cbxClinica = new JComboBox<String>();
        cbxClinica.setBounds(66, 68, 168, 20);
        add(cbxClinica);

        JLabel lblPaciente = new JLabel("Paciente:");
        lblPaciente.setBounds(244, 71, 46, 14);
        add(lblPaciente);

        cbxPaciente = new JComboBox<String>();
        cbxPaciente.setBounds(300, 68, 168, 20);
        add(cbxPaciente);

        JLabel lblMedico = new JLabel("Médico:");
        lblMedico.setBounds(478, 71, 38, 14);
        add(lblMedico);

        cbxMedico = new JComboBox<String>();
        cbxMedico.setBounds(526, 68, 168, 20);
        add(cbxMedico);

        JLabel lblEspecialidade = new JLabel("Especialidade:");
        lblEspecialidade.setBounds(704, 71, 74, 14);
        add(lblEspecialidade);

        cbxEspecialidade = new JComboBox<String>();
        cbxEspecialidade.setBounds(788, 68, 168, 20);
        add(cbxEspecialidade);

        JLabel lblData = new JLabel("Data:");
        lblData.setBounds(10, 110, 46, 14);
        add(lblData);

        spinData = new JSpinner();
        spinData.setModel(new SpinnerDateModel(new Date(), null, null, Calendar.HOUR_OF_DAY));
        JSpinner.DateEditor de1 = new JSpinner.DateEditor(spinData, "dd/MM/yyyy");
        spinData.setEditor(de1);
        spinData.setBounds(66, 107, 86, 20);
        add(spinData);

        JLabel lblHorario = new JLabel("Horário:");
        lblHorario.setBounds(244, 110, 46, 14);
        add(lblHorario);

        spinHorario = new JSpinner();
        spinHorario.setModel(new SpinnerDateModel(new Date(1528601807649L), null, null, Calendar.HOUR_OF_DAY));
        JSpinner.DateEditor de2 = new JSpinner.DateEditor(spinHorario, "hh:mm");
        spinHorario.setEditor(de2);
        spinHorario.setBounds(300, 107, 98, 20);
        add(spinHorario);

        JLabel lblDuracao = new JLabel("Duração:");
        lblDuracao.setBounds(478, 110, 46, 14);
        add(lblDuracao);

        cbxDuracao = new JComboBox<String>();
        cbxDuracao.setModel(new DefaultComboBoxModel<String>(new String[] {"00:15", "00:30", "00:45", "01:00"}));
        cbxDuracao.setBounds(526, 107, 62, 20);
        add(cbxDuracao);

        JLabel lblTipo = new JLabel("Tipo:");
        lblTipo.setBounds(732, 110, 46, 14);
        add(lblTipo);

        cbxTipo = new JComboBox<String>();
        cbxTipo.setBounds(788, 107, 98, 20);
        add(cbxTipo);

        JLabel lblSintomas = new JLabel("Sintomas:");
        lblSintomas.setBounds(385, 144, 62, 14);
        add(lblSintomas);

        JLabel lblPossivelMolestia = new JLabel("Possível moléstia:");
        lblPossivelMolestia.setBounds(370, 265, 98, 14);
        add(lblPossivelMolestia);

        JLabel lblPrescricao = new JLabel("Prescrição:");
        lblPrescricao.setBounds(385, 406, 62, 14);
        add(lblPrescricao);

        JScrollPane scrollSintomas = new JScrollPane();
        scrollSintomas.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollSintomas.setBounds(10, 169, 946, 74);
        add(scrollSintomas);

        txtAreaSintomas = new JTextArea();
        scrollSintomas.setViewportView(txtAreaSintomas);

        JScrollPane scrollPossivelMolestia = new JScrollPane();
        scrollPossivelMolestia.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPossivelMolestia.setBounds(10, 290, 946, 74);
        add(scrollPossivelMolestia);

        txtAreaPossivelMolestia = new JTextArea();
        scrollPossivelMolestia.setViewportView(txtAreaPossivelMolestia);

        JScrollPane scrollPrescricao = new JScrollPane();
        scrollPrescricao.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPrescricao.setBounds(10, 431, 946, 74);
        add(scrollPrescricao);

        txtAreaPrescricao = new JTextArea();
        scrollPrescricao.setViewportView(txtAreaPrescricao);
    }
    
    @Override
    public String getTituloJanela() {
        return "Manter consultas";
    }

    @Override
    public Consulta gravarNaEntidade() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void lerDaEntidade(Consulta c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Controlador<Consulta> getControlador() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
