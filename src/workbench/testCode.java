package workbench;

import java.util.Comparator;
import java.util.stream.Stream;

public class testCode {

    public static void main(String[] args) {
        Character[] chars = {'D', 'B', 'A', 'C'};

        System.out.println(Stream.of(chars).sorted().findFirst().get());

        System.out.println(Stream.of(chars).sorted(Comparator.reverseOrder()).findFirst().get());

        System.out.println(Stream.of(chars).limit(2).sorted().findFirst().get());

    }


}
