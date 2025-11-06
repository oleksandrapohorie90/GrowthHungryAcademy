package data_structures_and_algorithms_CS210.Leetcode.SDET_Critical.tasks.day01;

//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;

public class T03_ReverseSentence {
    //"java is fun" -> "fun is java"
    public static String reverseSentence(String str) {
        String[] words = str.split(" "); //str.split("\\s");
        String result = "";
        for (int i = words.length - 1; i >= 0; i--) {
            result += words[i] + " ";
        }
        return result.trim();
    }

//    @Test
//    public void test1() {
//        System.out.println(reverseSentence("java is fun"));
//        assertEquals("fun is java", reverseSentence("java is fun"));
//        assertEquals("all hello", reverseSentence("hello all"));
//        assertEquals("java", reverseSentence("java"));
//        assertEquals("", reverseSentence(""));
//    }
}
