package com.wordpress.ricardoanalistadesistemas.sistemadeclinicamedica.controller;

import java.util.List;
import com.wordpress.ricardoanalistadesistemas.sistemadeclinicamedica.model.Entidade;

public interface Controlador<E extends Entidade> {
    void alterar(E entidade);
    void cadastrar(E entidade);
    void deletar(E entidade);
    List<E> pesquisar();
    void fecharConexao();
}
