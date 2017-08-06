package br.com.venda.model.bean;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Classe modelo referente a tabela cliente
 * @author fernando
 *
 */
@Entity
@Table(name="cliente")
public class Cliente {

	/**
	 * variaveis relacionadas aos atributos da tabela
	 */
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cli_id")
	private int id;
	
	@Column(name="cli_nome")
	private String nome;
	
	@Column(name="cli_rg")
	private String rg;
	
	@Column(name="cli_cpf")
	private String cpf;
	
	@OneToMany(mappedBy="cliente")
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Set<Compra> getCompras() {
		return compras;
	}

	public void setCompras(Set<Compra> compras) {
		this.compras = compras;
	}
	
}
