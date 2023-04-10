package com.example.springwithmongo.repository;

import com.example.springwithmongo.entity.Brand;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BrandRepository extends MongoRepository<Brand, Long> {
}
