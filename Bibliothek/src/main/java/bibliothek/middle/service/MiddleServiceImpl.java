package bibliothek.middle.service;

import bibliothek.middle.model.User;
import bibliothek.middle.repository.MiddldeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MiddleServiceImpl implements MiddleService {

    @Autowired
    private MiddldeRepository middldeRepository;


    @Override
    public List<User> getAll() {
        return middldeRepository.getAll();
    }

    @Override
    public User getById(int id) {
        return middldeRepository.getById(id);
    }

    @Override
    public List<User> search(String firstName) {
        return middldeRepository.search(firstName);
    }

    @Override
    public User getByName(String firstName, String lastName) {
        return middldeRepository.getByName(firstName, lastName);
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
        return middldeRepository.create(user);
    }

    @Override
    public User update(int id, User user) {
        return middldeRepository.update(id, user);
    }

    @Override
    public User delete(int id) {
        return middldeRepository.delete(id);
    }

    @Override
    public List<User> filter(String field, String param) {
        return middldeRepository.filter(field, param);
    }
}
