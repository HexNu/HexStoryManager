package nu.hex.story.manager.core.domain;

/**
 * Created 2016-okt-23
 *
 * @author hl
 */
public interface Currency {

    Unit getMainUnit();

    void setMainUnit(Unit unit);

    public interface Unit {

        Unit getParentUnit();

        void setParentUnit(Unit unit);

        Unit getChildUnit();

        void setChildUnit(Unit unit);

        Integer getChildUnitRatio();

        void setChildUnitRatio(Integer ratio);

    }

}
