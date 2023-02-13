public class UnorderedList {
    private int [] data;

    private int manyItems;



    private final int DEFAULT_CAPACITY = 10;
    



    public UnorderedList (){

        this.data = new int [DEFAULT_CAPACITY];

        this.manyItems = 0;

    }



    public UnorderedList(int capacity){

        if (capacity < 1){

            throw new IllegalArgumentException("Capacity must be at least 1");

        }
        
        this.data = new int [capacity];

        this.manyItems = 0;

    }
    private void updateCapacity(int newCapacity){
        int[] temp  = new int[newCapacity];
        for (int i = 0; i < data.length; i++) {
            temp[i] = data[i];
            
        }
        data = temp;
    }
    public void add(int index, int val){
        if(index >= manyItems)
        throw new IndexOutOfBoundsException("Index "+ index + "is greater than " + manyItems + "-1");
       
        if(index < 0)
        throw new IllegalArgumentException("Index must be positive");

        for (int i = manyItems; i > index; i--) {
            data[i] = data[i-1];
                 
            data[index] = val; 
            manyItems++;
        }
    }

    public void remove(int val){
        for (int i = 0; i < manyItems; i++) {
            if(data[i] == val){
                data[i] = data[manyItems - 1];
                manyItems--;
                return;
            }
            
        }
    }
    
}
