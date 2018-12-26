package dao;

import java.util.List;

public interface DAO<E> {
	void alterar(E entidade);
	void cadastrar(E entidade);
	void deletar(E entidade);
	List<E> pesquisar();
	void fecharConexao();
	void entidadeToDAO(E entidade);
	E DAOToEntidade();
}
