package br.com.venda.model.bean;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * classe modelo referente a tabela fornecedor
 * @author fernando
 *
 */
@Entity
@Table(name="fornecedor")
public class Fornecedor {

	/**
	 * variaveis referentes aos atributos da tabela
	 */
	
	@Id
	@GeneratedValue
	@Column(name="for_id")
	private int id;
	
	@Column(name="for_descricao")
	private String descricao;
	
	@OneToMany(mappedBy="fornecedor")
	private Set<Produto> produtos = new HashSet<Produto>();

	/**
	 * gets and sets
	 */
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Set<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(Set<Produto> produtos) {
		this.produtos = produtos;
	}
	
}
