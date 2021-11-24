package ru.josanr.uniquechar.counter;

import ru.josanr.uniquechar.result.CharCountResult;

public class UniqueCharCounterImpl implements UniqueCharCounter {

    @Override
    public CharCountResult count(String input) {
        var result = new CharCountResult();
        var splitString = input.split("");
        for (String singleChar : splitString) {
            if(result.containsKey(singleChar)) {
                var count = result.get(singleChar);
                count += 1;
                result.put(singleChar, count);
            }else{
                result.put(singleChar, 1);
            }
        }
        return result;
    }
}
