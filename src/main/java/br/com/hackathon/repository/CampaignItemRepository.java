package br.com.hackathon.repository;

import br.com.hackathon.domain.entity.CampaignItemEntity;
import br.com.hackathon.dto.campaignitem.CampaignItemDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author eduardo.thums
 */
public interface CampaignItemRepository extends CrudRepository<CampaignItemEntity, Long> {

	@Query("SELECT new br.com.hackathon.dto.campaignitem.CampaignItemDto( " +
			"ci.id, " +
			"i.id, " +
			"i.title, " +
			"i.description, " +
			"ci.quantity, " +
			"ci.isCompleted) " +
			"FROM ItemEntity i " +
			"INNER JOIN CampaignItemEntity ci " +
			"ON i.id = ci.itemId " +
			"INNER JOIN CampaignEntity c " +
			"ON c.id = ci.campaignId " +
			"WHERE c.id = :campaignId")
	List<CampaignItemDto> findAllByCampaignId(Long campaignId);
}
