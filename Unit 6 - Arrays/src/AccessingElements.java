/**
 * AccessingElements
 */
public class AccessingElements {

    public static void main(String[] args) {
        declaringArrays();
        int[] arr = {5,7,1,3,4,6};
        accessingArrays(arr);
    }

    private static void accessingArrays(int[] arr) {
        System.out.println(arr[0]);
        System.out.println(arr[3]);
        System.out.println(arr[arr.length-1]);
        System.out.println(arr[arr.length / 2]);
        
    }

    private static void declaringArrays() {
        //declare an int array called arr
        //initialises it with a series of ints 
        int[] arr = {6, 4, 3, 6, 2, 5, 6, 7, 4, 3, 6};
        
        //declare double array called nums 
        // initialise it to a double array of length 10
        double[] nums = new double[10];

        //having nums refer to a different double array
        nums = new double[6];
        System.out.println(arr);
        System.out.println(nums);
        
    }
}