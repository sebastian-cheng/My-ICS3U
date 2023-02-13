import java.util.Arrays;

public class SearchingAlgorithms {
    public static void main(String[] args) {
        //int[] arr = {43,2,432,46,235,32452,35,352};

        // int findMe = 2; 
        // int index = sequentialSearch(arr, findMe);
        // System.out.println(index);
        // Arrays.sort(arr);
        // display(arr);
        // findMe = 32452;
        // index = binarySearch(arr, findMe);
        // System.out.println(index);
        for (int i = 0; i < 8; i++) {
            int[] arr = new int[(int)Math.pow(10, i)];
            int findMe = -1;
            binarySearch(arr, findMe);
        }
    }
    private static int binarySearch(int[] arr, int findMe) {
        
        int min = 0, max = arr.length-1;
        int mid; 
        int counter = 0;
        while(min < max){
            counter++;
            mid = (min + max / 2);
            if(arr[mid] == findMe)
            return mid; 
            else if(arr[mid] < findMe)
            min = mid+1; 
            else 
            max = mid -1;
        }
        System.out.println(arr.length + ": " + counter);
        return -1;
    }
    private static int sequentialSearch(int[] arr, int findMe) {
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == findMe)
            return i;
        }
        return -1;
    }
    
    private static void display(int[] arr){
        for(int el : arr){
        System.out.print(el + " ");  
        }
        System.out.println("");
    }
    
}
