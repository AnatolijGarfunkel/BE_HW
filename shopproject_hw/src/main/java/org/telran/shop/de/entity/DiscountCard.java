package org.telran.shop.de.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "discount_cards")
public class DiscountCard {

    @Id
    private String id;

    private boolean expired;


    public DiscountCard() {
        //
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isExpired() {
        return expired;
    }

    public void setExpired(boolean expired) {
        this.expired = expired;
    }
}
