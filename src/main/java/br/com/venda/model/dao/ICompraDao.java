package br.com.venda.model.dao;

import java.util.List;

import br.com.venda.model.bean.Compra;

/**
 * Interface de metodos da compra 
 * @author fernando
 *
 */
public interface ICompraDao {
	
	/**
	 * metodo que salva a compra
	 * @param compra
	 */
	public void save(Compra compra);
	
	/**
	 * metodo que atualiza a compra
	 * @param compra
	 */
	public void update(Compra compra);
	
	/**
	 * metodo que busca a compra pelo id
	 * @param id
	 * @return
	 */
	public Compra find(int id);
	
	/**
	 * metodo que lista todas as compras
	 * @return
	 */
	public List<Compra> findAll();
	
	/**
	 * metodo que apaga a compra
	 * @param compra
	 */
	public void delete(Compra compra);
}
