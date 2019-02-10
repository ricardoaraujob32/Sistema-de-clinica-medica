package dao;

import java.util.List;
import model.Entidade;

public interface DAO<E extends Entidade> {
	void alterar(E entidade) throws GenericDAOException;
	void cadastrar(E entidade) throws GenericDAOException;
	void deletar(E entidade) throws GenericDAOException;
	List<E> pesquisar() throws GenericDAOException;
}
