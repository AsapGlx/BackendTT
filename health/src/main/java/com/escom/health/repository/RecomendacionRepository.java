package com.escom.health.repository;

import com.escom.health.model.Recomendacion;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecomendacionRepository extends MongoRepository<Recomendacion,Integer> {
}