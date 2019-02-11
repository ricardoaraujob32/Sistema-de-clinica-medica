package com.wordpress.ricardoanalistadesistemas.sistemadeclinicamedica.controller;

import com.wordpress.ricardoanalistadesistemas.sistemadeclinicamedica.dao.AlocacaoMedicosDAO;
import com.wordpress.ricardoanalistadesistemas.sistemadeclinicamedica.model.AlocacaoMedicos;

public class AlocacaoMedicosController extends AbstractControlador<AlocacaoMedicos> {
	
	
	public AlocacaoMedicosController() {
		dao = new AlocacaoMedicosDAO();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void atualizarComboBoxModel() {
		// TODO Auto-generated method stub
		
	}
	
	
}
