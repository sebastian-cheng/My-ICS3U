package day5;

import java.util.Scanner;

public class PracticeEight {
    public static void main(String[] args) {
        System.out.print("Please type in a number:");
        Scanner in = new Scanner(System.in);
        double number = in.nextDouble();

        double numSq = number * number; 
        double numSqrt = Math.sqrt(number);

        System.out.println("The square of your number is " + numSq);
        System.out.println("The square root of your number is " + numSqrt);
        in.close();
    }
}
