package COMP9003;
import java.util.*;
import java.lang.Math;


public class AmazingSequence {
    static int n = 0;
    static int N = 0;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean flag = false;
        try {
            try{
                n = input.nextInt();
            }catch (Exception e){
                System.out.println("Error in input");
                return;
            }

            N = Math.abs(n);
            int[] num = new int[N];

            for (int i = 0; i < N; i++) {
                num[i] = input.nextInt();
                if (num[i] < 0) {
                    flag = true;
                }
            }
            if (!input.nextLine().isBlank()) {
                System.out.println("Invalid input");
                return;
            }
            if (n <= 0) {
                System.out.println("Error in input");
                return;
            } else if (flag == true) {
                System.out.println("Invalid input");
                return;
            }
            HashSet<Integer> set = new HashSet<>();
            ArrayList<Integer> arrayList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    int temp = 0;
                    temp = num[j] - num[i];
                    if (temp > 0) {
                        set.add(num[j] - num[i]);
                        arrayList.add(num[j] - num[i]);
                    }
                }
            }
            System.out.println(set);
            Collections.sort(arrayList);
            System.out.println(arrayList);

            System.out.println((n - 1) * n / 2);
            System.out.println(set.size());
            System.out.println(arrayList.size());
            if (set.size() != (n - 1) * n / 2) {
                System.out.println("It is an ordinary sequence");
                return;
            } else {
                System.out.println("It is an Amazing Sequence");
            }
        } catch (Exception e){
            System.out.println("Invalid input");
            return;
        }
    }
}
