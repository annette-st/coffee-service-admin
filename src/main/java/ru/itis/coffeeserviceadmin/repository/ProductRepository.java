package ru.itis.coffeeserviceadmin.repository;

import ru.itis.coffeeserviceadmin.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
