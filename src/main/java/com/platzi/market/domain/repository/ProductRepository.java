package com.platzi.market.domain.repository;

import com.platzi.market.domain.dto.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    List<Product> getAll();
    Optional<List<Product>> getByCategory(int categoryId);
    Optional<List<Product>> getScarseProducts(int quantity);
    Optional<Product> getProduct(int productId);
    Product save(Product product);
    Product updateProduct(int id, Product product);
    void delete(int productId);

}
