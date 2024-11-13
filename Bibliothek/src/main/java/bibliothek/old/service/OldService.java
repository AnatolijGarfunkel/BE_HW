package bibliothek.old.service;

import bibliothek.old.model.User;

import java.util.List;


public interface OldService {

    List<User> getAll();

    User getById(int id);

    User getByName(String firstName, String lastName);

    List<User> getByFirstName(String firstName);

    List<User> getByLastName(String lastName);

    List<User> getByLand(String land);

    User create(User user);

    User update(int id, User user);

    User delete(int id);

    List<User> filter(String field, String param);
}
