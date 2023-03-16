package COMP9003.week4;

import java.util.ArrayList;

public class SelectionSort {
    public static ArrayList<String> selectionSort(ArrayList<String> listA, ArrayList<Integer> listB) {
        if (listA == null || listB == null || listA.size() != listB.size()){
            return null;
        }
        ArrayList<String> result = new ArrayList<>();
        ArrayList<Integer> copyB = new ArrayList<>();
        for (int i = 0; i < listB.size(); i++) {
            copyB.add(i,listB.get(i));
        }
        for (int i = 0; i < listA.size(); i++) {
            int min = 99999;
            int num = 0;
            for (int j = 0; j < copyB.size(); j++) {
                if (copyB.get(j) < min && copyB.get(j) != -1){
                    min = copyB.get(j);
                    num = j;
                }
            }
            copyB.set(num,-1);
            result.add(i,listA.get(num));
        }
        return result;
    }
}
