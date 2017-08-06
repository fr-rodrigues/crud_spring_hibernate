package br.com.venda.model.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * Classe modelo referente a tabela compra
 * @author fernando
 *
 */
@Entity
@Table(name="compra")
public class Compra {

	/**
	 * variaveis referentes as atributos
	 */
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="com_id")
	private int id;
	
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	@Column(name="com_data")
	private Date data;
	
	@DateTimeFormat(pattern="HH:mm")
	@Temporal(TemporalType.TIME)
	@Column(name="com_hora")
	private Date hora;
	
	@ManyToOne
	@JoinColumn(name="com_cli_id")
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name="com_pro_id")
	private Produto produto;

	/**
	 * gets and sets
	 */
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Date getHora() {
		return hora;
	}

	public void setHora(Date hora) {
		this.hora = hora;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
}
