package controller;

import dao.EspecialidadeDAOImpl;
import model.Especialidade;

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
		String nomes[] = {"Código", "Descrição"};
		setNomeColunas(nomes);
		
		Class<?> tipos[] = {Integer.class, String.class};
		setTipoColunas(tipos);
		
		dao = new EspecialidadeDAOImpl();
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
