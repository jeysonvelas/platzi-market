package com.platzi.market.domain.repository;

import com.platzi.market.domain.dto.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository {

    List<Category> getAll();
    Optional<Category> getCategory(int categoryId);
    Category save(Category category);
    Category updateCategory(int categoryId, Category category);
    void delete(int categoryId);

}
