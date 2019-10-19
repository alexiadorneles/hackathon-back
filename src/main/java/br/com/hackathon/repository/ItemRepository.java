package br.com.hackathon.repository;

import br.com.hackathon.domain.entity.ItemEntity;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<ItemEntity, Long> {
}
