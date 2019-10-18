package br.com.hackathon.repository;

import br.com.hackathon.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author alexiadorneles
 * @email alexiadorneles02@gmail.com
 */

public interface UsuarioRepository extends CrudRepository<User, Long> {

	Optional<User> findById(Long id);

	Optional<User> findByEmail(String email);

	@Override
	List<User> findAll();

}
