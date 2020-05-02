package ru.itis.coffeeserviceadmin.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    private float price;

    private String name;
    private String description;

//    @ManyToMany(mappedBy = "products")
//    private List<OrderItem> orders;

    @Enumerated(EnumType.STRING)
    private ProductStatus status;

//    @ManyToOne(cascade=CascadeType.PERSIST)
//    private User user;
//
//    @OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
//    private Set<Event> events;

    public void postProduct() {
        if(this.status.equals(ProductStatus.DELETED)) {
            throw new IllegalArgumentException();
        } else if (this.status.equals(ProductStatus.DRAFT)) {
            this.status = ProductStatus.PUBLISHED;
        }
    }
}
