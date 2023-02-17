import java.util.Objects;
import java.util.stream.Stream;

public class StreamLearning {
    public static void main(String[] args) {
        String[] names = {"John", "Peter", "Susan", "Kim", "Jen", "George", "Alan", "Stacy", "Michelle"};

        Stream.of(names).limit(4).sorted()
                .forEach(e -> System.out.print(e+ "  "));

        System.out.println();
        Stream.of(names).skip(4)
                .sorted(String::compareToIgnoreCase)
                .forEach(e -> System.out.print(e + "    "));

        System.out.println();
        System.out.println("Largest string with length > 4\n" + Stream.of(names).filter(e -> e.length()>4)
                .max(String::compareTo).get());


        System.out.println("All names start with a capital letter? " + Stream.of(names)
                .allMatch(e -> Character.isUpperCase(e.charAt(0))));

        Object[] namesInLowerCase =
                Stream.of(names).map(String::toLowerCase).toArray();
        System.out.println(java.util.Arrays.toString(namesInLowerCase));
    }
}
