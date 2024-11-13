package bibliothek.old.repository;

import bibliothek.configuration.DataBaseManager;
import bibliothek.old.model.User;
import bibliothek.utils.DBMethods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class OldRepositoryImpl implements OldRepository {

    @Autowired
    private DataBaseManager dbManager;

    @Autowired
    private DBMethods dbMethods;


    @Override
    public List<User> getAll() {
        List<User> list = new ArrayList<>();
        String sql = "select * from old_user";
        Connection connection = dbManager.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            list = dbMethods.getUserList(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println(list);
        return list;
    }

    @Override
    public User getById(int id) {
        User user = null;
        String sql = "select * from old_user where id = ?";
        Connection connection = dbManager.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            user = dbMethods.getUser(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    @Override
    public User getByName(String firstName, String lastName) {
        User user;
        String sql = "select * from old_user where first_name = ? and last_name = ?";
        Connection connection = dbManager.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            ResultSet resultSet = preparedStatement.executeQuery();
            return dbMethods.getUser(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<User> getByFirstName(String firstName) {
        List<User> list = new ArrayList<>();
        String sql = "SELECT * FROM old_user WHERE first_name = ?";
        Connection connection = dbManager.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, firstName);
            ResultSet resultSet = preparedStatement.executeQuery();
            list = dbMethods.getUserList(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public List<User> getByLastName(String lastName) {
        List<User> list = new ArrayList<>();
        String sql = "SELECT * FROM old_user WHERE last_name = ?";
        Connection connection = dbManager.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, lastName);
            ResultSet resultSet = preparedStatement.executeQuery();
            list = dbMethods.getUserList(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public List<User> getByLand(String land) {
        List<User> list = new ArrayList<>();
        String sql = "SELECT * FROM old_user WHERE land = ?";
        Connection connection = dbManager.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, land);
            ResultSet resultSet = preparedStatement.executeQuery();
            list = dbMethods.getUserList(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public User create(User user) {
        User user1 = null;
        String sql = "INSERT INTO old_user (id, first_name, last_name, age, land) VALUES(?, ?, ?, ?, ?)";
        Connection connection = dbManager.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, user.getId());
            preparedStatement.setString(2, user.getFirstName());
            preparedStatement.setString(3, user.getLastName());
            preparedStatement.setInt(4, user.getAge());
            preparedStatement.setString(5, String.valueOf(user.getLand()));
            preparedStatement.executeUpdate();
            user1 = getById(user.getId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user1;
    }

    @Override
    public User update(int id, User user) {
        User updatedUser = null;
        String sql = "UPDATE old_user SET first_name = ?, last_name = ?, age = ?, land = ? WHERE id = ?";
        Connection connection = dbManager.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setInt(3, user.getAge());
            preparedStatement.setString(4, String.valueOf(user.getLand()));
            preparedStatement.setInt(5, id);
            preparedStatement.executeUpdate();
            updatedUser = getById(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return updatedUser;
    }

    @Override
    public User delete(int id) {
        User user = getById(id);
        String sql = "DELETE FROM old_user WHERE id = ?";
        Connection connection = dbManager.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    @Override
    public List<User> filter(String field, String param) {
        List<User> list = null;
        if (field.equals("firstname")) {
            list = getByFirstName(param);
        }
        if (field.equals("lastname")) {
            list = getByLastName(param);
        }
        if (field.equals("land")) {
            list = getByLand(param);
        }
        return list;
    }
}