package dao;

import java.sql.Date;

import model.Paciente;

public class PacienteRegistro extends AbstractRegistro<Paciente> {

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
	
	public PacienteRegistro() {
		
	}
	
	public PacienteRegistro(Paciente paciente) {
		super(paciente);
	}
	
	public int getCodigoPaciente() {
		return codigoPaciente;
	}
	
	public int getCodigoEmpresa() {
		return codigoEmpresa;
	}
	
	public String getNome() {
		return nome;
	}
	
	public Date getDataNascimento() {
		return dataNascimento;
	}
	
	public String getRg() {
		return rg;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public String getSexo() {
		return sexo;
	}
	
	public String getCep() {
		return cep;
	}
	
	public String getLogradouro() {
		return logradouro;
	}
	
	public String getNumero() {
		return numero;
	}
	
	public String getBairro() {
		return bairro;
	}
	
	public String getCidade() {
		return cidade;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public String getCelular() {
		return celular;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setCodigoPaciente(int codigoPaciente) {
		this.codigoPaciente = codigoPaciente;
	}
	
	public void setCodigoEmpresa(int codigoEmpresa) {
		this.codigoEmpresa = codigoEmpresa;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public void setRg(String rg) {
		this.rg = rg;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	public void setCep(String cep) {
		this.cep = cep;
	}
	
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public void setCelular(String celular) {
		this.celular = celular;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

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
}

