package ru.josanr.uniquechar.result;

import java.util.HashMap;

public class CharCountResult extends HashMap<Character, Integer> {

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (var entry : this.entrySet()) {
            result.append("\"")
                .append(entry.getKey())
                .append("\"")
                .append(" - ")
                .append(entry.getValue())
                .append("\n");
        }

        return result.toString();
    }
}
