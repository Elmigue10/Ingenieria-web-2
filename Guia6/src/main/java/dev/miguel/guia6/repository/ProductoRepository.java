package dev.miguel.guia6.repository;

import dev.miguel.guia6.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

    Producto findByNombre(String nombre);

}
