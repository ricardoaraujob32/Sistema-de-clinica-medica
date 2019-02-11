package com.wordpress.ricardoanalistadesistemas.sistemadeclinicamedica.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.wordpress.ricardoanalistadesistemas.sistemadeclinicamedica.model.Medico;

public class MedicoDAO extends AbstractDAO<Medico> {
	
	@Override
	public void alterar(Medico medico) {
		try {
			String sql = "UPDATE medicos SET nome = ?, data_nascimento = ?, rg = ?, cpf = ?, sexo = ?, cep = ?,"
					+ "logradouro = ?, numero = ?, bairro = ?, cidade = ?, estado = ?, telefone = ?, celular = ?,"
					+ "email = ?, crm = ? WHERE codigo_paciente = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString( 1, medico.getNome() );
			ps.setDate( 2, new java.sql.Date( medico.getDataNascimento().toEpochDay() ) );
			ps.setString( 3, medico.getRg() );
			ps.setString( 4, medico.getCpf() );
			ps.setNString( 5, Character.toString( medico.getSexo() ) );
			ps.setString( 6, medico.getEndereco().getCep() );
			ps.setString( 7, medico.getEndereco().getLogradouro() );
			ps.setString( 8, medico.getEndereco().getNumero() );
			ps.setString( 9, medico.getEndereco().getBairro() );
			ps.setString( 10, medico.getEndereco().getCidade() );
			ps.setString( 11, medico.getEndereco().getEstado() );
			ps.setString( 12, medico.getTelefone() );
			ps.setString( 13, medico.getCelular() );
			ps.setString( 14, medico.getEmail() );
			ps.setString( 15, medico.getCrm() );
			ps.setInt( 16, medico.getCodigo() );
			
			int n = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}			
	}

	@Override
	public void cadastrar(Medico medico) {
		try {
			String sql = "INSERT INTO medicos(nome, data_nascimento, rg, cpf, sexo, cep, logradouro, "
					+ "numero, bairro, cidade, estado, telefone, celular, email, crm)"
					+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString( 1, medico.getNome() );
			ps.setDate( 2, new java.sql.Date( medico.getDataNascimento().toEpochDay() ) );
			ps.setString( 3, medico.getRg() );
			ps.setString( 4, medico.getCpf() );
			ps.setNString( 5, Character.toString( medico.getSexo() ) );
			ps.setString( 6, medico.getEndereco().getCep() );
			ps.setString( 7, medico.getEndereco().getLogradouro() );
			ps.setString( 8, medico.getEndereco().getNumero() );
			ps.setString( 9, medico.getEndereco().getBairro() );
			ps.setString( 10, medico.getEndereco().getCidade() );
			ps.setString( 11, medico.getEndereco().getEstado() );
			ps.setString( 12, medico.getTelefone() );
			ps.setString( 13, medico.getCelular() );
			ps.setString( 14, medico.getEmail() );
			ps.setString( 15, medico.getCrm() );
			
			int n = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deletar(Medico medico) {
		try {
			String sql = "DELETE FROM medicos WHERE codigo_medico = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt( 1, medico.getCodigo() );
			
			int n = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Medico> pesquisar() {
		List<Medico> lista = new LinkedList<>();
		
		try {
			String sql = "SELECT * FROM medicos";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while ( rs.next() ) {
				Medico m = new Medico();
				
				m.setCodigo( rs.getInt("codigo_paciente") );
				m.setNome( rs.getString("nome") );
				m.setDataNascimento( rs.getDate("data_nascimento").toLocalDate() );
				m.setRg( rs.getString("rg") );
				m.setCpf( rs.getString("cpf") );
				m.setSexo( rs.getNString("sexo").charAt(0) );
				m.getEndereco().setCep( rs.getString("cep") );
				m.getEndereco().setLogradouro( rs.getString("logradouro") );
				m.getEndereco().setNumero( rs.getString("numero") );
				m.getEndereco().setBairro( rs.getString("bairro") );
				m.getEndereco().setCidade( rs.getString("cidade") );
				m.getEndereco().setEstado( rs.getString("estado") );
				m.setTelefone( rs.getString("telefone") );
				m.setCelular( rs.getString("celular") );
				m.setEmail( rs.getString("email") );
				m.setCrm( rs.getString("crm") );
				
				lista.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lista;
	}
}
