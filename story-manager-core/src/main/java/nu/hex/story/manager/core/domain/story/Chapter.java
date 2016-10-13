package nu.hex.story.manager.core.domain.story;

import nu.hex.story.manager.core.domain.DomainObject;

/**
 * Created 2016-jul-29
 *
 * @author hl
 */
public interface Chapter extends DomainObject<Long>, Comparable<Chapter> {

    Story getStory();

    void setStory(Story story);

    String getHeading();

    void setHeading(String heading);

    Integer getNumber();

    void setNumber(Integer number);

    String getRomanNumeral();

    String getDescription();

    void setDescription(String description);

    String getText();

    void setText(String text);

    void appendText(String text);
}
