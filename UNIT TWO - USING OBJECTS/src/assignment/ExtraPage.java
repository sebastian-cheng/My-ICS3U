package assignment;
import java.util.Scanner;
public class ExtraPage {
    public static void main(String[] args) {
        Scanner scanLength = new Scanner(System.in);
        Scanner scanWidth = new Scanner(System.in);
        Scanner scanShallowDepth = new Scanner(System.in);
        Scanner scanDeepDepth = new Scanner(System.in);
        Scanner scanTransition = new Scanner(System.in);
        Scanner scanShallowLength = new Scanner(System.in);
     
        
        System.out.println("Please enter the length of the pool in meters : ");
        System.out.println("Please enter the width of the pool in meters : ");
        System.out.println("Please enter the depth of the shallow end of the pool in meters : ");
        System.out.println("Please enter the depth of the deep end of the pool in meters: ");
        System.out.println("Please enter the transition length  between the shallow end and the deep end of the pool in meters: ");
        System.out.println("Please enter the length of the shallow end in meters: ");
        

        int length = scanLength.nextInt(); 
        int width = scanWidth.nextInt();
        int shallowDepth = scanShallowDepth.nextInt();
        int deepDepth = scanDeepDepth.nextInt();
        int transition = scanTransition.nextInt();
        int shallowLength = scanShallowLength.nextInt();
     

        double depthDifference = deepDepth - shallowDepth;
        
        double transitionSquared = Math.pow(transition, 2);
        System.out.println("transition is" + transition);
        System.out.println("transition squared is" + transitionSquared);
        double depthDifferenceSquared = Math.pow(depthDifference, 2);
        System.out.println("depth diff is" + depthDifference);
        System.out.println("depth diff squared is " + depthDifferenceSquared);
        double belowTransition = Math.sqrt(transitionSquared - depthDifferenceSquared);
        System.out.println("transition - depth difference is " + (transitionSquared - depthDifferenceSquared));
        double belowTransitionArea = (belowTransition * depthDifference) / 2;
        System.out.println("below transition area is " + belowTransitionArea);
        double volumeSubtract = (belowTransitionArea * width) + (((depthDifference * shallowLength * width)));
        System.out.println("the triangle area * width is" + (belowTransitionArea * width));
        System.out.println("the depth diff * length of shallow end * width is" + (depthDifference * shallowLength * width));
        System.out.println(volumeSubtract);
        double volume = (deepDepth * length * width) - volumeSubtract;
        System.out.println("the volume before subtracting is " + (deepDepth * length * width));
        System.out.println("the volume w subtraction is " + volume);
        double water = (volume * 1000) * 0.9; 
        System.out.println("The amount of water needed to keep the pool 90% full is: " + water + " liters.");

        
      
        System.out.println(belowTransition);
    }
}
