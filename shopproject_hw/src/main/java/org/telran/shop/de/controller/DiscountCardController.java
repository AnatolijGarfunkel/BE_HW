package org.telran.shop.de.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.telran.shop.de.entity.DiscountCard;
import org.telran.shop.de.service.DiscountCardService;

import java.util.List;


// getAll - GET    http://localhost:8080/api/discountcards
// create - POST   http://localhost:8080/api/discountcards
// getById- GET    http://localhost:8080/api/discountcards/5674
// delete - DELETE http://localhost:8080/api/discountcards/5674
// update - PUT    http://localhost:8080/api/discountcards/5657

// http://localhost:8080/api/discountcards/deleteCard/6567 !!!! Incorrect
// http://localhost:8080/api/discountcards/create !!!! Incorrect

// expire  http://localhost:8080/api/discountcards/expire/4356

@RestController
@RequestMapping("/api/discountcards")
public class DiscountCardController {

    @Autowired
    private DiscountCardService cardService;


// GET -----------------------------------------------------------------------------------------------------------------


    @GetMapping
    public List<DiscountCard> getAll() {
        return cardService.getAll();
    }

    @GetMapping("/{id}")
    public DiscountCard getById(@PathVariable(name = "id") String id) {
        return cardService.getById(id);
    }

    @GetMapping("/filter")
    public List<DiscountCard> getAllByState(@RequestParam(name = "expired") boolean expired) {
        return cardService.filter(expired);
    }

// POST ----------------------------------------------------------------------------------------------------------------

    @PostMapping
    public DiscountCard create(@RequestBody DiscountCard card) {
        return cardService.create(card);
    }

    @PutMapping("/expired/{id}")
    public DiscountCard setExpired(@PathVariable String id) {
        return cardService.setExpired(id);
    }

// DELETE --------------------------------------------------------------------------------------------------------------

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name = "id") String id) {
        cardService.deleteById(id);
    }

}
