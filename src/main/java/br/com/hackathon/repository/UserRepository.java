package br.com.hackathon.repository;

import br.com.hackathon.domain.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * @author alexiadorneles
 * @email alexiadorneles02@gmail.com
 */

public interface UserRepository extends CrudRepository<UserEntity, Long> {

	Optional<UserEntity> findByUsername(String username);
}
