package day5;

public class PracticeFive {
    public static void main(String[] args) {
        double won = 110.0;
        double loss = 44.0;
        double all = won + loss;
        double percentage = (won /  all) * 100; 
        System.out.println(all);
        System.out.println(percentage);

        double roundedpercent = Math.round(percentage * 100) / 100.00;
        System.out.println(roundedpercent);
    }
}
