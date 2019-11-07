package com.kun.models;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "parkings")
public class Parking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "parkingid")
    private int PID;

    @Min(value = 0, message = "Must be a positive number")
    @Column(name = "length", nullable = false)
    private int length;

    @Min(value = 0, message = "Must be a positive number")
    @Column(name = "width", nullable = false)
    private int width;

    @CreationTimestamp
    @Temporal(TemporalType.DATE)
    @Column(name = "creationDate")
    private Date creationDate;

    @NotNull
    @FutureOrPresent
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
    @Column(name = "availableFrom", nullable = false)
    private Date availableDate;

    @NotNull
    @FutureOrPresent
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
    @Column(name = "availableEnd", nullable = false)
    private Date endDate;

    @Min(value = 0, message = "Must be a positive number")
    @Column(name = "price", nullable = false)
    private int price;

    @Valid
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "addressid", nullable = false)
    private Address address;

    public int getPID() {
        return PID;
    }

    public void setPID(int PID) {
        this.PID = PID;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getAvailableDate() {
        return availableDate;
    }

    public void setAvailableDate(Date availableDate) {
        this.availableDate = availableDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Parking{" +
                "PID=" + PID +
                ", length=" + length +
                ", width=" + width +
                ", creationDate=" + creationDate +
                ", availableDate=" + availableDate +
                ", endDate=" + endDate +
                ", price=" + price +
                ", address=" + address +
                '}';
    }
}
