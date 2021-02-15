package com.enigma.Vcom.services;

import com.enigma.Vcom.entities.Product;

import java.util.List;

public interface ProductService {

    void addProduct(Product product);

    void updateProduct(Product product);

    Product findProductById(Integer id);

    List<Product> findAllProductByPrice(Integer min, Integer max);

    List<Product> findAllProductByTitle(String title);

    List<Product> findAllProductByType(String type);

    List<Product> findAllProduct();
}
