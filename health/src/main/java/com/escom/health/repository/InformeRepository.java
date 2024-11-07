package com.escom.health.repository;

import com.escom.health.model.Informe;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InformeRepository extends MongoRepository<Informe,Integer> {
}
