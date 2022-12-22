package day1;

public class DieGame {
    
    public static void main(String[] args) {
        int num1Wins = 0;
    int num2Wins = 0;
    int ties = 0;
        Die die2 = new Die();
        Die die1 = new Die(6);
        for(int i = 0; i < 10000; i++){
            

            die1.roll();
            die2.roll();
            if(die1.getTopSide() > die2.getTopSide()){
                num1Wins++;
            } else if(die2.getTopSide() > die1.getTopSide()){
                num2Wins++;
            } else {
                ties++;
            }
        }
    System.out.println("num1Wins: " + num1Wins);
    System.out.println("num2Wins " + num2Wins);
    System.out.println("Ties: " + ties);
    }
}
