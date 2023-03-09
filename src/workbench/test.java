package workbench;

public class test {
    public static void main(String[] args) {
        double[] array = new double[10];
        for(int i = 0; i< 10;i++){
            array[i] = ((i%2)/2.0-0.5)*(-1)-((i%4+1 - i%4)-(i%4+1)/2+(i%4+1)/4);
            System.out.println(array[i]);
        }
        System.out.println(-0.0 == 0.0);
    }
}
