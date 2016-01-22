package nu.hex.story.manager.core.service.command;

import nu.hex.story.manager.core.service.support.EmHandlerProvider;


/**
 *
 * @author thomas
 * @param <T>
 */
public interface ServiceCommand<T> {

    T execute();

    Object getSynchronizationObject();

    void setEmHandlerProvider(EmHandlerProvider provider);
}
