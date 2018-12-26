package controller;

import dao.AlocacaoMedicosDAOImpl;
import model.AlocacaoMedicos;

public class AlocacaoMedicosController extends AbstractControlador<AlocacaoMedicos> {
	
	
	public AlocacaoMedicosController() {
		dao = new AlocacaoMedicosDAOImpl();
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
