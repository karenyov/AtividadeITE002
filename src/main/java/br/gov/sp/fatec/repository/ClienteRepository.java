package br.gov.sp.fatec.repository;

import org.springframework.data.repository.CrudRepository;

import br.gov.sp.fatec.model.Cliente;

/**
 * @author Karen 25 de mar de 2018
 */
public interface ClienteRepository extends CrudRepository<Cliente, Long> {

}
