package com.wordpress.ricardoanalistadesistemas.sistemadeclinicamedica.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.wordpress.ricardoanalistadesistemas.sistemadeclinicamedica.model.Clinica;

public class ClinicaDAO extends AbstractDAO<Clinica> {
    private static final String CLINICAS = "clinicas";
    private static final String CODIGO_CLINICA = "codigo_clinica";
    private static final String CEP = "cep";
    private static final String LOGRADOURO = "logradouro";
    private static final String NUMERO = "numero";
    private static final String BAIRRO = "bairro";
    private static final String CIDADE = "cidade";
    private static final String ESTADO = "estado";
    
    @Override
    public void alterar(Clinica clinica) throws GenericDAOException {
        try {
            String sql = String.format("UPDATE %s SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ? "
                            + "WHERE %s = ?", CLINICAS, CEP, LOGRADOURO, NUMERO, BAIRRO, CIDADE, ESTADO, CODIGO_CLINICA);
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString( 1, clinica.getEndereco().getCep() );
            ps.setString( 2, clinica.getEndereco().getLogradouro() );
            ps.setString( 3, clinica.getEndereco().getNumero() );
            ps.setString( 4, clinica.getEndereco().getBairro() );
            ps.setString( 5, clinica.getEndereco().getCidade()  );
            ps.setString( 6, clinica.getEndereco().getEstado() );
            ps.setInt(    7, clinica.getCodigo() );

            int n = ps.executeUpdate();
        } catch (SQLException e) {
            throw new GenericDAOException(e);
        }				
    }

    @Override
    public void cadastrar(Clinica clinica) throws GenericDAOException {
        try {
            String sql = String.format("INSERT INTO %s(%s, %s, %s, %s, %s, %s VALUES(?, ?, ?, ?, ?, ?)",
                    CLINICAS, CEP, LOGRADOURO, NUMERO, BAIRRO, CIDADE, ESTADO);
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString( 1, clinica.getEndereco().getCep() );
            ps.setString( 2, clinica.getEndereco().getLogradouro() );
            ps.setString( 3, clinica.getEndereco().getNumero() );
            ps.setString( 4, clinica.getEndereco().getBairro() );
            ps.setString( 5, clinica.getEndereco().getCidade()  );
            ps.setString( 6, clinica.getEndereco().getEstado() );

            int n = ps.executeUpdate();
        } catch (SQLException e) {
            throw new GenericDAOException(e);
        }
    }

    @Override
    public void deletar(Clinica clinica) throws GenericDAOException {
        try {
            String sql = String.format("DELETE FROM %s WHERE %s = ?", CLINICAS, CODIGO_CLINICA);
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt( 1, clinica.getCodigo() );

            int n = ps.executeUpdate();
        } catch (SQLException e) {
            throw new GenericDAOException(e);
        }	
    }

    @Override
    public List<Clinica> pesquisar() throws GenericDAOException {
        List<Clinica> lista = new LinkedList<Clinica>();

        try {
            String sql = String.format("SELECT * FROM %s", CLINICAS);
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while ( rs.next() ) {
                Clinica c = new Clinica();

                c.setCodigo( rs.getInt(CODIGO_CLINICA) );
                c.getEndereco().setCep( rs.getString(CEP) );
                c.getEndereco().setLogradouro( rs.getString(LOGRADOURO) );
                c.getEndereco().setNumero( rs.getString(NUMERO) );
                c.getEndereco().setBairro( rs.getString(BAIRRO) );
                c.getEndereco().setCidade( rs.getString(CIDADE) );
                c.getEndereco().setEstado( rs.getString(ESTADO) );

                lista.add(c);
            }
        } catch (SQLException e) {
            throw new GenericDAOException(e);
        }

        return lista;
    }
}
