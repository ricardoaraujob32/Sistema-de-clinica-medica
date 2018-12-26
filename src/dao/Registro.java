package dao;

public interface Registro<E> {
	
	/**
	 * Mapeia uma entidade da aplica��o para uma entidade do banco de dados
	 */
	void entidadeToDAO(E entidade);
	
	/**
	 * 
	 * @return
	 */
	E DAOToEntidade();
}
