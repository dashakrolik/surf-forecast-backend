package com.ordina.surfforecast.web;

import java.util.List;

import com.ordina.surfforecast.exception.RecordNotFoundException;
import com.ordina.surfforecast.service.BeachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ordina.surfforecast.model.BeachEntity;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/beaches")
public class BeachController
{
    @Autowired
    BeachService service;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping
    public ResponseEntity<List<BeachEntity>> getAllBeaches() {
        List<BeachEntity> list = service.getAllBeaches();
 
        return new ResponseEntity<List<BeachEntity>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/{id}")
    public ResponseEntity<BeachEntity> getBeachById(@PathVariable("id") Long id)
                                                    throws RecordNotFoundException {
        BeachEntity entity = service.getBeachById(id);
 
        return new ResponseEntity<BeachEntity>(entity, new HttpHeaders(), HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping
    public ResponseEntity<BeachEntity> createOrUpdateBeach(@RequestBody BeachEntity beach)
                                                    throws RecordNotFoundException {
        System.out.println(beach);
        BeachEntity updated = service.createOrUpdateBeach(beach);
        return new ResponseEntity<BeachEntity>(updated, new HttpHeaders(), HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/{id}")
    public HttpStatus deleteBeachById(@PathVariable("id") Long id)
                                                    throws RecordNotFoundException {
        service.deleteBeachById(id);
        return HttpStatus.FORBIDDEN;
    }
 
}