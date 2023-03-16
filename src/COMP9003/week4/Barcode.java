package COMP9003.week4;


import java.util.Scanner;

public class Barcode {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.next();
        int check = 0;
        int[] nums = new int[12];
        boolean flag = true;

        for (int i = 0; i < s.length(); i++) {
            nums[i] = (int)(s.charAt(i)-48);
        }
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0){
                flag = false;
            }
        }
        if(flag){
            System.out.println("valid");
            return;
        }
//        for (int i = 0; i < nums.length; i++) {
//            if (i%2 == 0){
//                check += nums[i] *3;
//            }else{
//                if(i != 11){
//                    check += nums[i];
//                }
//            }
//        }
//        check = 10 - check%10;
        for (int i = 0; i < nums.length; i++) {
            if ( i % 2 == 0){
                check += nums[i];
            }

        }
        check *= 3;
        check %= 10;
        for (int i = 0; i < (nums.length - 1) ; i++) {
            if ( i % 2 == 1){
                check +=nums[i];
            }

        }
        check %= 10;
        check = (10 -check)%10;
        System.out.println(check);
        if(check == nums[11] ){
            System.out.println("valid");
        }else {
            System.out.println("invalid");
        }
    }
}
