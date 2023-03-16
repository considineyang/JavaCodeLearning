package COMP9003.week4;

import java.util.*;

public class Reverse {

    public static String reverse(String s){
        if (s == null){
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder(s);
        stringBuilder.reverse();
        return stringBuilder.toString();
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        while (input.hasNextLine()){
            list.add(input.nextLine());
        }
        for (String s:
             list) {
            System.out.println(reverse(s));
        }
    }


}
