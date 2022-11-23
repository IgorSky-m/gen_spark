package week_2.day_1.holidays;

import java.util.Objects;

public class Holiday {
    private String name;
    private int day;
    private String month;

    public Holiday(String name, int day, String month){
        this.name = name;
        this.day = day;
        this.month = month;
    }

    public boolean inSameMonth(Holiday other){
        //if objects is null - exception
        if (other == null) {
            throw new IllegalArgumentException("other object can't be empty");
        }
        return Objects.equals(month, other.month);
    }

    public double avgDate(Holiday[] arr){
        //if empty - exception
        if (arr == null) {
            throw new IllegalArgumentException("array can't be empty");
        }

        int sum = 0;

        for (Holiday holiday : arr) {
            //check instance, if null - exception
            if (holiday == null) {
                throw new IllegalArgumentException("holiday instance can't be empty");
            }
            sum+= holiday.day;
        }

        return sum / arr.length;
    }

}
