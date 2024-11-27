package org.telran.shop.de.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telran.shop.de.entity.Address;
import org.telran.shop.de.entity.User;
import org.telran.shop.de.exception.AllreadyExist;
import org.telran.shop.de.exception.NotFoundException;
import org.telran.shop.de.repository.UserJpaRepository;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserJpaRepository jpaRepository;

// GET -----------------------------------------------------------------------------------------------------------------

    @Override
    public User getByLogin(String login) {
        User user = jpaRepository.findByLogin(login);
        if (user == null) {
            throw new NotFoundException("User with login " + login + " not found");
        }
        return jpaRepository.findByLogin(login);
    }

// POST ----------------------------------------------------------------------------------------------------------------

    @Override
    public User create(User user) {
        User login = jpaRepository.findByLogin(user.getLogin());
        if (login != null) {
            throw new AllreadyExist("User with login " + user.getLogin() + " already exists");
        }
        User byEmail = jpaRepository.findUserByEmail(user.getEmail());
        if (byEmail != null) {
            throw new AllreadyExist("User with email " + user.getEmail() + " already exists");
        }
        return jpaRepository.save(user);
    }

// DELETE --------------------------------------------------------------------------------------------------------------

    @Override
    public User delete(long id) {
        User user = jpaRepository.findById(id).get();
        jpaRepository.delete(user);
        return user;
    }

}

