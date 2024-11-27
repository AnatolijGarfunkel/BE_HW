package org.telran.shop.de.service;

import org.telran.shop.de.entity.User;

import java.util.List;

public interface UserService {

    List<User> getAll ();

    User getById(long id);

    User getByLogin(String login);

    List<User> getByFullAddress(String fullAddress);

    User create(User user);

    User update(long id, User user);

    User updateAddress(long id, User user);

    User delete(long id);

    List<User> getWithEqualsPassword(String password);

}
