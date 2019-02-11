package com.wordpress.ricardoanalistadesistemas.sistemadeclinicamedica.model;

import java.time.LocalDate;

public abstract class PessoaFisica extends Pessoa {
	protected LocalDate dataNascimento;
    protected String rg;
    protected String cpf;
    protected String sexo;
    protected String celular;
    protected String email;
    protected Endereco endereco;
    
    public void setCelular(String celular) {
        this.celular = celular;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCelular() {
        return celular;
    }

    public String getCpf() {
        return cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public String getRg() {
        return rg;
    }

    public String getSexo() {
        return sexo;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Endereco getEndereco() {
        return endereco;
    }

}
