package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import model.Especialidade;

public class EspecialidadeDAOImpl extends AbstractDAO<Especialidade> {
		
	@Override
	public void alterar(Especialidade especialidade) {
		if (especialidade == null) {
			throw new NullPointerException("Especialidade nula");
		}
		
		try {
			String sql = "UPDATE especialidades SET descricao = ? WHERE codigo_especialidade = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString( 1, especialidade.getDescricao() );
			ps.setInt( 2, especialidade.getCodigo() );
			
			int n = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}			
		
	}

	@Override
	public void cadastrar(Especialidade especialidade) {
		if (especialidade == null) {
			throw new NullPointerException("Especialidade nula");
		}
		
		try {
			String sql = "INSERT INTO especialidades(descricao)"
					+ "VALUES(?)";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString( 1, especialidade.getDescricao() );
			
			int n = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deletar(Especialidade especialidade) {
		try {
			String sql = "DELETE FROM especialidades WHERE codigo_especialidade = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt( 1, especialidade.getCodigo() );
			
			int n = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}

	@Override
	public List<Especialidade> pesquisar() {
		List<Especialidade> lista = new LinkedList<>();
		
		try {
			String sql = "SELECT * FROM especialidades";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while ( rs.next() ) {
				Especialidade e = new Especialidade();
				
				e.setCodigo( rs.getInt("codigo_especialidade") );
				e.setDescricao( rs.getString("descricao") );
				
				lista.add(e);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lista;
	}	

}
