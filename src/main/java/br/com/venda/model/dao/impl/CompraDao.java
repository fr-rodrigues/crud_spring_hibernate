package br.com.venda.model.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.venda.model.bean.Compra;
import br.com.venda.model.dao.ICompraDao;

/**
 * classe que implemta os metodos da compra
 * @author fernando
 *
 */
@Repository
public class CompraDao implements ICompraDao{

	@Autowired
	private SessionFactory factory;
	
	@Transactional
	public void save(Compra compra) {
		this.factory.getCurrentSession().save(compra);
	}

	@Transactional
	public void update(Compra compra) {
		this.factory.getCurrentSession().merge(compra);
	}

	@Transactional
	public Compra find(int id) {
		Session session = this.factory.getCurrentSession();
		return (Compra) session.get(Compra.class, id);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Compra> findAll() {
		Session session = this.factory.getCurrentSession();
		return session.createCriteria(Compra.class).list();
	}

	@Transactional
	public void delete(Compra compra) {
		this.factory.getCurrentSession().delete(compra);
		
	}

}
