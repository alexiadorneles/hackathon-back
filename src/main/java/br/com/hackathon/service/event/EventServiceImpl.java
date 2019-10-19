package br.com.hackathon.service.event;

import br.com.hackathon.domain.entity.EventEntity;
import br.com.hackathon.repository.EventRepository;
import br.com.hackathon.service.GenericCRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl extends GenericCRUDService<EventEntity, Long> implements EventService{

    @Autowired
    public void setRepository(EventRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<EventEntity> findByCampaignId(Long campaignId) {
        return ((EventRepository)(this.repository)).findByCampaignId(campaignId);
    }
}
