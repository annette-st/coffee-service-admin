package ru.itis.coffeeserviceadmin.web;

import ru.itis.coffeeserviceadmin.model.Product;
import ru.itis.coffeeserviceadmin.repository.ProductRepository;
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
public class ProductController {
    private final Logger log = LoggerFactory.getLogger(GroupController.class);
    private UserRepository userRepository;
    private ProductRepository productRepository;

    public ProductController(UserRepository userRepository, ProductRepository productRepository) {
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    @GetMapping("/products")
    Collection<Product> products(Principal principal) {
        return productRepository.findAll();
    }
}
