package ru.itis.coffeeserviceadmin.repository;

import ru.itis.coffeeserviceadmin.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}