package com.datastructures;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CharFinder {

    private char value;
    public char findFirstNonRepeatingChar(String input){
        Map<Character, Integer> map = new HashMap<>();

        for (var ch : input.toCharArray()){
            var count = map.containsKey(ch) ? map.get(ch) : 0;
            map.put(ch, count+1);

            /*if (map.containsKey(ch)){
                var count = map.get(ch);
                map.put(ch, count+1);
            }
            else
                map.put(ch, 1);*/
        }
        for (var ch : input.toCharArray()){
            if (map.get(ch)==1)
                return ch;
        }

        return Character.MIN_VALUE;

    }

    public char findFirstRepeatedChar(String input){
        Set<Character> set = new HashSet<>();
        // Iterate over the string and put each character in a Set

        for (char ch : input.toCharArray()){
            //ask the set if it contains this character. If it contains, we should return the character immediately.
            if (set.contains(ch))
                return ch;

            set.add(ch);
        }

        return Character.MIN_VALUE;

    }

}
