package assignments;

import java.util.Scanner;


public class Blackjack {

    static Scanner in = new Scanner(System.in);
    static final int MIN_BET = 5;
    static final int STARTING_WALLET = 500;
    private static final int WIN = 1;
    private static final int LOSE = -1;
    private static final int TIE = 0;
    private static final int NUM_SUITS = 4;
    private static final String HEARTS = "H";
    private static final String SPADES = "S";
    private static final String CLUBS = "C";
    private static final String DIAMONDS = "D";
    private static final int NUM_VALUES = 13;
    private static final String ACE = "A";
    private static final String JACK = "J";
    private static final String QUEEN = "Q";
    private static final String KING = "K";
    private static final int BLACK_JACK = 21;

    public static void main(String[] args) {

        int wallet = STARTING_WALLET;   
        boolean stillPlaying = true;

    while(stillPlaying){
        int bet = getBet(wallet);
        String playerHand = getCard() + " " + getCard();  
        String dealerHand = getCard();
        
        displayHand(playerHand, false, "Player: ");
        displayHand(dealerHand, true, "Dealer: ");

        int result = playHand(playerHand, dealerHand);

        if(result == WIN){
            wallet += bet;
            System.out.println("You Win!!");
            System.out.println("You have $" + wallet + " left");
        } else if(result == LOSE){
            wallet -= bet;
            System.out.println("You Lose :( ");
            System.out.println("You have $" + wallet + " left");
        } else{
            System.out.println("You Tied");
            System.out.println("You have $" + wallet + " left");
        } 
        if(wallet < MIN_BET){
        stillPlaying = false;
        System.out.println("You do not have enough $$ to play.");
        }else 
        stillPlaying = playAgain();
    }
    }

    private static boolean playAgain() {
        while(true){
            System.out.println("Play again? ([Y}es/[N]o): ");
            String result = in.nextLine().toLowerCase();
            if(result.equals("y")||result.equals("yes")){
                return true;
            } else if(result.equals("n")||result.equals("no")){
                return false;
            }
        }
    }

    //return WIN if player wins, LOST if the player lost, TIE if they tie
    private static int playHand(String playerHand, String dealerHand) {
        playerHand = playerTurn(playerHand);
        dealerHand = dealerTurn(dealerHand);

        int playerScore = getCardsValue(playerHand);
        int dealerScore = getCardsValue(dealerHand);
        if(playerScore <= BLACK_JACK && (playerScore>dealerScore)||playerScore <= BLACK_JACK && (dealerScore >= BLACK_JACK) ){
            return WIN;
        } else if((playerScore >BLACK_JACK)|| dealerScore >playerScore){
            return LOSE;
        } else 
        return TIE;
    }


    private static int getCardsValue(String cards) {
        int numAces = 0;
        int scoreBeforeAces = 0;

        for(int i = 0; i<cards.length(); i++){
            String s = cards.substring(i, i+1);
            if("JQK1".indexOf(s) >= 0){
                scoreBeforeAces += 10;
            } else if("23456789".indexOf(s) >= 0){
                scoreBeforeAces += Integer.parseInt(s);
            } else if("A".indexOf(s)==0){
                numAces++;
            }
        }
        if(numAces > 0 && (scoreBeforeAces + 11 + numAces - 1) < BLACK_JACK)
        scoreBeforeAces += (11 + numAces - 1);
        else
        scoreBeforeAces += numAces;
        return scoreBeforeAces;
    }

    private static String dealerTurn(String dealerHand) {
        dealerHand += " " + getCard();
        displayHand(dealerHand, false, "Dealer Hand: ");
        while(getCardsValue(dealerHand) < 17){
            dealerHand += " " + getCard();
            displayHand(dealerHand, false, "Dealer hand: ");
        }
        return dealerHand;
    }

    private static String playerTurn(String playerHand) {
        displayHand(playerHand, false, "Player Hand: ");
        while(true){
            if(takeCard()){
                playerHand += " " + getCard();
                displayHand(playerHand, false, "Player Hand: ");
                if(getCardsValue(playerHand) > BLACK_JACK){
                    return playerHand;
                }
            }else{
                return playerHand;
            }
        }
    }

    

    private static boolean takeCard() {
        while(true){
            System.out.println("Hit [1] or Stand [2]: ");
            String result = in.nextLine();
            if(result.equals("1")){
                return true;
            } else if(result.equals("2"))
            return false;
            else 
            System.out.println("Invalid input. ");
        }
    }

    private static void displayHand(String cards, boolean isHidden, String label) {
        String result = label;
        if(isHidden)
        result += "XX " + cards;
        else 
        result += cards;
        System.out.println(result);
    }


    private static String getCard() {
        return getValue() + getSuit();
    }


    private static String getSuit() {
        int iSuit = (int)(Math.random() * NUM_SUITS) +1;
        if(iSuit ==1)
        return HEARTS;
        else if(iSuit == 2)
        return SPADES;
        else if(iSuit == 3)
        return CLUBS;
        else 
        return DIAMONDS;
    }

    private static String getValue() {
        int iValue = (int)(Math.random() * NUM_VALUES) + 1;
        if(iValue == 1)
        return ACE;
        else if(iValue == 11)
        return JACK;
        else if(iValue == 12)
        return QUEEN;
        else if(iValue == 13)
        return KING;
        else 
            return "" + iValue;
    }

    private static int getBet(int maxBet) {
        boolean validBet = false;
        int bet = 0;
        System.out.print("Please enter bet (MIN : $"+MIN_BET +")");
        while(!validBet){
            try{
                bet = Integer.parseInt(in.nextLine());

                if(bet > maxBet)
                System.out.println("Please enter bet (MAX: $" + maxBet + ")");
                else if(bet < MIN_BET)
                System.out.println("Please enter bet(MIN: $" + MIN_BET + ")");
                else
                    validBet = true;
        } catch(NumberFormatException ex){
                System.out.println("Invalid Bet");
        }
    }
    return bet;
}
}