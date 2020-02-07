package com.ordina.surfforecast.service;

import java.net.URISyntaxException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.ordina.surfforecast.model.WaveHeightDTO;
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
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class BeachService {
     
    @Autowired
    BeachRepository repository;

    public List<BeachEntity> getAllBeaches() throws URISyntaxException {

        List<BeachEntity> beachesList = repository.findAll();


        if(beachesList.size() > 0) {
            List<BeachEntity> arrayToLoop = beachesList.stream().map(beach -> {
                WaveHeightDTO response = getForecast(beach);
//
//                if (response.getHours().isEmpty()) {
//                    System.out.println("RESPONSE IS EMPTY !!!!!!!!!!!!!!!!!!!");
//                }

                beach.setWaveheightvalue(response.getHours().get(0).getWaveHeight().get(0).getValue());
                beach.setSwellperiodvalue(response.getHours().get(0).getSwellPeriod().get(0).getValue());
                beach.setWindspeedvalue(response.getHours().get(0).getWindSpeed().get(0).getValue());
                beach.setWinddirectionvalue(response.getHours().get(0).getWindDirection().get(0).getValue());

                return beach;
            }).collect(Collectors.toList());
            System.out.println(arrayToLoop);
           return arrayToLoop;

    } else {

         return new ArrayList<>();
      }
    }


    public WaveHeightDTO getForecast(BeachEntity beach) throws RestClientException {
        HttpHeaders requestHeaders = new HttpHeaders();

        requestHeaders.set("Authorization", "1f1a92e0-36d1-11ea-83df-0242ac130002-1f1a93f8-36d1-11ea-83df-0242ac130002");

        HttpEntity<?> requestEntity = new HttpEntity<Object>(requestHeaders);

        RestTemplate restTemplate = new RestTemplate();

        restTemplate.getMessageConverters().add(new StringHttpMessageConverter());

        try {
            // Make the HTTP GET request to the Basic Auth protected URL
            String lat = beach.getLatitude();
            String lng = beach.getLongitude();
            LocalDate localDate = LocalDate.now();
            ResponseEntity<WaveHeightDTO> response = restTemplate.exchange("https://api.stormglass.io/v1/weather/point?params=waveHeight,swellPeriod,windDirection,windSpeed&source=dwd" + "&start=" + localDate + "&end=" + localDate + "&lat=" + lat + "&lng=" + lng, HttpMethod.GET, requestEntity, WaveHeightDTO.class);

            WaveHeightDTO body = response.getBody();

            return body;
        } catch (RestClientException e) {
           e.printStackTrace();
        } return null;
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
     
    public BeachEntity createOrUpdateBeach(BeachEntity entity)
    {
        Optional<BeachEntity> beach = repository.findById(entity.getId());

        if(beach.isPresent())
        {
            BeachEntity newEntity = beach.get();
            newEntity.setName(entity.getName());
            newEntity.setLatitude(entity.getLatitude());
            newEntity.setLongitude(entity.getLongitude());
            newEntity.setWaveheightvalue(entity.getWaveheightvalue());
            newEntity.setSwellperiodvalue(entity.getSwellperiodvalue());
            newEntity.setWindspeedvalue(entity.getWindspeedvalue());
            newEntity.setWinddirectionvalue(entity.getWinddirectionvalue());

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