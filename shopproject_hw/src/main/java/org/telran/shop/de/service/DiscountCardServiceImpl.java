package org.telran.shop.de.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telran.shop.de.entity.DiscountCard;
import org.telran.shop.de.exception.AlreadyExist;
import org.telran.shop.de.exception.NotFoundException;
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
    public DiscountCard getById(String id) {
        DiscountCard cardById = repository.findDiscountCardById(id);
        if (cardById == null) {
            throw new NotFoundException("Discount Card with id " + id + " not found");
        }
        return repository.findDiscountCardById(id);
    }

    @Override
    public List<DiscountCard> filter(boolean expired) {
        List<DiscountCard> byExpired = repository.findAllByExpired(expired);
        if (byExpired.isEmpty()) {
            throw new NotFoundException("There are no Discount Cards with expired flag " + expired);
        }
        return byExpired;
    }

// POST ----------------------------------------------------------------------------------------------------------------

    @Override
    public DiscountCard create(DiscountCard card) {
        DiscountCard cardById = repository.findDiscountCardById(card.getId());
        if (cardById != null) {
            throw new AlreadyExist("Card with id " + card.getId() + " already exists");
        }
        return repository.save(card);
    }

    @Override
    public DiscountCard setExpired(String id) {
        DiscountCard card = new DiscountCard();
        card.setId(id);
        card.setExpired(true);
        repository.save(card);
//        repository.updateDiscountCardById(id);
        DiscountCard tempCard = getById(id);
        return tempCard;
    }

// DELETE --------------------------------------------------------------------------------------------------------------

    @Override
    public void deleteById(String id) {
        repository.deleteDiscountCardById(id);
    }

}
