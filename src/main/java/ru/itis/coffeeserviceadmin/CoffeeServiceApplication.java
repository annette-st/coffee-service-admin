package ru.itis.coffeeserviceadmin;

import ru.itis.coffeeserviceadmin.model.Category;
import ru.itis.coffeeserviceadmin.repository.CategoryRepository;
import ru.itis.coffeeserviceadmin.repository.ProductRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import static java.util.Arrays.asList;

@SpringBootApplication
public class CoffeeServiceApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(CoffeeServiceApplication.class, args);

        CategoryRepository categoryRepository = context.getBean(CategoryRepository.class);
        ProductRepository productRepository = context.getBean(ProductRepository.class);

        /* CATEGORIES */
        Category coffee = Category.builder()
                .name("Coffee to go")
                .description("Caffeine-containing drinks")
                .build();

        Category teas = Category.builder()
                .name("Herbal teas")
                .description("Herbal teas with different additives")
                .build();

        Category cookies = Category.builder()
                .name("Cookies")
                .description("Excellent addition to drinks")
                .build();
        /* categories */

        categoryRepository.saveAll(asList(
                coffee, teas, cookies
        ));

//        /* PRODUCTS */
//        Product americano = Product.builder()
//                .category(coffee)
//                .name("Caffe Americano")
//                .description("A coffee drink prepared by diluting an espresso with hot water.")
//                .price(2)
//                .status(ProductStatus.DELETED)
//                .build();
////
//        Product latte = Product.builder()
//                .category(coffee)
//                .name("Caffe Latte")
//                .description("A coffee drink made with espresso and steamed milk.")
//                .price(3)
//                .status(ProductStatus.PUBLISHED)
//                .build();
//
//        Product masala = Product.builder()
//                .category(teas)
//                .name("Masala chai")
//                .description("a flavoured tea beverage made by brewing black tea with a mixture of aromatic Indian spices and herbs.")
//                .price(2)
//                .status(ProductStatus.DRAFT)
//                .build();
//
//        Product vanilla = Product.builder()
//                .category(teas)
//                .name("Vanilla tea")
//                .description(" a warm beverage that contains black tea, vanilla flavoring and steamed milk.")
//                .price(2)
//                .status(ProductStatus.DRAFT)
//                .build();
//        /* products */
//
//        productRepository.save(americano);
//
//        productRepository.saveAll(asList(
//                americano, latte, masala, vanilla
//        ));

    }
}