package assignments;
import java.util.Scanner;



public class GoFish {
   static Scanner in = new Scanner(System.in);
   private static final int NUM_VALUES = 13;
   private static final int NUM_SUITS = 4;
   private static final int MAX_SCORE = 10;
   public static int PLAYER1_SCORE = 0;
   public static int PLAYER2_SCORE = 0;
   public static int PLAYER3_SCORE = 0;
   public static int PLAYER4_SCORE = 0;
   private static final String ACCEPTABLE_CARDS = "234568910JQKA";
   private static final String PLAYER_NAMES = "COMP1 COMP2 COMP3";
   private static final int RESET_CARDS = -2;
   private static String playerHand = "";
   private static String compOneHand = "";
   private static String compTwoHand = "";
   private static String compThreeHand = "";

    public static void main(String[] args) {
      boolean stillPlaying = true;
      
        System.out.println("Rules: the game will automatically remove matches of cards, try to get rid of all of them by asking a computer for a card, if they have it they will give it to you, otherwise you will draw a new card. Get rid of all your cards!");
        playerHand += getCard() + getCard() + getCard() + getCard() + getCard();
        compOneHand += getCard() + getCard() + getCard() + getCard() + getCard();
        compTwoHand += getCard() + getCard() + getCard() + getCard() + getCard();
        compThreeHand = getCard() + getCard() + getCard() + getCard() + getCard();
    
        displayHand(playerHand, false, "You: ", PLAYER1_SCORE);
        displayHand(compOneHand, false, "Computer 1: ", PLAYER2_SCORE);
        displayHand(compTwoHand, false, "Computer 2: ", PLAYER3_SCORE);
        displayHand(compThreeHand, false, "Computer 3: ", PLAYER4_SCORE);

        
        
        playerHand = ridCards(playerHand, 1);
        compOneHand = ridCards(compOneHand, 2);
        System.out.println(compOneHand);
        compTwoHand = ridCards(compTwoHand, 3);
        compThreeHand = ridCards(compThreeHand, 4);
        
      while(stillPlaying){
         displayHand(playerHand, false, "Your hand", PLAYER1_SCORE);
         displayHand(compOneHand, true, "Computer 1's hand: ", PLAYER2_SCORE);
         displayHand(compTwoHand,true, "Computer 2's hand: ", PLAYER3_SCORE);
         displayHand(compThreeHand, true, "Computer 3's hand: ", PLAYER4_SCORE);
   
         playGame(playerHand, compOneHand, compTwoHand, compThreeHand, 1);
         playGame(playerHand, compOneHand, compTwoHand, compThreeHand, 2);
         playGame(playerHand, compOneHand, compTwoHand, compThreeHand, 3);
         playGame(playerHand, compOneHand, compTwoHand, compThreeHand, 4);

         checkLength(playerHand);
         checkLength(compOneHand);
         checkLength(compTwoHand);
         checkLength(compThreeHand);
         
         if(PLAYER1_SCORE >= MAX_SCORE)
         System.out.println("YOU WIN!!!!");
      else if(PLAYER2_SCORE >= MAX_SCORE)
         System.out.println("COMPUTER 1 WINS");
      else if(PLAYER3_SCORE >= MAX_SCORE)
         System.out.println("COMPUTER 2 WINS");
      else if(PLAYER4_SCORE >= MAX_SCORE)
         System.out.println("COMPUTER 3 WINS");
      stillPlaying = playAgain();
        }
      
         
   }
//checks if the player wants to play again and if they do it sets stillPlaying to true
private static boolean playAgain() {
   while (true) {
      System.out.print("Play Again ([Y]es/[N]o): ");
      String result = in.nextLine().toLowerCase();
      if (result.equals("y") || result.equals("yes"))
         return true;
      else if (result.equals("n") || result.equals("no"))
         return false;
   }
}
//checks if the hand has 0 cards and if it does it deals the hand 5 cards
private static String checkLength(String hand) {
   if(hand.length() < 2)
      hand = getCard() + getCard() + getCard() + getCard() + getCard();
   
   return hand;
   }

private static void playGame(String playerHand, String compOneHand, String compTwoHand,String compThreeHand, int player) {
   String playerVictim = "";
   String comp1Victim = "";
   String comp2Victim = "";
   String comp3Victim = "";
   String playerVictimHand = "";
   String comp1VictimHand =  "";
   String comp2VictimHand = "";
   String comp3VictimHand = "";
      if(player == 1){
         //gets the victim
         playerVictim += getVictim(playerHand, compOneHand, compTwoHand, compThreeHand, 1);
            //sets the hand of the victim to be the victims hand
             if(playerVictim.equals("COMP1"))
               playerVictimHand += compOneHand;
            else if(playerVictim.equals("COMP2"))
               playerVictimHand += compTwoHand;
             else if(playerVictim.equals("COMP3"))
               playerVictimHand += compThreeHand;
         //adds the suit to the requested card
         String playerRequestedCard = playerRequestedCard() + getSuit();
         //adds the requested card to the player's hand
         playerHand += takeCard(playerHand, playerVictimHand, playerRequestedCard);
         //removes the pair of cards that the player just made
         playerHand = ridCards(playerHand, 1);
      } else if(player == 2){
           //gets the victim
         comp1Victim += getVictim(playerHand, compOneHand, compTwoHand, compThreeHand, 2);
               //sets the hand of the victim to be the victims hand
            if(comp1Victim.equals("PLAYER"))
               comp1VictimHand += playerHand;
            else if(comp1Victim.equals("COMP2"))
               comp1VictimHand += compTwoHand;
            else if(comp1Victim.equals("COMP3"))
               comp1VictimHand += compThreeHand;
         //adds the suit to the requested card
         String compOneRequestedCard = compRequestedCard(1) + getSuit();
          //adds the requested card to the player's hand
         compOneHand += takeCard(compOneHand, comp1VictimHand, compOneRequestedCard);
         //removes the pair of cards that the player just made
         compOneHand = ridCards(compOneHand, 2);
      }else if(player == 3){
          //gets the victim
         comp2Victim += getVictim(playerHand, compOneHand, compTwoHand, compThreeHand, 3);
               //sets the hand of the victim to be the victims hand
            if(comp2Victim.equals("PLAYER"))
               comp2VictimHand += playerHand;
            else if(comp2Victim.equals("COMP1"))
               comp2VictimHand += compOneHand;
            else if(comp2Victim.equals("COMP3"))
               comp2VictimHand += compThreeHand;
         //adds the suit to the requested card
         String compTwoRequestedCard = compRequestedCard(2) + getSuit();
         //adds the requested card to the player's hand
         compTwoHand += takeCard(compTwoHand, comp2VictimHand, compTwoRequestedCard);
         //removes the pair of cards that the player just made
         compTwoHand = ridCards(compTwoHand, 3);
         } else if(player == 4){
             //gets the victim
            comp3Victim += getVictim(playerHand, compOneHand, compTwoHand, compThreeHand, 4);
                  //sets the hand of the victim to be the victims hand
               if(comp3Victim.equals("PLAYER"))
                  comp3VictimHand += comp3Victim;
               else if(comp3Victim.equals("COMP1"))
                  comp3VictimHand += compOneHand;
               else if(comp3Victim.equals("COMP2"))
                  comp3VictimHand += compTwoHand;
            //adds the suit to the requested card
            String compThreeRequestedCard = compRequestedCard(3) + getSuit();
            //adds the requested card to the player's hand
            compThreeHand += takeCard(compThreeHand, comp3VictimHand, compThreeRequestedCard);
            //removes the pair of cards that the player just made
            compThreeHand = ridCards(compThreeHand, 4);
         }  
}

private static String takeCard(String hand, String victimHand, String requestedCard) {
   //changes the 10's to t's for simplicity
   victimHand = changeTens(victimHand);
   //if the card is in the victim's hand it will add the requested card 
   if(victimHand.indexOf(requestedCard) >= 0){
      for(int i = 0; i < victimHand.length(); i+=2){
         if(victimHand.indexOf(requestedCard) >= 0){
            hand += requestedCard;
         }
      }
   }
   return hand;
}

private static String compRequestedCard(int computer) {
   String hand = "";
        if(computer == 1)
            hand = compOneHand;
        if(computer == 2)
            hand = compTwoHand;
        if(computer == 3)
            hand = compThreeHand;

        int random = (int) (Math.random() * hand.length());
        //makes sure random is always on an even number, which is where the card values are
        if(random % 2 != 0)
            random--;

        return hand.charAt(random) + "";
}
//you need to input it twice and I don't know why but it works after the first one
private static int playerRequestedCard() {
   while(true){
      System.out.println("What card do you want?");
      String card = in.nextLine().toUpperCase();

      //checks if the card is valid
      if("12345678910JQKA".indexOf(card)>=0)
          return Integer.parseInt(card);
      //redoes the method if the requested card is not valid
      else if(playerHand.indexOf(card)<0){
          if("123456789AKJQ".indexOf(card)<0)
              System.out.println("Invalid Response, please say what card you want (2-10, AQJK)");
      }
   }
}

      private static String getVictim(String playerHand, String compOneHand, String compTwoHand, String compThreeHand, int player) {
         if(player == 1){
            while(true){
            System.out.println("Who would you like to take from? (Please type comp1, comp2 or comp3): ");
            String victim = in.nextLine().toUpperCase();
            if(victim.equals("COMP1") || victim.equals("COMP2") || victim.equals("COMP3"))
                return victim;
            else 
                System.out.println("Invalid input!");
                
            }
        } else if(player == 2){
            String victim = "";
            int decision = (int) (Math.random() * 3) + 1;
            if(decision == 1)
               victim += "PLAYER";
            else if(decision == 2)
               victim += "COMP2";
            else if(decision == 3)
               victim += "COMP3";
        return victim;

      } else if(player == 3){
        String victim = "";
        int decision = (int) (Math.random() * 3) + 1;
        if(decision == 1)
            victim += "PLAYER";
        else if(decision == 2)
            victim += "COMP1";
        else if(decision == 3)
            victim += "COMP3";
      } else if(player == 4){
        String victim = "";
        int decision = (int) (Math.random() * 3) + 1;
        if(decision == 1)
            victim += "PLAYER";
        else if(decision == 2)
            victim += "COMP1";
        else if(decision == 3)
            victim += "COMP3";
        return victim;
      }
      return null;
      }

      private static String ridCards(String hand, int player){
         hand = changeTens(hand);
         int count = 0;
        for (int i = 0; i < hand.length() - 1   ; i+=2) {
            String c = hand.charAt(i) + "";
            String temp = hand.substring(hand.indexOf(c) + 2); // string without current card and everything before it
            if(temp.contains(c)) {
                count++;
                hand = hand.substring(0, i) + temp.substring(0, temp.indexOf(c)) + temp.substring(temp.indexOf(c) + 2);
                i = RESET_CARDS; // resets the loop to make i = 0 again
            }
        } 
        hand = hand.replace("t" , "10");
        if(player == 1) {
            PLAYER1_SCORE += count;
            return hand;
        } else if(player == 2) {
             PLAYER2_SCORE += count;
            return hand;
        } else if(player == 3) {
            PLAYER3_SCORE += count;
            return hand;
        } else if(player == 4) {
            PLAYER4_SCORE += count;
            return hand;
        }
        return hand;
      }
     


   private static String changeTens(String hand) {
      String newHand = "";
      for(int i = 0; i < hand.length() - 1; i += 2){
         if(hand.substring(i, i + 1).equals("1"))
         newHand = hand.replace("10", "t");
      }
      return newHand;
      }

   private static void displayHand(String cards, boolean isHidden, String label, int score) {
        String result = label + "(" + score + "): ";
        if(isHidden){
            for(int i = 0; i < cards.length() / 3; i++){
            result += "XX ";
            }
        } else {
               result += cards;
            }
        
        System.out.println(result);
    }

    private static String getCard() {
        return getValue() + getSuit();
    }

    private static String getSuit() {
        int iSuit = (int) (Math.random() * NUM_SUITS) + 1;
      if (iSuit == 1)
         return "H";
      else if (iSuit == 2)
         return "S";
      else if (iSuit == 3)
         return "C";
      else
         return "D";

    }

    private static String getValue() {
        int iValue = (int) (Math.random() * NUM_VALUES) + 1;
      if (iValue == 1)
         return "A";
      else if (iValue == 11)
         return "J";
      else if (iValue == 12)
         return "Q";
      else if (iValue == 13)
         return "K";
      else
         return "" + iValue;

    }
}