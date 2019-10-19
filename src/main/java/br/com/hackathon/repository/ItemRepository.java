package br.com.hackathon.repository;

import br.com.hackathon.domain.entity.ItemEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ItemRepository extends CrudRepository<ItemEntity, Long> {

	Optional<ItemEntity> findById(Long id);

	@Override
	List<ItemEntity> findAll();

	@Query("SELECT i FROM ItemEntity i " +
			"INNER JOIN CampaignItemEntity ci " +
			"ON i.id = ci.itemId " +
			"INNER JOIN CampaignEntity c " +
			"ON c.id = ci.campaignId " +
			"WHERE c.id = :campaignId")
	List<ItemEntity> findByCampaignId(@Param("campaignId") Long campaignId);
}
