package com.wordpress.ricardoanalistadesistemas.sistemadeclinicamedica.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.LinkedList;
import java.util.List;

import com.wordpress.ricardoanalistadesistemas.sistemadeclinicamedica.model.AlocacaoMedicos;

public class AlocacaoMedicosDAO extends AbstractDAO<AlocacaoMedicos> {
	
	@Override
	public void alterar(AlocacaoMedicos aloc) {
            try {
                String sql = "UPDATE alocacao_medicos SET data_alocacao = ?, horario_alocacao = ?, "
                                + "codigo_medico = ?, codigo_clinica = ?, codigo_especialidade = ? "
                                + "WHERE data_alocacao = ? AND horario_alocacao = ? AND codigo_medico = ?";
                PreparedStatement ps = con.prepareStatement(sql);

                ps.setDate( 1, Date.valueOf( aloc.getDataAlocacao() ) );
                ps.setTime( 2, Time.valueOf( aloc.getHorarioAlocacao() ) );
                ps.setInt( 3, aloc.getCodigoMedico() );
                ps.setInt( 4, aloc.getCodigoClinica() );
                ps.setInt( 5, aloc.getCodigoEspecialidade() );
                ps.setDate( 6, Date.valueOf( aloc.getDataAlocacao() ) );
                ps.setTime( 7, Time.valueOf( aloc.getHorarioAlocacao() ) );
                ps.setInt( 8, aloc.getCodigoMedico() );

                int n = ps.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
	}

	@Override
	public void cadastrar(AlocacaoMedicos aloc) {
            try {
                String sql = "INSERT INTO alocacao_medicos(data_alocacao, horario_alocacao, codigo_medico, codigo_clinica, "
                                + "codigo_especialidade VALUES(?, ?, ?, ?, ?)";
                PreparedStatement ps = con.prepareStatement(sql);

                ps.setDate( 1, Date.valueOf( aloc.getDataAlocacao() ) );
                ps.setTime( 2, Time.valueOf( aloc.getHorarioAlocacao() ) );
                ps.setInt( 3, aloc.getCodigoMedico() );
                ps.setInt( 4, aloc.getCodigoClinica() );
                ps.setInt( 5, aloc.getCodigoEspecialidade() );

                int n = ps.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
	}

	@Override
	public void deletar(AlocacaoMedicos aloc) {
            try {
                    String sql = "DELETE FROM alocacao_medicos "
                                    + "WHERE data_alocacao = ? AND horario_alocacao = ? AND codigo_medico = ?";
                    PreparedStatement ps = con.prepareStatement(sql);

                    ps.setDate( 1, Date.valueOf( aloc.getDataAlocacao() ) );
                    ps.setTime( 2, Time.valueOf( aloc.getHorarioAlocacao() ) );
                    ps.setInt( 3, aloc.getCodigoMedico() );

                    int n = ps.executeUpdate();
            } catch (SQLException e) {
                    e.printStackTrace();
            }	
	}

	@Override
	public List<AlocacaoMedicos> pesquisar() {
            List<AlocacaoMedicos> lista = new LinkedList<>();

            try {
                    String sql = "SELECT * FROM alocacao_medicos";
                    PreparedStatement ps = con.prepareStatement(sql);
                    ResultSet rs = ps.executeQuery();

                    while ( rs.next() ) {
                            AlocacaoMedicos a = new AlocacaoMedicos();

                            a.setDataAlocacao( rs.getDate("data_alocacao").toLocalDate() );
                            a.setHorarioAlocacao( rs.getTime("horario_alocacao").toLocalTime() );
                            a.setCodigoMedico( rs.getInt("codigo_medico") );
                            a.setCodigoClinica( rs.getInt("codigo_clinica") );
                            a.setCodigoEspecialidade( rs.getInt("codigo_especialidade") );

                            lista.add(a);
                    }
            } catch (SQLException e) {
                    e.printStackTrace();
            }

            return lista;
	}
}
