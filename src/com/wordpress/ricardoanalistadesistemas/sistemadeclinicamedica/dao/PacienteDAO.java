package com.wordpress.ricardoanalistadesistemas.sistemadeclinicamedica.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.wordpress.ricardoanalistadesistemas.sistemadeclinicamedica.model.Paciente;

public class PacienteDAO extends AbstractDAO<Paciente> {
	private int codigoPaciente;
	private int codigoEmpresa;
	private String nome;
	private Date dataNascimento;
	private String rg;
	private String cpf;
	private String sexo;
	private String cep;
	private String logradouro;
	private String numero;
	private String bairro;
	private String cidade;
	private String estado;
	private String telefone;
	private String celular;
	private String email;
	
	public PacienteDAO() {
		//listaRegistros = new LinkedList< PacienteRegistro >();
	}
	
	@Override
	public void alterar(Paciente paciente) {
		entidadeToDAO(paciente);
		String sql = "UPDATE pacientes SET codigo_empresa = ?, nome = ?, data_nascimento = ?, rg = ?, "
				+ "cpf = ?, sexo = ?, cep = ?, logradouro = ?, numero = ?, bairro = ?, cidade = ?, estado = ?,"
				+ "telefone = ?, celular = ?, email = ? WHERE codigo_paciente = ?";
		try {
			executarINSERTouUPDATE(sql, true);
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}

	@Override
	public void cadastrar(Paciente paciente) {
		entidadeToDAO(paciente);
		String sql = "INSERT INTO pacientes(codigo_empresa, nome, data_nascimento, rg, cpf, sexo, cep, logradouro, "
				+ "numero, bairro, cidade, estado, telefone, celular, email)"
				+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			executarINSERTouUPDATE(sql, false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deletar(Paciente paciente) {
		entidadeToDAO(paciente);
		String sql = "DELETE FROM pacientes WHERE codigo_paciente = ?";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt( 1, codigoPaciente );
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Paciente> pesquisar() {
		List<Paciente> lista = new LinkedList<>();
		String sql = "SELECT * FROM pacientes";
		
		try {
			ResultSet rs = executarSELECT(sql);
			
			while ( rs.next() ) {
				carregarListaRegistros(rs);				
				lista.add( DAOToEntidade() );
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lista;
	}

	/**
	 * Mapeia uma entidade da aplica��o para uma entidade do banco de dados
	 */
	@Override
	public void entidadeToDAO(Paciente paciente) {
		codigoPaciente = paciente.getCodigo();
		codigoEmpresa = paciente.getCodigoEmpresa();
		nome = paciente.getNome();
		dataNascimento = new Date( paciente.getDataNascimento().toEpochDay() );
		rg = paciente.getRg();
		cpf = paciente.getCpf();
		sexo = paciente.getSexo();
		cep = paciente.getEndereco().getCep();
		logradouro = paciente.getEndereco().getLogradouro();
		numero = paciente.getEndereco().getNumero();
		bairro = paciente.getEndereco().getBairro();
		cidade = paciente.getEndereco().getCidade();
		estado = paciente.getEndereco().getEstado();
		telefone = paciente.getTelefone();
		celular = paciente.getCelular();
		email = paciente.getEmail();		
	}

	@Override
	public Paciente DAOToEntidade() {
		Paciente paciente = new Paciente();
		
		paciente.setCodigo(codigoPaciente);
		paciente.setCodigoEmpresa(codigoEmpresa);
		paciente.setNome(nome);
		paciente.setDataNascimento( dataNascimento.toLocalDate() );
		paciente.setRg(rg);
		paciente.setCpf(cpf);
		paciente.setSexo(sexo);
		paciente.getEndereco().setCep(cep);
		paciente.getEndereco().setLogradouro(logradouro);
		paciente.getEndereco().setNumero(numero);
		paciente.getEndereco().setBairro(bairro);
		paciente.getEndereco().setCidade(cidade);
		paciente.getEndereco().setEstado(estado);
		paciente.setTelefone(telefone);
		paciente.setCelular(celular);
		paciente.setEmail(email);
		
		return paciente;
	}

	@Override
	protected void executarINSERTouUPDATE(String sql, boolean usarCodigo) throws SQLException {
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setInt( 1, codigoEmpresa );
		ps.setString( 2, nome );
		ps.setDate( 3, dataNascimento );
		ps.setString( 4, rg );
		ps.setString( 5, cpf );
		ps.setNString( 6, sexo );
		ps.setString( 7, cep );
		ps.setString( 8, logradouro );
		ps.setString( 9, numero );
		ps.setString( 10, bairro );
		ps.setString( 11, cidade );
		ps.setString( 12, estado );
		ps.setString( 13, telefone );
		ps.setString( 14, celular );
		ps.setString( 15, email );
		
		if (usarCodigo) {
			ps.setInt(16, codigoPaciente);
		}
		
		ps.executeUpdate();
	}

	@Override
	protected ResultSet executarSELECT(String sql) throws SQLException {
		PreparedStatement ps = con.prepareStatement(sql);
		 return ps.executeQuery();
	}
	
	private void carregarListaRegistros(ResultSet rs) throws SQLException {
		PacienteRegistro pr = new PacienteRegistro();
		
		pr.setCodigoPaciente( rs.getInt("codigo_paciente") );
		pr.setCodigoEmpresa( rs.getInt("codigo_empresa") );
		pr.setNome( rs.getString("nome") );
		pr.setDataNascimento( rs.getDate("data_nascimento") );
		pr.setRg( rs.getString("rg") );
		pr.setCpf( rs.getString("cpf") );
		pr.setSexo( rs.getString("sexo") );
		pr.setCep( rs.getString("cep") );
		pr.setLogradouro( rs.getString("logradouro") );
		pr.setNumero( rs.getString("numero") );
		pr.setBairro( rs.getString("bairro") );
		pr.setCidade( rs.getString("cidade") );
		pr.setEstado( rs.getString("estado") );
		pr.setTelefone( rs.getString("telefone") );
		pr.setCelular( rs.getString("celular") );
		pr.setEmail( rs.getString("email") );
		
		listaRegistros.add(pr);
	}
	
	
}
