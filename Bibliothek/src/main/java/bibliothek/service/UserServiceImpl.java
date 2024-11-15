package bibliothek.service;

import bibliothek.entity.User;
import bibliothek.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

//  GET ----------------------------------------------------------------------------------------------------------------

    @Override
    public List<User> getAll() {
        List<User> users = repository.findAll();
        return users;
//        return repository.findAll();
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
    public List<User> filter(String field, String param) {
        return List.of();
    }


//  POST ---------------------------------------------------------------------------------------------------------------

    @Override
    public User create(User user) {
        return repository.save(user);
    }

    @Override
    public User update(int id, User user) {
        User updatedUser = repository.findById(id).get();
        if (user.getFirstName() != null) {
            updatedUser.setFirstName(user.getFirstName());
        }
        if (user.getLastName() != null) {
            updatedUser.setLastName(user.getLastName());
        }
        if (user.getLand() != null) {
            updatedUser.setLand(user.getLand());
        }
        if (user.getAge() != 0) {
            updatedUser.setAge(user.getAge());
        }
        repository.save(updatedUser);
        return repository.findById(id).get();
    }

//  DELETE -------------------------------------------------------------------------------------------------------------

    @Override
    public User delete(int id) {
        User user = repository.findById(id).get();
        repository.delete(user);
        return user;
    }

}
