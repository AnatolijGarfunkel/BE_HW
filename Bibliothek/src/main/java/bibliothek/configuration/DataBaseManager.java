package bibliothek.configuration;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
public class DataBaseManager {

    @Value("${database.url}")
    private String url;// = "localhost:3306";

    @Value("${database.name}")
    private String name;// = "oldbibliothek";

    @Value("${database.user}")
    private String user;// = "root";

    @Value("${database.password}")
    private String password;// = "groot";

    private Connection connection;

    public DataBaseManager () {
        //
    }

    public Connection getConnection() {
        if (connection == null) {
            createConnection();
        }
        return connection;
    }

    @PostConstruct
    private void createConnection() {
        String connString = "jdbc:mysql://" + url + "/" + name;
        try {
            connection = DriverManager.getConnection(connString, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
