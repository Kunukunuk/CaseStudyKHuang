package com.kun.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "payments")
public class Payment {

    @Id
    @Column(name = "payid", nullable = false)
    private int payID;

    @Column(name = "dateofpayment", nullable = false)
    private Date dateOfPayment;

    @Column(name = "cardtype", nullable = false)
    private String cardType;

    @Column(name = "cardnumber", nullable = false)
    private String cardNumber;

    @Column(name = "nameoncard", nullable = false)
    private String nameOnCard;

    @Column(name = "price", nullable = false)
    private int price;

    @Column(name = "paysuccess", nullable = false)
    private boolean success;

    public int getPayID() {
        return payID;
    }

    public void setPayID(int payID) {
        this.payID = payID;
    }

    public Date getDateOfPayment() {
        return dateOfPayment;
    }

    public void setDateOfPayment(Date dateOfPayment) {
        this.dateOfPayment = dateOfPayment;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getNameOnCard() {
        return nameOnCard;
    }

    public void setNameOnCard(String nameOnCard) {
        this.nameOnCard = nameOnCard;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
