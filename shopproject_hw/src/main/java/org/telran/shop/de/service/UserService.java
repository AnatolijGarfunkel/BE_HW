package org.telran.shop.de.service;

import org.telran.shop.de.entity.User;

import java.util.List;

public interface UserService {

    List<User> getAll ();

    User getById(long id);

    User getByName(String login);

    List<User> getByFullAdress(String fullAddress);

    User create(User user);

    User update(long id, User user);

    User updateAdress(long id, User user);

    User delete(long id);

    List<User> getWithEqualsPassword(String password);

}
