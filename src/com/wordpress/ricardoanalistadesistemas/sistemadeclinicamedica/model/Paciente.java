package com.wordpress.ricardoanalistadesistemas.sistemadeclinicamedica.model;

public class Paciente extends PessoaFisica {
	private int codigoEmpresa;
	
	public int getCodigoEmpresa() {
		return codigoEmpresa;
	}

	public void setCodigoEmpresa(int codigoEmpresa) {
		this.codigoEmpresa = codigoEmpresa;
	}
}
