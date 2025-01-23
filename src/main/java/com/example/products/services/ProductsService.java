package com.example.products.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.products.models.ProductsModel;
import com.example.products.repositories.ProductsRepository;

@Service
public class ProductsService {
    @Autowired
    ProductsRepository productsRepository;

    public ArrayList<ProductsModel> getProducts(){
        return (ArrayList<ProductsModel>) productsRepository.findAll();
    }

    public ProductsModel saveProducts(ProductsModel product){
        return productsRepository.save(product);
    }

    public ProductsModel updateProducts(Long id, ProductsModel product){
        product.setId(id);
        return productsRepository.save(product);
    }
    public Optional<ProductsModel> getProductById(Long id){
        return productsRepository.findById(id);
    }

    public boolean deleteProduct(Long id){
        try {
            productsRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
