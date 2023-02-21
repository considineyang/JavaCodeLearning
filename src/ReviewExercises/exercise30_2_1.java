package ReviewExercises;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class exercise30_2_1 {
    public static void main(String[] args) {
        Character[] chars = {'D', 'B', 'A', 'C'};
        System.out.println(Stream.of(chars).filter(e -> e > 'A').findFirst().get());
        System.out.println(Stream.of(chars).allMatch(e -> e >= 'A'));
        System.out.println(Stream.of(chars).anyMatch(e -> e > 'F'));
        Object[] temp = Stream.of(chars).map(e -> e + "Y").map(e -> e.toLowerCase()).sorted().toArray();
        System.out.println(Arrays.toString(temp));
        System.out.println("======================================================================");
        Stream<Character> stream = Stream.of(chars).sorted();
//        System.out.println(stream.findFirst());
        System.out.println("======================================================================");
        //(a) sorted((s1, s2) -> si.compareToIgnoreCase(s2))
        //(b) forEach(System.out::println)
        String[] names = {"John", "Peter", "Susan", "Kim"};
        Stream.of(names).sorted((e1, e2) -> e1.compareToIgnoreCase(e2));
        Stream.of(names).sorted(
                new java.util.Comparator<String>() {
                    public int compare(String e1, String e2){
                        return e1.compareToIgnoreCase(e2);
                    }
                });
        Stream.of(names).sorted(String::compareToIgnoreCase);

        System.out.println(".............................");
        Stream.of(names).forEach(e -> System.out.println(e));
        Stream.of(names).forEach(new java.util.function.Consumer<String>() {
            public void accept(String e) {
                System.out.println(e + " ");
            }
        });
        Stream.of(names).forEach(System.out::println);
        System.out.println("======================================================================");
        Map<String, Double> map = new HashMap<>();
        map.put("John", 1.5);
        map.put("Peter", 1.1);
        Double sum = map.entrySet().stream().mapToDouble(e -> e.getValue()).sum();
        System.out.println(sum);
        System.out.println((char)51);
        int[] numbers = {2,3,4,1};
        Object[] array = IntStream.of(numbers).mapToObj(new java.util.function.IntFunction<Character>() {
            public Character apply (int e){
                return (char)(e+50);
            }
        }).toArray();
        System.out.println(Arrays.toString(array));

    }
}
