package org.telran.shop.de.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telran.shop.de.entity.Product;
import org.telran.shop.de.enums.ProductType;
import org.telran.shop.de.repository.ProductRepository;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;


// GET -----------------------------------------------------------------------------------------------------------------

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product getById(long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public List<Product> getByType(String type) {
        return productRepository.findAllByType(ProductType.valueOf(type));
    }

    @Override
    public Product getByTitle(String title) {
        return productRepository.findByTitle(title);
    }

// POST ----------------------------------------------------------------------------------------------------------------

    @Override
    public Product put(Product product) {
        return productRepository.save(product);
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
        return productRepository.save(updatedProduct);
    }

// DELETE --------------------------------------------------------------------------------------------------------------

    @Override
    public Product deleteById(long id) {
        Product product = getById(id);
        productRepository.deleteById(id);
        return product;
    }

    @Override
    public Product deleteByTitle(String title) {
        Product product = getByTitle(title);
        long id = product.getId();
        productRepository.deleteById(id);
        return product;
    }
}
