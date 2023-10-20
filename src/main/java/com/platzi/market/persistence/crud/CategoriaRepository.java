package com.platzi.market.persistence.crud;

import com.platzi.market.domain.dto.Category;
import com.platzi.market.domain.repository.CategoriaCrudRepository;
import com.platzi.market.domain.repository.CategoryRepository;
import com.platzi.market.persistence.entity.Categoria;
import com.platzi.market.persistence.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CategoriaRepository implements CategoryRepository {

    @Autowired
    private CategoriaCrudRepository categoriaCrudRepository;

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> getAll() {
        List<Categoria> categorias = categoriaCrudRepository.findAll();
        return categoryMapper.toCategorys(categorias);
    }

    @Override
    public Optional<Category> getCategory(int categoryId) {
        return categoriaCrudRepository.findById(categoryId).map(categoria -> categoryMapper.toCategory(categoria));
    }

    @Override
    public Category save(Category category) {
        Categoria categoria = categoryMapper.toCategoria(category);
        return categoryMapper.toCategory(categoriaCrudRepository.save(categoria));
    }

    @Override
    public Category updateCategory(int categoryId, Category category) {
        return getCategory(categoryId).map(categoryToUpdate -> {
            categoryToUpdate.setCategory(category.getCategory());
            categoryToUpdate.setActive(category.isActive());
            Categoria categoria = categoryMapper.toCategoria(categoryToUpdate);
            return save(categoryMapper.toCategory(categoria));
        }).orElse(null);
    }

    @Override
    public void delete(int categoryId) {
        categoriaCrudRepository.deleteById(categoryId);

    }
}
