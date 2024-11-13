package org.telran.shop.de.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.telran.shop.de.entity.User;

import java.util.List;

@Repository
public interface UserJpaRepository extends JpaRepository<User, Long> {

    User findByLogin(String login);

    List<User> findAllByPassword(String password);

    @Query("select u from User u where u.userInfo is not null")
    List<User> getUserWithUserInfo();

    @Query("select u from Adress a inner join User u on a.user_id = u.id where a.fullAdress =:fullAddress")
    List<User> findAllByAdresses(@Param("fullAddress") String fullAddress);
}
