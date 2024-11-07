package com.escom.health.repository;

import com.escom.health.model.Diagnostico;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiagnosticoRepository extends MongoRepository <Diagnostico,Integer> {
}
