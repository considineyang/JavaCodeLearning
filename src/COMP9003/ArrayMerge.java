package COMP9003;

import java.util.Arrays;

public class ArrayMerge {
    public static int[][] mergeArrays(int[][] arrayA, int[][] arrayB){
        int a1 = arrayA.length;
        int a2 = arrayA[0].length;
        int b1 = arrayB.length;
        int b2 = arrayB[0].length;
        int[][] result = new int[a1][a2+b2];
        for (int i = 0; i < a1; i++) {
            for (int j = 0; j < a2 ; j++) {
                result[i][j] = arrayA[i][j];
            }
        }
        for (int i = 0; i < a1; i++) {
            for (int j = a2; j < a2+b2; j++) {
                result[i][j] = arrayB[i][j-a2];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] array1 = {{1,2,3,3},{3,2,1,6},{4,5,6,1}};
        int[][] array2 = {{1,9,7,2,3},{0,7,8,3,2},{3,8,9,7,2}};
        int a1 = array1.length;
        int a2 = array1[0].length;
        int b1 = array2.length;
        int b2 = array2[0].length;
        System.out.println(a1);
        System.out.println(a2);
        System.out.println(b1);
        System.out.println(b2);

        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array1[0].length+array2[0].length; j++) {
                System.out.print(mergeArrays(array1,array2)[i][j]+ " ");
            }
        }
    }
}
