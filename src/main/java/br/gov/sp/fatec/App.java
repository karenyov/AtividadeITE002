package br.gov.sp.fatec;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.gov.sp.fatec.common.Situacao;
import br.gov.sp.fatec.model.Cliente;
import br.gov.sp.fatec.model.ItemPedido;
import br.gov.sp.fatec.model.Pedido;
import br.gov.sp.fatec.model.Produto;
import br.gov.sp.fatec.model.Usuario;
import br.gov.sp.fatec.repository.ClienteRepository;
import br.gov.sp.fatec.repository.ItemPedidoRepository;
import br.gov.sp.fatec.repository.PedidoRepository;
import br.gov.sp.fatec.repository.ProdutoRepository;
import br.gov.sp.fatec.repository.UsuarioRepository;
import br.gov.sp.fatec.service.PedidoService;
import br.gov.sp.fatec.service.ProdutoService;

/**
 * @author Karen 7 de mar de 2018
 */
public class App {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		ProdutoService produtoService = (ProdutoService) context.getBean("produtoService");
		try {
			produtoService.cadastrarProdutosTransacao();
		} catch (Exception e) {
			System.out.println("Erro esperado! Rollback realizado!");
			e.printStackTrace();
		}
		
		PedidoService pedidoService = (PedidoService) context.getBean("pedidoService");
		try {
			pedidoService.doPedidoTransacao();
		} catch (Exception e) {
			System.out.println("Erro esperado! Rollback realizado!");
			e.printStackTrace();
		}
		
		try {
			pedidoService.doPedidoItensTransacao();
		} catch (Exception e) {
			System.out.println("Erro esperado! Rollback realizado!");
			e.printStackTrace();
		}

		/*
		pedido.setItens(new HashSet<ItemPedido>(Arrays.asList(itemPedido)));*/

		// consultas
		/*System.out.println("1º Cliente cadastrado: " + clienteRepository.findById(1L).getNome());
		System.out.println("Descrição do Produto AAA02: " + produtoRepo.findByCodigo("AAA02").getDescricao());
		System.out.println("Pedido: " + pedido.getId());

		Set<ItemPedido> itens = pedido.getItens();
		for (ItemPedido i : itens) {
			System.out.println("Item: ");
		}

		// testando consulta de busca de produtos
		System.out.println("Buscar - Produto: pizza ");
		List<Produto> produtosPizza = produtoRepo.buscaProduto("pizza");
		for (Produto p : produtosPizza) {
			System.out.println("Produto: " + p.getCodigo() + " - " + p.getDescricao());
		}

		// testando busca de pedidos
		System.out.println("Total pedidos ABERTOS: " + pedidoRepository.countPedidosAbertos());
		System.out.println("Total pedidos EM ANDAMENTO: " + pedidoRepository.countPedidosEmAndamento());
		System.out.println("Total pedidos ENTREGUE: " + pedidoRepository.countPedidosEmAndamento());
		System.out.println("Total pedidos CANCELADO: " + pedidoRepository.countPedidosCancelados());*/

	}

}
