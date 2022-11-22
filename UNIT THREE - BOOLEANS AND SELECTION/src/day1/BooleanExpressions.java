package day1;

public class BooleanExpressions {
    public static void main(String[] args) {
        //mathematical expression evaluate to a number 
        // logical and boolean expressions ecaluate to TRUE or FALSE 

        boolean exp1 = 17 > 5;
        boolean exp2 = 17 == 17;
        boolean isRed = true;
        boolean isHard = false;

        boolean exp3 = isHard == isRed; // false 

        int x = 7;
        boolean exp4 = (x < 3) != (x > 5); //true bc false is not equal to true 

        int y = 3;
        boolean exp5 = (x < y) == (y > 7); //true bc false = false so its true 

    }
}
