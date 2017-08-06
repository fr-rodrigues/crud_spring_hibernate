package br.com.venda.model.dao;

import java.util.List;

import br.com.venda.model.bean.Produto;

/**
 * Interface de metodos do produto
 * @author fernando
 *
 */
public interface IProdutoDao {
	
	/**
	 * metodo que salva o produto
	 * @param produto
	 */
	public void save(Produto produto);

	/**
	 * metodo que atualiza o produto
	 * @param produto
	 */
	public void update(Produto produto);
	
	/**
	 * metodo que busca o produto
	 * @param id
	 * @return
	 */
	public Produto find(int id);
	
	/**
	 * metodo que lista todos os produtos
	 * @return
	 */
	public List<Produto> findAll();
	
	/**
	 * metodo que apaga o produto
	 * @param produto
	 */
	public void delete(Produto produto);
}
