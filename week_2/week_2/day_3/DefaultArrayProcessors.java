package week_2.day_3;

import java.util.Arrays;

public class DefaultArrayProcessors {

    private static final double DEFAULT_PRECISION = 0.0000001;

    public static final ArrayProcessor MAX = arr -> Arrays.stream(arr).summaryStatistics().getMax();
    public static final ArrayProcessor MIN = arr -> Arrays.stream(arr).summaryStatistics().getMin();
    public static final ArrayProcessor SUM = arr -> Arrays.stream(arr).sum();
    public static final ArrayProcessor AVG = arr -> Arrays.stream(arr).summaryStatistics().getAverage();

    public static ArrayProcessor counter(double value) {
        return arr -> Arrays.stream(arr)
                .filter(e ->  Math.abs(e - value) <= DEFAULT_PRECISION)
                .sum();
    }
}
