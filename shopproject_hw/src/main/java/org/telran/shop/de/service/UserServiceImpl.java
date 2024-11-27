package org.telran.shop.de.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telran.shop.de.entity.Address;
import org.telran.shop.de.entity.User;
import org.telran.shop.de.repository.UserJpaRepository;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserJpaRepository jpaRepository;

// GET -----------------------------------------------------------------------------------------------------------------

    @Override
    public User getByLogin(String login) {
        return jpaRepository.findByLogin(login);
    }

// POST ----------------------------------------------------------------------------------------------------------------

    @Override
    public User create(User user) {
        return jpaRepository.save(user);
    }

    @Override
    public List<User> getWithEqualsPassword(String password) {
        return jpaRepository.findAllByPassword(password);
    }

// DELETE --------------------------------------------------------------------------------------------------------------

    @Override
    public User delete(long id) {
        User user = jpaRepository.findById(id).get();
        jpaRepository.delete(user);
        return user;
    }

}

