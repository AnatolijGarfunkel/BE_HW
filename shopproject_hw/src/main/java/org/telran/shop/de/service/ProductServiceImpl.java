package org.telran.shop.de.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telran.shop.de.entity.Product;
import org.telran.shop.de.enums.ProductType;
import org.telran.shop.de.exception.NotFoundException;
import org.telran.shop.de.repository.ProductRepository;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository repository;


// GET -----------------------------------------------------------------------------------------------------------------

    @Override
    public List<Product> getAll() {
        List<Product> all = repository.findAll();
        return all;
    }

    @Override
    public Product getById(long id) {
        return repository
                .findById(id)
                .orElseThrow(
                        () -> new NotFoundException("Product wiht id " + id + " not found")
                );
    }

    @Override
    public List<Product> getByType(String type) {
        return repository.findAllByType(ProductType.valueOf(type));
    }

    @Override
    public Product getByTitle(String title) {
        Product product = repository.findByTitle(title);
        if (product == null) {
            throw new NotFoundException("Product with title " + title + " not found");
        }
        return product;
    }

// POST ----------------------------------------------------------------------------------------------------------------

    @Override
    public Product put(Product product) {
        return repository.save(product);
    }

    @Override
    public Product update(long id, Product product) {
        Product updatedProduct = getById(id);
        if (product.getTitle() != null) {
            updatedProduct.setTitle(product.getTitle());
        }
        if (product.getType() != null) {
            updatedProduct.setType(product.getType());
        }
        return repository.save(updatedProduct);
    }

// DELETE --------------------------------------------------------------------------------------------------------------

    @Override
    public Product deleteById(long id) {
        Product product = getById(id);
        repository.deleteById(id);
        return product;
    }

    @Override
    public Product deleteByTitle(String title) {
        Product product = getByTitle(title);
        long id = product.getId();
        repository.deleteById(id);
        return product;
    }


}
