package org.telran.shop.de.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "discount_cards")
@NoArgsConstructor
@Getter
@Setter
public class DiscountCard {

    @Id
    private String id;

    private boolean expired;


    public boolean isExpired() {
        return expired;
    }

    public void setExpired(boolean expired) {
        this.expired = expired;
    }
}
