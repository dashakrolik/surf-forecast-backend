package com.ordina.surfforecast.web;

import java.util.List;

import com.ordina.surfforecast.exception.RecordNotFoundException;
import com.ordina.surfforecast.service.BeachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ordina.surfforecast.model.BeachEntity;

@RestController
@RequestMapping("/beaches")
public class BeachController
{
    @Autowired
    BeachService service;
 
    @GetMapping
    public ResponseEntity<List<BeachEntity>> getAllBeaches() {
        List<BeachEntity> list = service.getAllBeaches();
 
        return new ResponseEntity<List<BeachEntity>>(list, new HttpHeaders(), HttpStatus.OK);
    }
 
    @GetMapping("/{id}")
    public ResponseEntity<BeachEntity> getBeachById(@PathVariable("id") Long id)
                                                    throws RecordNotFoundException {
        BeachEntity entity = service.getBeachById(id);
 
        return new ResponseEntity<BeachEntity>(entity, new HttpHeaders(), HttpStatus.OK);
    }
 
    @PostMapping
    public ResponseEntity<BeachEntity> createOrUpdateBeach(BeachEntity beach)
                                                    throws RecordNotFoundException {
        BeachEntity updated = service.createOrUpdateBeach(beach);
        return new ResponseEntity<BeachEntity>(updated, new HttpHeaders(), HttpStatus.OK);
    }
 
    @DeleteMapping("/{id}")
    public HttpStatus deleteBeachById(@PathVariable("id") Long id)
                                                    throws RecordNotFoundException {
        service.deleteBeachById(id);
        return HttpStatus.FORBIDDEN;
    }
 
}