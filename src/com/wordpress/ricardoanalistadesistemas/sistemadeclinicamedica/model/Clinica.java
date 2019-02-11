package com.wordpress.ricardoanalistadesistemas.sistemadeclinicamedica.model;

public class Clinica extends Entidade {
    private Endereco endereco;

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Endereco getEndereco() {
        return endereco;
    }
}
