package bibliothek.service;

import bibliothek.entity.Author;

import java.util.List;

public interface AuthorService {

    List<Author> getAll();

    Author getById(int id);

    Author getByName(String firstName, String lastName);

    List<Author> getByFirstName(String firstName);

    List<Author> getByLastName(String lastName);

    List<Author> getByLand(String land);

    List<Author> filter(String field, String param);

    Author create(Author author);

    Author update(int id, Author author);

    Author delete(int id);

}
