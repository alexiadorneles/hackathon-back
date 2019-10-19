package br.com.hackathon.service.item;

import br.com.hackathon.domain.entity.ItemEntity;
import br.com.hackathon.service.GenericCRUDService;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl extends GenericCRUDService<ItemEntity, Long> implements ItemService {
}
