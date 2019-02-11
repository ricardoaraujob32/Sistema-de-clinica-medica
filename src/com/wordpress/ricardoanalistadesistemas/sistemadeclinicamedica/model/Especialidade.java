package com.wordpress.ricardoanalistadesistemas.sistemadeclinicamedica.model;

/**
 * 
 * @author ricardobalduino
 *
 */
public class Especialidade extends Entidade {
    /**
     * 
     */
	private String descricao;

	/**
	 * 
	 * @param descricao
	 */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * 
     * @return
     */
    public String getDescricao() {
        return descricao;
    }
}
