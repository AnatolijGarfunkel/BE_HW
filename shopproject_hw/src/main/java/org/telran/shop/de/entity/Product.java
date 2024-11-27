package org.telran.shop.de.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.telran.shop.de.enums.ProductType;


@Entity
@Table(name = "products")
@NoArgsConstructor
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;

    @Enumerated(EnumType.STRING)
    private ProductType type;

}
