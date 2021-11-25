package ru.josanr.uniquechar.cache;

import ru.josanr.uniquechar.result.CharCountResult;

public interface CharCountResultCache {

    boolean containsKey(String input);

    void put(String key, CharCountResult result);

    CharCountResult get(String key);
}
