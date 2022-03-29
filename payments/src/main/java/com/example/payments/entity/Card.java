package com.example.payments.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "test_card")
public class Card implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="card_number" , unique = true )
    @Size(min =4)
    private Long cardNumber;
    private Long cardBalance;
    @Column( unique = true )
    @Size(min =4)
    private Long cardBankCode;
    private String cardName;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date carddate;

    @PrePersist
    private void onCreate() {
        carddate = new Date();}

    public Long getId() {
        return id;
    }

    public Date getCarddate() {
        return carddate;
    }

    public void setCarddate(Date carddate) {
        this.carddate = carddate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(Long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Long getCardBalance() {
        return cardBalance;
    }

    public void setCardBalance(Long cardBalance) {
        this.cardBalance = cardBalance;
    }

    public Long getCardBankCode() {
        return cardBankCode;
    }

    public void setCardBankCode(Long cardBankCode) {
        this.cardBankCode = cardBankCode;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }
}
