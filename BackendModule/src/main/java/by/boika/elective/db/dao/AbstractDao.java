package by.boika.elective.db.dao;

import by.boika.elective.entities.Entity;
import org.apache.log4j.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class AbstractDao<T extends Entity> {
    protected Connection connection;
    private final static Logger LOGGER = Logger.getLogger(AbstractDao.class);
    public AbstractDao(Connection connection) {
        this.connection = connection;
    }
    public void close(PreparedStatement st) {
        try {
            if (st != null) {
                st.close();
            }
        } catch (SQLException e) {
            LOGGER.error("Statement isn't close.");
        }
    }
}
