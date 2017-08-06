package br.com.venda.model.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.venda.model.bean.Cliente;
import br.com.venda.model.dao.IClienteDao;

/**
 * Classe que define o comportamento dos metodos do cliente
 * 
 * @author fernando
 *
 */
@Repository
public class ClienteDao implements IClienteDao {

	@Autowired
	private SessionFactory factory;

	@Transactional
	public void save(Cliente cliente) {
		this.factory.getCurrentSession().save(cliente);
	}

	@Transactional
	public void update(Cliente cliente) {
		this.factory.getCurrentSession().merge(cliente);
	}

	@Transactional
	public Cliente find(int id) {
		return (Cliente) this.factory.getCurrentSession()
				.get(Cliente.class, id);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Cliente> findAll() {
		Session session = this.factory.getCurrentSession();
		return session.createCriteria(Cliente.class).list();
		
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Cliente> findAllByName(String name) {
		Session session = this.factory.getCurrentSession();
		Query query = session.createQuery("select c from Cliente c where c.nome = :name");
		query.setParameter("name", name);
		return query.list();
	}

	@Transactional
	public void delete(Cliente cliente) {
		this.factory.getCurrentSession().delete(cliente);
	}

}
