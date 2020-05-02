package ru.itis.coffeeserviceadmin.web;

import ru.itis.coffeeserviceadmin.model.Category;
import ru.itis.coffeeserviceadmin.repository.CategoryRepository;
import ru.itis.coffeeserviceadmin.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Collection;

@RestController
@RequestMapping("/api")
public class CategoryController {
    private final Logger log = LoggerFactory.getLogger(GroupController.class);
    private UserRepository userRepository;
    private CategoryRepository categoryRepository;

    public CategoryController(UserRepository userRepository, CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/categories")
    Collection<Category> categories(Principal principal) {
        return categoryRepository.findAll();
    }
}
