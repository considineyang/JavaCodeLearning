package examplesLearning;

import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CountOccurenceOfWordsStream {
    public static void main(String[] args) {
        String text = "Good morning, sir. Please have a seat, you can order food on the menu! have a good time!";

        Stream.of(text.split("[\\s+\\p{P}]")).parallel()
                .filter(e -> e.length() > 0).collect(Collectors.groupingBy(String::toLowerCase, TreeMap::new, Collectors.counting()))
                .forEach((k, v) -> System.out.println(k + " " + v));
    }
}
