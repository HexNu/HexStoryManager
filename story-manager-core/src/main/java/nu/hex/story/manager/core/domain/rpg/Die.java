package nu.hex.story.manager.core.domain.rpg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import nu.hex.story.manager.core.util.RandomNumber;

/**
 * Created 2016-okt-22
 *
 * @author hl
 */
public class Die {

    private final RandomNumber randomNumber;
    public static final Die D2 = new Die(2);
    public static final Die D3 = new Die(3);
    public static final Die D4 = new Die(4);
    public static final Die D6 = new Die(6);
    public static final Die D8 = new Die(8);
    public static final Die D10 = new Die(10);
    public static final Die D12 = new Die(12);
    public static final Die D20 = new Die(20);
    public static final Die D100 = new Die(100);

    public Die(Integer max) {
        randomNumber = new RandomNumber(1, max);
    }

    public Integer get() {
        return randomNumber.get();
    }

    public Integer get(Integer numberOfDice) {
        if (isInvalid(numberOfDice)) {
            throw new IllegalArgumentException("The field \"numberOfDice\" must be a positive integer");
        }
        Integer result = 0;
        int i = 0;
        while (i++ < numberOfDice) {
            result += get();
        }
        return result;
    }

    public Integer getBestOf(Integer best, Integer numberOfDice) {
        if (isInvalid(numberOfDice)) {
            throw new IllegalArgumentException("The variable \"numberOfDice\" must be a positive integer");
        }
        if (isInvalid(best)) {
            throw new IllegalArgumentException("The variable \"best\" must be a positive integer");
        }
        if (best > numberOfDice) {
            throw new IllegalArgumentException("The variable \"best\" cannot be higher than the variable \"numberOfDice\"");
        }
        int i = 0;
        List<Integer> rolls = new ArrayList<>();
        while (i++ < numberOfDice) {
            rolls.add(get());
        }
        Collections.sort(rolls, (a, b) -> b.compareTo(a));
        i = 0;
        Integer result = 0;
        while (i++ < best) {
            result += rolls.get(i);
        }
        return result;
    }

    private boolean isInvalid(Integer i) {
        return i == null || i < 1;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 6; i++) {
//            System.out.println(new Die(7).getBestOf(3, 30));
            System.out.println(Die.D10.getBestOf(2, 4));
        }
    }
}
