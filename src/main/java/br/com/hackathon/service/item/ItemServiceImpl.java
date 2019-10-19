package br.com.hackathon.service.item;

import br.com.hackathon.domain.entity.ItemEntity;
import br.com.hackathon.repository.ItemRepository;
import br.com.hackathon.service.GenericCRUDService;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl extends GenericCRUDService<ItemEntity, Long> implements ItemService{

    @Autowired
    public void setRepository(ItemRepository repository) {
        this.repository = repository;
    }

}
