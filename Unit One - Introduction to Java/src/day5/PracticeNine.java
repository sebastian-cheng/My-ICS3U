package day5;

import java.util.Scanner;

public class PracticeNine {
    public static void main(String[] args) {
        System.out.print("Please type in a number:");
            Scanner in = new Scanner(System.in);
            double items = in.nextDouble();

            double paydue = items * 0.27; 

            System.out.println("If the Golden Sales Company sells " + items + "items, it will owe the salesperson $" + paydue);
            in.close();
    
    }
}
