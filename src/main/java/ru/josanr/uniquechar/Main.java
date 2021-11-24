package ru.josanr.uniquechar;

import ru.josanr.uniquechar.cache.HashMapCharCountResultCache;
import ru.josanr.uniquechar.counter.CachingCounterDecorator;
import ru.josanr.uniquechar.counter.UniqueCharCounter;
import ru.josanr.uniquechar.counter.UniqueCharCounterImpl;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        UniqueCharCounter counter = new CachingCounterDecorator(
            new UniqueCharCounterImpl(),
            new HashMapCharCountResultCache()
        );
        while (true) {
            System.out.print("Input string for counting (type exit to quit):");
            String inputString = scanner.nextLine();
            if (inputString.equalsIgnoreCase("exit")) {
                break;
            }

            System.out.println(counter.count(inputString));
        }
    }
}
