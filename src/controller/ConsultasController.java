package controller;

import dao.ConsultaDAO;
import model.Consulta;

public class ConsultasController extends AbstractControlador<Consulta> {
	
	public ConsultasController() {
		// TODO Auto-generated constructor stub
		
		dao = new ConsultaDAO();
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
