package br.com.hackathon.service.item;

import br.com.hackathon.domain.entity.ItemEntity;
import br.com.hackathon.repository.ItemRepository;
import br.com.hackathon.service.GenericCRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl extends GenericCRUDService<ItemEntity, Long> implements ItemService {

	@Autowired
	ItemRepository repository;

	@Override
	public List<ItemEntity> findByCampaignId(Long campaignId) {
		return repository.findByCampaignId(campaignId);
	}
}
