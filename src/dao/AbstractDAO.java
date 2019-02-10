package dao;

import java.sql.Connection;
import model.Entidade;

public abstract class AbstractDAO<E extends Entidade> implements DAO<E> {
	protected Connection con;
	
	public AbstractDAO() throws GenericDAOException {
            con = GerenciadorConexao.getInstance().getConnection();
	}
}
