package by.boika.elective.db.dao;

import by.boika.elective.entities.User;
import org.apache.log4j.Logger;
import java.sql.*;

public class UserDao extends AbstractDao<User> {
    private final static Logger LOGGER = Logger.getLogger(UserDao.class);

    public UserDao(Connection connection) {
        super(connection);
    }

    public String findPassword(String login) {
        final String SELECT_USER = "SELECT PASSWORD FROM ACCOUNT WHERE LOGIN = (?)";
        PreparedStatement ps = null;
        String password = "";
        try {
            ps = connection.prepareStatement(SELECT_USER);
            ps.setString(1, login);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet == null || resultSet.next() == false) {
                return password;
            }
            password = resultSet.getString(1);
        } catch (SQLException e) {
            LOGGER.error(e);
        } finally {
            this.close(ps);
        }
        return password;
    }
}
