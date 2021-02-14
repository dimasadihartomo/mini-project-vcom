package com.enigma.Vcom.services.impls;

import com.enigma.Vcom.entities.Profile;
import com.enigma.Vcom.models.ProfileModel;
import com.enigma.Vcom.repositories.ProfileRepository;
import com.enigma.Vcom.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    ProfileRepository profileRepository;

    @Override
    public void addProfile(ProfileModel profile) {
        profileRepository.save(profile);
    }

    @Override
    public void updateProfile(ProfileModel profile) {
        profileRepository.update(profile);
    }

    @Override
    public void deleteProfile(Profile profile) {
        profileRepository.delete(profile);
    }

    @Override
    public Profile findProfileById(Integer id) {
        return profileRepository.findById(id);
    }

    @Override
    public List<Profile> findAllProfile() {
        return profileRepository.findAll();
    }
}
