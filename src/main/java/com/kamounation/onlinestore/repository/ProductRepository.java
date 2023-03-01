package com.kamounation.onlinestore.repository;

import com.kamounation.onlinestore.models.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}
