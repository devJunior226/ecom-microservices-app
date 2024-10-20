package dev.juldas.ecommerce.repository;

import dev.juldas.ecommerce.entity.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String> {
}
