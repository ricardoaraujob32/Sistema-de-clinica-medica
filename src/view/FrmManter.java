/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Controlador;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author ricardobalduino
 */
public class FrmManter extends JFrame implements ChangeListener, ActionListener {
    private JButton btnNovo;
    private JButton btnPrimeiro;	
    private JButton btnAnterior;	
    private JButton btnProximo;	
    private JButton btnUltimo;
    private JMenuItem mntmAlterar;
    private JMenuItem mntmSalvar;
    private JMenuItem mntmDeletar;
    private JRadioButtonMenuItem mntmAlocacao;
    private JRadioButtonMenuItem mntmClinicas;
    private JRadioButtonMenuItem mntmConsultas;
    private JRadioButtonMenuItem mntmConvenios;
    private JRadioButtonMenuItem mntmEmpresas;
    private JRadioButtonMenuItem mntmEspecialidades;
    private JRadioButtonMenuItem mntmMedicos;
    private JRadioButtonMenuItem mntmPacientes;
    private JPanel painelAtual;
    private Controlador controlador;
    private Cadastrador cadastrador;

    public FrmManter() throws HeadlessException {
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        
        JMenu mnVisualizar = new JMenu("Visualizar");
        menuBar.add(mnVisualizar);
        
        ButtonGroup grpVisualizar = new ButtonGroup();
        
        mntmAlocacao = new JRadioButtonMenuItem("Alocação de médicos", true);
        mntmAlocacao.addChangeListener(this);
        grpVisualizar.add(mntmAlocacao);
        mnVisualizar.add(mntmAlocacao);
        
        mntmClinicas = new JRadioButtonMenuItem("Clínicas");
        mntmClinicas.addChangeListener(this);
        grpVisualizar.add(mntmClinicas);
        mnVisualizar.add(mntmClinicas);
        
        mntmConsultas = new JRadioButtonMenuItem("Consultas");
        mntmConsultas.addChangeListener(this);
        grpVisualizar.add(mntmClinicas);
        mnVisualizar.add(mntmClinicas);
        
        mntmConvenios = new JRadioButtonMenuItem("Convênios");
        mntmConvenios.addChangeListener(this);
        grpVisualizar.add(mntmConvenios);
        mnVisualizar.add(mntmConvenios);
        
        mntmEmpresas = new JRadioButtonMenuItem("Empresas");
        mntmEmpresas.addChangeListener(this);
        grpVisualizar.add(mntmEmpresas);
        mnVisualizar.add(mntmEmpresas);
        
        mntmEspecialidades = new JRadioButtonMenuItem("Especialidades");
        mntmEspecialidades.addChangeListener(this);
        grpVisualizar.add(mntmEspecialidades);
        mnVisualizar.add(mntmEspecialidades);
        
        mntmMedicos = new JRadioButtonMenuItem("Médicos");
        mntmMedicos.addChangeListener(this);
        grpVisualizar.add(mntmMedicos);
        mnVisualizar.add(mntmMedicos);
        
        mntmPacientes = new JRadioButtonMenuItem("Pacientes");
        mntmPacientes.addChangeListener(this);
        grpVisualizar.add(mntmPacientes);
        mnVisualizar.add(mntmPacientes);

        JMenu mnOpcoes = new JMenu("Opções");
        menuBar.add(mnOpcoes);

        mntmAlterar = new JMenuItem("Alterar");
        mntmAlterar.addActionListener(this);
        mnOpcoes.add(mntmAlterar);

        mntmSalvar = new JMenuItem("Salvar");
        mntmSalvar.addActionListener(this);
        mnOpcoes.add(mntmSalvar);

        mntmDeletar = new JMenuItem("Deletar");
        mntmDeletar.addActionListener(this);
        mnOpcoes.add(mntmDeletar);
        
        Container container = getContentPane();
        container.setLayout( new BorderLayout() );
        
        painelAtual = new JPanel();
        JPanel pnlBotoes = new JPanel( new FlowLayout(FlowLayout.CENTER) );
        
        btnNovo = new JButton("Novo");
        btnNovo.addActionListener(this);
        pnlBotoes.add(btnNovo);

        btnPrimeiro = new JButton("Primeiro");
        btnPrimeiro.addActionListener(this);
        pnlBotoes.add(btnPrimeiro);

        btnAnterior = new JButton("Anterior");
        btnAnterior.addActionListener(this);
        pnlBotoes.add(btnAnterior);

        btnProximo = new JButton("Próximo");
        btnProximo.addActionListener(this);
        pnlBotoes.add(btnProximo);

        btnUltimo = new JButton("Último");
        btnUltimo.addActionListener(this);
        pnlBotoes.add(btnUltimo);
        
        painelAtual = new AlocacaoMedicosManter();
        container.add(painelAtual, BorderLayout.CENTER);
        container.add(pnlBotoes, BorderLayout.SOUTH);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }   
    
    public static void main(String[] args) {
        try{
            EventQueue.invokeLater( () -> new FrmManter() );
        } catch (Exception e){
            
        }
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        JRadioButtonMenuItem source = (JRadioButtonMenuItem) e.getSource();
        
        if (source == mntmAlocacao){
            painelAtual = new AlocacaoMedicosManter();
        } else if (source == mntmClinicas){
            painelAtual = new ClinicasManter();
        } else if (source == mntmConsultas){
            painelAtual = new ConsultasManter();
        } else if (source == mntmConvenios){
            painelAtual = new ConveniosManter();
        } else if (source == mntmEmpresas){
            painelAtual = new EmpresasManter();
        } else if (source == mntmEspecialidades){
            painelAtual = new EspecialidadesManter();
        } else if (source == mntmMedicos){
            painelAtual = new MedicosManter();
        } else if (source == mntmPacientes){
            painelAtual = new PacientesManter();            
        }        
        
        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == btnNovo){
            cadastrador.limpar();
        } else if (source == btnPrimeiro){
            cadastrador.primeiro();
        } else if (source == btnAnterior){
            cadastrador.anterior();
        } else if (source == btnProximo){
            cadastrador.proximo();
        } else if (source == btnUltimo){
            cadastrador.ultimo();
        } else if (source == mntmAlterar){
            cadastrador.alterar();
        } else if (source == mntmSalvar){
            cadastrador.cadastrar();
        } else if (source == mntmDeletar){
            cadastrador.deletar();
        }
    }
    
    private void configurarJanela(Cadastrador c){
        cadastrador = c;
        setTitle( cadastrador.getTituloJanela() );
        controlador = cadastrador.getControlador();
    }
}
