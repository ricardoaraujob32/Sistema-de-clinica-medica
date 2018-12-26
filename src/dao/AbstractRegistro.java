package dao;

public abstract class AbstractRegistro<E> implements Registro<E> {
	
	public AbstractRegistro() {
		
	}
	
	public AbstractRegistro(E entidade) {
		entidadeToDAO(entidade);
	}
}
