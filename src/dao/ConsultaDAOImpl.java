package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.LinkedList;
import java.util.List;

import model.Consulta;

public class ConsultaDAOImpl extends AbstractDAO<Consulta> {
	
	@Override
	public void alterar(Consulta consulta) {
		try {
			String sql = "UPDATE consultas SET codigo_paciente = ?, codigo_medico = ?, data_alocacao = ?, horario_alocacao = ?, "
					+ "duracao = ?, tipo_consulta = ?, cancelada = ?, sintomas = ?, possivel_molestia = ?, "
					+ "prescricao = ? WHERE codigo_consulta = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt( 1, consulta.getCodigoPaciente() );
			ps.setInt( 2, consulta.getAlocacaoMedicos().getCodigoMedico() );
			ps.setDate( 3, Date.valueOf( consulta.getAlocacaoMedicos().getDataAlocacao() ) );
			ps.setTime( 4, Time.valueOf( consulta.getAlocacaoMedicos().getHorarioAlocacao() ) );
			ps.setTime( 5, Time.valueOf( consulta.getDuracao() )  );
			ps.setInt( 6, consulta.getTipoConsulta() );
			ps.setBoolean( 7, consulta.isCancelada() );
			ps.setString( 8, consulta.getSintomas() );
			ps.setString( 9, consulta.getPossivelMolestia() );
			ps.setString( 10, consulta.getPrescricao() );
			ps.setInt( 11, consulta.getCodigo() );
			
			int n = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}				
	}

	@Override
	public void cadastrar(Consulta consulta) {
		try {
			String sql = "INSERT INTO consultas(codigo_paciente, codigo_medico, data_alocacao, "
					+ "horario_alocacao, duracao, tipo_consulta, cancelada, sintomas, possivel_molestia, prescricao) "
					+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt( 1, consulta.getCodigoPaciente() );
			ps.setInt( 2, consulta.getAlocacaoMedicos().getCodigoMedico() );
			ps.setDate( 3, Date.valueOf( consulta.getAlocacaoMedicos().getDataAlocacao() ) );
			ps.setTime( 4, Time.valueOf( consulta.getAlocacaoMedicos().getHorarioAlocacao() ) );
			ps.setTime( 5, Time.valueOf( consulta.getDuracao() )  );
			ps.setInt( 6, consulta.getTipoConsulta() );
			ps.setBoolean( 7, consulta.isCancelada() );
			ps.setString( 8, consulta.getSintomas() );
			ps.setString( 9, consulta.getPossivelMolestia() );
			ps.setString( 10, consulta.getPrescricao() );
			
			int n = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deletar(Consulta consulta) {
		try {
			String sql = "DELETE FROM consultas WHERE codigo_consulta = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt( 1, consulta.getCodigo() );
			
			int n = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

	@Override
	public List<Consulta> pesquisar() {
		List<Consulta> lista = new LinkedList<>();
		
		try {
			String sql = "SELECT * FROM consultas";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while ( rs.next() ) {
				Consulta c = new Consulta();
				
				c.setCodigo( rs.getInt("codigo_consulta") );
				c.setCodigoPaciente( rs.getInt("codigo_paciente") );
				c.getAlocacaoMedicos().setCodigoMedico( rs.getInt("codigo_medico") );
				c.getAlocacaoMedicos().setDataAlocacao( rs.getDate("data_alocacao").toLocalDate() );
				c.getAlocacaoMedicos().setHorarioAlocacao( rs.getTime("horario_alocacao").toLocalTime() );
				c.setDuracao( rs.getTime("duracao").toLocalTime() );
				c.setTipoConsulta( rs.getInt("tipo_consulta") );
				c.setCancelada( rs.getBoolean("cancelada") );
				c.setSintomas( rs.getString("sintomas") );
				c.setPossivelMolestia( rs.getString("possivel_molestia") );
				c.setPrescricao( rs.getString("prescricao") );
																
				lista.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lista;
	}
}
