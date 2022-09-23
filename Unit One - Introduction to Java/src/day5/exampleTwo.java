package day5;

import java.util.Scanner;

/**
 * exampleTwo
 */
public class exampleTwo {
    public static void main(String[] args) {
        System.out.print("Please enter a decimal number: ");
        Scanner in = new Scanner(System.in);
        double number  = in.nextDouble();
    
        number  = Math.round(number*100)/100.0;
        System.out.println(number);


        System.out.print("Please enter an integer number: ");

        int iNumber = in.nextInt();
        iNumber = (int) Math.round(iNumber / 100.0) * 100;
        System.out.println(iNumber);

        in.close();
    }
}
