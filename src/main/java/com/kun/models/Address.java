package com.kun.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "aid", nullable = false)
    private int AID;

    @NotBlank(message = "Can not be empty")
    @Column(name = "street", nullable = false)
    private String street;

    @NotBlank(message = "Can not be empty")
    @Column(name = "zip", nullable = false, length = 5)
    private String zip;

    @NotBlank(message = "Can not be empty")
    @Column(name = "city", nullable = false)
    private String city;

    @NotBlank(message = "Can not be empty")
    @Column(name = "state", nullable = false, length = 2)
    private String state;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Parking.class)
    private Set<Parking> parking = new HashSet<Parking>();

//    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
//    private User user;

    public int getAID() {
        return AID;
    }

    public void setAID(int AID) {
        this.AID = AID;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Set<Parking> getParking() {
        return parking;
    }

    public void setParking(Set<Parking> parking) {
        this.parking = parking;
    }

//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
}
