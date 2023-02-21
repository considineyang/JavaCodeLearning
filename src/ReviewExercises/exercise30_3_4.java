package ReviewExercises;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class exercise30_3_4 {
    public static void main(String[] args) {
        int[][] m = {{1,2},{3,4},{5,6}};

        System.out.println(Stream.of(m).mapToInt(e -> IntStream.of(e).sum()).sum());

        Random random = new Random();
        double[] numbers = random.doubles(1000,0.0,1.0).toArray();
        System.out.println(Arrays.toString(numbers));


    }
}
