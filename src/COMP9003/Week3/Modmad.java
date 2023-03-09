package COMP9003.Week3;
/*
 *	Generate a sequence of numbers using the modulus operation
 *
 *	Each method returns an array of n numbers
 *	if n < 0 return null
 *  if n == 0 return array of size zero
 */
public class Modmad
{
    // practice (no modulus needed)
    // Sequence: 13, 13, 13, 13, 13, 13, ...
    public static int[] practice1(int n) {
        // YOUR CODE BE HERE
        if(n<0){
            return null;
        }
        if(n == 0){
            int[] array0 = new int[0];
            return array0;
        }
        int[] array = new int[n];
        for(int i = 0; i< n;i++){
            array[i] = 13;
        }
        return array;
    }

    // practice (no modulus needed)
    // Sequence: 0, 1, 2, 3, 4, 5, 6, 7...
    public static int[] practice2(int n) {
        // YOUR CODE BE HERE
        if(n<0){
            return null;
        }
        if(n == 0){
            int[] array0 = new int[0];
            return array0;
        }
        int[] array = new int[n];
        for(int i = 0; i< n;i++){
            array[i] = i;
        }
        return array;
    }

    // Sequence: 0, 1, 2, 3, 0, 1, 2, 3, 0, 1, 2, 3...
    public static int[] generateA(int n) {
        // YOUR CODE BE HERE
        if(n<0){
            return null;
        }
        if(n == 0){
            int[] array0 = new int[0];
            return array0;
        }
        int[] array = new int[n];
        for(int i = 0; i< n;i++){
            array[i] = i%4;
        }
        return array;
    }

    // Sequence: 3, 2, 1, 0, 3, 2, 1, 0, 3, 2, 1, 0...
    public static int[] generateB(int n) {
        // YOUR CODE BE HERE
        if(n<0){
            return null;
        }
        if(n == 0){
            int[] array0 = new int[0];
            return array0;
        }
        int[] array = new int[n];
        for(int i = 0; i< n;i++){
            array[i] = 3 - i%4;
        }
        return array;
    }

    // Sequence: 0, 3, 6, 0, 3, 6, 0, 3, 6...
    public static int[] generateC(int n) {
        if(n<0){
            return null;
        }
        if(n == 0){
            int[] array0 = new int[0];
            return array0;
        }
        int[] array = new int[n];
        for(int i = 0; i< n;i++){
            array[i] = 3*(i%3);
        }
        return array;
    }

    // Sequence: 0, 2, 4, 6, 0, 2, 4, 6, 0, 2, 4, 6...
    public static int[] generateD(int n) {
        if(n<0){
            return null;
        }
        if(n == 0){
            int[] array0 = new int[0];
            return array0;
        }
        int[] array = new int[n];
        for(int i = 0; i< n;i++){
            array[i] = 2*(i%4);
        }
        return array;
    }

    // Sequence: -3, -2, -1, 0, 1, 2, 3, -3, -2, -1, 0, 1, 2, 3...
    public static int[] generateE(int n) {
        if(n<0){
            return null;
        }
        if(n == 0){
            int[] array0 = new int[0];
            return array0;
        }
        int[] array = new int[n];
        for(int i = 0; i< n;i++){
            array[i] = (i%7) - 3;
        }
        return array;
    }

    // Sequence: 100, 105, 110, 115, 120, 100, 105, 110, 115, 120, 100...
    public static int[] generateF(int n) {
        if(n<0){
            return null;
        }
        if(n == 0){
            int[] array0 = new int[0];
            return array0;
        }
        int[] array = new int[n];
        for(int i = 0; i< n;i++){
            array[i] = 100 + 5*(i%5);
        }
        return array;
    }

    // Sequence: -1, 1, 3, 5, -1, 1, 3, 5, -1, 1, 3, 5...
    public static int[] generateG(int n) {
        // YOUR CODE BE HERE
        if(n<0){
            return null;
        }
        if(n == 0){
            int[] array0 = new int[0];
            return array0;
        }
        int[] array = new int[n];
        for(int i = 0; i< n;i++){
            array[i] = -1 + 2*(i%4);
        }
        return array;
    }

    // Sequence: 0, 50, 100, 0, 50, 100...
    public static int[] generateH(int n) {
        // YOUR CODE BE HERE
        if(n<0){
            return null;
        }
        if(n == 0){
            int[] array0 = new int[0];
            return array0;
        }
        int[] array = new int[n];
        for(int i = 0; i< n;i++){
            array[i] = 50*(i%3);
        }
        return array;
    }

    // Sequence: -0.5, 0, 0.5, 0, -0.5, 0, 0.5...
    public static double[] generateI(int n) {
        // YOUR CODE BE HERE
        if(n<0){
            return null;
        }
        if(n == 0){
            double[] array0 = new double[0];
            return array0;
        }
        double[] array = new double[n];
        for(int i = 0; i< n;i++){
            array[i] = ((i%2)/2.0-0.5)*(-1)-((i%4+1 - i%4)-(i%4+1)/2+(i%4+1)/4);
        }
        return array;
    }

    // Sequence: 0, 1, 2, 3, 1, 2, 3, 4, 2, 3, 4, 5, 3, 4, 5, 6...
    public static int[] generateJ(int n) {
        // YOUR CODE BE HERE
        if(n<0){
            return null;
        }
        if(n == 0){
            int[] array0 = new int[0];
            return array0;
        }
        int[] array = new int[n];
        for(int i = 0; i< n;i++){
            array[i] = i%4+i/4;
        }
        return array;
    }

    // oh being cheeky with the if statements?
    // return the exact number appearing in the sequence for the given i
    // if (i < 0) return i;
    // Sequence: -0.5, 0, 0.5, 0, -0.5, 0, 0.5...
    public static double generateI2(int i) {
        // YOUR CODE BE HERE
        if(i < 0)
            return i;
        double value;
        value = ((i%2)/2.0-0.5)*(-1)-((i%4+1 - i%4)-(i%4+1)/2+(i%4+1)/4);
        return value;
    }


    // oh being cheeky with the if statements?
    // return the exact number appearing in the sequence for the given i
    // if (i <= 0) return i;
    // Sequence: 0, 1, 2, 3, 1, 2, 3, 4, 2, 3, 4, 5, 3, 4, 5, 6...
    public static int generateJ2(int i) {
        // YOUR CODE BE HERE
        if(i < 0)
            return i;
        return i%4+i/4;
    }

}

