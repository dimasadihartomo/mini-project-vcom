package com.enigma.Vcom.controllers;

import com.enigma.Vcom.entities.Payment;
import com.enigma.Vcom.entities.Profile;
import com.enigma.Vcom.exceptions.EntityNotFoundException;
import com.enigma.Vcom.messages.ResponseMessage;
import com.enigma.Vcom.models.PaymentModel;
import com.enigma.Vcom.models.ProfileModel;
import com.enigma.Vcom.services.PaymentService;
import com.enigma.Vcom.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping
@RestController
public class PaymentController {

    @Autowired
    private PaymentService service;

    @Autowired
    private ProfileService profileService;

    @PostMapping("/topup")
    public ResponseMessage<PaymentModel> add(@RequestBody @Valid PaymentModel model) {

        service.addPayment(model);

        Profile profile = profileService.findProfileById(model.getProfileId());
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
        entity.setvPocket(profile.getvPocket() + model.getAmount());
        entity.setUserId((int) profile.getUser().getId());
        profileService.updateProfile(entity);

        return ResponseMessage.success(model);
    }

    @GetMapping("/payments")
    public ResponseMessage<List<Payment>> findAll() {
        List<Payment> data = service.findAllPayment();
        return ResponseMessage.success(data);
    }

    @GetMapping("/payment{id}")
    public ResponseMessage findById(@PathVariable Integer id) {

        Payment data = service.findPaymentById(id);
        if (data == null) {
            throw new EntityNotFoundException();
        }

        return ResponseMessage.success(data);
    }

    @DeleteMapping("/payment{id}")
    public ResponseMessage removeById(@PathVariable Integer id) {

        Payment data = service.findPaymentById(id);
        if (data == null) {
            throw new EntityNotFoundException();
        }

        service.deletePayment(data);

        return ResponseMessage.success(data);
    }

    @PutMapping("/payment{id}")
    public ResponseMessage<PaymentModel> removeById(@PathVariable Integer id, @RequestBody PaymentModel model) {

        model.setId(id);
        service.updatePayment(model);

        return ResponseMessage.success(model);
    }
}
