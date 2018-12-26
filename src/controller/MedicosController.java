package controller;

import java.time.LocalDate;

import dao.MedicoDAOImpl;
import model.Medico;

public class MedicosController extends AbstractControlador<Medico> {	
	
	public MedicosController() {
		String nomes[] = {"Código", "Nome", "Data de nascimento", "RG", "CPF", "Sexo", "Endereço", 
				"Telefone", "Celular", "E-Mail", "CRM"};
		setNomeColunas(nomes);
		
		Class<?> tipos[] = {Integer.class, String.class, LocalDate.class, String.class, String.class,
				Character.class, String.class, String.class, String.class, String.class, String.class};
		setTipoColunas(tipos);
		
		dao = new MedicoDAOImpl();
	}	
		
	@Override
	public Object getValueAt(int linha, int coluna) {
		Medico m = listaEntidades.get(linha);
		Object o;
		
		switch (coluna) {
			case 0:
				o = m.getCodigo();
			break;
	
			case 1:
				o = m.getNome();
			break;
	
			case 2:
				o = m.getDataNascimento();
			break;

			case 3:
				o = m.getRg();
			break;

			case 4:
				o = m.getCpf();
			break;

			case 5:
				o = m.getSexo();
			break;

			case 6:
				o = m.getEndereco().toString();
			break;

			case 7:
				o = m.getTelefone();
			break;

			case 8:
				o = m.getCelular();
			break;

			case 9:
				o = m.getEmail();
			break;

			case 10:
				o = m.getCrm();
			break;

			default:
				o = "";
			break;
		}
		
		return o;
	}


	@Override
	protected void atualizarComboBoxModel() {
		cmbModel.removeAllElements();
		
		for (Medico m : listaEntidades) {
			cmbModel.addElement( m.getNome() );
		}
	}	
}
