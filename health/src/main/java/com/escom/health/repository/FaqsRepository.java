package com.escom.health.repository;

import com.escom.health.model.Faqs;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FaqsRepository extends MongoRepository<Faqs,Integer> {
}
