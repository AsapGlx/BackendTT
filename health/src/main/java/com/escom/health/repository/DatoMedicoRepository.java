package com.escom.health.repository;

import com.escom.health.model.DatoMedico;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DatoMedicoRepository extends MongoRepository<DatoMedico,Integer> {
}
