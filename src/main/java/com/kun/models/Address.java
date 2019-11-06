package com.kun.models;

import javax.persistence.*;
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

    @NotEmpty(message = "Can not be empty")
    @Column(name = "street", nullable = false)
    private String street;

    @NotEmpty(message = "Can not be empty")
    @Column(name = "zip", nullable = false, length = 5)
    private String zip;

    @NotEmpty(message = "Can not be empty")
    @Column(name = "city", nullable = false)
    private String city;

    @NotEmpty(message = "Can not be empty")
    @Column(name = "state", nullable = false, length = 2)
    private String State;

    @OneToMany(mappedBy = "address", cascade = CascadeType.ALL)
    private Set<Parking> parking = new HashSet<Parking>();

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
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public Set<Parking> getParking() {
        return parking;
    }

    public void setParking(Set<Parking> parking) {
        this.parking = parking;
    }

}
