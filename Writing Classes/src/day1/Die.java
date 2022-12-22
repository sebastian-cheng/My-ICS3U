package day1;

public class Die {
    private int numSides; 
    private int topSide; 

    public int getTopSide() {
        return topSide;
    }
    public String toString(){
        return "The top side is: " + this.topSide;
    }

    public Die(int numSides){
        this.numSides = numSides;

        roll();
    }

    public Die(){
        numSides = 6; 
        roll();
    }
    //sets top side to be a number between 1 and numSides 
    public void roll() {
        topSide = (int) (Math.random() * numSides) + 1;
    }
}
