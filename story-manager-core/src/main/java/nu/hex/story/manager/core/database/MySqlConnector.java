package nu.hex.story.manager.core.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created 2010-mar-12
 *
 * @author thomas
 */
public class MySqlConnector implements DatabaseConnector {

    @Override
    public void create(String databaseName) {
        try {
            Class.forName(getJdbcDriverClassName());
            Connection conn = createConnection();
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("CREATE DATABASE IF NOT EXISTS " + databaseName);
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(MySqlConnector.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException(ex.getMessage(), ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MySqlConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getJdbcDriverClassName() {
        return "com.mysql.jdbc.Driver";
    }

    @Override
    public String getDatabaseUrl(String databaseName) {
        return "jdbc:mysql://" + System.getProperty("story-manager-db.host", "localhost") + (databaseName.length() > 0 ? "/" + databaseName : "");
    }

    @Override
    public String getDisplayName() {
        return "MySQL";
    }

    @Override
    public String getHibernateDialectClassName() {
        return "org.hibernate.dialect.MySQLDialect";
    }

    @Override
    public void drop(String databaseName) {
        try {
            Connection conn = createConnection();
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("DROP DATABASE " + databaseName);
            stmt.close();
            conn.close();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(MySqlConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private Connection createConnection() throws SQLException, ClassNotFoundException {
        Class.forName(getJdbcDriverClassName());
        Connection conn = DriverManager.getConnection(getDatabaseUrl(""),
                System.getProperty("story-manager-db.username", "venus"),
                System.getProperty("story-manager-db.password", "venus"));
        return conn;
    }

    @Override
    public Map getFlavoredProperties() {
        return new HashMap() {
            {
                put("hibernate.connection.username", System.getProperty("story-manager-db.username", "venus"));
                put("hibernate.connection.password", System.getProperty("story-manager-db.password", "venus"));
            }
        };
    }
}
