package bibliothek.old.service;

import bibliothek.old.model.User;
import bibliothek.old.repository.OldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OldServiceImpl implements OldService {

    @Autowired
    private OldRepository oldRepository;


    @Override
    public List<User> getAll() {
        return oldRepository.getAll();
    }

    @Override
    public User getById(int id) {
        return oldRepository.getById(id);
    }

    @Override
    public User getByName(String firstName, String lastName) {
        return oldRepository.getByName(firstName, lastName);
    }

    @Override
    public List<User> getByFirstName(String firstName) {
        return oldRepository.getByFirstName(firstName);
    }

    @Override
    public List<User> getByLastName(String lastName) {
        return oldRepository.getByLastName(lastName);
    }

    @Override
    public List<User> getByLand(String land) {
        return oldRepository.getByLand(land);
    }

    @Override
    public User create(User user) {
        return oldRepository.create(user);
    }

    @Override
    public User update(int id, User user) {
        return oldRepository.update(id, user);
    }

    @Override
    public User delete(int id) {
        return oldRepository.delete(id);
    }

    @Override
    public List<User> filter(String field, String param) {
        return oldRepository.filter(field, param);
    }
}
