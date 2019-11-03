package com.kun.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "reserves")
public class Reserve {

    @Id
    @Column(name = "rid", nullable = false)
    private int RID;

    @Column(name = "reserveDate", nullable = false)
    private Date creationDate;

    @Column(name = "parkingID", nullable = false)
    private Parking parking;

    @Column(name = "price", nullable = false)
    private int price;

    @Column(name = "username", nullable = false)
    private User user;

    @Column(name = "payid", nullable = false)
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
