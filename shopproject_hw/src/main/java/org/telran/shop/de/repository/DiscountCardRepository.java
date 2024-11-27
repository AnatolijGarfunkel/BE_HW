package org.telran.shop.de.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.telran.shop.de.entity.DiscountCard;

import java.util.List;

@Repository
public interface DiscountCardRepository extends JpaRepository<DiscountCard, Long> {

    List<DiscountCard> findAllByExpired(boolean expired);

    @Modifying
    @Query("update DiscountCard card set card.expired = true where card.id =:id")
    DiscountCard updateDiscountCardById(String id);

    @Query("select card from DiscountCard card where card.id =:id")
    DiscountCard findDiscountCardById(String id);

    void deleteDiscountCardById(String id);
}
