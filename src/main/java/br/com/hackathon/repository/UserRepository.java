package br.com.hackathon.repository;

import br.com.hackathon.domain.entity.UserEntity;
import br.com.hackathon.dto.user.RankUserDto;
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

	@Query("SELECT new br.com.hackathon.dto.user.RankUserDto( " +
			"CONCAT(u.firstName, u.lastName), " +
			"u.imageUrl, " +
			"u.cpf, " +
			"u.cnpj) " +
			"FROM UserEntity u")
	List<RankUserDto> listUsersRank();

	@Query("SELECT u.id FROM UserEntity u")
	public List<Long> teste();
}
