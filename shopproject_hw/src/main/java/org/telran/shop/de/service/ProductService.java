package org.telran.shop.de.service;

import org.telran.shop.de.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAll();

    Product getById(long id);

    List<Product> getByType(String type);

    Product getByTitle(String title);

    Product put(Product product);

    Product update(long id, Product product);

    Product deleteByTitle(String title);

    Product deleteById(long id);

}
