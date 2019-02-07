package dao;

import java.util.List;

public interface DAO<E> {
	void alterar(E entidade) throws GenericDAOException;
	void cadastrar(E entidade) throws GenericDAOException;
	void deletar(E entidade) throws GenericDAOException;
	List<E> pesquisar() throws GenericDAOException;
}
