/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Controlador;
import controller.ControladorMediatorImpl;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ListIterator;
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
import model.Medico;

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
    private TituloJanela tituloJanela;

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
        mntmAlterar.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                        List<String> lista = criarLista(true);

                        ControladorMediatorImpl.getInstancia().alterarMedico(lista);
                }
        });
        mnOpcoes.add(mntmAlterar);

        mntmSalvar = new JMenuItem("Salvar");
        mntmSalvar.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                        List<String> lista = criarLista(false);

                        ControladorMediatorImpl.getInstancia().cadastrarMedico(lista);
                }
        });
        mnOpcoes.add(mntmSalvar);

        mntmDeletar = new JMenuItem("Deletar");
        mntmDeletar.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                        int codigo = Integer.parseInt( txtCodigo.getText() );
                        ControladorMediatorImpl.getInstancia().deletarMedico(codigo);
                }
        });
        mnOpcoes.add(mntmDeletar);
        
        Container container = getContentPane();
        container.setLayout( new BorderLayout() );
        
        painelAtual = new JPanel();
        JPanel pnlBotoes = new JPanel( new FlowLayout(FlowLayout.CENTER) );
        
        btnNovo = new JButton("Novo");
        btnNovo.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                        exibirEntidade(null);
                }
        });
        pnlBotoes.add(btnNovo);

        btnPrimeiro = new JButton("Primeiro");
        btnPrimeiro.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                        Medico primeiro = listaMedicos.peekFirst();

                        exibirEntidade(primeiro);
                }
        });
        pnlBotoes.add(btnPrimeiro);

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
        pnlBotoes.add(btnAnterior);

        btnProximo = new JButton("Próximo");
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
        pnlBotoes.add(btnProximo);

        btnUltimo = new JButton("Último");
        btnUltimo.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                        Medico ultimo = listaMedicos.peekLast();

                        exibirEntidade(ultimo);
                }
        });
        pnlBotoes.add(btnUltimo);
        
        container.add(painelAtual, BorderLayout.CENTER);
        container.add(pnlBotoes, BorderLayout.SOUTH);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }   
    
    public static void main(String[] args) {
        new FrmManter();
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        JRadioButtonMenuItem source = (JRadioButtonMenuItem) e.getSource();
        
        if (source == mntmAlocacao){
            
        } else if (source == mntmClinicas){
            
        } else if (source == mntmConsultas){
            
        } else if (source == mntmConvenios){
            
        } else if (source == mntmEmpresas){
            
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
        
    }
    
    private void configurarJanela(TituloJanela tj){
        tituloJanela = tj;
        setTitle( tituloJanela.getTituloJanela() );
        controlador = tituloJanela.getControlador();
    }
}
