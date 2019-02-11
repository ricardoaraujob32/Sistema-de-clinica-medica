package com.wordpress.ricardoanalistadesistemas.sistemadeclinicamedica.controller;

import com.wordpress.ricardoanalistadesistemas.sistemadeclinicamedica.dao.ClinicaDAO;
import com.wordpress.ricardoanalistadesistemas.sistemadeclinicamedica.model.Clinica;

public class ClinicasController extends AbstractControlador<Clinica> {	
	
	public ClinicasController() {
		String nomes[] = {"C�digo", "Endere�o"};
		setNomeColunas(nomes);
		
		Class<?> tipos[] = {Integer.class, String.class};
		setTipoColunas(tipos);
		
		dao = new ClinicaDAO();
	}
			
	@Override
	protected void atualizarComboBoxModel() {
		cmbModel.removeAllElements();

		for (Clinica c : listaEntidades) {
			cmbModel.addElement( c.getEndereco().getBairro() );
		}
	}	
		
	@Override
	public Object getValueAt(int linha, int coluna) {
		Clinica c = listaEntidades.get(linha);
		Object o;
		
		switch (coluna) {
			case 0:
				o = c.getCodigo();
			break;
	
			case 1:
				o = c.getEndereco().toString();
			break;
	
			default:
				o = "";
			break;
		}
		
		return o;
	}
}
