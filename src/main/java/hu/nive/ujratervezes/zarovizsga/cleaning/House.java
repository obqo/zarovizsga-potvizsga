package hu.nive.ujratervezes.zarovizsga.cleaning;

public class House implements Cleanable{

    private final String address;
    private final int area;

    public House(String address, int area) {
        this.address = address;
        this.area = area;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public int clean() {
        return area * 80;
    }
}
