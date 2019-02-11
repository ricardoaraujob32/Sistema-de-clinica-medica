/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wordpress.ricardoanalistadesistemas.sistemadeclinicamedica.view;

import com.wordpress.ricardoanalistadesistemas.sistemadeclinicamedica.controller.Controlador;
import java.util.LinkedList;
import java.util.ListIterator;
import javax.swing.JPanel;
import com.wordpress.ricardoanalistadesistemas.sistemadeclinicamedica.model.Entidade;

/**
 *
 * @author ricardobalduino
 */
public abstract class AbstractBoundaryManter<E extends Entidade> extends JPanel implements Cadastrador {
    protected Controlador<E> controlador;
    protected LinkedList<E> listaEntidades;
    protected ListIterator<E> iterator;

    public AbstractBoundaryManter() {
        listaEntidades = new LinkedList<E>();
        iterator = listaEntidades.listIterator();
    }
    
    @Override
    public void alterar() {
        controlador.alterar( (E) gravarNaEntidade(true) );
    }

    @Override
    public void cadastrar() {
        controlador.cadastrar( (E) gravarNaEntidade(false) );
    }

    @Override
    public void deletar() {
        controlador.deletar( (E) gravarNaEntidade(true) );
    }

    @Override
    public void pesquisar() {
        listaEntidades = ( LinkedList<E> ) controlador.pesquisar();
    }

    @Override
    public void limpar() {
        lerDaEntidade(null);
    }

    @Override
    public void primeiro() {
        E primeiro = listaEntidades.getFirst();
        lerDaEntidade(primeiro);
    }

    @Override
    public void anterior() {
        if ( iterator.hasPrevious() ){
            E anterior = iterator.previous();
            lerDaEntidade(anterior);
        }
    }

    @Override
    public void proximo() {
        if ( iterator.hasNext() ){
            E proximo = iterator.next();
            lerDaEntidade(proximo);
        }
    }

    @Override
    public void ultimo() {
        E ultimo = listaEntidades.getLast();
        lerDaEntidade(ultimo);
    }

    @Override
    public Controlador getControlador() {
        return controlador;
    }    
}
