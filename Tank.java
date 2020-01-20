package League;

public class Tank extends Champion {
  private boolean belowFifty = false;
  
  public Tank(String champName, String champType, String champTribe , String ability1, 
              String ability2, String ability3) throws Exception { // Creates tank champion object
    super(champName, champType, champTribe, ability1, ability2, ability3);
  } 
  
  //Getters
  public boolean getBelowFifty() {
    return belowFifty;
  }
  
  // Setters
  public void setBelowFifty(boolean belowFiftyState) {
    belowFifty = belowFiftyState;
  }
  
  // attack for tank
  public void attack (int abilityName, Champion champ, Champion enemy){
    if (belowFifty == true) {
      // do nothing, trait already activated
    }
    else if (champ.getHealth() < champ.getMaxHealth() / 2) { // If health is below 50%
      champ.setArmor(champ.getArmor() + 25);
      champ.setMagicRes(champ.getMagicRes() + 25);
      setBelowFifty(true);
    }
    abilities[abilityName - 1].attack(champ, enemy);
  }
}