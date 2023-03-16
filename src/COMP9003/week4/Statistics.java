package COMP9003.week4;

import java.util.ArrayList;
import java.lang.Math;
import java.util.Scanner;

public class Statistics {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Double> numbers = new ArrayList<>();
        System.out.println("Enter data set:");
        while (input.hasNextDouble()){
            double d = input.nextDouble();
            numbers.add(d);
        }
        System.out.println();


        if (numbers.isEmpty()){
            System.out.println("No data!");
        }else {
            System.out.printf("Mean = %.4f",mean(numbers));
            System.out.println();
            System.out.printf("Variance = %.4f",variance(numbers,mean(numbers)));
            System.out.println();
            System.out.printf("Standard deviation = %.4f",sd(variance(numbers,mean(numbers))));
            System.out.println();
        }
    }

    // Returns the mean of the given data set.
    public static double mean(ArrayList<Double> numbers) {
        double sum = 0.0;
        for (int i = 0; i < numbers.size(); i++) {
            sum += numbers.get(i);
        }
        sum /= numbers.size();
        return sum;
    }

    // Returns the variance of the given data set.
    public static double variance(ArrayList<Double> numbers, double mean) {
        double result = 0.0;
        for (int i = 0; i < numbers.size(); i++) {
            result += Math.pow((numbers.get(i) - mean),2);
        }
        result /= numbers.size();
        return result;
    }

    // Returns the standard deviation of the given data set.
    public static double sd(double variance) {
        return Math.sqrt(variance);
    }
}
