package com.example.springwithmongo.repository;

import com.example.springwithmongo.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, Long> {

}
