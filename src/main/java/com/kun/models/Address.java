package com.kun.models;

import javax.persistence.*;

@Entity
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "aid", nullable = false)
    private int AID;

    @Column(name = "street", nullable = false)
    private String street;

    @Column(name = "zip", nullable = false, length = 5)
    private String zip;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "state", nullable = false, length = 2)
    private String State;

    @OneToOne(mappedBy = "address", cascade = CascadeType.ALL)
    @JoinColumn(name = "parkingid", nullable = false)
    private Parking parking;

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

    public Parking getParking() {
        return parking;
    }

    public void setParking(Parking parking) {
        this.parking = parking;
    }
}
