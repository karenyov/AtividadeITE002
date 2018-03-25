package br.gov.sp.fatec.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Karen 25 de mar de 2018
 */
@Entity
@Table(name = "item_pedido")
public class ItemPedido implements Serializable {

	private static final long serialVersionUID = 1751217561907107286L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "item_pedido_id")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "pedido_id")
	private Pedido pedido;

	@ManyToOne
	@JoinColumn(name = "produto_id")
	private Produto produto;

	private int quantidade;

	private Double preco_unitario;

	private Double preco_total;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the pedido
	 */
	public Pedido getPedido() {
		return pedido;
	}

	/**
	 * @param pedido
	 *            the pedido to set
	 */
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	/**
	 * @return the produto
	 */
	public Produto getProduto() {
		return produto;
	}

	/**
	 * @param produto
	 *            the produto to set
	 */
	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	/**
	 * @return the quantidade
	 */
	public int getQuantidade() {
		return quantidade;
	}

	/**
	 * @param quantidade
	 *            the quantidade to set
	 */
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	/**
	 * @return the preco_unitario
	 */
	public Double getPreco_unitario() {
		return preco_unitario;
	}

	/**
	 * @param preco_unitario
	 *            the preco_unitario to set
	 */
	public void setPreco_unitario(Double preco_unitario) {
		this.preco_unitario = preco_unitario;
	}

	/**
	 * @return the preco_total
	 */
	public Double getPreco_total() {
		return preco_total;
	}

	/**
	 * @param preco_total
	 *            the preco_total to set
	 */
	public void setPreco_total(Double preco_total) {
		this.preco_total = preco_total;
	}

}
