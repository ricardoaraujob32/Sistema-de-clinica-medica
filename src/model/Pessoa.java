package model;

public abstract class Pessoa extends Entidade {
    protected String nome;
    protected String telefone;
    
	public String getNome() {
		return nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
    
    
}
