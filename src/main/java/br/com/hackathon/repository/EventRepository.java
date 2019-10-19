package br.com.hackathon.repository;

import br.com.hackathon.domain.entity.EventEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface EventRepository extends CrudRepository<EventEntity, Long> {

    Optional<EventEntity> findById(Long id);

    @Override
    List<EventEntity> findAll();

    List<EventEntity> findByCampaignId(Long campaignId);
}
