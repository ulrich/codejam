package net.reservoircode.aoc19.fuel_requirements;

import java.util.stream.IntStream;

import static java.lang.Math.floor;

public class FuelRequirements {

    public Integer chall1(int[] masses) {
        return IntStream.of(masses).map(masse -> (int) floor(masse / 3) - 2).sum();
    }
}
