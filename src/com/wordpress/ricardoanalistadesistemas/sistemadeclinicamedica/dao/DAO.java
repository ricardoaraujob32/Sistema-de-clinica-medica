package com.wordpress.ricardoanalistadesistemas.sistemadeclinicamedica.dao;

import java.util.List;
import com.wordpress.ricardoanalistadesistemas.sistemadeclinicamedica.model.Entidade;

public interface DAO<E extends Entidade> {
	void alterar(E entidade) throws GenericDAOException;
	void cadastrar(E entidade) throws GenericDAOException;
	void deletar(E entidade) throws GenericDAOException;
	List<E> pesquisar() throws GenericDAOException;
}
