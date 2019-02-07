package controller;

import java.util.List;

public interface Controlador<E> {
    void alterar(E entidade);
    void cadastrar(E entidade);
    void deletar(E entidade);
    List<E> pesquisar();
    void fecharConexao();
}
