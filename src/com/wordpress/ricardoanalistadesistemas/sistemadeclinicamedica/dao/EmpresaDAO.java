package com.wordpress.ricardoanalistadesistemas.sistemadeclinicamedica.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.wordpress.ricardoanalistadesistemas.sistemadeclinicamedica.model.Empresa;

public class EmpresaDAO extends AbstractDAO<Empresa> {
    private static final String EMPRESAS = "empresas";
    private static final String CODIGO_CONVENIO = "codigo_convenio";
    private static final String NOME_FANTASIA = "nome_fantasia";
    private static final String RAZAO_SOCIAL = "razao_social";
    private static final String CNPJ = "cnpj";
    private static final String TELEFONE = "telefone";
    private static final String CONTATO = "contato";
    private static final String SITE = "site";
    private static final String CODIGO_EMPRESA = "codigo_empresa";
        
    @Override
    public void alterar(Empresa empresa) throws GenericDAOException {
        String sql = String.format("UPDATE %s SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ? WHERE %s = ?",
                EMPRESAS, CODIGO_CONVENIO, NOME_FANTASIA, RAZAO_SOCIAL, CNPJ, TELEFONE, CONTATO, SITE, CODIGO_EMPRESA);
        
        try {            
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
            throw new GenericDAOException(e);
        }			
    }

    @Override
    public void cadastrar(Empresa empresa) throws GenericDAOException {
        String sql = String.format("INSERT INTO %s(%s, %s, %s, %s, %s, %s, %s) VALUES(?, ?, ?, ?, ?, ?, ?)",
                EMPRESAS, CODIGO_CONVENIO, NOME_FANTASIA, RAZAO_SOCIAL, CNPJ, TELEFONE, CONTATO, SITE);
        
        try {            
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
            throw new GenericDAOException(e);
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
