package br.com.hackathon.repository;

import br.com.hackathon.domain.entity.OrganizationEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * @author eduardo.thums
 */
public interface OrganizationRepository extends CrudRepository<OrganizationEntity, Long> {

	Optional<OrganizationEntity> findByUsername(String email);
}
