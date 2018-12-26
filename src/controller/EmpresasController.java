package controller;

import dao.EmpresaDAOImpl;
import model.Empresa;

/** 
 * @author Ricardo de Araújo Balduino
 * @version 1.0
 * @since 1.0
 */
public class EmpresasController extends AbstractControlador<Empresa> {
			
	/** 
	 * Cria um novo objeto com a lista de entidades vazia e o modelo de dados do ComboBox vazio
	 */
	public EmpresasController() {
		String nomes[] = {"Código", "Nome fantasia", "Razão social", "CNPJ",
				"Convênio", "Telefone", "Contato", "Site"};
		setNomeColunas(nomes);
		
		Class<?> tipos[] = {Integer.class, String.class, String.class, String.class, 
				String.class, String.class, String.class, String.class};
		setTipoColunas(tipos);
		
		dao = new EmpresaDAOImpl();
		
	}
	
	
	/** 
	 * Configura o modelo de dados do ComboBox
	 */
	@Override
	protected void atualizarComboBoxModel() {
		cmbModel.removeAllElements();
		
		for (Empresa e : listaEntidades) {
			cmbModel.addElement( e.getNome() );
		}
	}

	/** 
	 * 
	 */
	@Override
	public Object getValueAt(int linha, int coluna) {
		Empresa e = listaEntidades.get(linha);
		Object o;
		
		switch (coluna) {
			case 0:
				o = e.getCodigo();
			break;
	
			case 1:
				o = e.getNome();
			break;
	
			case 2:
				o = e.getRazaoSocial();
			break;
	
			case 3:
				o = e.getCnpj();
			break;
	
			case 4:
				o = e.getCodigoConvenio();
			break;
	
			case 5:
				o = e.getTelefone();
			break;
	
			case 6:
				o = e.getContato();
			break;
	
			case 7:
				o = e.getSite();
			break;
		
			default:
				o = "";
			break;
		}
		
		return o;
	}

	
}
