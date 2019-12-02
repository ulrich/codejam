package net.reservoircode.aoc18.inverse_captcha;

import java.util.List;

import static java.lang.Integer.parseInt;
import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;

public class InverseCaptcha {

    public Integer chall1(String entry) {
        List<Integer> integers = stream(entry.split("")).map(s -> parseInt(s)).collect(toList());

        integers.add(integers.get(0));

        int value = 0;
        for (int i = 0; i < integers.size() - 1; i++) {
            if (integers.get(i).equals(integers.get(i + 1))) {
                value += integers.get(i);
            }
        }
        return value;
    }

    public Integer chall2(String entry) {
        List<Integer> integers = stream(entry.split("")).map(s -> parseInt(s)).collect(toList());

        int step = integers.size() / 2;

        int value = 0;
        for (int i = 0; i < integers.size() - 1; i++) {
            if (integers.get(i).equals(integers.get((i + step) % integers.size()))) {
                value += integers.get(i);
            }
        }
        return value;
    }
}
