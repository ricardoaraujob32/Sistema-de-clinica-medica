package controller;

import dao.PacienteDAOImpl;
import model.Paciente;

public class PacientesController extends AbstractControlador<Paciente> {

	public PacientesController() {
		String nomes[] = {"Código", "Nome", "Empresa", "RG", "CPF", "Data de nascimento", "Sexo", 
				"Endereço", "Telefone", "Celular", "E-Mail"};
		setNomeColunas(nomes);
		
		Class<?> tipos[] = {Integer.class, String.class, String.class, String.class, String.class,
				String.class, String.class, String.class, String.class};
		setTipoColunas(tipos);
		
		dao = new PacienteDAOImpl();
	}
	
	@Override
	protected void atualizarComboBoxModel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object getValueAt(int linha, int coluna) {
		// TODO Auto-generated method stub
		return null;
	}

}
