package br.com.hackathon.repository;

import br.com.hackathon.domain.entity.UserEntity;
import br.com.hackathon.projection.RankUserDtoProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

/**
 * @author alexiadorneles
 * @email alexiadorneles02@gmail.com
 */
public interface UserRepository extends JpaRepository<UserEntity, Long> {

	Optional<UserEntity> findByUsername(String username);

	@Query(value = "SELECT CONCAT(u.first_name, u.last_name) as fullName, " +
			"u.image_url  as imageUrl, " +
			"u.cpf as cpf, " +
			"u.cnpj as cnpj " +
			"FROM \"user\" u ",
			nativeQuery = true)
	List<RankUserDtoProjection> listUsersRank();
}
