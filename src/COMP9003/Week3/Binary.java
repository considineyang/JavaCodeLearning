package COMP9003.Week3;

import java.util.Scanner;
public class Binary {


    public int toDecimal(String b) {
        int num = 0;
        for (int i =0; i < b.length() ; i++) {
            num += java.lang.Math.pow(2,i)*(b.charAt(b.length() - i - 1) - 48);
        }
        return num;
    }


    public boolean isBinary(String b) {
        for (int i = 0; i < b.length(); i++) {
            if (b.charAt(i) != '0' && b.charAt(i) != '1' ) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Binary binary = new Binary();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter binary: ");
        String str = scanner.next();
        System.out.println();
        if (!binary.isBinary(str)){
            System.out.println("Not binary!");
            return;
        }
        System.out.println(binary.toDecimal(str)+" in decimal");
    }
}