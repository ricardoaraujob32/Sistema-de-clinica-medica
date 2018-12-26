package controller;

import javax.swing.DefaultComboBoxModel;

public class EstadosComboBoxModel extends DefaultComboBoxModel<String> {
	private static String nomesEstados[] = {"AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA", "MG", "MS", "MT",
			"PA", "PB", "PE", "PI", "PR", "RJ", "RN", "RO", "RR", "RS", "SC", "SE", "SP", "TO"};
	
	public EstadosComboBoxModel() {
		super(nomesEstados);
	}
}
