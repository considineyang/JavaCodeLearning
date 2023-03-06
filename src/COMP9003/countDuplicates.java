package COMP9003;

import java.util.HashSet;

public class countDuplicates {
    public static int countDuplicates(int[] a) {
        int result = 0;
        int count = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < a.length; i++) {
            set.add(a[i]);
        }
        for (int t :
                set) {
            count = 0;
            for (int i = 0; i < a.length; i++) {
                if (t == a[i]){
                    count++;
                }
            }
            if (count > 1){
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] dups = {1, 1, 5, 6, 5, 3, 8, 1, 9, 2, 8};
        int result = countDuplicates(dups);
        System.out.println(result);

    }

}
