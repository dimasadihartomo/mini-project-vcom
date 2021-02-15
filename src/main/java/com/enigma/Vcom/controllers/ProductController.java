package com.enigma.Vcom.controllers;

import com.enigma.Vcom.entities.Product;
import com.enigma.Vcom.exceptions.EntityNotFoundException;
import com.enigma.Vcom.messages.ResponseMessage;
import com.enigma.Vcom.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping
@RestController
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping("/addproduct")
    public ResponseMessage<Product> add(@RequestBody @Valid Product model) {

        service.addProduct(model);
        return ResponseMessage.success(model);
    }

    @GetMapping("/products")
    public ResponseMessage<List<Product>> findAll() {
        List<Product> data = service.findAllProduct();
        return ResponseMessage.success(data);
    }

    @GetMapping("/products/price-min={min}max={max}")
    public ResponseMessage<List<Product>> findAllByPrice(@PathVariable Integer min, @PathVariable Integer max) {
        List<Product> data = service.findAllProductByPrice(min, max);
        return ResponseMessage.success(data);
    }

    @GetMapping("/product{id}")
    public ResponseMessage findById(@PathVariable Integer id) {

        Product data = service.findProductById(id);
        if (data == null) {
            throw new EntityNotFoundException();
        }

        return ResponseMessage.success(data);
    }

    @DeleteMapping("/product{id}")
    public ResponseMessage removeById(@PathVariable Integer id) {

        Product data = service.findProductById(id);
        if (data == null) {
            throw new EntityNotFoundException();
        }
        data.setStatus(!data.getStatus());
        service.updateProduct(data);

        return ResponseMessage.success(data);
    }

    @PutMapping("/product{id}")
    public ResponseMessage<Product> removeById(@PathVariable Integer id, @RequestBody Product model) {

        model.setId(id);
        service.updateProduct(model);

        return ResponseMessage.success(model);
    }
}
