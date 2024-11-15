package bibliothek.service;

import bibliothek.entity.Author;
import bibliothek.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository repository;

//  GET ----------------------------------------------------------------------------------------------------------------

    @Override
    public List<Author> getAll() {
        return repository.findAll();
    }

    @Override
    public Author getById(int id) {
        return repository.findById(id).get();
    }

    @Override
    public Author getByName(String firstName, String lastName) {
        return repository.findAuthorByFirstNameAndLastName(firstName, lastName);
    }

    @Override
    public List<Author> getByFirstName(String firstName) {
        return List.of();
    }

    @Override
    public List<Author> getByLastName(String lastName) {
        return List.of();
    }

    @Override
    public List<Author> getByLand(String land) {
        return List.of();
    }

    @Override
    public List<Author> filter(String field, String param) {
        return List.of();
    }

//  POST ---------------------------------------------------------------------------------------------------------------

    @Override
    public Author create(Author author) {
        return null;
    }

    @Override
    public Author update(int id, Author author) {
        return null;
    }


//  DELETE -------------------------------------------------------------------------------------------------------------

    @Override
    public Author delete(int id) {
        return null;
    }

}









































