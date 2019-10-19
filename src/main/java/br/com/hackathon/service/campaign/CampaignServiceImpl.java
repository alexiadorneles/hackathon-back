package br.com.hackathon.service.campaign;

import br.com.hackathon.domain.entity.CampaignEntity;
import br.com.hackathon.repository.CampaignRepository;
import br.com.hackathon.service.GenericCRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CampaignServiceImpl extends GenericCRUDService<CampaignEntity, Long> implements CampaignService {

    @Autowired
    public void setRepository(CampaignRepository repository) {
        this.repository = repository;
    }

}
