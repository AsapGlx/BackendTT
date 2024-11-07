package com.escom.health.repository;

import com.escom.health.model.Investigador;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvestigadorRepository extends MongoRepository<Investigador,Integer> {
}
