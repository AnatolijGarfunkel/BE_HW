package org.telran.shop.de.service;

import org.telran.shop.de.entity.User;

public interface UserService {

    User getByLogin(String login);

    User create(User user);

    User delete(long id);
}
