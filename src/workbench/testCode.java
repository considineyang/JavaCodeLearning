package workbench;

import java.util.Comparator;
import java.util.stream.Stream;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files



public class testCode {

        public static void main(String[] args) {
            try {
                File myObj = new File("/Users/yangwenbo/IdeaProjects/JavaCodeLearning/src/workbench/marks1.txt");
                Scanner myReader = new Scanner(myObj);
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    System.out.println(data);
                }
                myReader.close();
            } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }
    }




