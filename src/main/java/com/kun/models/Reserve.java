package com.kun.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "reserves")
public class Reserve {

    @Id
    @Column(name = "rid", nullable = false)
    private int RID;

    @Column(name = "reserveDate", nullable = false)
    private Date creationDate;

    @OneToOne
    @JoinColumn(name = "parkingid", nullable = false)
    private Parking parking;

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

    public Parking getParking() {
        return parking;
    }

    public void setParking(Parking parking) {
        this.parking = parking;
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
}
