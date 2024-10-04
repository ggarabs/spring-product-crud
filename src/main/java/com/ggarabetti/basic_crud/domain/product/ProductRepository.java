package com.ggarabetti.basic_crud.domain.product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
    List<Product> findAllByActiveTrue(); // JPA constrói o corpo da função em Runtime
}