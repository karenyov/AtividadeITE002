package br.gov.sp.fatec.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.gov.sp.fatec.model.Pedido;

/**
 * @author Karen 25 de mar de 2018
 */
public interface PedidoRepository extends CrudRepository<Pedido, Long> {

	@Query("SELECT COUNT(*) FROM Pedido p WHERE p.situacao = 'ABERTO'")
	public int countPedidosAbertos();

	@Query("SELECT COUNT(*) FROM Pedido p WHERE p.situacao = 'EM_ANDAMENTO'")
	public int countPedidosEmAndamento();

	@Query("SELECT COUNT(*) FROM Pedido p WHERE p.situacao = 'ENTREGUE'")
	public int countPedidosEntregues();

	@Query("SELECT COUNT(*) FROM Pedido p WHERE p.situacao = 'CANCELADO'")
	public int countPedidosCancelados();
}
