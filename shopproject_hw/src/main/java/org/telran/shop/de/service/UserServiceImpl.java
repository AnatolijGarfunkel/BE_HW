package org.telran.shop.de.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telran.shop.de.entity.Adress;
import org.telran.shop.de.entity.User;
import org.telran.shop.de.repository.UserJpaRepository;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserJpaRepository jpaRepository;

// GET -----------------------------------------------------------------------------------------------------------------

    @Override
    public List<User> getAll() {
        return jpaRepository.findAll();
    }

    @Override
    public User getById(long id) {
        return jpaRepository.findById(id).get();
    }

    @Override
    public User getByName(String login) {
        return jpaRepository.findByLogin(login);
    }

    @Override
    public List<User> getByFullAdress(String fullAddress) {
        return null;
    }

// POST ----------------------------------------------------------------------------------------------------------------

    @Override
    public User create(User user) {
        return jpaRepository.save(user);
    }

    @Override
    public User update(long id, User user) {
        User updatedUser = getById(id);
        if (user.getLogin() != null) {
            updatedUser.setLogin(user.getLogin());
        }
        if (user.getPassword() != null) {
            updatedUser.setPassword(user.getPassword());
        }
        if (user.getEmail() != null) {
            updatedUser.setEmail(user.getEmail());
        }
        if (user.getUserInfo() != null) {
            updatedUser.setUserInfo(user.getUserInfo());
        }
        if (user.getInformation() != null) {
            updatedUser.setInformation(user.getInformation());
        }
        if (!user.getAdresses().isEmpty()) {
            updatedUser.setAdresses(user.getAdresses());
        }
        if (user.getPassport() != null) {
            updatedUser.setPassport(user.getPassport());
        }
        return jpaRepository.save(updatedUser);
    }

    @Override
    public User updateAdress(long id, User user) {
        User updatedUser = getById(id);
        for (Adress data : user.getAdresses()) {
            updatedUser.getAdresses().add(data);
        }
        return jpaRepository.save(updatedUser);
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

