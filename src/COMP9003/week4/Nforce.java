package COMP9003.week4;

import java.util.Scanner;

public class Nforce {
    public static void main(String[] args) {

        try {
            System.out.print("Enter height: ");
            Scanner input = new Scanner(System.in);
            int height = input.nextInt();
            if (height < 1 || height > 20) {
                System.out.println();
                System.out.println("Invalid height.");
                return;
            }
            int rows = 0;
            try{
                System.out.print("Enter number of rows: ");
                rows = input.nextInt();
            if (rows < 1 || rows > 20) {
                System.out.println();
                System.out.println("Invalid number of rows.");
                return;
            }
            } catch (Exception e) {
                System.out.println();
                System.out.println("Invalid number of rows.");
                return;
            }
            System.out.println();

            for (int k = 1; k <= rows; k++) {;
                for (int i = 0; i < height; i++) {
                    int temp = k;
                    while(temp>0){
                        if (temp == k){
                            for (int j = 0; j < rows - k; j++) {
                                for (int l = 0; l < height; l++) {
                                    System.out.print(" ");
                                }
                            }
                        }
                        for (int j = 0; j < height - i - 1; j++) {
                            System.out.print(" ");
                            if (temp!=k){
                                System.out.print(" ");
                            }
                        }
                        System.out.print("/");
                        for (int j = 0; j < 2 * i; j++) {
                            if (i < height - 1) {
                                System.out.print(" ");
                            } else {
                                System.out.print("_");
                            }
                        }
                        System.out.print("\\");
                        temp--;
                    }
                    System.out.println();
                }
            }
        } catch (Exception e) {
            System.out.println();
            System.out.println("Invalid height.");
            return;
        }

    }
}
