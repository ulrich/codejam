package net.reservoircode.adventofcode19.program_alarm;

import javafx.util.Pair;

import static java.util.Arrays.copyOf;
import static java.util.stream.IntStream.range;

public class ProgramAlarm {

    public int[] chall1(int[] intCode) {
        for (int i = 0; i < intCode.length; i += 4) {
            if (i + 4 <= intCode.length) {
                int opcode = intCode[i];
                if (opcode == 99) {
                    break;
                }
                int inputA = intCode[intCode[i + 1]];
                int inputB = intCode[intCode[i + 2]];
                int position = intCode[i + 3];
                intCode[position] = (opcode == 1) ? inputA + inputB : (opcode == 2) ? inputA * inputB : intCode[position];
            }
        }
        return intCode;
    }

    public Pair<Integer, Integer> chall2(int[] intCode, int expectedOutput) {
        for (int i = 0; i <= 99; i++) {
            for (int j = 0; j <= 99; j++) {
                int[] copy = copyOf(intCode, intCode.length);
                copy[1] = i;
                copy[2] = j;
                int[] result = chall1(copy);
                if (result[0] == expectedOutput) {
                    return new Pair<>(i, j);
                }
            }
        }
        return null;
    }

    public void chall2_2(int[] intCode, int expectedOutput) {
        range(0, 100).parallel().forEach(i -> range(0, 100).parallel().forEach(j -> {
            int[] copy = copyOf(intCode, intCode.length);
            copy[1] = i;
            copy[2] = j;
            int[] result = chall1(copy);
            if (result[0] == expectedOutput) {
                System.out.println("I=" + i + " J=" + j);
            }
        }));
    }
}
