package br.com.hackathon.controller.campaign;

import br.com.hackathon.domain.entity.CampaignEntity;
import br.com.hackathon.dto.campaignitem.CampaignItemDto;
import br.com.hackathon.service.campaign.CampaignService;
import br.com.hackathon.service.campaignitem.CampaignItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/public/campaign")
public class CampaignPublicController {

	@Autowired
	private CampaignService campaignService;

	@Autowired
	private CampaignItemService campaignItemService;

	@GetMapping
	public List<CampaignEntity> findAll() {
		return this.campaignService.findAll();
	}

	@GetMapping("/id/{id}")
	public CampaignEntity findById(@PathVariable("id") Long id) {
		return this.campaignService.findById(id);
	}

	@GetMapping("/id/{id}/items")
	public List<CampaignItemDto> findItemsById(@PathVariable("id") Long id) {
		return campaignItemService.findAllByCampaignId(id);
	}

	@PostMapping
	public CampaignEntity save(@RequestBody CampaignEntity campaignEntity) {
		return this.campaignService.save(campaignEntity);
	}

	@PutMapping
	public CampaignEntity update(@RequestBody CampaignEntity campaignEntity) {
		return this.campaignService.update(campaignEntity);
	}
}
