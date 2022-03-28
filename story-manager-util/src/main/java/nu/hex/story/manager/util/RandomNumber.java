package nu.hex.story.manager.util;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created 2016-okt-22
 *
 * @author hl
 */
public class RandomNumber {

    private final int min;
    private final int max;

    public RandomNumber(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public RandomNumber() {
        this.min = 1;
        this.max = 6;
    }
    
    /**
     * The range is inclusive of max;
     *
     * @return
     */
    public Integer get() {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static void main(String[] args) {
        RandomNumber D20 = new RandomNumber(1, 20);
        for (int i = 0; i < 30; i++) {
            System.out.println(D20.get());
        }
    }
}
