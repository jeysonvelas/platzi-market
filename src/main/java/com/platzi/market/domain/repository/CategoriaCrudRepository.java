package com.platzi.market.domain.repository;

import com.platzi.market.persistence.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaCrudRepository extends JpaRepository<Categoria, Integer> {
}
