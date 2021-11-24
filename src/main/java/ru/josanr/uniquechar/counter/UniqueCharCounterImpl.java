package ru.josanr.uniquechar.counter;

import ru.josanr.uniquechar.result.CharCountResult;

public class UniqueCharCounterImpl implements UniqueCharCounter {

    @Override
    public CharCountResult count(String input) {
        var result = new CharCountResult();
        var splitString = input.toCharArray();
        for (Character singleChar : splitString) {
            result.merge(singleChar, 1, (previous, one) -> previous + 1);
        }
        return result;
    }
}
