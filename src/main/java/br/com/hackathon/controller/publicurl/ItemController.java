package br.com.hackathon.controller.publicurl;

import br.com.hackathon.domain.entity.ItemEntity;
import br.com.hackathon.service.item.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/public/item")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @GetMapping()
    public List<ItemEntity> findAll() {
        return this.itemService.findAll();
    }

    @GetMapping("/id/{id}")
    public ItemEntity findById(@PathVariable("id") Long id) {
        return this.itemService.findById(id);
    }

    @PostMapping
    public ItemEntity save(@RequestBody ItemEntity itemEntity){
        return this.itemService.save(itemEntity);
    }
}
