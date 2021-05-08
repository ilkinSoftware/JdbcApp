/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entity;

import java.sql.Date;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public class User {

    private String name;
    private String surName;
    private String email;
    private String phone;
    private int id;
    private Date birthyDate;
    private Country nationality;
    private Country birtypalce;
    private List<UserSkill> userSkill;
    private String address;
    private String profileDesc;

    public User() {
    }

    public User(int id) {
        this.id = id;
    }

    public User(String name, String surName, String email, String phone, int id, Date birthyDate, Country nationality, Country birtypalce, String address, String profileDesc) {
        this.name = name;
        this.surName = surName;
        this.email = email;
        this.phone = phone;
        this.id = id;
        this.birthyDate = birthyDate;
        this.nationality = nationality;
        this.birtypalce = birtypalce;
        this.profileDesc = profileDesc;
        this.address = address;
    }

    public Date getBirthyDate() {
        return birthyDate;
    }

    public void setBirthyDate(Date birthyDate) {
        this.birthyDate = birthyDate;
    }

    public Country getNationality() {
        return nationality;
    }

    public void setNationality(Country nationality) {
        this.nationality = nationality;
    }

    public Country getBirtypalce() {
        return birtypalce;
    }

    public void setBirtypalce(Country birtypalce) {
        this.birtypalce = birtypalce;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<UserSkill> getUserSkill() {
        return userSkill;
    }

    public void setUserSkill(List<UserSkill> userSkill) {
        this.userSkill = userSkill;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getProfileDesc() {
        return profileDesc;
    }

    public void setProfileDesc(String profileDesc) {
        this.profileDesc = profileDesc;
    }

    @Override
    public String toString() {
        return "User{" + "name=" + name + ", surName=" + surName + ", email=" + email + ", phone=" + phone + ", id=" + id + ", birthyDate=" + birthyDate + ", nationality=" + nationality + ", birtypalce=" + birtypalce + ", address=" + address + ", profileDesc=" + profileDesc + '}';
    }

}
