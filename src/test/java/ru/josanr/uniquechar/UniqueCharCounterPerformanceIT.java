package ru.josanr.uniquechar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.josanr.uniquechar.cache.HashMapCharCountResultCache;
import ru.josanr.uniquechar.counter.CachingCounterDecorator;
import ru.josanr.uniquechar.counter.UniqueCharCounterImpl;

import java.time.Duration;
import java.time.Instant;
import java.util.UUID;

class UniqueCharCounterPerformanceIT {

    private UniqueCharCounterImpl uniqueCharCounter;
    private CachingCounterDecorator cachedCharCounter;

    @BeforeEach
    void setUp() {
        uniqueCharCounter = new UniqueCharCounterImpl();
        cachedCharCounter = new CachingCounterDecorator(new UniqueCharCounterImpl(), new HashMapCharCountResultCache());
    }

    @Test
    void count_shouldBeFasterWithCaching_SameStringMultipleTimes() {
        var testString = UUID.randomUUID().toString();
        int numberOfIterations = 1000000;

        Instant startNoCache = Instant.now();
        for (int counter = 0; counter < numberOfIterations; counter++) {
            uniqueCharCounter.count(testString);
        }
        Instant finishNoCache = Instant.now();
        long timeElapsedNoCache = Duration.between(startNoCache, finishNoCache).toMillis();

        Instant startCache = Instant.now();
        for (int counter = 0; counter < numberOfIterations; counter++) {
            cachedCharCounter.count(testString);
        }
        Instant finishCache = Instant.now();
        long timeElapsedCache = Duration.between(startCache, finishCache).toMillis();

        Assertions.assertTrue(timeElapsedNoCache > timeElapsedCache);
    }
}
