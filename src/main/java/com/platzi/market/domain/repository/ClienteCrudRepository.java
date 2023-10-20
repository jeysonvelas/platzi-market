package com.platzi.market.domain.repository;

import com.platzi.market.persistence.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClienteCrudRepository extends JpaRepository<Cliente, String> {

}
