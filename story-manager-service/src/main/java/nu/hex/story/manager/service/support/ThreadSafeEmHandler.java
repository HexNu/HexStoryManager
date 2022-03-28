package nu.hex.story.manager.service.support;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import nu.hex.story.manager.core.database.ConnectorFactory;

/**
 * Created 2009-nov-25
 *
 * @author thomas
 */
public class ThreadSafeEmHandler implements EmHandler {

    private final EntityManagerFactory entityManagerFactory;
    private final ThreadLocal<EntityManager> threadLocalManager = new ThreadLocal<EntityManager>() {

        @Override
        protected EntityManager initialValue() {
            return entityManagerFactory.createEntityManager();
        }
    };

    public ThreadSafeEmHandler() {
        String databaseName = "story_manager";
        ConnectorFactory.getCONNECTOR().create(databaseName);
        Map properties = setupProperties(databaseName);
        entityManagerFactory = Persistence.createEntityManagerFactory("story-managerPU", properties);
    }

    protected Map getSpecialisedProperties() {
        return Collections.EMPTY_MAP;
    }

    @Override
    public void close() {
        entityManagerFactory.close();
    }

    @Override
    public EntityManager getManager() {
        return threadLocalManager.get();
    }

    @Override
    public void closeManager() {
        if (getManager().isOpen()) {
            getManager().close();
        }
        threadLocalManager.remove();
    }

    private Map setupProperties(String databaseName) {
        Map properties = new HashMap();
        properties.put("javax.persistence.jdbc.url", ConnectorFactory.getCONNECTOR().getDatabaseUrl(databaseName));
        properties.put("javax.persistence.jdbc.driver", ConnectorFactory.getCONNECTOR().getJdbcDriverClassName());
        properties.put("hibernate.dialect", ConnectorFactory.getCONNECTOR().getHibernateDialectClassName());
        properties.putAll(ConnectorFactory.getCONNECTOR().getFlavoredProperties());
        properties.putAll(getSpecialisedProperties());
        return properties;
    }

}
