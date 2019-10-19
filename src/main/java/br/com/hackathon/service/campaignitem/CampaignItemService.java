package br.com.hackathon.service.campaignitem;

import br.com.hackathon.domain.entity.CampaignItemEntity;
import br.com.hackathon.dto.campaignitem.CampaignItemDto;
import br.com.hackathon.service.CRUDService;

import java.util.List;

/**
 * @author eduardo.thums
 */
public interface CampaignItemService extends CRUDService<CampaignItemEntity, Long> {

	List<CampaignItemDto> findAllByCampaignId(Long campaignId);
}
