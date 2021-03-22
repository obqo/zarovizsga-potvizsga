package hu.nive.ujratervezes.zarovizsga.words;

public class Words {

    public boolean hasMoreDigits(String s) {
        int digits = 0;
        for (char item : s.toCharArray()) {
            if (Character.isDigit(item)) {
                digits++;
            }
        }
        return digits > s.length() / 2;
    }
}
