package net.reservoircode.aoc19.fuel_requirements;

import java.util.stream.IntStream;

import static java.lang.Math.floor;

public class FuelRequirements {

    public Integer chall1(int[] masses) {
        return IntStream.of(masses).map(masse -> (int) floor(masse / 3) - 2).sum();
    }

    public Integer chall2(int[] masses) {
        return IntStream.of(masses).map(masse -> compute1(masse)).sum();
    }

    private int compute1(int masse) {
        if (masse <= 0) {
            return 0;
        }
        int val = (int) floor(masse / 3) - 2;
        if (val < 0) {
            val = 0;
        }
        return val + compute1(val);
    }

    private int compute2(int masse) {
        int val, result = 0;
        do {
            val = (int) floor(masse / 3) - 2;
            if (val < 0) {
                break;
            }
            result += masse = val;
        } while (val > 0);
        return result;
    }
}
