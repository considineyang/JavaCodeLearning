import java.util.Arrays;
import java.util.Comparator;

public class LowestLexicography {

    public static class MyComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            return (o1 + o2).compareTo(o2 + o1);
        }
    }

    public static String lowestString(String[] strings){
        if (strings == null || strings.length == 0){
            return "";
        }
        Arrays.sort(strings,new MyComparator());
        String res = "";
        for (int i = 0; i < strings.length; i++) {
            res += strings[i];
        }
        return res;
    }

}
