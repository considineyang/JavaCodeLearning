import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//The difference between the function collect and the factory function collector
public class CollectDemo {
    public static void main(String[] args) {
        String[] names = {"John", "Peter", "Susan", "Kim", "Jen", "George", "Alan", "Stacy", "Michelle", "john"};
//        System.out.println("The number of characters for all name:" + Stream.of(names).collect(StringBuilder::new,
//                StringBuilder::append,StringBuilder::append).length());
        List<String> list = Stream.of(names).collect(ArrayList::new,ArrayList::add,ArrayList::addAll);
//        System.out.println(list);

        list = Stream.of(names).collect(Collectors.toList());
                                                                                //classifier        //processor
        Map<Character, Long> map = Stream.of(names).collect(Collectors.groupingBy(e -> e.charAt(0), Collectors.counting()));
//        System.out.println(map);


        //CollectGroupDemo

        Map<String, Long> map1 = Stream.of(names).map(String::toUpperCase).collect(Collectors.groupingBy(e -> e, Collectors.counting()));
//        System.out.println(map1);

        Map<Character, Long> map2 = Stream.of(names).collect(Collectors.groupingBy(e -> e.charAt(0), TreeMap::new, Collectors.counting()));
        System.out.println(map2);


    }

}
