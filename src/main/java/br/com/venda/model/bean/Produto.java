package br.com.venda.model.bean;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * classe modelo referente a tabel produto
 * @author fernando
 *
 */
@Entity
@Table(name="produto")
public class Produto {
	
	/**
	 * variaveis referentes aos atributos da tabela
	 */

	@Id
	@GeneratedValue
	@Column(name="pro_id")
	private int id;
	
	@Column(name="pro_descricao")
	private String descricao;
	
	@Column(name="pro_qtd")
	private int quantidade;
	
	@ManyToOne
	@JoinColumn(name="pro_for_id")
	private Fornecedor fornecedor;
	
	@OneToMany(mappedBy="produto")
	private Set<Compra> compras;
	
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

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public Set<Compra> getCompras() {
		return compras;
	}

	public void setCompras(Set<Compra> compras) {
		this.compras = compras;
	}
	
}
