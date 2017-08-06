package br.com.venda.model.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.venda.model.bean.Fornecedor;
import br.com.venda.model.dao.IFornecedorDao;

/**
 * classe que implementa comportamento do fornecedor
 * com o banco de dados
 * @author fernando
 * @see IFornecedorDao
 */
@Repository
public class FornecedorDao implements IFornecedorDao{

	@Autowired
	private SessionFactory factory;
	
	@Transactional
	public void save(Fornecedor fornecedor) {
		this.factory.getCurrentSession().save(fornecedor);		
	}

	@Transactional
	public void update(Fornecedor fornecedor) {
		this.factory.getCurrentSession().merge(fornecedor);
	}

	@Transactional
	public Fornecedor find(int id) {
		Session session = this.factory.getCurrentSession();
		return (Fornecedor) session.get(Fornecedor.class, id);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Fornecedor> findAll() {
		Session session = this.factory.getCurrentSession();
		return session.createCriteria(Fornecedor.class).list();
	}

	@Transactional
	public void delete(Fornecedor fornecedor) {
		this.factory.getCurrentSession().delete(fornecedor);
	}

}
