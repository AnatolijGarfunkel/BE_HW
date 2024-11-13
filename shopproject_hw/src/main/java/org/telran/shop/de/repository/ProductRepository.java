package org.telran.shop.de.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.telran.shop.de.entity.Product;
import org.telran.shop.de.enums.ProductType;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByType(ProductType type);

    Product findByTitle(String title);

    void deleteByTitle(String title);
}
