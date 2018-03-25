package br.gov.sp.fatec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.gov.sp.fatec.model.Produto;

/**
 * @author Karen 25 de mar de 2018
 */
public interface ProdutoRepository extends CrudRepository<Produto, Long> {

	public Produto findByCodigo(String codigo);

	@Query("SELECT p FROM Produto p WHERE p.descricao LIKE %?1%")
	public List<Produto> buscaProduto(String nome);
}
