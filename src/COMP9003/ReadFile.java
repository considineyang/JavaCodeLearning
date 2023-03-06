package COMP9003;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;


public class ReadFile {
    static int num = 0;
    static StudentScore[] studentScores = new StudentScore[500];

    public static StudentScore contain(String name) {
        for (int i = 0; i < num; i++) {
            if (studentScores[i] == null){
                continue;
            }
            if (studentScores[i].getStudentName().equals(name)){
                return studentScores[i];
            }
        }
        return null;
    }

    public static void bubblingSort(String[] arr) {
        int size = arr.length;
        for(int i = 0; i<size-1; i++) {
            for (int j = i+1; j<arr.length; j++) {
                if (arr[j] == null){
                    return;
                }
                if(arr[i].compareTo(arr[j])>0) {
                    String temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        // TODO


        if (args.length == 0){
            System.out.println("No file provided");
            return;
        }

        if (args.length > 1){
            System.out.println("Error in input");
            return;
        }

        try {

            //Read the file
            File file = new File(args[0]);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String info = scanner.nextLine();
                String[] studentInfo = info.split(",");
                String stName = studentInfo[0].toLowerCase();
                if(Double.parseDouble(studentInfo[2])<0 || Double.parseDouble(studentInfo[2])>100){
                    System.out.println("Invalid marks");
                    return;
                }
                if (contain(stName)==null){
                    double[] marks = new double[20];
                    marks[0] = Double.parseDouble(studentInfo[2]);
                    studentScores[num] = new StudentScore(stName,marks,1);
                }else {
                    StudentScore studentScore = contain(stName);
                    int number = studentScore.getNumOfCOurse();
                    studentScore.getMarks()[number] = Double.parseDouble(studentInfo[2]);
                    studentScore.setNumOfCOurse(number+1);
                }
                num++;
            }

        }catch (FileNotFoundException e){
            System.out.println("No such file");
        }
        String[] names = new String[500];
        int k = 0;
        for (int i = 0; i < num; i++) {
            if (studentScores[i] == null){
                continue;
            }

            int sum = 0;
            for (int j = 0; j < studentScores[i].getMarks().length; j++) {
                sum += studentScores[i].getMarks()[j];
            }
            studentScores[i].setAverage(sum/studentScores[i].getNumOfCOurse());
//            System.out.println(studentScores[i].toString());
        }
        double max = 0;
        for (int i = 0; i < num; i++) {
            if (studentScores[i] == null) {
                continue;
            }
            if (studentScores[i].getAverage() > max){
                max = studentScores[i].getAverage();
            }
        }
        for (int i = 0; i < num; i++) {
            if (studentScores[i] == null) {
                continue;
            }
            if (studentScores[i].getAverage() == max){
                names[k++] = studentScores[i].getStudentName();
            }
        }
        bubblingSort(names);
        for (int i = 0; i < names.length; i++) {
            if (names[i] == null) {
                break;
            }
            System.out.println(names[i]);
        }
    }

}

class StudentScore{
    private String studentName;

    private double[] marks;

    private int numOfCOurse = 0;

    private double average;

    @Override
    public String toString() {
        return "StudentScore{" +
                "studentName='" + studentName + '\'' +
                ", marks=" + Arrays.toString(marks) +
                ", numOfCOurse=" + numOfCOurse +
                ", average=" + average +
                '}';
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public double[] getMarks() {
        return marks;
    }

    public void setMarks(double[] marks) {
        this.marks = marks;
    }

    public int getNumOfCOurse() {
        return numOfCOurse;
    }

    public void setNumOfCOurse(int numOfCOurse) {
        this.numOfCOurse = numOfCOurse;
    }

    public StudentScore(String studentName, double[] marks, int numOfCOurse) {
        this.studentName = studentName;
        this.marks = marks;
        this.numOfCOurse = numOfCOurse;
    }


}
