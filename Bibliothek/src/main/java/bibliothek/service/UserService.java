package bibliothek.service;

import bibliothek.entity.User;

import java.util.List;

public interface UserService {

    List<User> getAll();

    User getById(int id);

    User getByName(String firstName, String lastName);

    List<User> getByFirstName(String firstName);

    List<User> getByLastName(String lastName);

    List<User> getByLand(String land);

    List<User> filter(String field, String param);

    User create(User user);

    User update(int id, User user);

    User delete(int id);

}
