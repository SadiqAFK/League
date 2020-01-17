package League;

import java.util.*;

class Tribe {
  private String FRELJORD = "Freljord";
  private String ZAUN = "Zaun";
  private String IONIA = "Ionia";
  private String PILTOVER = "Piltover";
  private String DEMACIA = "Demacia";
  private String NOXUS = "Noxus";
 
  private static int killCounter; // Kill counter
  
  private boolean freeze; // Freljord
  private boolean poison; // Zaun
  
  // Applies the noxian trait
  public double noxusTrait(Champion champion, Champion enemyChamp) {
    double damageAmp = 0; // Damage amplification based off kills
    
    return damageAmp;
  }
  
  // Applies the ionian effect
  public double ionianTrait(Champion champion, Ability ability) {
    
    double lifesteal = 0; // Heals ionians for 10% of the damage they deal
    champion.setHealth(champion.getHealth() - 100); // Decreases the total health of ionians by 100
    
    lifesteal = (ability.getBaseAttack() + ability.getBaseMagic() * 0.1);
    
    return lifesteal;
  }
  
  // Applies freljord and zaun traits
  public boolean applyTrait(Champion champion, Ability ability) {
    
    Random randomGen = new Random(); // Random generator
    int randomNum = randomGen.nextInt(100); // Random num between 0 and 99
    if (champion.getTribe() == "Freljord") { // If freljord, any ability has the chance to freeze the target
      if (randomNum <= 0 && randomNum >= 10) { // 10% to freeze
        return freeze = true;
      }
    }
    
    if (champion.getTribe() == "Zaun") { // If zaun, any ability has the chance to poison the target
      if (randomNum <= 0 && randomNum >= 39) { // 40% to freeze
        return poison = true;
      }
    }
    return false; // Default case
  }
}
