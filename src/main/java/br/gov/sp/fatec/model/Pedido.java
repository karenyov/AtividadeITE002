package br.gov.sp.fatec.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.gov.sp.fatec.common.Situacao;

/**
 * @author Karen 25 de mar de 2018
 */
@Entity
@Table(name = "pedido")
public class Pedido implements Serializable {

	private static final long serialVersionUID = 2298873710280634404L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pedido_id")
	private Long id;

	@Enumerated(EnumType.STRING)
	private Situacao situacao;

	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;

	private Double total;

	@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
	private Set<ItemPedido> itens;

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
	 * @return the situacao
	 */
	public Situacao getSituacao() {
		return situacao;
	}

	/**
	 * @param situacao
	 *            the situacao to set
	 */
	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}

	/**
	 * @return the cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * @param cliente
	 *            the cliente to set
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	/**
	 * @return the total
	 */
	public Double getTotal() {
		return total;
	}

	/**
	 * @param total
	 *            the total to set
	 */
	public void setTotal(Double total) {
		this.total = total;
	}

	/**
	 * @return the itens
	 */
	public Set<ItemPedido> getItens() {
		return itens;
	}

	/**
	 * @param itens
	 *            the itens to set
	 */
	public void setItens(Set<ItemPedido> itens) {
		this.itens = itens;
	}

}
