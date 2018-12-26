package controller;

import java.util.LinkedList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.table.AbstractTableModel;

import dao.DAO;

public abstract class AbstractControlador<E> extends AbstractTableModel implements Controlador<E> {
	
	/** 
	 * Os nomes das colunas da tabela Empresas 
	 */
	protected static String nomeColunas[];
	
	/**
	 * Os tipos de dados das colunas da tabela Empresas
	 */
	protected static Class<?> tipoColunas[];
	
	/**
	 * O modelo de dados de todos os ComboBox que exibem uma lista de empresas
	 */
	protected DefaultComboBoxModel<String> cmbModel;
	
	/**
	 * O conjunto de todos as empresas cadastradas
	 */
	protected LinkedList<E> listaEntidades;
	
	/** 
	 * Representa a interface com o banco de dados
	 */
	protected DAO<E> dao;
	
	/** 
	 * Cria um novo objeto com a lista de entidades vazia e o modelo de dados do ComboBox vazio
	 */
	public AbstractControlador() {
		cmbModel = new DefaultComboBoxModel<>();
		listaEntidades = new LinkedList<E>();
	}
	
	/** 
	 * Fornece acesso ao modelo de dados do ComboBox
	 * 
	 * @return O modelo de dados para um ComboBox
	 */
	public DefaultComboBoxModel<String> getComboBoxModel() {
		return cmbModel;
	}

	/** 
	 * Fornece acesso à lista de empresas
	 * 
	 * @return Uma lista representando o conjunto de empresas cadastradas
	 */
	public List<E> getListaEntidades() {
		return listaEntidades;
	}

	/** 
	 * 
	 */
	@Override
	public boolean isCellEditable(int linha, int coluna) {
		return false;
	}
	
	/** 
	 * 
	 */
	@Override
	public Class<?> getColumnClass(int coluna) {
		return tipoColunas[coluna];
	}
	
	/** 
	 * 
	 */
	@Override
	public String getColumnName(int coluna) {
		return nomeColunas[coluna];
	}
	
	/** 
	 * 
	 */
	@Override
	public int getColumnCount() {
		return nomeColunas.length;
	}

	/** 
	 * 
	 */
	@Override
	public int getRowCount() {
		return listaEntidades.size();
	}

	/** 
	 * 
	 */
	@Override
	public void alterar(E entidade) {
		if (entidade != null) {
			dao.alterar(entidade);
		}		
	}

	/** 
	 * 
	 */
	@Override
	public void cadastrar(E entidade) {
		if (entidade != null) {
			dao.cadastrar(entidade);
		}		
	}
	
	/** 
	 * 
	 */
	@Override
	public void deletar(E entidade) {
		if (entidade != null) {
			dao.deletar(entidade);
		}		
	}

	/** 
	 * 
	 */
	@Override
	public List<E> pesquisar() {
		listaEntidades = ( LinkedList<E> ) dao.pesquisar();
		atualizarComboBoxModel();
		
		return listaEntidades;
	}

	/** 
	 * 
	 */
	@Override
	public void fecharConexao() {
		dao.fecharConexao();		
	}
	
	/** 
	 * Configura o modelo de dados do ComboBox
	 */
	protected abstract void atualizarComboBoxModel();
	
	/**
	 * 
	 * @param nomes
	 */
	protected static void setNomeColunas(String[] nomes) {
		nomeColunas = nomes;
	}
	
	/**
	 * 
	 * @param tipos
	 */
	protected static void setTipoColunas(Class<?>[] tipos) {
		tipoColunas = tipos;
	}
}
