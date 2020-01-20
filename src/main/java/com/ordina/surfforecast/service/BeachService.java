package com.ordina.surfforecast.service;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.ordina.surfforecast.repository.BeachRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Service;

import com.ordina.surfforecast.exception.RecordNotFoundException;
import com.ordina.surfforecast.model.BeachEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class BeachService {
     
    @Autowired
    BeachRepository repository;
    
    public List<BeachEntity> getAllBeaches() throws URISyntaxException {

        List<BeachEntity> beachesList = repository.findAll();

        if(beachesList.size() > 0) {
            getForecast();
            return beachesList;

    } else {
         return new ArrayList<>();
      }
    }


    public String getForecast() throws URISyntaxException {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.set("Authorization", "1f1a92e0-36d1-11ea-83df-0242ac130002-1f1a93f8-36d1-11ea-83df-0242ac130002");
        HttpEntity<?> requestEntity = new HttpEntity<Object>(requestHeaders);

        RestTemplate restTemplate = new RestTemplate();

        restTemplate.getMessageConverters().add(new StringHttpMessageConverter());


        try {
            // Make the HTTP GET request to the Basic Auth protected URL
            String url = "";
            String start = "2018-01-20T17:00:00+00:00";
            String end = "2018-01-20T17:02:00+00:00";
            ResponseEntity<String> response = restTemplate.exchange("https://api.stormglass.io/v1/weather/point?lat=39.3712&lng=9.3389&params=waveHeight&source=dwd&start=2020-01-19&end=2020-01-19", HttpMethod.GET, requestEntity, String.class);
            String result = response.getBody();


            System.out.println(response.getBody());
            return response.getBody();
        } catch (HttpClientErrorException e) {
            return e.toString();
            // Handle 401 Unauthorized response
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
            newEntity.setLatitude(entity.getLatitude());
            newEntity.setLongitude(entity.getLongitude());

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