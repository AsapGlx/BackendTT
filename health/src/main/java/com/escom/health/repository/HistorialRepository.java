package com.escom.health.repository;

import com.escom.health.model.Historial;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistorialRepository extends MongoRepository<Historial,Integer> {
}
