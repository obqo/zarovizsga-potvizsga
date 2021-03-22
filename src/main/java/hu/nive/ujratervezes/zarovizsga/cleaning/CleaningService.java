package hu.nive.ujratervezes.zarovizsga.cleaning;

import java.util.ArrayList;
import java.util.List;

public class CleaningService {

    private List<Cleanable> cleanables = new ArrayList<>();

    public List<Cleanable> getCleanables() {
        return cleanables;
    }

    public void add(Cleanable cleanable) {
        cleanables.add(cleanable);
    }

    public int cleanAll() {
        int result = 0;
        for (Cleanable item : cleanables) {
            result += item.clean();
        }
        cleanables = new ArrayList<>();
        return result;
    }

    public int cleanOnlyOffices() {
        int result = 0;
        List<Cleanable> remains = new ArrayList<>();
        for (Cleanable item : cleanables) {
            if (item instanceof Office) {
                result += item.clean();
            } else {
                remains.add(item);
            }
        }
        cleanables = remains;
        return result;
    }

    public List<Cleanable> findByAddressPart(String address) {
        List<Cleanable> result = new ArrayList<>();
        for (Cleanable item : cleanables) {
            if (item.getAddress().contains(address)) {
                result.add(item);
            }
        }
        return result;
    }

    public String getAddresses() {
        StringBuilder sb = new StringBuilder();
        for (Cleanable item : cleanables) {
            sb.append(item.getAddress()).append(", ");
        }
        return sb.substring(0, sb.toString().length() - 2);
    }
}
