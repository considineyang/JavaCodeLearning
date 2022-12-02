import java.util.Arrays;
import java.util.Comparator;

public class BestArrange {
    public static class Program{
        public int startTime;
        public int endTime;

        public Program(int startTime, int endTime){
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }

    public static class ProgramComparator implements Comparator<Program> {
        @Override
        public int compare(Program o1, Program o2) {
            return o1.endTime - o2.endTime;
        }
    }

    public static int bestArrange(Program[] programs, int timePoint){
        Arrays.sort(programs,new ProgramComparator());
        int result = 0;
        for (int i = 0; i < programs.length; i++) {
            if (timePoint <= programs[i].startTime){
                result++;
                timePoint = programs[i].endTime;
            }
        }
        return result;
    }


}
