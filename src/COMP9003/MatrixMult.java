package COMP9003;
import java.util.Scanner;

public class MatrixMult {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String inputP = input.nextLine();
        String[] param = inputP.split(" ");
        int widthOfA = Integer.parseInt(param[0]);
        int heightOfA = Integer.parseInt(param[1]);
        int widthOfB = Integer.parseInt(param[2]);
        int heightOfB = Integer.parseInt(param[3]);
        if(widthOfA == 0 || heightOfA == 0|| widthOfB == 0|| heightOfB ==0){
            System.out.println(0);
            return;
        }

        int[][] matrixA = new int[heightOfA][widthOfA];
        int[][] matrixB = new int[heightOfB][widthOfB];

        for (int i = 0; i < heightOfA; i++) {
            for (int j = 0; j < widthOfA; j++) {
                matrixA[i][j] = input.nextInt();
            }
        }

        for (int i = 0; i < heightOfB; i++) {
            for (int j = 0; j < widthOfB; j++) {
                matrixB[i][j] = input.nextInt();
            }
        }

//        for (int i = 0; i < heightOfA; i++) {
//            for (int j = 0; j < widthOfA; j++) {
//                System.out.print(matrixA[i][j] + " ");
//            }
//        }
//
//        for (int i = 0; i < heightOfB; i++) {
//            for (int j = 0; j < widthOfB; j++) {
//                System.out.print(matrixB[i][j] + " ");
//            }
//        }

        if (widthOfA != heightOfB){
            System.out.println("Invalid input.");
            return;
        }

        int[][] result = new int[heightOfA][widthOfB];

        for (int i = 0; i < heightOfA; i++) {
            for (int j = 0; j < widthOfB; j++) {
                for (int k = 0; k < widthOfA; k++) {
                    result[i][j] += matrixA[i][k] * matrixB[k][j];
                }
            }
        }

//        System.out.println();

        for (int i = 0; i < heightOfA; i++) {
            for (int j = 0; j < widthOfB; j++) {
                System.out.print(result[i][j] + ((j == widthOfB-1) ? "":" "));
            }
            System.out.println();
        }


    }
}
