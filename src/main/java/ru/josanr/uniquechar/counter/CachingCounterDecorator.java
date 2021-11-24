package ru.josanr.uniquechar.counter;

import ru.josanr.uniquechar.cache.CharCountResultCache;
import ru.josanr.uniquechar.result.CharCountResult;

public class CachingCounterDecorator implements UniqueCharCounter {

    private final UniqueCharCounter counter;
    private final CharCountResultCache cache;

    public CachingCounterDecorator(UniqueCharCounter counter, CharCountResultCache cache) {
        this.counter = counter;
        this.cache = cache;
    }

    @Override
    public CharCountResult count(String input) {
        if (cache.containsKey(input)) {
            return cache.get(input);
        }

        var result = counter.count(input);
        cache.put(input, result);
        return result;
    }
}
