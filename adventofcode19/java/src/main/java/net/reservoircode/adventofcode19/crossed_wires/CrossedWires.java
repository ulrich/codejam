package net.reservoircode.adventofcode19.crossed_wires;

import java.util.HashMap;
import java.util.Map;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.parseInt;
import static java.lang.Math.abs;
import static java.lang.Math.min;

public class CrossedWires {
    Map<String, Integer> wireMap = new HashMap<>();

    public Result chall(String input) {
        int distance = MAX_VALUE;
        int fewestWire = MAX_VALUE;

        int x = 0, y = 0, z = 0;

        String[] wires = input.split("\\n");

        Map<String, Integer> wireMap = new HashMap<>();

        for (String coordinate : wires[0].split(",")) {
            int[] direction = direction(coordinate.charAt(0));
            int step = parseInt(coordinate.substring(1));
            for (int j = 0; j < step; j++) {
                int newX = x + direction[0];
                int newY = y + direction[1];
                wireMap.put(newX + "," + newY, ++z);
                x = newX;
                y = newY;
            }
        }
        x = y = z = 0;

        for (String coordinate : wires[1].split(",")) {
            int[] direction = direction(coordinate.charAt(0));
            int step = parseInt(coordinate.substring(1));
            for (int j = 0; j < step; j++) {
                z++;
                int newX = x + direction[0];
                int newY = y + direction[1];
                if (wireMap.containsKey(newX + "," + newY)) {
                    distance = min(distance, abs(newX) + abs(newY));
                    fewestWire = min(fewestWire, wireMap.get(newX + "," + newY) + z);
                }
                x = newX;
                y = newY;
            }
        }
        return new Result(distance, fewestWire);
    }

   public static class Result {
        public final int distance, fewestWire;

        public Result(int distance, int fewestWire) {
            this.distance = distance;
            this.fewestWire = fewestWire;
        }
    }

    private int[] direction(char c) {
        switch (c) {
            case 'U':
                return new int[]{0, 1};
            case 'D':
                return new int[]{0, -1};
            case 'L':
                return new int[]{-1, 0};
            case 'R':
                return new int[]{1, 0};
        }
        return null;
    }
}
