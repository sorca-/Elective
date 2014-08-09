package by.boika.elective.db.pool;

import org.apache.log4j.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.concurrent.ArrayBlockingQueue;

public class ConnectionPool {
    private ArrayBlockingQueue<ProxyConnection> connectionQueue;
    private final static Logger LOGGER = Logger.getLogger(ConnectionPool.class);

    private ConnectionPool() {
        try {
            ResourceBundle resource = ResourceBundle.getBundle("properties.database");
            int poolSize = Integer.parseInt(resource.getString("db.poolsize"));
            String url = resource.getString("db.url");
            String user = resource.getString("db.user");
            String pass = resource.getString("db.password");
            connectionQueue = new ArrayBlockingQueue(poolSize);
            DriverManager.registerDriver(new org.h2.Driver());
            for (int i = 0; i < poolSize; i++) {
                Connection con = DriverManager.getConnection(url, user, pass);
                ProxyConnection pCon = new ProxyConnection(con);
                connectionQueue.add(pCon);
            }
        } catch (MissingResourceException e) {
            LOGGER.error("properties file is missing " + e);
        } catch (SQLException e) {
            LOGGER.error("not obtained connection " + e);
        }
    }

    private static class ConnectionPoolHolder {
        private final static ConnectionPool instance = new ConnectionPool();
    }

    public static ConnectionPool getInstance() {
        return ConnectionPoolHolder.instance;
    }

    public ProxyConnection getConnection() {
        try {
            return connectionQueue.take();
        } catch (InterruptedException e) {
            LOGGER.error(e);
        }
        return null;
    }
    public void putConnection(ProxyConnection connection) {
        connectionQueue.offer(connection);
    }
}
