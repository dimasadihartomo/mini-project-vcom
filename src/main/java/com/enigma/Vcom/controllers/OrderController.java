package com.enigma.Vcom.controllers;

import com.enigma.Vcom.entities.Order;
import com.enigma.Vcom.entities.Product;
import com.enigma.Vcom.entities.Profile;
import com.enigma.Vcom.exceptions.EntityNotFoundException;
import com.enigma.Vcom.exceptions.MoneyNotEnoughException;
import com.enigma.Vcom.messages.ResponseMessage;
import com.enigma.Vcom.models.OrderModel;
import com.enigma.Vcom.models.ProfileModel;
import com.enigma.Vcom.services.OrderService;
import com.enigma.Vcom.services.ProductService;
import com.enigma.Vcom.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping
@RestController
public class OrderController {

    @Autowired
    private OrderService service;

    @Autowired
    private ProfileService profileService;

    @Autowired
    private ProductService productService;

    @PostMapping("/addorder")
    public ResponseMessage<OrderModel> add(@RequestBody @Valid OrderModel model) {

        Profile profile = profileService.findProfileById(model.getProfileId());
        Product product = productService.findProductById(model.getProductId());

        if (profile.getvPocket() < product.getPrice()) {
            throw new MoneyNotEnoughException();
        }
        service.addOrder(model);

        ProfileModel entity = new ProfileModel();
        entity.setId(model.getProfileId());
        entity.setBirthDate(profile.getBirthDate());
        entity.setCountry(profile.getCountry());
        entity.setEmail(profile.getEmail());
        entity.setFirstName(profile.getFirstName());
        entity.setGender(profile.getGender());
        entity.setLastName(profile.getLastName());
        entity.setMobileNumber(profile.getMobileNumber());
        entity.setStatus(profile.getStatus());
        entity.setvPocket(profile.getvPocket() - product.getPrice());
        entity.setUserId((int) profile.getUser().getId());
        profileService.updateProfile(entity);

        return ResponseMessage.success(model);
    }

    @GetMapping("/orders")
    public ResponseMessage<List<Order>> findAll() {
        List<Order> data = service.findAllOrder();
        return ResponseMessage.success(data);
    }

    @GetMapping("/order{id}")
    public ResponseMessage findById(@PathVariable Integer id) {

        Order data = service.findOrderById(id);
        if (data == null) {
            throw new EntityNotFoundException();
        }

        return ResponseMessage.success(data);
    }

    @DeleteMapping("/order{id}")
    public ResponseMessage removeById(@PathVariable Integer id) {

        Order data = service.findOrderById(id);
        if (data == null) {
            throw new EntityNotFoundException();
        }

        service.deleteOrder(data);

        return ResponseMessage.success(data);
    }

    @PutMapping("/order{id}")
    public ResponseMessage<OrderModel> removeById(@PathVariable Integer id, @RequestBody OrderModel model) {

        model.setId(id);
        service.updateOrder(model);

        return ResponseMessage.success(model);
    }
}
