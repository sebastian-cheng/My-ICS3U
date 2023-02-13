import java.util.Arrays;

/**
 * SortingAlgorithms
 */
public class SortingAlgorithms {

    public static void main(String[] args) {
        int[] arr1 = {43,2,432,46,235,32452,35,352};
        int[] arr2 = {43,2,4321,46,235,32452,35,352};
        selectionSort(arr1);
        selectionSort(arr2);
        //     insertionSort(arr);
        // display(arr);
        
        Arrays.sort(arr1);
        Arrays.sort(arr2); 
        display(arr1);
        System.out.println("");
        display(arr2);
        int[] sortedArray = merge(arr1, arr2);

    }
    private static int[] merge(int[] arr1, int[] arr2) {
        int[] temp = new int[arr1.length + arr2.length];
        int i = 0; 
        int j = 0; 

        while(i < arr1.length && j<arr2.length){
            if(arr1[i] < arr2[j]){
                temp[i+j] = arr1[i];
                i++;
            } else{
                temp[i+j] = arr2[j]; 
                j++;
            }

        }
        if( i!= arr1.length){
            for (; i < temp.length; i++) {
                temp[i + j] = arr2[i];
            }
        }else{ 
            for (; j< temp.length; j++) {
                temp[i+j] = arr2[j];
            }
        }
        return temp;
    }
    private static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int val = arr[i]; 
            int j;
            for(j = i - 1; j >= 0 && val < arr[j]; j--){
                arr[j+1] = arr[j];
            }
            arr[j+1] = val;
        }
    }
    private static void display(int[] arr){
        for(int el : arr){
        System.out.print(el + " ");  
        }
    }
    private static void selectionSort(int[] arr){
        for (int i = 0; i < arr.length-1; i++){
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++){
                if (arr[minIndex] > arr[j])
                 minIndex = j;
                 }
                 int temp = arr[i];
                 arr[i] = arr[minIndex];
                 arr[minIndex] = temp;
    }
}
}