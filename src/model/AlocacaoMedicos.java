package model;

import java.time.LocalDate;
import java.time.LocalTime;

public class AlocacaoMedicos extends Entidade {
	private LocalDate dataAlocacao;
	private LocalTime horarioAlocacao;
	private int codigoMedico;
	private int codigoEspecialidade;
	private int codigoClinica;
	
	public LocalDate getDataAlocacao() {
		return dataAlocacao;
	}

	public LocalTime getHorarioAlocacao() {
		return horarioAlocacao;
	}

	public int getCodigoMedico() {
		return codigoMedico;
	}

	public int getCodigoEspecialidade() {
		return codigoEspecialidade;
	}

	public int getCodigoClinica() {
		return codigoClinica;
	}

	public void setDataAlocacao(LocalDate dataAlocacao) {
		this.dataAlocacao = dataAlocacao;
	}

	public void setHorarioAlocacao(LocalTime horarioAlocacao) {
		this.horarioAlocacao = horarioAlocacao;
	}

	public void setCodigoMedico(int codigoMedico) {
		this.codigoMedico = codigoMedico;
	}

	public void setCodigoEspecialidade(int codigoEspecialidade) {
		this.codigoEspecialidade = codigoEspecialidade;
	}

	public void setCodigoClinica(int codigoClinica) {
		this.codigoClinica = codigoClinica;
	}
}
