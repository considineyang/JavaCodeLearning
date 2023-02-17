import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;

public class IntStreamDemo {
    public static void main(String[] args) {
        int[] values = {3,4,1,5,20,1,3,3,4,6};

        IntSummaryStatistics stats =
                IntStream.of(values).summaryStatistics();

        System.out.printf("""
                        The summary of the stream is\s
                        %-10s%10d
                        %-10s%10d
                        %-10s%10d
                        %-10s%10d
                        %-10s%10.2f
                        """,
                " Count:",stats.getCount(), " Max:", stats.getMax(),
                " Min:",stats.getMin(), " Sum:",stats.getSum(),
                " Average",stats.getAverage());
    }
}
