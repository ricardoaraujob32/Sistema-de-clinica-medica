/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Controlador;

/**
 *
 * @author ricardobalduino
 */
public interface TituloJanela<E> {
    String getTituloJanela();
    E gravarNaEntidade(boolean usarCodigo);
    void lerDaEntidade(E entidade);
    Controlador<E> getControlador();
    
}
