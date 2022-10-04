package src.day1;

/**
 * ExamplecompareTo
 */
public class ExamplecompareTo {

    public static void main(String[] args) {
        String s1 = new String("Happy");
        String s2 = new String("Happy");
        String s3 = "Happy";
        String s4 = "Happy";
        //two equal signs for equality 
        //one for assignment
        System.out.println(s1==s2); //false bc different addresses 
        
        System.out.println(s1.equals(s2)); //true bc same sequence of characters 
       // s3 == s4 because string literals are not reused
        System.out.println();
    }
}