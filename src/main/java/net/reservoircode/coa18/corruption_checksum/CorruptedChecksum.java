package net.reservoircode.coa18.corruption_checksum;

import static java.lang.Integer.parseInt;
import static java.util.stream.Stream.of;

public class CorruptedChecksum {

    public Integer sum(String matrix) {
        return of(matrix.split("\n")).map(line -> {
            Integer min = of(line.split("\t")).mapToInt(value -> parseInt(value)).min().getAsInt();
            Integer max = of(line.split("\t")).mapToInt(value -> parseInt(value)).max().getAsInt();
            return max - min;
        }).mapToInt(value -> value).sum();
    }
}
