package COMP9003.Week3;


import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ReverseArray {
    public static void main(String[] args) {
        if (args.length == 0){
            return;
        }
        File inputFile = new File(args[0]);
        File outputFile = new File(args[1]);

        try {
            Scanner scanner = new Scanner(inputFile);
            String string = scanner.nextLine();
            String[] array = string.split(" ");
            String[] reverseArray = new String[array.length];
            for (int i = 0; i < array.length; i++) {
                reverseArray[i] = array[array.length-i-1];
            }
            PrintWriter printWriter = new PrintWriter(outputFile);
            for (int i = 0; i < reverseArray.length; i++) {
                printWriter.print(reverseArray[i]);
                if(i != reverseArray.length-1){
                    printWriter.print(" ");
                }
            }
            printWriter.print('\n');
            printWriter.close();

        }catch (FileNotFoundException e){
            // System.out.println("No file found!");
            return;

        }
        System.out.println();
    }
}
