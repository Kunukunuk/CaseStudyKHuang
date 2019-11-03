package com.kun.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "parkings")
public class Parking {

    @Id
    @Column(name = "parkingid", nullable = false)
    private int PID;

    @Column(name = "length", nullable = false)
    private int length;

    @Column(name = "width", nullable = false)
    private int width;

    @Column(name = "creationDate", nullable = false)
    private Date creationDate;

    @Column(name = "availableFrom", nullable = false)
    private Date availableDate;

    @Column(name = "availableEnd", nullable = false)
    private Date endDate;

    @OneToOne
    @JoinColumn(name = "username", nullable = false)
    private User user;

    @Column(name = "price", nullable = false)
    private int price;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
