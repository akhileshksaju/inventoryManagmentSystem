package com.akhi.microservices.product.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.akhi.microservices.product.Model.Product;

public interface ProductRepository extends MongoRepository<Product, String> {

}
