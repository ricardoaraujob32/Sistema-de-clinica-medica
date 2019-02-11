package com.wordpress.ricardoanalistadesistemas.sistemadeclinicamedica.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.LinkedList;
import java.util.List;

import com.wordpress.ricardoanalistadesistemas.sistemadeclinicamedica.model.Consulta;

public class ConsultaDAO extends AbstractDAO<Consulta> {
    private static final String CONSULTAS = "consultas";
    private static final String CODIGO_PACIENTE = "codigo_paciente";
    private static final String CODIGO_MEDICO = "codigo_medico";
    private static final String DATA_ALOCACAO = "data_alocacao";
    private static final String HORARIO_ALOCACAO = "horario_alocacao";
    private static final String DURACAO = "duracao";
    private static final String TIPO_CONSULTA = "tipo_consulta";
    private static final String CANCELADA = "cancelada";
    private static final String SINTOMAS = "sintomas";
    private static final String POSSIVEL_MOLESTIA = "possivel_molestia";
    private static final String PRESCRICAO = "prescricao";
    private static final String CODIGO_CONSULTA = "codigo_consulta";
    
    @Override
    public void alterar(Consulta consulta) throws GenericDAOException {
        try {
            String sql = String.format("UPDATE %s SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ? WHERE %s = ?",
                    CONSULTAS, CODIGO_PACIENTE, CODIGO_MEDICO, DATA_ALOCACAO, HORARIO_ALOCACAO,
                    DURACAO, TIPO_CONSULTA, CANCELADA, SINTOMAS, POSSIVEL_MOLESTIA, PRESCRICAO, CODIGO_CONSULTA);
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(     1, consulta.getCodigoPaciente() );
            ps.setInt(     2, consulta.getAlocacaoMedicos().getCodigoMedico() );
            ps.setDate(    3, Date.valueOf( consulta.getAlocacaoMedicos().getDataAlocacao() ) );
            ps.setTime(    4, Time.valueOf( consulta.getAlocacaoMedicos().getHorarioAlocacao() ) );
            ps.setTime(    5, Time.valueOf( consulta.getDuracao() )  );
            ps.setInt(     6, consulta.getTipoConsulta() );
            ps.setBoolean( 7, consulta.isCancelada() );
            ps.setString(  8, consulta.getSintomas() );
            ps.setString(  9, consulta.getPossivelMolestia() );
            ps.setString( 10, consulta.getPrescricao() );
            ps.setInt(    11, consulta.getCodigo() );

            int n = ps.executeUpdate();
        } catch (SQLException e) {
            throw new GenericDAOException(e);
        }				
    }

    @Override
    public void cadastrar(Consulta consulta) throws GenericDAOException {
        try {
            String sql = String.format("INSERT INTO %s(%s, %s, %s, %s, %s, %s, %s, %s, %s, %s) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                    CONSULTAS, CODIGO_PACIENTE, CODIGO_MEDICO, DATA_ALOCACAO, HORARIO_ALOCACAO,
                    DURACAO, TIPO_CONSULTA, CANCELADA, SINTOMAS, POSSIVEL_MOLESTIA, PRESCRICAO);
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(     1, consulta.getCodigoPaciente() );
            ps.setInt(     2, consulta.getAlocacaoMedicos().getCodigoMedico() );
            ps.setDate(    3, Date.valueOf( consulta.getAlocacaoMedicos().getDataAlocacao() ) );
            ps.setTime(    4, Time.valueOf( consulta.getAlocacaoMedicos().getHorarioAlocacao() ) );
            ps.setTime(    5, Time.valueOf( consulta.getDuracao() )  );
            ps.setInt(     6, consulta.getTipoConsulta() );
            ps.setBoolean( 7, consulta.isCancelada() );
            ps.setString(  8, consulta.getSintomas() );
            ps.setString(  9, consulta.getPossivelMolestia() );
            ps.setString( 10, consulta.getPrescricao() );

            int n = ps.executeUpdate();
        } catch (SQLException e) {
            throw new GenericDAOException(e);
        }
    }

    @Override
    public void deletar(Consulta consulta) throws GenericDAOException {
        try {
            String sql = String.format("DELETE FROM %s WHERE %s = ?", CONSULTAS, CODIGO_CONSULTA);
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt( 1, consulta.getCodigo() );

            int n = ps.executeUpdate();
        } catch (SQLException e) {
            throw new GenericDAOException(e);
        }	
    }

    @Override
    public List<Consulta> pesquisar() throws GenericDAOException {
        List<Consulta> lista = new LinkedList<Consulta>();

        try {
            String sql = String.format("SELECT * FROM %s", CONSULTAS);
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while ( rs.next() ) {
                Consulta c = new Consulta();

                c.setCodigo( rs.getInt(CODIGO_CONSULTA) );
                c.setCodigoPaciente( rs.getInt(CODIGO_PACIENTE) );
                c.getAlocacaoMedicos().setCodigoMedico( rs.getInt(CODIGO_MEDICO) );
                c.getAlocacaoMedicos().setDataAlocacao( rs.getDate(DATA_ALOCACAO).toLocalDate() );
                c.getAlocacaoMedicos().setHorarioAlocacao( rs.getTime(HORARIO_ALOCACAO).toLocalTime() );
                c.setDuracao( rs.getTime(DURACAO).toLocalTime() );
                c.setTipoConsulta( rs.getInt(TIPO_CONSULTA) );
                c.setCancelada( rs.getBoolean(CANCELADA) );
                c.setSintomas( rs.getString(SINTOMAS) );
                c.setPossivelMolestia( rs.getString(POSSIVEL_MOLESTIA) );
                c.setPrescricao( rs.getString(PRESCRICAO) );

                lista.add(c);
            }
        } catch (SQLException e) {
            throw new GenericDAOException(e);
        }

        return lista;
    }
}
