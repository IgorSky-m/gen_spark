package week_2.day_1.classes_and_interfaces;

import java.util.Arrays;

public class Classroom extends Room {

    private int numStudents;

    public Classroom(double d1, double d2, int floor, int numStudents) {
        super(d1, d2, floor);
        this.numStudents = numStudents;
    }

    public int getNumStudents() {
        return numStudents;
    }

    public void setNumStudents(int numStudents) {
        this.numStudents = numStudents;
    }

    @Override
    public String toString() {
        return super.toString() + ", capacity = " + numStudents + " students";
    }

    public static Classroom[] findClassrooms(Room[] rooms){
        return Arrays.stream(rooms)
                .filter(e -> e instanceof Classroom)
                .toArray(Classroom[]::new);
    }
}
