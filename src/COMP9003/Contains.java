package COMP9003;

import java.util.Arrays;

public class Contains {
    public static boolean contains(int[] a, int element) {
        boolean result = Arrays.stream(a).anyMatch(n -> n == element);
        return result;
    }

    public static void main(String[] args) {
        int[] array = {1,1,5,5,5,3,8,1};
        boolean result = contains(array, 5);
        System.out.println(result);
    }
}
