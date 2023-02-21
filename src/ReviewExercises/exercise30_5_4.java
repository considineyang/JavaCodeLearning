package ReviewExercises;

import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class exercise30_5_4 {
    public static void main(String[] args) {
        int[][] m = {{1,2},{3,4},{5,6},{1,3}};
        System.out.println(
                Stream.of(m).map(e -> IntStream.of(e))
                        .reduce((e1,e2)->IntStream.concat(e1,e2))
                        .get().mapToObj(e -> e+"").distinct()
                        .reduce((e1,e2)->e1 + ", " + e2).get()
        );

        System.out.println("=============================================");


        int[] values1 = {1,2,3,4,5,6};
        List<Integer> list = IntStream.of(values1).mapToObj(e -> e).collect(Collectors.toList());
        Object[] test = IntStream.of(values1).mapToObj(e -> e).toArray();
        System.out.println(Arrays.toString(test));
//        System.out.println(list);


        System.out.println("=============================================");

        int[] values = {1, 2, 2, 3, 4, 2, 1};
        IntStream.of(values).mapToObj(e -> e).collect(
                        Collectors.groupingBy(e -> e, TreeMap::new,
                                Collectors.counting())).
                forEach((k, v) -> System.out.println(k + " occurs " + v
                        + (v > 1 ? " times " : " time ")));


        System.out.println("=============================================");


        String[][] matrix = {{"John","Kate"},{"Bob","Tom"},{"Peter","Carlie"}};

        Object[] list3 = Stream.of(matrix).map(e -> Stream.of(e)).reduce((e1,e2) -> Stream.concat(e1,e2)).get().toArray();
        System.out.println(Arrays.toString(list3));



    }
}
