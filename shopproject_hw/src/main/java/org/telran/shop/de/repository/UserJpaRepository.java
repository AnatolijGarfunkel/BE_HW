package org.telran.shop.de.repository;

import jakarta.validation.constraints.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.telran.shop.de.entity.User;

import java.util.List;

@Repository
public interface UserJpaRepository extends JpaRepository<User, Long> {

    User findByLogin(String login);

    @Query("select user from User user where user.email =:email")
    User findUserByEmail(@Email String email);
}
