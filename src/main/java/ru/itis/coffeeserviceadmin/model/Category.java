package ru.itis.coffeeserviceadmin.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String description;

    @OneToMany(mappedBy = "category")
    private List<Product> products;

//    @ManyToOne(cascade=CascadeType.PERSIST)
//    private User user;
//
//    @OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
//    private Set<Event> events;

    public void removeAllDeletedProducts() {
        this.products.removeIf(p -> p.getStatus().equals(ProductStatus.DELETED));
    }
}
