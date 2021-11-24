package ru.josanr.uniquechar.cache;

import ru.josanr.uniquechar.result.CharCountResult;

import java.util.HashMap;
import java.util.Map;

public class HashMapCharCountResultCache implements CharCountResultCache {
    Map<String, CharCountResult> cache = new HashMap<>();
    @Override
    public boolean containsKey(String input) {
        return cache.containsKey(input);
    }

    @Override
    public void put(String key, CharCountResult result) {
        cache.put(key, result);
    }

    @Override
    public CharCountResult get(String key) {
        return cache.get(key);
    }
}
