package com.elbuensabor.apirest.Service;

import com.elbuensabor.apirest.Entity.Product;
import com.elbuensabor.apirest.Exception.MiException;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    Product getProductById(Long id) throws MiException;
    Product createProduct(Product product) throws MiException;
    Product updateProduct(Long id, Product product) throws MiException;
    void deleteProduct(Long id) throws MiException;
}
