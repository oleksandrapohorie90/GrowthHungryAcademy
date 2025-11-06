package data_structures_and_algorithms_CS210.Leetcode.SDET_Critical.tasks.day01;

//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class T04_FirstNonRepeatedChar {
   // "aabccddj" -> a=2, b=1, c=2, d=2, j=1 -> b
    public static char firstNonRepeatedChar(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char current = str.charAt(i);
            map.put(current, map.getOrDefault(current, 0) + 1);
        }

        for(char each : str.toCharArray()) {
            if (map.get(each) == 1) {
                return each;
            }
        }

        return '\0';
    }

//    @Test
//    public void test1stNonRepeat() {
//        Map<Character, Integer> map = new HashMap<>();
//        map.put('a', 3);
//        map.put('b', 2);
//        System.out.println(map.get('a')); //3
//        System.out.println(map.get('c')); //null
//        System.out.println(map.getOrDefault('c', 0)); //0
//        System.out.println(map.getOrDefault('b', 0)); //2
//
//        Assertions.assertEquals('b', firstNonRepeatedChar("aabccddu"));
//    }

}
