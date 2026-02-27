package com.devsuperior.bds02.controller;

import com.devsuperior.bds02.dto.CityDTO;
import com.devsuperior.bds02.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/cities")
public class CityController {

    @Autowired
    private CityService service;

    //FIND ALL BY SORTED BY NAME
    @GetMapping
    public ResponseEntity<List<CityDTO>> findAll() {
        List<CityDTO> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    //INSERT
    @PostMapping
    public ResponseEntity<CityDTO> insert (@RequestBody CityDTO dto) {
        CityDTO cituDto = service.save(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cituDto.getId()).toUri();
        return ResponseEntity.created(uri).body(cituDto);
    }

    //DELETE
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<CityDTO> delete (@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }


}
