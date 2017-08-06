package br.com.venda.model.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.venda.model.bean.Produto;
import br.com.venda.model.dao.IProdutoDao;

/**
 * Classe que que implementa os metodos do produto
 * @author fernando
 * @see IProdutoDao
 */
@Repository
public class ProdutoDao implements IProdutoDao{
	
	@Autowired
	private SessionFactory factory;

	@Transactional
	public void save(Produto produto) {
		this.factory.getCurrentSession().save(produto);
	}

	@Transactional
	public void update(Produto produto) {
		this.factory.getCurrentSession().merge(produto);
	}

	@Transactional
	public Produto find(int id) {
		Session session = this.factory.getCurrentSession();
		return (Produto) session.get(Produto.class, id);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Produto> findAll() {
		Session session = this.factory.getCurrentSession();
		return session.createCriteria(Produto.class).list();
	}

	@Transactional
	public void delete(Produto produto) {
		this.factory.getCurrentSession().delete(produto);
	}

}
