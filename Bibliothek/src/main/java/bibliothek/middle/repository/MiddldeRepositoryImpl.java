package bibliothek.middle.repository;

import bibliothek.middle.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MiddldeRepositoryImpl implements MiddldeRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public List<User> getAll() {
        String sql = "select * from old_user";
        List<User> list = jdbcTemplate.query(
                sql,
                new BeanPropertyRowMapper<>(User.class)
        );
        return list;
    }

    @Override
    public User getById(int id) {
        String sql = "select * from old_user where id = ?";
        User user = jdbcTemplate.queryForObject(
                sql,
                new Object[]{id},
                new BeanPropertyRowMapper<>(User.class)
        );
        return user;
    }

    @Override
    public List<User> search(String firstName) {
        String sql = "select * from old_user where first_name = ?";
        List<User> list = jdbcTemplate.query(
                sql,
                new Object[]{firstName},
                new BeanPropertyRowMapper<>(User.class)
        );
        return list;
    }

    @Override
    public User getByName(String firstName, String lastName) {
        String sql = "select * from old_user where first_name = ? and last_name = ?";
        User user = jdbcTemplate.queryForObject(
                sql,
                new Object[]{firstName, lastName},
                new BeanPropertyRowMapper<>(User.class)
        );
        return user;
    }

    @Override
    public List<User> getByFirstName(String firstName) {
        String sql = "select * from old_user where first_name = ?";
        List<User> list = jdbcTemplate.query(
                sql,
                new Object[]{firstName},
                new BeanPropertyRowMapper<>(User.class)
        );
        return list;
    }

    @Override
    public List<User> getByLastName(String lastName) {
        String sql = "select * from old_user where last_name = ?";
        List<User> list = jdbcTemplate.query(
                sql,
                new Object[]{lastName},
                new BeanPropertyRowMapper<>(User.class)
        );
        return list;
    }

    @Override
    public List<User> getByLand(String land) {
        String sql = "select * from old_user where land = ?";
        List<User> list = jdbcTemplate.query(
                sql,
                new Object[]{land},
                new BeanPropertyRowMapper<>(User.class)
        );
        return list;
    }

    @Override
    public User create(User user) {
        String sql = "insert into old_user (id, first_name, last_name, age, land) values (?, ?, ?, ?, ?)";
        jdbcTemplate.update(
                sql,
                user.getId(), user.getFirstName(), user.getLastName(), user.getAge(), String.valueOf(user.getLand())
        );
        User newUser = getById(user.getId());
        return newUser;
    }

    @Override
    public User update(int id, User user) {
        String sql = "update old_user set first_name = ?, last_name = ?, age = ?, land = ? where id = ?";
        jdbcTemplate.update(
                sql,
                user.getFirstName(), user.getLastName(), user.getAge(), String.valueOf(user.getLand()), id
        );
        User newUser = getById(id);
        return newUser;
    }

    @Override
    public User delete(int id) {
        User user = getById(id);
        String sql = "delete from old_user where id = ?";
        jdbcTemplate.update(
                sql,
                id
        );
        return user;
    }

    @Override
    public List<User> filter(String field, String param) {
        List<User> list;
        if (field.equals("firstName")) {
            list = getByFirstName(param);
            return list;
        }
        if (field.equals("lastName")) {
            list = getByLastName(param);
            return list;
        }
        if (field.equals("land")) {
            list = getByLand(param);
            return list;
        }
        return null;
    }
}
