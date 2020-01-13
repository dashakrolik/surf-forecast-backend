package com.ordina.surfforecast.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ordina.surfforecast.model.BeachEntity;
 
@Repository
public interface BeachRepository
        extends JpaRepository<BeachEntity, Long> {
 
}
