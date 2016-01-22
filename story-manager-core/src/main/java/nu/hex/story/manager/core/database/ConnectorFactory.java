package nu.hex.story.manager.core.database;

/**
 * Created 2010-mar-12
 *
 * @author thomas
 */
public class ConnectorFactory {

    private static final DatabaseConnector CONNECTOR = new MySqlConnector();

    public static DatabaseConnector getCONNECTOR() {
        return CONNECTOR;
    }
}
