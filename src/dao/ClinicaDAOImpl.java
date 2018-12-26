package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import model.Clinica;

public class ClinicaDAOImpl extends AbstractDAO<Clinica> {
	
	@Override
	public void alterar(Clinica clinica) {
		try {
			String sql = "UPDATE clinicas SET cep = ?, logradouro = ?, numero = ?, bairro = ?, cidade = ?, estado = ? "
					+ "WHERE codigo_clinica = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString( 1, clinica.getEndereco().getCep() );
			ps.setString( 2, clinica.getEndereco().getLogradouro() );
			ps.setString( 3, clinica.getEndereco().getNumero() );
			ps.setString( 4, clinica.getEndereco().getBairro() );
			ps.setString( 5, clinica.getEndereco().getCidade()  );
			ps.setString( 6, clinica.getEndereco().getEstado() );
			ps.setInt( 7, clinica.getCodigo() );
			
			int n = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}				
	}

	@Override
	public void cadastrar(Clinica clinica) {
		try {
			String sql = "INSERT INTO clinicas(cep, logradouro, numero, bairro, cidade, estado "
					+ "VALUES(?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString( 1, clinica.getEndereco().getCep() );
			ps.setString( 2, clinica.getEndereco().getLogradouro() );
			ps.setString( 3, clinica.getEndereco().getNumero() );
			ps.setString( 4, clinica.getEndereco().getBairro() );
			ps.setString( 5, clinica.getEndereco().getCidade()  );
			ps.setString( 6, clinica.getEndereco().getEstado() );
			
			int n = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deletar(Clinica clinica) {
		try {
			String sql = "DELETE FROM clinicas WHERE codigo_clinica = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt( 1, clinica.getCodigo() );
			
			int n = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

	@Override
	public List<Clinica> pesquisar() {
		List<Clinica> lista = new LinkedList<>();
		
		try {
			String sql = "SELECT * FROM clinicas";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while ( rs.next() ) {
				Clinica c = new Clinica();
				
				c.setCodigo( rs.getInt("codigo_clinica") );
				c.getEndereco().setCep( rs.getString("cep") );
				c.getEndereco().setLogradouro( rs.getString("logradouro") );
				c.getEndereco().setNumero( rs.getString("numero") );
				c.getEndereco().setBairro( rs.getString("bairro") );
				c.getEndereco().setCidade( rs.getString("cidade") );
				c.getEndereco().setEstado( rs.getString("estado") );
																
				lista.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lista;
	}
}
