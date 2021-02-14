package com.enigma.Vcom.repositories;

import com.enigma.Vcom.entities.Profile;
import com.enigma.Vcom.models.ProfileModel;

import java.util.List;

public interface ProfileRepository {

    boolean save(ProfileModel profile);

    boolean update(ProfileModel profile);

    boolean delete(Profile profile);

    Profile findById(Integer id);

    List<Profile> findAll();
}
