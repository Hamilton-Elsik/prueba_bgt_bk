package com.example.products.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.products.models.ProductsModel;

@Repository
public interface  ProductsRepository extends CrudRepository<ProductsModel, Long>{
    
}
