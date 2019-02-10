/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import model.AlocacaoMedicos;
import model.Entidade;

/**
 *
 * @author ricardobalduino
 */
public class AlocacaoMedicosManter extends AbstractBoundaryManter<AlocacaoMedicos> {
    private JComboBox cbxClinica;
    private JComboBox cbxEspecialidade;
    private JComboBox cbxMedico;
    private JSpinner spinHorarioInicio;
    private JSpinner spinHorarioFim;
    private JButton btnVerEscalaMedico;
    
    public AlocacaoMedicosManter() {
        JLabel lblClnica = new JLabel("Clínica:");
        lblClnica.setBounds(10, 11, 46, 14);
        add(lblClnica);

        cbxClinica = new JComboBox<>();
        cbxClinica.setBounds(66, 8, 120, 20);
        add(cbxClinica);

        JLabel lblEspecialidade = new JLabel("Especialidade:");
        lblEspecialidade.setBounds(202, 11, 74, 14);
        add(lblEspecialidade);

        cbxEspecialidade = new JComboBox<>();
        cbxEspecialidade.setBounds(286, 8, 120, 20);
        add(cbxEspecialidade);

        JLabel lblMedico = new JLabel("Médico:");
        lblMedico.setBounds(416, 11, 46, 14);
        add(lblMedico);

        cbxMedico = new JComboBox<>();
        cbxMedico.setBounds(472, 8, 120, 20);
        add(cbxMedico);

        JLabel lblHorarioInicio = new JLabel("Horário (Início):");
        lblHorarioInicio.setBounds(10, 51, 83, 14);
        add(lblHorarioInicio);

        spinHorarioInicio = new JSpinner();
        spinHorarioInicio.setBounds(98, 48, 93, 20);
        add(spinHorarioInicio);

        JLabel lblHorarioFim = new JLabel("Horário (Fim):");
        lblHorarioFim.setBounds(255, 51, 74, 14);
        add(lblHorarioFim);

        spinHorarioFim = new JSpinner();
        spinHorarioFim.setBounds(339, 48, 90, 20);
        add(spinHorarioFim);

        btnVerEscalaMedico = new JButton("Ver escala do médico");
        btnVerEscalaMedico.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                }
        });
        btnVerEscalaMedico.setBounds(454, 98, 138, 23);
        add(btnVerEscalaMedico);
    }    
    
    @Override
    public String getTituloJanela() {
        return "Manter alocação de médicos";
    }

    @Override
    public AlocacaoMedicos gravarNaEntidade(boolean usarCodigo) {
        AlocacaoMedicos a = new AlocacaoMedicos();
		
        a.setCodigoClinica( (Integer) cbxClinica.getSelectedItem() );
        a.setCodigoEspecialidade( (Integer) cbxEspecialidade.getSelectedItem() );
        a.setCodigoMedico( (Integer) cbxMedico.getSelectedItem() );
        a.setHorarioAlocacao( (LocalTime) spinHorarioInicio.getValue() );
        a.setHorarioAlocacao( (LocalTime) spinHorarioFim.getValue() );

        return a;
    }

    @Override
    public void lerDaEntidade(Entidade e) {
        if (e != null) {
            AlocacaoMedicos a = (AlocacaoMedicos) e;
			
			
			
        } else {
            cbxClinica.setSelectedIndex(0);
            cbxEspecialidade.setSelectedIndex(0);
            cbxMedico.setSelectedIndex(0);
            spinHorarioInicio.setValue( new Date() );
            spinHorarioFim.setValue( new Date() );
        }
    }

    

    
    
}
