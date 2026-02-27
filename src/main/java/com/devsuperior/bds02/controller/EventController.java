package com.devsuperior.bds02.controller;

import com.devsuperior.bds02.dto.EventDTO;
import com.devsuperior.bds02.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "events")
public class EventController {

    @Autowired
    private EventService service;

    //UPDATE
    @PutMapping(value = "/{id}")
    public EventDTO update(@PathVariable Long id, @RequestBody EventDTO dto) {
        EventDTO dtoUpdated = service.update(id, dto);
        return dtoUpdated;
    }

}
