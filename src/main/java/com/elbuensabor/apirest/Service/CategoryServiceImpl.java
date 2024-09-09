package com.elbuensabor.apirest.Service;

import com.elbuensabor.apirest.Entity.Category;
import com.elbuensabor.apirest.Exception.MiException;
import com.elbuensabor.apirest.Repository.CategoryRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(Long id) throws MiException {
        return categoryRepository.findById(id).orElseThrow(() -> new MiException("Category not found with id: " + id));
    }

    @Override
    @Transactional
    public Category createCategory(Category category) throws MiException {
        try {
            return categoryRepository.save(category);
        } catch (Exception e) {
            throw new MiException("Error creating category!");
        }
    }

    @Override
    @Transactional
    public Category updateCategory(Long id, Category category) throws MiException {
        Category existingCategory = categoryRepository.findById(id).orElseThrow(() -> new MiException("Category not found with id: " + id));

        existingCategory.setName(category.getName());
        existingCategory.setProducts(category.getProducts());

        try {
            return categoryRepository.save(existingCategory);
        } catch (Exception e) {
            throw new MiException("Error updating category!");
        }
    }

    @Override
    @Transactional
    public void deleteCategory(Long id) throws MiException {
        Category existingCategory = categoryRepository.findById(id).orElseThrow(() -> new MiException("Category not found with id: " + id));

        try {
            categoryRepository.delete(existingCategory);
        } catch (Exception e) {
            throw new MiException("Error deleting category!");
        }
    }
}
