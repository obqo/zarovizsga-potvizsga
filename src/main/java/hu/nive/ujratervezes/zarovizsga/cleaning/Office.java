package hu.nive.ujratervezes.zarovizsga.cleaning;

public class Office implements Cleanable{

    private final String address;
    private final int area;
    private final int level;

    public Office(String address, int area, int level) {
        this.address = address;
        this.area = area;
        this.level = level;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public int clean() {
        return area * level * 100;
    }

    @Override
    public String toString() {
        return "Office{" +
                "address='" + address + '\'' +
                ", area=" + area +
                ", level=" + level +
                '}';
    }
}
