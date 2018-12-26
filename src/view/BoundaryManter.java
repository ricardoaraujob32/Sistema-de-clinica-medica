package view;

public interface BoundaryManter<E> {
	E criarEntidade(boolean usarCodigo);	
	void exibirEntidade(E entidade);
}
