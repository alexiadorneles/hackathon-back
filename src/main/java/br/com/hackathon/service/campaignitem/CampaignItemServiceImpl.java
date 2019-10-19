package br.com.hackathon.service.campaignitem;

import br.com.hackathon.domain.entity.CampaignItemEntity;
import br.com.hackathon.dto.campaignitem.CampaignItemDto;
import br.com.hackathon.repository.CampaignItemRepository;
import br.com.hackathon.service.GenericCRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author eduardo.thums
 */
@Service
public class CampaignItemServiceImpl extends GenericCRUDService<CampaignItemEntity, Long> implements CampaignItemService {

	@Autowired
	private CampaignItemRepository campaignItemRepository;

	@Override
	public List<CampaignItemDto> findAllByCampaignId(Long campaignId) {
		return campaignItemRepository.findAllByCampaignId(campaignId);
	}
}
