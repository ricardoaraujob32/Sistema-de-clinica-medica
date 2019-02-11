package com.wordpress.ricardoanalistadesistemas.sistemadeclinicamedica.controller;

import java.awt.EventQueue;

import javax.swing.JOptionPane;
import org.w3c.dom.*;
import view.JanelaInicial;

public class ControladorMediatorImpl {
//	private static Controlador instancia = new Controlador();
//	private AlocacaoMedicosController alocacaoMedicosController;
//	private ClinicasController clinicasController;
//	private ConsultasController consultasController;
//	private ConveniosController conveniosController;
//	private EmpresasController empresasController;
//	private EspecialidadesController especialidadesController;
//	private MedicosController medicosController;
//	private PacientesController pacientesController;
//			
//	private Controlador() {
//		this.alocacaoMedicosController = new AlocacaoMedicosController();
//		this.clinicasController = new ClinicasController();
//		this.consultasController = new ConsultasController();
//		this.conveniosController = new ConveniosController();
//		this.empresasController = new EmpresasController();
//		this.especialidadesController = new EspecialidadesController();
//		this.medicosController = new MedicosController();
//		this.pacientesController = new PacientesController();
//	}

//	public static Controlador getInstancia() {
//		return instancia;
//	}
//	
//	public AlocacaoMedicosController getAlocacaoMedicosController() {
//		return alocacaoMedicosController;
//	}
//
//	public ClinicasController getClinicasController() {
//		return clinicasController;
//	}
//
//	public ConsultasController getConsultasController() {
//		return consultasController;
//	}
//
//	public ConveniosController getConveniosController() {
//		return conveniosController;
//	}
//
//	public EmpresasController getEmpresasController() {
//		return empresasController;
//	}
//
//	public EspecialidadesController getEspecialidadesController() {
//		return especialidadesController;
//	}
//
//	public MedicosController getMedicosController() {
//		return medicosController;
//	}
//
//	public PacientesController getPacientesController() {
//		return pacientesController;
//	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new JanelaInicial().setVisible(true);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
				}
			}
		});		
	}
}
