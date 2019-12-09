package net.reservoircode.adventofcode19.secure_container;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static java.lang.Integer.parseInt;
import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.range;

public class SecureContainer {
    private static final Predicate<List<Integer>> hasDigitsTwice = s -> s.get(0).equals(s.get(1));
    private static final Predicate<List<Integer>> hasAllIncreasingDigits = s -> s.get(1) >= s.get(0);

    public int chall1(String input) {
        final AtomicInteger hit = new AtomicInteger(0);

        String[] range = input.split("-");

        range(parseInt(range[0]) + 1, parseInt(range[1])).parallel().forEachOrdered(i -> {
            List<Integer> split = String.valueOf(i).chars().boxed().collect(toList());
            if (sliding(split).anyMatch(hasDigitsTwice)) {
                if (sliding(split).filter(hasAllIncreasingDigits).count() == 5) {
                    hit.incrementAndGet();
                }
            }
        });
        return hit.get();
    }

    private static <T> Stream<List<T>> sliding(List<T> list) {
        return range(0, list.size() - 2 + 1).mapToObj(start -> list.subList(start, start + 2));
    }
}
