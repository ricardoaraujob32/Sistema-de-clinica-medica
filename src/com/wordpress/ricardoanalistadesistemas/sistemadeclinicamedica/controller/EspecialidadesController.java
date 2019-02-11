package com.wordpress.ricardoanalistadesistemas.sistemadeclinicamedica.controller;

import com.wordpress.ricardoanalistadesistemas.sistemadeclinicamedica.dao.EspecialidadeDAO;
import com.wordpress.ricardoanalistadesistemas.sistemadeclinicamedica.model.Especialidade;

/**
 * 
 * @author ricardobalduino
 *
 */
public class EspecialidadesController extends AbstractControlador<Especialidade> {
		
	/**
	 * 
	 */
	public EspecialidadesController() {
		String nomes[] = {"C�digo", "Descri��o"};
		setNomeColunas(nomes);
		
		Class<?> tipos[] = {Integer.class, String.class};
		setTipoColunas(tipos);
		
		dao = new EspecialidadeDAO();
	}
	
	@Override
	protected void atualizarComboBoxModel() {
		cmbModel.removeAllElements();
		
		for (Especialidade e : listaEntidades) {
			cmbModel.addElement( e.getDescricao() );
		}
	}
	
	@Override
	public Object getValueAt(int linha, int coluna) {
		Especialidade e = listaEntidades.get(linha);
		Object o;
		
		switch (coluna) {
			case 0:
				o = e.getCodigo();
			break;
			
			case 1:
				o =	e.getDescricao();
			break;

			default:
				o = "";
			break;
		}		
		
		return o;
	}
}
