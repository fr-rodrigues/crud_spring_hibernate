package br.com.venda.model.dao;

import java.util.List;

import br.com.venda.model.bean.Fornecedor;

/**
 * Interface de metodos do fornecedor 
 * @author fernando
 *
 */
public interface IFornecedorDao {
	
	/**
	 * metodo para salvar o fornecedor
	 * @param fornecedor
	 */
	public void save(Fornecedor fornecedor);
	
	/**
	 * metodo para atualizar o fornecedor
	 * @param fornecedor
	 */
	public void update(Fornecedor fornecedor);
	
	/**
	 * metodo para buscar o fornecedor pelo id
	 * @param id
	 * @return
	 */
	public Fornecedor find(int id);
	
	/**
	 * metodo que lista todos os fornecedores
	 * @return
	 */
	public List<Fornecedor> findAll();
	
	/**
	 * metodo para apagar o fornecedor
	 * @param fornecedor
	 */
	public void delete(Fornecedor fornecedor);

}
