package com.platzi.market.domain.repository;

import com.platzi.market.persistence.entity.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CompraCrudRepository extends JpaRepository<Compra, Integer> {

    Optional<List<Compra>> findByIdCliente(String idCliente);

    @Query(value = "SELECT p.id,  c.id_compra, p.nombre, c.fecha, d.descripcion, h.nombre, b.cantidad, b.total\n" +
            "FROM\n" +
            "   compras c\n" +
            "   INNER JOIN clientes p ON p.id = c.id_cliente\n" +
            "   INNER JOIN compras_productos b ON b.id_compra = c.id_compra\n" +
            "   INNER JOIN productos h ON h.id_producto = b.id_producto\n" +
            "   INNER JOIN categorias d ON h.id_categoria = d.id_categoria\n" +
            "   ORDER BY c.id_compra", nativeQuery = true)
    List<Object[]> findAllPurchases();

}
