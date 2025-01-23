package com.example.products.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.products.models.ProductsModel;
import com.example.products.services.ProductsService;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/products")
public class ProductsController {
    @Autowired
    ProductsService productsService;

    @GetMapping()
    public ArrayList<ProductsModel> getProducts(){
        return productsService.getProducts();
    }

    @PostMapping()
    public ResponseEntity<?> saveProduct(@RequestBody ProductsModel product){
        try {
            ProductsModel savedProduct = this.productsService.saveProducts(product);
            return ResponseEntity.ok(savedProduct);
        }catch(Exception e) {
            return ResponseEntity.status(500).body("Error al guardar el producto: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable("id") Long id, @RequestBody ProductsModel product) {

        try {
            ProductsModel updateProduct = this.productsService.updateProducts(id, product);
            return ResponseEntity.ok(updateProduct);
        }catch(Exception e) {
            return ResponseEntity.status(500).body("Error al modificar el producto: " + e.getMessage());
        }
    }

    @GetMapping(path = "/{id}")
    public Optional<ProductsModel> getProductsById(@PathVariable("id") Long id) {
        return this.productsService.getProductById(id);
    }
    
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Map<String, String>> deleteById(@PathVariable("id") Long id) {
        boolean ok = this.productsService.deleteProduct(id);
        Map<String, String> response = new HashMap<>();
        
        if (ok) {
            response.put("message", "Se eliminó el producto con id " + id);
            return ResponseEntity.ok(response);
        } else {
            response.put("message", "No se pudo eliminar el producto con id " + id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

}
