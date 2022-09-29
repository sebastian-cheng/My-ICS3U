package day5;

public class PracticeFour {
    public static void main(String[] args) {
        double minute = (3 * Math.pow(10,8));
        double hours = minute * 60;
        double days = hours * 24;
        double year = days * 365;

        System.out.println(minute);
        System.out.println(year);

    }
}
