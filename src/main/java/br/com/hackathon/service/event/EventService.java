package br.com.hackathon.service.event;

import br.com.hackathon.domain.entity.EventEntity;
import br.com.hackathon.service.CRUDService;

import java.util.List;

public interface EventService extends CRUDService<EventEntity, Long> {
    List<EventEntity> findByCampaignId(Long campaignId);
}
