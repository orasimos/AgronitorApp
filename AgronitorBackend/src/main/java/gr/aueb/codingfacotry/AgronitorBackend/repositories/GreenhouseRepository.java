package gr.aueb.codingfacotry.AgronitorBackend.repositories;

import gr.aueb.codingfacotry.AgronitorBackend.models.Greenhouse;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GreenhouseRepository extends MongoRepository<Greenhouse, String> {
    Greenhouse findByGreenhouseName(String username);
}