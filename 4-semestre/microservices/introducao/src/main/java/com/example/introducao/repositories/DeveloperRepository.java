package com.example.introducao.repositories;

import com.example.introducao.models.Developer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeveloperRepository extends MongoRepository<Developer, String> {
}
