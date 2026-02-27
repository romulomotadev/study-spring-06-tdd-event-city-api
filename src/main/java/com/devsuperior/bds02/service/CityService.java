package com.devsuperior.bds02.service;

import com.devsuperior.bds02.dto.CityDTO;
import com.devsuperior.bds02.entities.City;
import com.devsuperior.bds02.repository.CityRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CityService {

    @Autowired
    private CityRepository repository;

    //FIND ALL SORTED BY NAME
    @Transactional(readOnly = true)
    public List<CityDTO> findAll() {
        List<City> cities = repository.findAllByOrderByName();
        return cities.stream().map(CityDTO::new).toList();
    }

    //INSERT
    @Transactional
    public CityDTO save(CityDTO dto) {
        City city = new City();
        city.setName(dto.getName());
        repository.save(city);
        return new CityDTO(city);
    }

    //DELETE DOES NOT EXISTING ID
    @Transactional
    public void delete(Long id){
        try {
            repository.findById(id).orElseThrow(
                    ()-> new EntityNotFoundException("Resource Not Found")
            );
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e){
            throw new DataIntegrityViolationException("Data Integrity Violation");
        }

    }
}
