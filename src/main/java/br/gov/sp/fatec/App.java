package br.gov.sp.fatec;

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

/**
 * @author Karen 7 de mar de 2018
 */
public class App {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		UsuarioRepository usuarioRepo = (UsuarioRepository) context.getBean("usuarioRepository");
		
		//insere usuario 
		/*Usuario usuario = new Usuario();
		usuario.setNome("teste");
		usuario.setEmail("teste@teste.com");
		usuarioRepo.save(usuario);*/
		
		//insere produto
		ProdutoRepository produtoRepo = (ProdutoRepository) context.getBean("produtoRepository");
		Produto produto = new Produto();
		produto.setDescricao("Pizza do Garfield");
		produtoRepo.save(produto);
		
		Produto produto2 = new Produto();
		produto2.setDescricao("Pizza do Johnny Bravo");
		produtoRepo.save(produto2);
		
		Produto produto3 = new Produto();
		produto3.setDescricao("Pizza da Magali");
		produtoRepo.save(produto3);
		
		//insere cliente
		ClienteRepository clienteRepository = (ClienteRepository) context.getBean("clienteRepository");
		Cliente cliente = new Cliente();
		cliente.setNome("Jon");
		cliente.setEndereco("R. Cartoons nº 0000");
		cliente.setTelefone("12 99999999");
		clienteRepository.save(cliente);
		
		PedidoRepository pedidoRepository = (PedidoRepository) context.getBean("pedidoRepository");
		Pedido pedido = new Pedido();
		pedido.setCliente(cliente);
		pedido.setSituacao(Situacao.ABERTO);
		pedidoRepository.save(pedido);
		
		ItemPedidoRepository itemPedidoRepository = (ItemPedidoRepository) context.getBean("itemPedidoRepository");
		ItemPedido itemPedido = new ItemPedido();
		itemPedido.setPedido(pedido);
		itemPedido.setPreco_unitario(29.90);
		itemPedido.setQuantidade(1);
		itemPedido.setProduto(produto);
		itemPedidoRepository.save(itemPedido);
		
		//clienteRepository.delete(cliente);
	}

}
