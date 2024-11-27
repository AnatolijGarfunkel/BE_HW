package org.telran.shop.de.service;

import org.telran.shop.de.entity.DiscountCard;

import java.util.List;

public interface DiscountCardService {

    List<DiscountCard> getAll();

    DiscountCard getById(String id);

    List<DiscountCard> filter(boolean expired);

    DiscountCard create(DiscountCard card);

    DiscountCard setExpired(String id);

    void deleteById(String id);

}
