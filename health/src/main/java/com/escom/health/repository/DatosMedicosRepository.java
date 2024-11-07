package com.escom.health.repository;

import com.escom.health.model.DatosMedicos;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DatosMedicosRepository extends MongoRepository<DatosMedicos,Integer> {
}
