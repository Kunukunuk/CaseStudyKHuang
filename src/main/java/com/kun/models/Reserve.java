package com.kun.models;

import javax.persistence.*;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
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

    @FutureOrPresent
    @Column(name = "reserveDate", nullable = false)
    private Date creationDate;

    @OneToMany(mappedBy = "reserve", cascade = CascadeType.ALL)
    private Set<Parking> parking = new HashSet<Parking>();

    @NotEmpty(message = "Can not be empty")
    @Min(value = 0, message = "Must be positive")
    @Column(name = "price", nullable = false)
    private int price;

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
