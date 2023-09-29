package com.platzi.market.persistence.crud;

import com.platzi.market.domain.dto.Product;
import com.platzi.market.domain.repository.ProductRepository;
import com.platzi.market.domain.repository.ProductoRepository;
import com.platzi.market.persistence.entity.Producto;
import com.platzi.market.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoCrudReposiory implements ProductRepository {

    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<Product> getAll() {
        List<Producto> productos = (List<Producto>) productoRepository.findAll();
        return productMapper.toProducts(productos);
    }

    @Override
    public Optional<List<Product>> getByCategory(int categoryId) {
        Optional<List<Producto>> productos = productoRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
        return productos.map(produ -> productMapper.toProducts(produ));
    }

    @Override
    public Optional<List<Product>> getScarseProducts(int quantity) {
        Optional<List<Producto>> productos = productoRepository.findByCantidadStockLessThanAndEstado(quantity, true);
        return productos.map(produ -> productMapper.toProducts(produ));
    }

    @Override
    public Optional<Product> getProduct(int productId) {
        return productoRepository.findById(productId).map(producto -> productMapper.toProduct(producto));
    }

    @Override
    public Product save(Product product) {
        Producto producto = productMapper.toProducto(product);
        return productMapper.toProduct(productoRepository.save(producto));
    }

//    @Override
//    public Product update(Product product) {
//
//        return getProduct(product.getProductId()).map(productToUpdate -> {
//            productToUpdate.setName(product.getName());
//            productToUpdate.setCategoryId(product.getCategoryId());
//            productToUpdate.setPrice(product.getPrice());
//            productToUpdate.setStock(product.getStock());
//            productToUpdate.setActive(product.isActive());
//            Producto producto = productMapper.toProducto(productToUpdate);
//            return save(productMapper.toProduct(producto));
//        }).orElse(null);
//
//    }

    @Override
    public Product updateProduct(int id, Product product) {
        return getProduct(id).map(productToUpdate -> {
            productToUpdate.setName(product.getName());
            productToUpdate.setCategoryId(product.getCategoryId());
            productToUpdate.setPrice(product.getPrice());
            productToUpdate.setStock(product.getStock());
            productToUpdate.setActive(product.isActive());
            Producto producto = productMapper.toProducto(productToUpdate);
            return save(productMapper.toProduct(producto));
        }).orElse(null);
    }

    @Override
    public void delete(int productId) { productoRepository.deleteById(productId);}


}
