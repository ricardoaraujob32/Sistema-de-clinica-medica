
package com.wordpress.ricardoanalistadesistemas.sistemadeclinicamedica.model;

/**
 * @author ricardobalduino
 *
 */
public abstract class PessoaJuridica extends Pessoa {
	protected String razaoSocial;
    protected String cnpj;
    protected String contato;
    protected String site;

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getContato() {
        return contato;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public String getSite() {
        return site;
    }
}
