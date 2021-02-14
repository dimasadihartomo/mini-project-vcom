package com.enigma.Vcom.controllers;

import com.enigma.Vcom.entities.Profile;
import com.enigma.Vcom.exceptions.EntityNotFoundException;
import com.enigma.Vcom.messages.ResponseMessage;
import com.enigma.Vcom.models.ProfileModel;
import com.enigma.Vcom.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping
@RestController
public class ProfileController {

    @Autowired
    private ProfileService service;

    @PostMapping("/addprofile")
    public ResponseMessage<ProfileModel> add(@RequestBody @Valid ProfileModel model) {

        service.addProfile(model);
        return ResponseMessage.success(model);
    }

    @GetMapping("/profiles")
    public ResponseMessage<List<Profile>> findAll() {
        List<Profile> data = service.findAllProfile();
        return ResponseMessage.success(data);
    }

    @GetMapping("/profile{id}")
    public ResponseMessage findById(@PathVariable Integer id) {

        Profile data = service.findProfileById(id);
        if (data == null) {
            throw new EntityNotFoundException();
        }

        return ResponseMessage.success(data);
    }

    @DeleteMapping("/profile{id}")
    public ResponseMessage removeById(@PathVariable Integer id) {

        Profile data = service.findProfileById(id);
        if (data == null) {
            throw new EntityNotFoundException();
        }

        service.deleteProfile(data);

        return ResponseMessage.success(data);
    }

    @PutMapping("/profile{id}")
    public ResponseMessage<ProfileModel> removeById(@PathVariable Integer id, @RequestBody ProfileModel model) {

        model.setId(id);
        service.updateProfile(model);

        return ResponseMessage.success(model);
    }
}
