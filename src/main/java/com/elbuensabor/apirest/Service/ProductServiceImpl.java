package com.elbuensabor.apirest.Service;

import com.elbuensabor.apirest.Entity.Product;
import com.elbuensabor.apirest.Exception.MiException;
import com.elbuensabor.apirest.Repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) throws MiException {
        return productRepository.findById(id)
                .orElseThrow(() -> new MiException("Product not found with id: " + id));
    }

    @Override
    @Transactional
    public Product createProduct(Product product) throws MiException {
        try {
            return productRepository.save(product);
        } catch (Exception e) {
            throw new MiException("Error creating Product!", e);
        }
    }

    @Override
    @Transactional
    public Product updateProduct(Long id, Product product) throws MiException {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new MiException("Product not found with id: " + id));

        existingProduct.setType(product.getType());
        existingProduct.setEstimatedCookingTime(product.getEstimatedCookingTime());
        existingProduct.setName(product.getName());
        existingProduct.setPurchasePrice(product.getPurchasePrice());
        existingProduct.setSalePrice(product.getSalePrice());
        existingProduct.setCurrentStock(product.getCurrentStock());
        existingProduct.setMinimumStock(product.getMinimumStock());
        existingProduct.setPhoto(product.getPhoto());
        existingProduct.setRecipe(product.getRecipe());
        existingProduct.setUnitOfMeasure(product.getUnitOfMeasure());
        existingProduct.setCategory(product.getCategory());
        existingProduct.setSalesOrderDetails(product.getSalesOrderDetails());

        try {
            return productRepository.save(existingProduct);
        } catch (Exception e) {
            throw new MiException("Error updating Product!", e);
        }
    }

    @Override
    @Transactional
    public void deleteProduct(Long id) throws MiException {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new MiException("Product not found with id: " + id));

        try {
            productRepository.delete(existingProduct);
        } catch (Exception e) {
            throw new MiException("Error deleting Product!", e);
        }
    }
}
