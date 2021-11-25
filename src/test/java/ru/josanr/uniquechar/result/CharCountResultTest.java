package ru.josanr.uniquechar.result;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CharCountResultTest {

    @Test
    void testToString_returnStringMustConformToTemplate() {
        var charResult = new CharCountResult();
        charResult.put('a', 1);
        charResult.put('b', 2);
        charResult.put('c', 3);
        charResult.put('d', 123);

        var expected = """
            "a" - 1
            "b" - 2
            "c" - 3
            "d" - 123
            """;

        assertEquals(expected, charResult.toString());
    }
}
