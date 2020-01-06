// Creators: Sadiq Hussain, Nathan Chung
// This is the champion class used to define the traits of a champion

import java.util.*;

public class Champion {
  // Initialize protected int fields (stats):
  protected static String name;
  protected static String tribe;
  protected int health;
  protected int atkSpd;
  protected int atkDmg;
  protected int armor;
  protected int crit;
  protected int magicDmg;
  protected int magicRes;
  protected int mana;
  protected int manaReg;
  protected int moveSpd;
  protected int tenacity;
  
  // Initialize private booleans (effects):
  private boolean stunned = false;
  private boolean poisoned = false;
  
  public Champion(String champName, String champTribe) {
    name = champName;
    tribe = champTribe;
  } 
  
  public int getHealth() {
    return health;
  }
  
  public int getAtkSpd() {
    return atkSpd;
  }
  
  public int getAtkDmg() {
    return atkDmg;
  }
  
  public int getArmor() {
    return armor;
  }
  
  public int getCrit() {
    return crit;
  }
  
  public int getMagicDmg() {
    return magicDmg;
  }
  
  public int getMagicRes() {
    return magicRes;
  }
  
  public int getMana() {
    return mana;
  }
  
  public int getManaReg() {
    return manaReg;
  }
  
  public int getMoveSpd() {
    return moveSpd;
  }
  
  public int getTenacity() {
    return tenacity;
  }
  
  public String getTribe() {
    return tribe;
  }

  public void setHealth(int newHealth) {
    health = newHealth;
  }
  
  public void setAtkSpd(int newAtkSpd) {
    atkSpd = newAtkSpd;
  }
  
  public void setAtkDmg(int newAtkDmg) {
    atkDmg = newAtkDmg;
  }
  
  public void setArmor(int newArmor) {
    armor = newArmor;
  }
  
  public void setCrit(int newCrit) {
    crit = newCrit;
  }
  
  public void setMagicDmg(int newMagicDmg) {
    magicDmg = newMagicDmg;
  }
  
  public void setMagicRes(int newMagicRes) {
    magicRes = newMagicRes;
  }
  
  public void setMana(int newMana) {
    mana = newMana;
  }
  
  public void setManaReg(int newManaReg) {
    manaReg = newManaReg;
  }
  
  public void setMoveSpd(int newMoveSpd) {
    moveSpd = newMoveSpd;
  }
  
  public void setTenacity(int newTenacity) {
    tenacity = newTenacity;
  }
  
  public boolean isStunned(boolean stunned) {
    return stunned;
  }
  
  public boolean isPoisoned(boolean poisoned) {
    return poisoned;
  }
  
  public void addPoison(boolean poisoned) {
    poisoned = true;
  }
  
  public void removePoison(boolean poisoned) {
    poisoned = false;
  }
  
  public void addStun(boolean stunned) {
    stunned = true;
  }
  
  public void removeStun(boolean stunned) {
    stunned = false;
  }
  
}
