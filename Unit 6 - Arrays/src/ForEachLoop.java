public class ForEachLoop {
    //ethan???
    public static void main(String[] args) {
        String[] feelings = {"Happy", "Sad", "Angry", "Blah", "Excited", "Sleepy"};
        
        // for each loop - meant to iterate through the whole collection 
        // cannot change the size of the collection - not a big deal for arrays 
        // no access to the index, must iterate starting at index 0 and goes until length-1
        for (String mood : feelings) {
            System.out.println(mood);
            
        }
    }
}
