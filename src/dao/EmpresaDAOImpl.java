package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import model.Empresa;

public class EmpresaDAOImpl extends AbstractDAO<Empresa> {
	
	@Override
	public void alterar(Empresa empresa) {
		try {
			String sql = "UPDATE empresas SET codigo_convenio = ?, nome_fantasia = ?, razao_social = ?, cnpj = ?, "
					+ "telefone = ?, contato = ?, site = ? WHERE codigo_empresa = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt( 1, empresa.getCodigoConvenio() );
			ps.setString( 2, empresa.getNome() );
			ps.setString( 3, empresa.getRazaoSocial() );
			ps.setString( 4, empresa.getCnpj() );
			ps.setString( 5, empresa.getTelefone() );
			ps.setString( 6, empresa.getContato() );
			ps.setString( 7, empresa.getSite() );
			ps.setInt( 8, empresa.getCodigo() );
			
			int n = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}			
	}

	@Override
	public void cadastrar(Empresa empresa) {
		try {
			String sql = "INSERT INTO empresas(codigo_convenio, nome_fantasia, razao_social, cnpj, telefone, contato, site)"
					+ "VALUES(?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt( 1, empresa.getCodigoConvenio() );
			ps.setString( 2, empresa.getNome() );
			ps.setString( 3, empresa.getRazaoSocial() );
			ps.setString( 4, empresa.getCnpj() );
			ps.setString( 5, empresa.getTelefone() );
			ps.setString( 6, empresa.getContato() );
			ps.setString( 7, empresa.getSite() );
			
			int n = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deletar(Empresa empresa) {
		try {
			String sql = "DELETE FROM empresas WHERE codigo_empresa = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt( 1, empresa.getCodigo() );
			
			int n = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}			
	}

	@Override
	public List<Empresa> pesquisar() {
		List<Empresa> lista = new LinkedList<>();
		
		try {
			String sql = "SELECT * FROM empresas";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while ( rs.next() ) {
				Empresa e = new Empresa();
				
				e.setCodigo( rs.getInt("codigo_empresa") );
				e.setCodigoConvenio( rs.getInt("codigo_convenio") );
				e.setNome( rs.getString("nome_fantasia") );
				e.setRazaoSocial( rs.getString("razao_social") );
				e.setCnpj( rs.getString("cnpj") );
				e.setTelefone( rs.getString("telefone") );
				e.setContato( rs.getString("contato") );
				e.setSite( rs.getString("site") );
												
				lista.add(e);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lista;
	}
}
