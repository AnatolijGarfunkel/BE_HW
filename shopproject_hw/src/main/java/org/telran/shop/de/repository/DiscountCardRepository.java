package org.telran.shop.de.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.telran.shop.de.entity.DiscountCard;

import java.util.List;

@Repository
public interface DiscountCardRepository extends JpaRepository<DiscountCard, Long> {

    List<DiscountCard> findAllByExpired(boolean expired);

//    @Modifying
//    @Query("update DiscountCard c set c.expired = true where c.id =:id")
//    DiscountCard updateDiscountCardById(@Param("id") long id);

    @Modifying
    @Query("update DiscountCard card set card.expired = true where card.id =:id")
    DiscountCard updateDiscountCardById(long id);
}
