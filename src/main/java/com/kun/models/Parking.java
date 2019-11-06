package com.kun.models;

import javax.persistence.*;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
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

    @NotEmpty(message = "Can not be empty")
    @Column(name = "creationDate", nullable = false)
    private Date creationDate;

    @FutureOrPresent
    @NotEmpty(message = "Can not be empty")
    @Column(name = "availableFrom", nullable = false)
    private Date availableDate;

    @FutureOrPresent
    @NotEmpty(message = "Can not be empty")
    @Column(name = "availableEnd", nullable = false)
    private Date endDate;

    @Min(value = 0, message = "Must be a positive number")
    @Column(name = "price", nullable = false)
    private int price;

    @ManyToOne
    private Address address;

    @ManyToOne
    private Reserve reserve;

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

    public Reserve getReserve() {
        return reserve;
    }

    public void setReserve(Reserve reserve) {
        this.reserve = reserve;
    }
}
