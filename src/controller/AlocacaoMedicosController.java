package controller;

import dao.AlocacaoMedicosDAO;
import model.AlocacaoMedicos;

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
