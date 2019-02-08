/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Controlador;
import model.Entidade;

/**
 *
 * @author ricardobalduino
 */
public interface Cadastrador<E extends Entidade> {
    String getTituloJanela();
    E gravarNaEntidade(boolean usarCodigo);
    void lerDaEntidade(E entidade);
    Controlador<E> getControlador();
    void alterar();
    void cadastrar();
    void deletar();
    void pesquisar();
    void limpar();
    void primeiro();
    void anterior();
    void proximo();
    void ultimo();
}
