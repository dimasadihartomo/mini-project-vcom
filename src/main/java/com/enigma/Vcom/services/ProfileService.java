package com.enigma.Vcom.services;

import com.enigma.Vcom.entities.Profile;
import com.enigma.Vcom.models.ProfileModel;

import java.util.List;

public interface ProfileService {

    void addProfile(ProfileModel profile);

    void updateProfile(ProfileModel profile);

    void deleteProfile(Profile profile);

    Profile findProfileById(Integer id);

    List<Profile> findAllProfile();
}
