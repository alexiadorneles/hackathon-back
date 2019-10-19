package br.com.hackathon.service.item;

import br.com.hackathon.domain.entity.ItemEntity;
import br.com.hackathon.service.CRUDService;

import java.util.List;

public interface ItemService extends CRUDService<ItemEntity, Long> {

	List<ItemEntity> findByCampaignId(Long campaignId);
}
