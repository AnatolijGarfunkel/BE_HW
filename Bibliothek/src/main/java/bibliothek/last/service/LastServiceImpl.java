package bibliothek.last.service;

import bibliothek.last.entity.User;
import bibliothek.last.repository.LastRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LastServiceImpl implements LastService {

    @Autowired
    private LastRepository repository;


    @Override
    public List<User> getAll() {
        return repository.findAll();
    }

    @Override
    public User getById(int id) {
        return repository.findById(id).get();
    }

    @Override
    public User getByName(String firstName, String lastName) {
        return null;
    }

    @Override
    public List<User> getByFirstName(String firstName) {
        return List.of();
    }

    @Override
    public List<User> getByLastName(String lastName) {
        return List.of();
    }

    @Override
    public List<User> getByLand(String land) {
        return List.of();
    }

    @Override
    public User create(User user) {
        return repository.save(user);
    }

    @Override
    public User update(int id, User user) {
        return null;
    }

    @Override
    public User delete(int id) {
        User user = repository.findById(id).get();
        repository.delete(user);
        return user;
    }

    @Override
    public List<User> filter(String field, String param) {
        return List.of();
    }
}
