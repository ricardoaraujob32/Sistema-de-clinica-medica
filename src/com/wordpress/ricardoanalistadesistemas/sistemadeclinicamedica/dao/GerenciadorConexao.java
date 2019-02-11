/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wordpress.ricardoanalistadesistemas.sistemadeclinicamedica.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ricardobalduino
 */
public class GerenciadorConexao {
    private Connection con;
    
    private GerenciadorConexao() throws GenericDAOException {
        final String URL = "jdbc:mariadb://localhost:3303/clinica_medica";
        final String USUARIO = "root";
        final String SENHA = "root";

        try {
            Class.forName("org.mariadb.jdbc.Driver");
            con = DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (ClassNotFoundException e) {
            throw new GenericDAOException("Classe não encontrada", e);
        } catch (SQLException e) {
            throw new GenericDAOException("Erro com a conexão", e);
        }	
    }
    
    public Connection getConnection(){
        return con;
    }
    
    public void fecharConexao(){
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(GerenciadorConexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static GerenciadorConexao getInstance() throws GenericDAOException {
        return GerenciadorConexaoHolder.getGerenciador();
    }
    
    private static class GerenciadorConexaoHolder {

        private static GerenciadorConexao INSTANCE;
        
        public static GerenciadorConexao getGerenciador() throws GenericDAOException{
            if (INSTANCE == null){
                INSTANCE = new GerenciadorConexao();
            }
            
            return INSTANCE;
        }
        
        
    }
}
