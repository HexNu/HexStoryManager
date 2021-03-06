package nu.hex.calendar.core.calendar.sample.fictive;

import nu.hex.calendar.core.calendar.rpg.Month;

/**
 * Created 2016-okt-12
 *
 * @author hl
 */
public class FictiveMonth implements Month {

    private Integer index;
    private String name;
    private Integer numberOfDays;

    @Override
    public Integer getIndex() {
        return index;
    }

    @Override
    public void setIndex(Integer index) {
        this.index = index;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Integer getNumberOfDays() {
        return numberOfDays;
    }

    @Override
    public void setNumberOfDays(Integer numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

}
