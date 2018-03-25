package br.gov.sp.fatec;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.gov.sp.fatec.model.Usuario;
import br.gov.sp.fatec.repository.UsuarioRepository;

/**
 * @author Karen 7 de mar de 2018
 */
public class App {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		UsuarioRepository usuarioRepo = (UsuarioRepository) context.getBean("usuarioRepository");
		
		Usuario usuario = new Usuario();
		/*usuario.setNome("teste");
		usuario.setEmail("teste@teste.com");
		usuarioRepo.save(usuario);*/
	}

}
