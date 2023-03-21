package COMP9003.Week5;
import java.util.*;

public class Question13 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        HashMap<Integer,String> map = new HashMap<>();
        map.put(1," ");
        map.put(2," ");
        map.put(3," ");
        boolean flag = false;
        String name = " ";

        while (map.containsValue(" ")) {
            if (flag == false){
                System.out.print("Enter Name: ");
                name = input.next();
            }
            System.out.print("Enter time: ");
            int time = input.nextInt();
            if (!(time == 1||time == 2||time == 3)){
                System.out.println("Invalid slot, please choose either 1, 2 or 3 pm slot");
                flag = true;
                continue;
            }
            if (!Objects.equals(map.get(time), " ")){
                System.out.println("Slot Not Available, please choose another slot");
                flag = true;
                continue;
            }
            map.put(time,name);
            System.out.println("Hi " + name+", your appointment is confirmed at "+ time+" PM");
            flag = false;
        }
        for (Map.Entry<Integer,String> entry: map.entrySet()
             ) {
            System.out.println(entry.getKey()+" --> "+entry.getValue());
        }
    }
}
