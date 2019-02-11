package com.wordpress.ricardoanalistadesistemas.sistemadeclinicamedica.model;

public class Empresa extends PessoaJuridica {
	private int codigoConvenio;
    
	public int getCodigoConvenio() {
		return codigoConvenio;
	}

	public void setCodigoConvenio(int codigoConvenio) {
		this.codigoConvenio = codigoConvenio;
	}
}
