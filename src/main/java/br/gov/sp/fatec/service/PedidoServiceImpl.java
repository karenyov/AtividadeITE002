package br.gov.sp.fatec.service;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.common.Situacao;
import br.gov.sp.fatec.model.Cliente;
import br.gov.sp.fatec.model.ItemPedido;
import br.gov.sp.fatec.model.Pedido;
import br.gov.sp.fatec.model.Produto;
import br.gov.sp.fatec.repository.ClienteRepository;
import br.gov.sp.fatec.repository.ItemPedidoRepository;
import br.gov.sp.fatec.repository.PedidoRepository;
import br.gov.sp.fatec.repository.ProdutoRepository;

/**
 * @author Karen 25 de mar de 2018
 */
@Service("pedidoService")
public class PedidoServiceImpl implements PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;

	private Pedido pedidoCadastrado;

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.gov.sp.fatec.service.PedidoService#doPedidoTransacao()
	 */
	@Transactional
	public void doPedidoTransacao() {

		// insere cliente
		Cliente cliente = new Cliente();
		cliente.setNome("Jon");
		cliente.setEndereco("R. Cartoons nº 0000");
		cliente.setTelefone("12 99999999");
		clienteRepository.save(cliente);

		Pedido pedido = new Pedido();
		pedido.setCliente(cliente);
		pedido.setSituacao(Situacao.ABERTO);
		this.setPedidoCadastrado(pedidoRepository.save(pedido));

	}

	@Transactional
	public void doPedidoItensTransacao() {
		Produto produto = new Produto();
		produto.setDescricao("Pizza do Cebolinha");
		produto.setCodigo("AAA06");
		produtoRepository.save(produto);
		
		ItemPedido itemPedido = new ItemPedido();
		itemPedido.setPedido(this.getPedidoCadastrado());
		itemPedido.setPreco_unitario(29.90);
		itemPedido.setQuantidade(1);
		itemPedido.setProduto(produto);
		itemPedidoRepository.save(itemPedido);
	}

	/**
	 * @return the pedidoCadastrado
	 */
	public Pedido getPedidoCadastrado() {
		return pedidoCadastrado;
	}

	/**
	 * @param pedidoCadastrado
	 *            the pedidoCadastrado to set
	 */
	public void setPedidoCadastrado(Pedido pedidoCadastrado) {
		this.pedidoCadastrado = pedidoCadastrado;
	}

}
