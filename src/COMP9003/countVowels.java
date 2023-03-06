package COMP9003;

import java.util.stream.Stream;

public class countVowels {
    static int counts = 0;

    static int countVowels(String s){
        counts = 0;
        char[] chars = {'a','e','i','o','u'};
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < 5; j++) {
                if (s.charAt(i) == chars[j]){
                    counts++;
                }
            }
        }
        return counts;
    }
    public static void main(String[] args) {
        String s = "astronautaaaa";
        int count = countVowels(s);
        System.out.println(count);

    }
}
