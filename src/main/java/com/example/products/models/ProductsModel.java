package com.example.products.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
 
@Entity
@Table
public class ProductsModel {

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    
    @Size(min = 2, max = 20, message = "El nombre debe tener entre 2 y 20 caracteres.")
    private String nameProduct;

    @Size(min = 2, max = 20, message = "La categoría debe tener entre 2 y 20 caracteres.")
    private String category;

    @Positive(message = "El precio debe ser un valor positivo.")
    private Float price;

    @Positive(message = "La cantidad en stock debe ser un valor positivo.")
    private Long quantityStock;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNameProduct() {
        return nameProduct;
    }
    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public Float getPrice() {
        return price;
    }
    public void setPrice(Float price) {
        this.price = price;
    }
    public Long getQuantityStock() {
        return quantityStock;
    }
    public void setQuantityStock(Long quantityStock) {
        this.quantityStock = quantityStock;
    }
}
