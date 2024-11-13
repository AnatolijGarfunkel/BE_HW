package org.telran.shop.de.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "passport")
public class Passport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nummber;

    public Passport() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNummber() {
        return nummber;
    }

    public void setNummber(String nummber) {
        this.nummber = nummber;
    }
}
