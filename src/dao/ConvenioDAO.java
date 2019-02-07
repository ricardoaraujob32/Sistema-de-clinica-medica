package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import model.Convenio;

public class ConvenioDAO extends AbstractDAO<Convenio> {
	
	@Override
	public void alterar(Convenio convenio) {
		try {
			String sql = "UPDATE convenios SET nome_fantasia = ?, razao_social = ?, cnpj = ?, "
					+ "telefone = ?, contato = ?, site = ? WHERE codigo_convenio = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString( 1, convenio.getNome() );
			ps.setString( 2, convenio.getRazaoSocial() );
			ps.setString( 3, convenio.getCnpj() );
			ps.setString( 4, convenio.getTelefone() );
			ps.setString( 5, convenio.getContato() );
			ps.setString( 6, convenio.getSite() );
			ps.setInt( 7, convenio.getCodigo() );
			
			int n = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}

	@Override
	public void cadastrar(Convenio convenio) {
		try {
			String sql = "INSERT INTO convenios(nome_fantasia, razao_social, cnpj, telefone, contato, site)"
					+ "VALUES(?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString( 1, convenio.getNome() );
			ps.setString( 2, convenio.getRazaoSocial() );
			ps.setString( 3, convenio.getCnpj() );
			ps.setString( 4, convenio.getTelefone() );
			ps.setString( 5, convenio.getContato() );
			ps.setString( 6, convenio.getSite() );
			
			int n = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deletar(Convenio convenio) {
		try {
			String sql = "DELETE FROM convenios WHERE codigo_convenio = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt( 1, convenio.getCodigo() );
			
			int n = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}

	@Override
	public List<Convenio> pesquisar() {
		List<Convenio> lista = new LinkedList<>();
		
		try {
			String sql = "SELECT * FROM convenios";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while ( rs.next() ) {
				Convenio c = new Convenio();
				
				c.setCodigo( rs.getInt("codigo_empresa") );
				c.setNome( rs.getString("nome_fantasia") );
				c.setRazaoSocial( rs.getString("razao_social") );
				c.setCnpj( rs.getString("cnpj") );
				c.setTelefone( rs.getString("telefone") );
				c.setContato( rs.getString("contato") );
				c.setSite( rs.getString("site") );
												
				lista.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lista;
	}
}
