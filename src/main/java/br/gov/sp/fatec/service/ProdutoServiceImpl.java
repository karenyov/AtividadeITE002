package br.gov.sp.fatec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.model.Produto;
import br.gov.sp.fatec.repository.ProdutoRepository;

/**
 * @author Karen 25 de mar de 2018
 */
@Service("produtoService")
public class ProdutoServiceImpl implements ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepo;

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.gov.sp.fatec.service.ProdutoService#cadastrarProdutosTransacao()
	 */
	@Transactional
	public void cadastrarProdutosTransacao() {
		// insere produto
		Produto produto = new Produto();
		produto.setDescricao("Pizza do Garfield");
		produto.setCodigo("AAA01");
		produtoRepo.save(produto);

		Produto produto2 = new Produto();
		produto2.setDescricao("Pizza do Johnny Bravo");
		produto2.setCodigo("AAA02");
		produtoRepo.save(produto2);

		Produto produto3 = new Produto();
		produto3.setDescricao("Pizza da Magali");
		produto3.setCodigo("AAA03");
		produtoRepo.save(produto3);

	}

	/**
	 * @param produtoRepo
	 *            the produtoRepo to set
	 */
	public void setProdutoRepo(ProdutoRepository produtoRepo) {
		this.produtoRepo = produtoRepo;
	}

}
