package day5;

import java.util.Scanner;

public class PracticeTen {
    public static void main(String[] args) {
        System.out.print("Please enter a length and a width: ");
        Scanner in = new Scanner(System.in);
        double length = in.nextDouble();
        double width = in.nextDouble();

        double perimeter = (length * 2) + (width * 2);
        double area = length * width; 
       
        System.out.println("The perimeter of a rectangle with a length of 4.5 feet and a width of 2.3 feet is " + perimeter + " units");
        System.out.println("The area of a rectangle with a length of 4.5 feet and a width of 2.3 feet is " + area + " units");
        
    
        in.close();
    }
}
