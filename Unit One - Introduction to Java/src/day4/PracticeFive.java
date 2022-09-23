package day4;

public class PracticeFive {
    public static void main(String[] args) {
        int pennies = 4; 
        int nickels = 3; 
        int dimes = 10;
        int quarters = 3;
        int loonies = 6;
        int toonies = 5; 
        double money  = (pennies * 0.01) + (nickels * 0.05) + (dimes * 0.10) + (quarters * 0.25) + (loonies * 1) + (toonies * 2);
        System.out.println(money);

    }
}
