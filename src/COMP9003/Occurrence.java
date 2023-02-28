package COMP9003;
import  java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Occurrence {
    public static void main(String[] args) {
        //YOUR CODE HERE
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
//        System.out.println(str.charAt(0) - 48);
//        int[] counts = {0,0,0,0,0,0,0,0,0,0};
//        for (int i = 0; i < str.length(); i++) {
//            counts[str.charAt(i) - 48]++;
//        }
//        for (int i = 0; i < counts.length; i++) {
//            System.out.println(i+": "+counts[i]);
//        }
//        Stream.of(toCharacterArray(str.toCharArray()))
//                .filter(ch -> Character.isDigit(ch))
//                .collect(Collectors.groupingBy(e -> e, TreeMap::new, Collectors.counting()))
//                .forEach((k,v)-> System.out.println(k + " : "+ v));

        TreeMap<Character, Long> map = Stream.of(toCharacterArray(str.toCharArray()))
                .filter(ch -> Character.isDigit(ch))
                .collect(Collectors.groupingBy(e -> e, TreeMap::new, Collectors.counting()));

        for (int i = 0; i < 10; i++) {
            if (!map.containsKey((char)(i+48))){
                map.put((char)(i+48),0L);
            }
        }

        map.entrySet().forEach(entry -> System.out.println(entry.getKey() + " : " + entry.getValue()));

        }

    public static Character[] toCharacterArray(char[] list) {
        Character[] result = new Character[list.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = list[i];
        }
        return result;
    }

//        System.out.println(str.toCharArray());
}




