package com.escom.health.repository;

import com.escom.health.model.Paciente;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PacienteRepository extends MongoRepository<Paciente,Integer> {

}
