package ru.itis.coffeeserviceadmin.repository;

import ru.itis.coffeeserviceadmin.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByName(String name);
   // List<Category> findAllByUserId(String id);
}
