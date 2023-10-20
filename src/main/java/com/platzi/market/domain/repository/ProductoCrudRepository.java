package com.platzi.market.domain.repository;

import com.platzi.market.persistence.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
public interface ProductoCrudRepository extends JpaRepository<Producto, Integer> {

    Optional <List<Producto>> findByIdCategoriaOrderByNombreAsc(int idCategoria);
    Optional <List<Producto>> findByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado);

}
