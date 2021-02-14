package com.enigma.Vcom.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ProfileModel {

    private Integer id;

    @NotBlank
    @Size(min = 1, max = 100)
    private String firstName;

    @NotBlank
    @Size(min = 1, max = 100)
    private String lastName;

    @NotBlank
    @Size(min = 1, max = 100)
    private String email;

    @NotBlank
    @Size(min = 1, max = 100)
    private String mobileNumber;

    @NotBlank
    @Size(min = 1, max = 100)
    private String birthDate;

    @NotBlank
    @Size(min = 1, max = 100)
    private String gender;

    @NotBlank
    @Size(min = 1, max = 100)
    private String country;

    private Integer vPocket = 0;

    private Boolean status = true;

    private Integer userId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getvPocket() {
        return vPocket;
    }

    public void setvPocket(Integer vPocket) {
        this.vPocket = vPocket;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
