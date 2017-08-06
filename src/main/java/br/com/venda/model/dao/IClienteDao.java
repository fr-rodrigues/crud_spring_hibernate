package br.com.venda.model.dao;

import java.util.List;

import br.com.venda.model.bean.Cliente;

/**
 * Interface de metodos do cliente
 * @author fernando
 *
 */
public interface IClienteDao {

	/**
	 * metodo para salvar o cliente
	 * @param cliente
	 */
	public void save(Cliente cliente);
	
	/**
	 * metodo para atualizar os dados do cliente
	 * @param cliente
	 */
	public void update(Cliente cliente);
	
	/**
	 * metodo para buscar o cliente por id
	 * @param id
	 * @return
	 */
	public Cliente find(int id);
	
	/**
	 * metodo que lista todos os clientes
	 * @return
	 */
	public List<Cliente> findAll();
	
	/**
	 * metodo que lista os clientes por nome espefico
	 * @param name
	 * @return
	 */
	public List<Cliente> findAllByName(String name);
	
	/**
	 * metodo para deletar o cliente
	 * apenas o administrador tem acesso a esse metodo
	 * @param cliente
	 */
	public void delete(Cliente cliente);
	
}
