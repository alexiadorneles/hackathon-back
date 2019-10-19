package br.com.hackathon.repository;

import br.com.hackathon.domain.entity.CampaignEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CampaignRepository extends CrudRepository<CampaignEntity,Long> {

    Optional<CampaignEntity> findById(Long id);

    @Override
    List<CampaignEntity> findAll();
}
