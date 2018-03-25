package br.gov.sp.fatec.repository;

import org.springframework.data.repository.CrudRepository;

import br.gov.sp.fatec.model.Usuario;

/**
 * @author Karen 7 de mar de 2018
 */
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

}
