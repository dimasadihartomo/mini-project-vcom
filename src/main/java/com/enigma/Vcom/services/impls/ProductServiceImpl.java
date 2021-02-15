package com.enigma.Vcom.services.impls;

import com.enigma.Vcom.entities.Product;
import com.enigma.Vcom.repositories.ProductRepository;
import com.enigma.Vcom.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public void addProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public void updateProduct(Product product) {
        productRepository.update(product);
    }

    @Override
    public Product findProductById(Integer id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> findAllProductByPrice(Integer min, Integer max) {
        return productRepository.findAllbyPrice(min, max);
    }

    @Override
    public List<Product> findAllProductByTitle(String title) {
        return productRepository.findAllbyTitle(title);
    }

    @Override
    public List<Product> findAllProductByType(String type) {
        return productRepository.findAllbyType(type);
    }

    @Override
    public List<Product> findAllProduct() {
        return productRepository.findAll();
    }
}
