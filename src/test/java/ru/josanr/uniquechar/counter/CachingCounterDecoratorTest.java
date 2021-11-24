package ru.josanr.uniquechar.counter;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.josanr.uniquechar.cache.CharCountResultCache;

import static org.mockito.Mockito.when;

class CachingCounterDecoratorTest {

    public static final String INPUT_STRING = "unique_string";

    @Test
    void count_shouldNotCalcResult_CacheContainsValue() {
        var innerCounter = Mockito.mock(UniqueCharCounter.class);
        var cache = Mockito.mock(CharCountResultCache.class);
        when(cache.containsKey(INPUT_STRING)).thenReturn(true);


        var counter = new CachingCounterDecorator(
            innerCounter,
            cache
        );
        counter.count(INPUT_STRING);
        Mockito.verify(innerCounter, Mockito.times(0)).count(INPUT_STRING);
    }

    @Test
    void count_shouldCalcResultAndCacheIt_CacheDoesNotContainValue() {
        var innerCounter = Mockito.mock(UniqueCharCounter.class);
        var cache = Mockito.mock(CharCountResultCache.class);
        when(cache.containsKey(INPUT_STRING)).thenReturn(false);

        var counter = new CachingCounterDecorator(
            innerCounter,
            cache
        );

        counter.count(INPUT_STRING);
        Mockito.verify(innerCounter, Mockito.times(1)).count(INPUT_STRING);
        Mockito.verify(cache, Mockito.times(1)).put(INPUT_STRING, null);
    }
}
