package com.ordina.surfforecast.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.ordina.surfforecast.repository.BeachRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ordina.surfforecast.exception.RecordNotFoundException;
import com.ordina.surfforecast.model.BeachEntity;

@Service
public class BeachService {
     
    @Autowired
    BeachRepository repository;
     
    public List<BeachEntity> getAllBeaches()
    {
        List<BeachEntity> beachesList = repository.findAll();
         
        if(beachesList.size() > 0) {
            return beachesList;
        } else {
            return new ArrayList<>();
        }
    }
     
    public BeachEntity getBeachById(Long id) throws RecordNotFoundException
    {
        Optional<BeachEntity> beach = repository.findById(id);
         
        if(beach.isPresent()) {
            return beach.get();
        } else {
            throw new RecordNotFoundException("No beach record exist for given id");
        }
    }
     
    public BeachEntity createOrUpdateBeach(BeachEntity entity) throws RecordNotFoundException
    {
        Optional<BeachEntity> beach = repository.findById(entity.getId());

        if(beach.isPresent())
        {
            BeachEntity newEntity = beach.get();
            newEntity.setName(entity.getName());
            newEntity.setLocation(entity.getLocation());

            newEntity = repository.save(newEntity);

            return newEntity;
        } else {
            entity = repository.save(entity);

            return entity;
        }
    }
     
    public void deleteBeachById(Long id) throws RecordNotFoundException
    {
        Optional<BeachEntity> beach = repository.findById(id);
         
        if(beach.isPresent())
        {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No beach record exist for given id");
        }
    }
}