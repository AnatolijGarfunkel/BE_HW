package bibliothek.utils;

import bibliothek.old.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface DBMethods {

    List<User> getUserList(ResultSet resultSet) throws SQLException;

    User getUser(ResultSet resultSet) throws SQLException;
}
