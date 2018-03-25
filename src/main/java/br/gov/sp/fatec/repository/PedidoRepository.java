package br.gov.sp.fatec.repository;

import org.springframework.data.repository.CrudRepository;

import br.gov.sp.fatec.model.Pedido;

/**
 * @author Karen 25 de mar de 2018
 */
public interface PedidoRepository extends CrudRepository<Pedido, Long> {

}
