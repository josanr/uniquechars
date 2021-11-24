package ru.josanr.uniquechar.counter;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.josanr.uniquechar.result.CharCountResult;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


class UniqueCharCounterImplTest {

    private static Stream<Arguments> provideParameters() {
        var unique_string = new CharCountResult();
        unique_string.put('u', 2);
        unique_string.put('n', 2);
        unique_string.put('i', 2);
        unique_string.put('q', 1);
        unique_string.put('e', 1);
        unique_string.put('_', 1);
        unique_string.put('s', 1);
        unique_string.put('t', 1);
        unique_string.put('r', 1);
        unique_string.put('g', 1);

        var jetbrains = new CharCountResult();
        jetbrains.put('j', 1);
        jetbrains.put('e', 1);
        jetbrains.put('t', 1);
        jetbrains.put('b', 1);
        jetbrains.put('r', 1);
        jetbrains.put('a', 1);
        jetbrains.put('i', 1);
        jetbrains.put('n', 1);
        jetbrains.put('s', 1);

        return Stream.of(
            Arguments.of("unique_string", unique_string),
            Arguments.of("jetbrains", jetbrains)
        );
    }

    @ParameterizedTest
    @MethodSource("provideParameters")
    void count_ShouldReturnMapOfCharCount_givenStringParameter(String input, CharCountResult expected) {
        UniqueCharCounterImpl uniqueCharCounter = new UniqueCharCounterImpl();
        var result = uniqueCharCounter.count(input);

        assertEquals(expected, result);
    }
}
