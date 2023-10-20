package com.platzi.market.domain.service;

import com.platzi.market.domain.dto.Category;
import com.platzi.market.domain.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAll(){
        return categoryRepository.getAll();
    }

    public Optional<Category> getCategory(int categoryId){
        return categoryRepository.getCategory(categoryId);
    }

    public Category save(Category category){
        return categoryRepository.save(category);
    }

    public Category updateCategory(int categoryId, Category category){
        return categoryRepository.updateCategory(categoryId, category);
    }

    public boolean delete(int categoryId){
        return getCategory(categoryId).map(category -> {
            categoryRepository.delete(categoryId);
            return true;
        }).orElse(false);
    }
}
