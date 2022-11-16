package assignment;
import java.util.Scanner;
public class BayviewGlenPools {
    public static void main(String[] args) {

        Scanner pool = new Scanner(System.in);

        
        System.out.println("Please enter the length of the pool in meters : ");
        double length = pool.nextDouble();

        System.out.println("Please enter the width of the pool in meters : ");
        double width = pool.nextDouble();

        System.out.println("Please enter the depth of the shallow end of the pool in meters : ");
        double shallowDepth = pool.nextDouble();

        System.out.println("Please enter the depth of the deep end of the pool in meters: ");
        double deepDepth = pool.nextDouble();

        System.out.println("Please enter the transition length  between the shallow end and the deep end of the pool in meters: ");
        double transition = pool.nextDouble();

        System.out.println("Please enter the length of the shallow end in meters: ");
        double shallowLength = pool.nextDouble();

        System.out.println("Please enter the price of liner per meter squared in dollars: ");
        double linerPrice = pool.nextDouble();

    
        double transitionHeight = (deepDepth - shallowDepth);
        //pythagorean theorem 
        double transitionBase = Math.sqrt((Math.pow(transition , 2)) - (Math.pow(transitionHeight,2)));
        double belowTransitionArea= (transitionBase * transitionHeight) / 2;
        double deepLength = (length - shallowLength - transitionBase);
        

        //volume for water

        double depthDifference = deepDepth - shallowDepth;
       
        double volumeSubtract = (belowTransitionArea* width) + (((depthDifference * (shallowLength) * width)));
        double volume = (deepDepth * length * width) - volumeSubtract;
        double water = (volume * 1000) * 0.9; 
        System.out.println("The amount of water needed to keep the pool 90% full is: " + water + " liters.");

        //surface area for liner
        //deep end surface areas 
        double deepBackWallArea = deepDepth * width; 
        double deepBottomArea = deepLength * width; 
        double deepSideWallAreas = (deepDepth * deepLength) * 2;
        double deepSurfaceArea = deepBackWallArea + deepBottomArea + deepSideWallAreas;
       
        //transition surface areas

        double transitionArea = transition * width;
        double transitionWalls = ((transitionBase * deepDepth) - belowTransitionArea) * 2;
        double transitionSurfaceArea = transitionArea + transitionWalls;
        
        //shallow end surface area

        double shallowBackWallArea = shallowDepth * width;
        double shallowBottomArea = shallowLength * width;
        double shallowWalls = (shallowDepth * shallowLength) * 2;
        double shallowSurfaceArea = shallowBackWallArea + shallowBottomArea + shallowWalls;

        //full surface area 

        double fullSurfaceArea = deepSurfaceArea + transitionSurfaceArea + shallowSurfaceArea;
        System.out.println("The amount of liner needed is " + fullSurfaceArea + " meters.");

        //liner pricing

        double linerCost = linerPrice * fullSurfaceArea;
        double roundedLinerCost = Math.round(linerCost * 100) / 100.0;
        System.out.println("The cost for the liner is $" + roundedLinerCost);

        pool.close();
    }
}
