package br.com.hackathon.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

import br.com.hackathon.model.Usuario;

/**
 * @author alexiadorneles
 * @email alexiadorneles02@gmail.com
 */

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

	Optional<Usuario> findByDsLogin(String dsLogin);

	Optional<Usuario> findByIdUsuario(Long idUsuario);

	List<Usuario> findByNmUsuario(String nmUsuario);

	@Override
	List<Usuario> findAll();

}
