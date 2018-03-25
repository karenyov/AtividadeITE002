package br.gov.sp.fatec.repository;

import org.springframework.data.repository.CrudRepository;

import br.gov.sp.fatec.model.Produto;

/**
 * @author Karen 25 de mar de 2018
 */
public interface ProdutoRepository extends CrudRepository<Produto, Long> {

}
