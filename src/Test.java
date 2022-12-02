import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Test {
    public static void main(String[] args) {
        Collection<String> collection = new ArrayList<>();
        collection.add("ywb");
        collection.add("love");
        collection.add("zrt");

        Iterator<String> iterator = collection.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().toUpperCase() + "  ");
        }
        System.out.println();

        collection.forEach(e -> System.out.print(e.toUpperCase() + " "));


    }
}
