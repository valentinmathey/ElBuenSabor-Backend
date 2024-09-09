package com.elbuensabor.apirest.Service;

import com.elbuensabor.apirest.Entity.Category;
import com.elbuensabor.apirest.Exception.MiException;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();
    Category getCategoryById(Long id) throws MiException;
    Category createCategory(Category category) throws MiException;
    Category updateCategory(Long id, Category category) throws MiException;
    void deleteCategory(Long id) throws MiException;
}
