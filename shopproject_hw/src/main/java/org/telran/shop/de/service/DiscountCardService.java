package org.telran.shop.de.service;

import org.telran.shop.de.entity.DiscountCard;

import java.util.List;

public interface DiscountCardService {

    List<DiscountCard> getAll();

    DiscountCard getById(long id);

    List<DiscountCard> filter(boolean expired);

    DiscountCard create(DiscountCard card);

    DiscountCard setExpired(long id);

    void deleteById(long id);

}
