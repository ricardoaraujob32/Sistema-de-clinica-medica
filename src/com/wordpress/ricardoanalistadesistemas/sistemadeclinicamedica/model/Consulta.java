package com.wordpress.ricardoanalistadesistemas.sistemadeclinicamedica.model;

import java.time.LocalTime;

public class Consulta extends Entidade {
	private int codigoPaciente;
	private AlocacaoMedicos alocacaoMedicos;
    private LocalTime duracao;
    private int tipoConsulta;
    private boolean cancelada;
    private String sintomas;
    private String possivelMolestia;
    private String prescricao;
	
	public int getCodigoPaciente() {
		return codigoPaciente;
	}

	public AlocacaoMedicos getAlocacaoMedicos() {
		return alocacaoMedicos;
	}

	public LocalTime getDuracao() {
		return duracao;
	}

	public int getTipoConsulta() {
		return tipoConsulta;
	}

	public boolean isCancelada() {
		return cancelada;
	}

	public String getSintomas() {
		return sintomas;
	}

	public String getPossivelMolestia() {
		return possivelMolestia;
	}

	public String getPrescricao() {
		return prescricao;
	}

	public void setCodigoPaciente(int codigoPaciente) {
		this.codigoPaciente = codigoPaciente;
	}

	public void setAlocacaoMedicos(AlocacaoMedicos alocacaoMedicos) {
		this.alocacaoMedicos = alocacaoMedicos;
	}

	public void setDuracao(LocalTime duracao) {
		this.duracao = duracao;
	}

	public void setTipoConsulta(int tipoConsulta) {
		this.tipoConsulta = tipoConsulta;
	}

	public void setCancelada(boolean cancelada) {
		this.cancelada = cancelada;
	}

	public void setSintomas(String sintomas) {
		this.sintomas = sintomas;
	}

	public void setPossivelMolestia(String possivelMolestia) {
		this.possivelMolestia = possivelMolestia;
	}

	public void setPrescricao(String prescricao) {
		this.prescricao = prescricao;
	}
    
    
}
