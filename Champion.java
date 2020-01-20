
// Creators: Sadiq Hussain, Nathan Chung
// This is the champion class used to define the traits of a champion

package League;

import java.util.*;

public class  Champion {
  // Initialize protected int fields (stats):
  protected String name;
  protected String tribe;
  protected String type;
  
  //Array to stor names of all stats
  private String[] statNames = {"Health","Attack Speed","Attack Damage","Armor","Crit","Magic Damage","Magic Resistance",
    "Mana","Mana Regen","Movement Speed","Tenacity","maxHealth","maxMana"};
  
  //Array to store values of all coresponding stats
  private double[] statValues = new double[13];
  
  // Initialize private booleans (effects):
  private boolean frozen = false;
  private boolean poisoned = false;
  
  protected Ability[] abilities = new Ability[3];
  
  public Champion() {
    
  }
  
  public Champion(String champName, String champType, String champTribe , String ability1, String ability2, String ability3) throws Exception {
    name = champName;
    type = champType;
    tribe = champTribe;
    
    //Adding champions abilities
    abilities[0] = new Ability(ability1);
    abilities[1] = new Ability(ability2);
    abilities[2] = new Ability(ability3);
  } 
  
  //Getters
  
  public String getName() {
    return name;
  }
  
  public double getHealth() {
    return statValues[0];
  }
  
  public double getAtkSpd() {
    return statValues[1];
  }
  
  public double getAtkDmg() {
    return statValues[2];
  }
  
  public double getArmor() {
    return statValues[3];
  }
  
  public double getCrit() {
    return statValues[4];
  }
  
  public double getMagicDmg() {
    return statValues[5];
  }
  
  public double getMagicRes() {
    return statValues[6];
  }
  
  public double getMana() {
    return statValues[7];
  }
  
  public double getManaReg() {
    return statValues[8];
  }
  
  public double getMoveSpd() {
    return statValues[9];
  }
  
  public double getTenacity() {
    return statValues[10];
  }
  
  public double getMaxHealth(){
    return statValues[11];
  }
  
  public double getMaxMana(){
    return statValues[12];
  }
  
  public String getTribe() {
    return tribe;
  }
  
  public String getType() {
    return type;
  }
  
  public String[] getStatNames(){
    return statNames;
  }
  
  public double[] getStatValues(){
    return statValues;
  }
  
  //Setters
  
  public void setHealth(double newHealth) {
    //Make ssure health does not exceed max health
    if (newHealth < this.getMaxHealth()) {
      statValues[0] = this.getMaxHealth();
    } else {
      statValues[0] = newHealth;
    }
  }
  
  public void setAtkSpd(double newAtkSpd) {
    statValues[1] = newAtkSpd;
  }
  
  public void setAtkDmg(double newAtkDmg) {
    statValues[2] = newAtkDmg;
  }
  
  public void setArmor(double newArmor) {
    statValues[3] = newArmor;
  }
  
  public void setCrit(double newCrit) {
    statValues[4] = newCrit;
  }
  
  public void setMagicDmg(double newMagicDmg) {
    statValues[5] = newMagicDmg;
  }
  
  public void setMagicRes(double newMagicRes) {
    statValues[6] = newMagicRes;
  }
  
  public void setMana(double newMana)  {
    
    //if new mana exceeds the max then set it to max
    if(newMana < this.getMaxMana()){
      statValues[7] = this.getMaxMana();
    }else {
      statValues[7] = newMana;
    }
  }
  
  public void setManaReg(double newManaReg) {
    statValues[8] = newManaReg;
  }
  
  public void setMoveSpd(double newMoveSpd) {
    statValues[9] = newMoveSpd;
  }
  
  public void setTenacity(double newTenacity) {
    statValues[10] = newTenacity;
  }
  
  public void setMaxHealth(double maxHealth){
    statValues[11]=maxHealth;
  }
  
  public void setMaxMana(double maxMana){
    statValues[12]=maxMana;
  }
  
  
  public void setStatValues(double[] newStats){
    
    for(int i=0;i<newStats.length;i++){
      statValues[i]=newStats[i];
    }
  }
  
  //Adding/Removing status effects
  
  public boolean isFrozen() {
    return frozen;
  }
  
  public boolean isPoisoned() {
    return poisoned;
  }
  
  public void addPoison() {
    poisoned = true;
  }
  
  public void removePoison() {
    poisoned = false;
  }
  
  public void addFrozen() {
    frozen = true;
  }
  
  public void removeFrozen() {
    frozen = false;
  }
  
  //Methods
  
  public void applyType(Champion champion, Ability ability) {
    
  }
  public void attack (int abilityName, Champion champ, Champion enemy){
    abilities[abilityName - 1].attack(champ, enemy);
  }
  
  public String toString() {
    return "\nName: " + name + "\nType: " + type + "\nTribe: " +tribe + "\nHealth: " + statValues[0]
      + "\nAttack Speed: " + statValues[1] + "\nAttack Damage: " + statValues[2] +
      "\nArmor: " + statValues[3] + "\nCrit: " + statValues[4] + "\nMagic Damage: " + statValues[5]
      + "\nMagic Res: " + statValues[6] + "\nMana: " + statValues[7] + "\nMana Regen: " + statValues[8]
      + "\nMove Speed: " + statValues[9] + "\nTenacity: " + statValues[10];
  }
  
  //Regenerates mana as required
  public void regen() {
    setMana(getMana()+getManaReg());
    
    //Makes sure the champion dosent surpass their maximum mana
    if(getMana()>getMaxMana()){
      setMana(getMaxMana());
    }
  }
  
  //Checks if champion is dead
  public boolean isDead() {
    return this.getHealth()<=0;
  }
  
  public void printAbilities(){
    int counter = 0;
    for(int i=0; i<abilities.length; i++) {
      counter++;
      double totalAtkDmg = this.getAtkDmg() + abilities[i].getBaseAttack();
      double totalMagicDmg = this.getMagicDmg() + abilities[i].getBaseMagic();
      System.out.println(counter + ". " + abilities[i].getName());
      System.out.println("Mana Cost: " + abilities[i].getManaCost());
      if(abilities[i].getBaseAttack()>=0){
        System.out.print("Attack damage: "+ totalAtkDmg + "\n");
      }
      if(abilities[i].getBaseMagic()>=0){
        System.out.print("Magic damage:" + totalMagicDmg + "\n");
      }
    }
  }
}