package com.kun.models;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "reserves")
public class Reserve {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rid", nullable = false)
    private int RID;

    @Column(name = "reserveDate", nullable = false)
    private Date creationDate;

    @OneToMany
    @JoinColumn(name = "parkingid", nullable = false)
    private Set<Parking> parking = new HashSet<Parking>();

    @Column(name = "price", nullable = false)
    private int price;

    @OneToOne
    @JoinColumn(name = "username", nullable = false)
    private User user;

    @OneToOne
    @JoinColumn(name = "payid", nullable = false)
    private Payment payment;

    public int getRID() {
        return RID;
    }

    public void setRID(int RID) {
        this.RID = RID;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Set<Parking> getParking() {
        return parking;
    }

    public void setParking(Set<Parking> parking) {
        this.parking = parking;
    }
}
