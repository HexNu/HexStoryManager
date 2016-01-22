package nu.hex.story.manager.core.database;

import java.util.Map;

/**
 *
 * @author thomas
 */
public interface DatabaseConnector {

    public void create(String databaseName);

    public void drop(String databaseName);

    public String getJdbcDriverClassName();

    public String getDatabaseUrl(String databaseName);

    public String getDisplayName();

    public String getHibernateDialectClassName();

    public Map getFlavoredProperties();
}
