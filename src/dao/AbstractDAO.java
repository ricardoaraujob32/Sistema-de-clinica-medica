package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public abstract class AbstractDAO<E> implements DAO<E> {
	protected Connection con;
	protected LinkedList< Registro<E> > listaRegistros;
	
	public AbstractDAO() {
		final String URL = "jdbc:mariadb://localhost:3303/clinica_medica?allowMultiQueries=true";
		final String USUARIO = "root";
		final String SENHA = "root";
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			con = DriverManager.getConnection(URL, USUARIO, SENHA);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	@Override
	public void fecharConexao() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	protected abstract void executarINSERTouUPDATE(String sql, boolean usarCodigo) throws SQLException;
	
	protected abstract ResultSet executarSELECT(String sql) throws SQLException;
}
