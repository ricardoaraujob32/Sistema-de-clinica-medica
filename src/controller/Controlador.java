package controller;

import java.util.List;
import model.Entidade;

public interface Controlador<E extends Entidade> {
    void alterar(E entidade);
    void cadastrar(E entidade);
    void deletar(E entidade);
    List<E> pesquisar();
    void fecharConexao();
}
