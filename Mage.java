package League;

import java.util.*;

public class Mage extends Champion {
  private boolean doubleCast = false;
  
  public Mage(String champName, String champType, String champTribe , String ability1, 
              String ability2, String ability3) throws Exception { // Creates mage object
    super(champName, champType, champTribe, ability1, ability2, ability3);
  }
  
  // Getters
  public boolean getDoubleCast() {
    return doubleCast;
  }
  
  // Setters
  public void setDoubleCast(boolean doubleCastState) {
    doubleCast = doubleCastState;
  }
  
  public void mageTrait(Ability ability) { // Applies mage trait
    Random randomGen = new Random();
    int randomNum = randomGen.nextInt(100); // Generates num between 0 and 99
    
    if (ability.getName() != "Auto") { // If ability is not an auto attack
      if (randomNum <= 0 && randomNum >= 29) { // If num is between 0 and 29, return true (30% to cast twice)
        doubleCast = true;
      }
      else {
        doubleCast = false;
      }
    }
  }
  
  // attack for mage
  public void attack (int abilityName, Champion champ, Champion enemy){
    mageTrait(abilities[abilityName - 1]);
    if (doubleCast = true) {
      abilities[abilityName - 1].attack(champ, enemy);
      abilities[abilityName - 1].attack(champ, enemy);
      doubleCast = false; // resets double cast
    }
    else {
      abilities[abilityName - 1].attack(champ, enemy);
    }
  }
}