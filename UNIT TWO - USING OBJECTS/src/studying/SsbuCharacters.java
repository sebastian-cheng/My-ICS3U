package studying;

/**
 * SsbuCharacters
 */

public class SsbuCharacters {
    private String name; 
    private int Number; 
    private boolean isHeavy;
      public SsbuCharacters(String charName){
        name = charName;
      }
      public SsbuCharacters(String charName , boolean charIsHeavy){
        charName = name;
        isHeavy = charIsHeavy;
      }
      public SsbuCharacters(String charName , boolean charIsHeavy, int CharNumber){
        charName = name; 
        if(isHeavy){
            charIsHeavy = isHeavy;
        }
        CharNumber = Number;
      }
      public SsbuCharacters(boolean charIsHeavy){
        isHeavy = true;
      }
      public SsbuCharacters(int CharNumber){
        Number = CharNumber;
      }
    }
