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

  public void setHealth(double newHealth) {
    health = newHealth;
  }
  
  public void setAtkSpd(double newAtkSpd) {
    atkSpd = newAtkSpd;
  }
  
  public void setAtkDmg(double newAtkDmg) {
    atkDmg = newAtkDmg;
  }
  
  public void setArmor(double newArmor) {
    armor = newArmor;
  }
  
  public void setCrit(double newCrit) {
    crit = newCrit;
  }
  
  public void setMagicDmg(double newMagicDmg) {
    magicDmg = newMagicDmg;
  }
  
  public void setMagicRes(double newMagicRes) {
    magicRes = newMagicRes;
  }
  
  public void setMana(double newMana) {
    mana = newMana;
  }
  
  public void setManaReg(double newManaReg) {
    manaReg = newManaReg;
  }
  
  public void setMoveSpd(double newMoveSpd) {
    moveSpd = newMoveSpd;
  }
  
  public void setTenacity(double newTenacity) {
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
    return "Name: " + name + "\nTribe: " +tribe + "\nHealth: " + health
           + "\nAttack Speed: " + atkSpd + "\nAttack Damage: " + atkDmg + 
           "\nArmor: " + armor + "\nCrit: " + crit + "\nMagic Damage: " + magicDmg
           + "\nMagic Res: " + magicRes + "\nMana: " + mana + "\nMana Regen: " + manaReg
           + "\nMove Speed: " + moveSpd + "\nTenacity: " + tenacity;
  }
}
