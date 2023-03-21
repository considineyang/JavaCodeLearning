package workbench;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class test {
    public static void main(String[] args) {

        System.out.println( new String("Java") == "Java");//1
        System.out.println(new String("Java") == new String("Java"));// 2
        System.out.println(new String("Java").equals("Java")); // 3

    }
}
