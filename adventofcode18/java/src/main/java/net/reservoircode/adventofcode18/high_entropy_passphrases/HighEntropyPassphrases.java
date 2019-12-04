package net.reservoircode.adventofcode18.high_entropy_passphrases;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;

public class HighEntropyPassphrases {

    public Integer isValid(String passphrase) {
        Integer numberOfValidPhrases = 0;

        for (String phrase : passphrase.split("\n")) {
            Optional<List<String>> first = Stream.of(phrase.split(" ")) //
                    .collect(groupingBy(o -> o)).values().stream() //
                    .filter(strings -> strings.size() > 1).findFirst();
            if (!first.isPresent()) {
                numberOfValidPhrases++;
            }
        }
        return numberOfValidPhrases;
    }
}
