package com.devsuperior.bds02.service;

import com.devsuperior.bds02.dto.EventDTO;
import com.devsuperior.bds02.entities.City;
import com.devsuperior.bds02.entities.Event;
import com.devsuperior.bds02.repository.CityRepository;
import com.devsuperior.bds02.repository.EventRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private CityRepository cityRepository;

    //UPDATE
    @Transactional
    public EventDTO update(Long id, EventDTO dto) {

        Event event = eventRepository.findById(id).orElseThrow(
                ()-> new EntityNotFoundException("Entity event not found"));

        event.setName(dto.getName());
        event.setDate(dto.getDate());
        event.setUrl(dto.getUrl());

        City city = cityRepository.findById(dto.getCityId()).orElseThrow(
                ()-> new EntityNotFoundException("Entity city not found"));

        event.setCity(city);
        eventRepository.save(event);
        return new EventDTO(event);
    }
}
