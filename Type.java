import java.util.*;

public class Type extends Ability {
  private String RANGER = "Ranger";
  private String MAGE = "Mage";
  private String TANK = "Tank";
  
  protected boolean autoTwice = false; // Ranger effect, allows for two autos in succession
  protected boolean castTwice = false; // Mage effect, allows for doublecasting of spells
  protected boolean belowFifty = false; // Tank effect, allows for extra resistances when below 50% health
  
  // Type constructor, accounts for all 3 types of champions
  public Type (String abilityName, boolean twoAutos, boolean doubleCast, boolean fifty) {
    super(abilityName);
    autoTwice = twoAutos;
    castTwice = doubleCast;
    belowFifty = fifty;
  }
  
  // Calculates what effect will be returned
  public boolean typeEffect(Champion champion, Ability ability, boolean autoTwice, boolean castTwice, boolean belowFifty) {
    Random randomGen = new Random();
    int randomNum = randomGen.nextInt(100); // Generates num between 0 and 99
    
    if (champion.getTribe() == RANGER) { // If ranger, run this part
      if (ability.getName() == "Auto") { // Only for ranger autos           
        if (randomNum <= 0 && randomNum >= 29) { // If num is between 0 and 29, return true
          return autoTwice = true;
        }
        else {
          return autoTwice = false;
        }
      }
    }
    
    if (champion.getTribe() == MAGE) { // If mage, run this part
      if (ability.getName() != "Auto") { // If ability is not an auto attack
        if (randomNum <= 0 && randomNum >= 29) { // If num is between 0 and 29, return true
          return castTwice = true;
        }
        else {
          return castTwice = false;
        }
      }
    }
    
    if (champion.getTribe() == TANK) { // If tank
      if (champion.getHealth() < champion.getHealth() / 2) { // If health is below 50%
        return belowFifty = true;
      }
      else {
        return belowFifty = false;
      }
    }
    
    return true;
  }
  
  public void setAutoTwice(boolean autoTwiceState) {
    autoTwice = autoTwiceState;
  }
  
  public void setCastTwice(boolean castTwiceState) {
    castTwice = castTwiceState;
  }
  
  public void setBelowFifty(boolean belowFiftyState) {
    belowFifty = belowFiftyState;
  }
}