package com.example.payments.entity;

import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "test_account")
public class Account implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "card_and_account" , joinColumns=@JoinColumn(name = "account_id" , referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name ="card_id" , referencedColumnName = "card_number"))
    private Set<Card> cards ;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Card> getCards() {
        return cards;
    }

    public void setCards(Set<Card> cards) {
        this.cards = cards;
    }
}
