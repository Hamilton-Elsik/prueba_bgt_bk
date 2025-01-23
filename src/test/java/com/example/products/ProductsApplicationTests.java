package com.example.products;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.products.models.ProductsModel;
import com.example.products.services.ProductsService;

@SpringBootTest
class ProductsApplicationTests {
@Autowired
ProductsService productsService;

Long productId;

@BeforeEach
void setUp() {
    ProductsModel product = new ProductsModel();
    product.setNameProduct("testNameProduct");
    product.setCategory("testCategory");
    product.setPrice(1000f);
    product.setQuantityStock(5L);

    ProductsModel savedProduct = productsService.saveProducts(product);
    this.productId = savedProduct.getId();
}

@Test
void testSaveProduct() {
    Assertions.assertNotNull(productId, "El ID del producto guardado no debe ser nulo.");
}

@Test
void testFindProductById() {
    Optional<ProductsModel> result = productsService.getProductById(productId);
    Assertions.assertTrue(result.isPresent(), "El producto debe estar presente.");
    ProductsModel product = result.get();
    Assertions.assertEquals("testNameProduct", product.getNameProduct(), "El nombre del producto debe ser correcto.");
}

@Test
void testUpdateProduct() {
    ProductsModel updatedProduct = new ProductsModel();
    updatedProduct.setNameProduct("updatedName");
    updatedProduct.setCategory("updatedCategory");
    updatedProduct.setPrice(2000f);
    updatedProduct.setQuantityStock(10L);

    ProductsModel result = productsService.updateProducts(productId, updatedProduct);
    Assertions.assertEquals("updatedName", result.getNameProduct(), "El nombre del producto debe haber sido actualizado.");
    Assertions.assertEquals(2000f, result.getPrice(), "El precio debe haber sido actualizado.");
}

@Test
void testDeleteProduct() {
    productsService.deleteProduct(productId);
    Optional<ProductsModel> result = productsService.getProductById(productId);
    Assertions.assertFalse(result.isPresent(), "El producto no debe estar presente después de ser eliminado.");
}
}
