package com.wordpress.ricardoanalistadesistemas.sistemadeclinicamedica.controller;

import com.wordpress.ricardoanalistadesistemas.sistemadeclinicamedica.dao.PacienteDAO;
import com.wordpress.ricardoanalistadesistemas.sistemadeclinicamedica.model.Paciente;

public class PacientesController extends AbstractControlador<Paciente> {

	public PacientesController() {
		String nomes[] = {"C�digo", "Nome", "Empresa", "RG", "CPF", "Data de nascimento", "Sexo", 
				"Endere�o", "Telefone", "Celular", "E-Mail"};
		setNomeColunas(nomes);
		
		Class<?> tipos[] = {Integer.class, String.class, String.class, String.class, String.class,
				String.class, String.class, String.class, String.class};
		setTipoColunas(tipos);
		
		dao = new PacienteDAO();
	}
	
	@Override
	protected void atualizarComboBoxModel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object getValueAt(int linha, int coluna) {
		// TODO Auto-generated method stub
		return null;
	}

}
