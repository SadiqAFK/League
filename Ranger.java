package League;

import java.util.Random;

public class Ranger extends Champion {
  private boolean doubleAuto = false; // Decides if ranger will auto twice or not
  
  public Ranger(String champName, String champType, String champTribe , String ability1, 
                String ability2, String ability3) throws Exception { // Ranger object
    super(champName, champType, champTribe, ability1, ability2, ability3);
  } 
  
  // Getters
  public boolean getDoubleAuto() { 
    return doubleAuto;
  }
  
  // Setters
  public void setDoubleAuto(boolean doubleAutoState) {
    doubleAuto = doubleAutoState;
  }
  
  // Applies ranger trait
  public void rangerTrait(Ability ability) {
    Random randomGen = new Random();
    int randomNum = randomGen.nextInt(100); // Generates num between 0 and 99
    
    if (ability.getName() == "Auto") { // Only for ranger autos           
      if (randomNum <= 0 && randomNum >= 29) { // If num is between 0 and 29, return true (30% to auto twice)
        doubleAuto = true;
      }
      else {
        doubleAuto = false;
      }
    }
  }
  
  // attack for ranger
  public void attack (int abilityName, Champion champ, Champion enemy){
    rangerTrait(abilities[abilityName - 1]);
    if (doubleAuto = true) {
      abilities[abilityName - 1].attack(champ, enemy);
      abilities[abilityName - 1].attack(champ, enemy);
      doubleAuto = false; // resets double auto
    }
    else {
      abilities[abilityName - 1].attack(champ, enemy);
    }
  }
  
}