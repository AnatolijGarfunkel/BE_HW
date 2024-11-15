package org.telran.shop.de.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telran.shop.de.entity.DiscountCard;
import org.telran.shop.de.repository.DiscountCardRepository;

import java.util.List;

@Service
public class DiscountCardServiceImpl implements DiscountCardService {

    @Autowired
    private DiscountCardRepository repository;


// GET -----------------------------------------------------------------------------------------------------------------

    @Override
    public List<DiscountCard> getAll() {
        return repository.findAll();
    }

    @Override
    public DiscountCard getById(long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<DiscountCard> filter(boolean expired) {
        return repository.findAllByExpired(expired);
    }

// POST ----------------------------------------------------------------------------------------------------------------

    @Override
    public DiscountCard create(DiscountCard card) {
        return repository.save(card);
    }

    @Override
    public DiscountCard setExpired(long id) {
//        DiscountCard card = new DiscountCard();
//        card.setId(id);
//        card.setExpired(true);
//        repository.save(card);
        repository.updateDiscountCardById(id);
        DiscountCard tempCard = getById(id);
        return tempCard;
    }

// DELETE --------------------------------------------------------------------------------------------------------------

    @Override
    public void deleteById(long id) {
        repository.deleteById(id);
    }

}
