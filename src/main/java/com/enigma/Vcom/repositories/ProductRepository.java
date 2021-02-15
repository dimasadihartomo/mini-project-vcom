package com.enigma.Vcom.repositories;

import com.enigma.Vcom.entities.Product;

import java.util.List;

public interface ProductRepository {

    boolean save(Product product);

    boolean update(Product product);

    Product findById(Integer id);

    List<Product> findAllbyTitle(String title);

    List<Product> findAllbyType(String type);

    List<Product> findAllbyPrice(Integer min, Integer max);

    List<Product> findAll();
}
