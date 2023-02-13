public class OrderedList {

    private int [] data;

    private int manyItems;



    private final int DEFAULT_CAPACITY = 10;



    public OrderedList (){

        this.data = new int [DEFAULT_CAPACITY];

        this.manyItems = 0;

    }



    public OrderedList(int capacity){

        if (capacity < 1){

            throw new IllegalArgumentException("Capacity must be at least 1");

        }

        this.data = new int [capacity];

        this.manyItems = 0;

    }



    public void add(int val){
        data[manyItems] = val;
        manyItems++;
    }

    public int get (int index){
        if(index >= manyItems)
        throw new IndexOutOfBoundsException("Index "+ index + "is greater than " + manyItems + "-1");  
        if(index < 0)
        throw new IllegalArgumentException("Index must be positive");

        return data[index];
    }

    public int set(int index, int val){
        if(index >= manyItems)
        throw new IndexOutOfBoundsException("Index "+ index + "is greater than " + manyItems + "-1");
       
        if(index < 0)
        throw new IllegalArgumentException("Index must be positive");

        int temp = data[index];
        data[index] = val; 
        return temp;

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
    public int remove(int index, int val){
        if(index >= manyItems)
        throw new IndexOutOfBoundsException("Index "+ index + "is greater than " + manyItems + "-1");
       
        if(index < 0)
        throw new IllegalArgumentException("Index must be positive");

        int temp = data[index];
        for (int i = index; i <= manyItems; i--) {
            data[i] = data[i + 1];
            manyItems++;
        }
        return temp;
    }

}