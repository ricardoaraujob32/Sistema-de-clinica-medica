package controller;

import dao.ClinicaDAOImpl;
import model.Clinica;

public class ClinicasController extends AbstractControlador<Clinica> {	
	
	public ClinicasController() {
		String nomes[] = {"Código", "Endereço"};
		setNomeColunas(nomes);
		
		Class<?> tipos[] = {Integer.class, String.class};
		setTipoColunas(tipos);
		
		dao = new ClinicaDAOImpl();
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
