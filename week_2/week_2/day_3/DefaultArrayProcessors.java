package week_2.day_3;

import java.util.Arrays;

public class DefaultArrayProcessors {

    private static final double DEFAULT_PRECISION = 0.0000001;

    public static final ArrayProcessor MAX = arr -> Arrays.stream(arr).summaryStatistics().getMax();
    public static final ArrayProcessor MIN = arr -> Arrays.stream(arr).summaryStatistics().getMin();
    public static final ArrayProcessor SUM = arr -> Arrays.stream(arr).sum();
    public static final ArrayProcessor AVG = arr -> Arrays.stream(arr).summaryStatistics().getAverage();

    /**
     * This function should return an ArrayProcessor that counts the number of times that
     * value occurs in an array. The return value should be given as a lambda expression.
     * @param value value occurs in array
     * @return counts the number of times that value occurs
     */
    public static ArrayProcessor counter(double value) {
        return arr -> Arrays.stream(arr)
                .filter(e ->  Math.abs(e - value) <= DEFAULT_PRECISION)
                .count();
    }
}
