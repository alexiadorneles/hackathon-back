package br.com.hackathon.repository;

import br.com.hackathon.domain.entity.ItemEntity;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
import java.util.Optional;

import java.util.List;
import java.util.Optional;

public interface ItemRepository extends CrudRepository<ItemEntity, Long> {

    Optional<ItemEntity> findById(Long id);

    @Override
    List<ItemEntity> findAll();

}
