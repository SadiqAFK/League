// Creators: Sadiq Hussain, Nathan Chung
// This is the champion class used to define the traits of a champion

import java.util.*;

public class Champion {
  // Initialize protected int fields (stats):
  protected static String name;
  protected static String tribe;
  protected double health;
  protected double atkSpd;
  protected double atkDmg;
  protected double armor;
  protected double crit;
  protected double magicDmg;
  protected double magicRes;
  protected double mana;
  protected double manaReg;
  protected double moveSpd;
  protected double tenacity;
  
  // Initialize private booleans (effects):
  private boolean stunned = false;
  private boolean poisoned = false;
  
  public Champion() {
    
  }
  
  public Champion(String champName, String champTribe) {
    name = champName;
    tribe = champTribe;
  } 
  
  public double getHealth() {
    return health;
  }
  
  public double getAtkSpd() {
    return atkSpd;
  }
  
  public double getAtkDmg() {
    return atkDmg;
  }
  
  public double getArmor() {
    return armor;
  }
  
  public double getCrit() {
    return crit;
  }
  
  public double getMagicDmg() {
    return magicDmg;
  }
  
  public double getMagicRes() {
    return magicRes;
  }
  
  public double getMana() {
    return mana;
  }
  
  public double getManaReg() {
    return manaReg;
  }
  
  public double getMoveSpd() {
    return moveSpd;
  }
  
  public double getTenacity() {
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
  
  public String toString() {
    return name + ", " +tribe;
  }
}
