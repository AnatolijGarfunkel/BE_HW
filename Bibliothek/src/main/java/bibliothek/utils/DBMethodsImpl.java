package bibliothek.utils;

import bibliothek.enums.OriginLand;
import bibliothek.old.model.User;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class DBMethodsImpl implements DBMethods {

    @Override
    public List<User> getUserList(ResultSet resultSet) throws SQLException {
        List<User> userList = new ArrayList<>();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String firstName = resultSet.getString("first_name");
            String lastName = resultSet.getString("last_name");
            int age = resultSet.getInt("age");
            OriginLand land = OriginLand.valueOf(resultSet.getString("land"));
            userList.add(new User(id, firstName, lastName, age, land));
        }
        return userList;
    }

    @Override
    public User getUser(ResultSet resultSet) throws SQLException {
        User user = null;
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String firstName = resultSet.getString("first_name");
            String lastName = resultSet.getString("last_name");
            int age = resultSet.getInt("age");
            OriginLand land = OriginLand.valueOf(resultSet.getString("land"));
            user = new User(id, firstName, lastName, age, land);
        }
        return user;
    }
}
