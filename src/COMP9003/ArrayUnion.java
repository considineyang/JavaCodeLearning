package COMP9003;

import java.util.Arrays;
import java.util.HashSet;

public class ArrayUnion {


    public static int[] union(int[] a, int[] b) {
        if (a == null || b == null){
            return null;
        }
        HashSet<Integer> seta = new HashSet<>();
        HashSet<Integer> setb = new HashSet<>();


        for (int i = 0; i < a.length; i++) {
            seta.add(a[i]);
        }
        for (int i = 0; i < b.length; i++) {
            setb.add(b[i]);
        }
        for (int t :
                setb) {
            if (!seta.contains(t)) {
                seta.add(t);
            }
        }
        int[] result = new int[seta.size()];
        int i = 0;
        for (int t :
                seta) {
            result[i++] = t;
        }


        return result;
    }


    public static void main(String[] args) {
        int[] x = {3, 2, 7};
        int[] y = {3, 8, 9};

        int[] result = union(x, y);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }


    }

}