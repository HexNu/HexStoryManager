package nu.hex.story.manager.service.support;

import javax.persistence.EntityManager;

/**
 *
 * @author thomas
 */
public interface EmHandler {

    EntityManager getManager();

    void closeManager();

    void close();
}
