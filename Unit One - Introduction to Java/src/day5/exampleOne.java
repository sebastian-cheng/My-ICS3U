package day5;

import java.util.Scanner;

public class exampleOne {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
    
        System.out.print("PLease enter the radius : ");
        double radius  = in.nextDouble();

        double area = Math.PI * radius * radius;

        System.out.println("The are of the circle with radius " + radius + " of " + area);

        in.close();

    }
    
}
