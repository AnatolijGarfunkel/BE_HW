package org.telran.shop.de.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.telran.shop.de.entity.User;

import java.util.List;

@Repository
public interface UserJpaRepository extends JpaRepository<User, Long> {

    User findByLogin(String login);

    List<User> findAllByPassword(String password);

    @Query("select u from User u where u.userInfo is not null")
    List<User> getUserWithUserInfo();

//    @Query("select Adress.fullAdress, User.login from Adress inner join User on Adress.user_id = User.id where Adress.fullAdress =:fullAddress")
//    List<User> findAllByAdresses(@Param("fullAddress") String fullAddress);
}