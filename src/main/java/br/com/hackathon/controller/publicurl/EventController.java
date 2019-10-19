package br.com.hackathon.controller.publicurl;

import br.com.hackathon.domain.entity.EventEntity;
import br.com.hackathon.service.event.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/public/event")
public class EventController {
    @Autowired
    EventService eventService;

    @GetMapping()
    public List<EventEntity> findAll() {
        return this.eventService.findAll();
    }

    @GetMapping("/id/{id}")
    public EventEntity findById(@PathVariable("id") Long id) {
        return this.eventService.findById(id);
    }

    @GetMapping("/campaign/{id}")
    public List<EventEntity> findByCampaignId(@PathVariable("id") Long id) {
        return this.eventService.findByCampaignId(id);
    }

    @PostMapping
    public EventEntity save(@RequestBody EventEntity campaignEntity) {
        return this.eventService.save(campaignEntity);
    }

    @PutMapping
    public EventEntity update(@RequestBody EventEntity campaignEntity) {
        return this.eventService.update(campaignEntity);
    }
}
