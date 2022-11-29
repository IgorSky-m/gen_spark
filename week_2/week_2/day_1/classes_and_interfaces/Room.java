package week_2.day_1.classes_and_interfaces;

public class Room implements Comparable<Room>{
    private double width;
    private double length;
    private int floor;

    public Room() {
        this.width = 10;
        this.length = 12.5;
        this.floor = 1;
    }

    public Room(double d1, double d2, int floor) {
        setLength(Math.max(d1, d2));
        setWidth(Math.min(d1,d2));
        setFloor(floor);
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    @Override
    public String toString() {
        return width + " x " + length + ", floor " + floor;
    }

    @Override
    public int compareTo(Room other) {
        if (other == null) {
            return 1;
        }

        int compareResult = Integer.compare(floor, other.getFloor());

        if (compareResult == 0) {
            compareResult = Double.compare(length, other.getLength());

            if (compareResult == 0) {
                compareResult = Double.compare(width, other.getWidth());
            }
        }

        return compareResult;
    }
}
