class Ability extends Champion {
  private String abilityName;
  
  //This array will store the total magic damage and total attack damage of the ability
  private double[] damage=new double[2];
  private String effect;
  
  //counter may be used for abilities which deal more damage when used in succession
  private int counter;
  private int basedamage = 0;
  
  public double[] attack(Champion champ, Champion enemyChamp) {
    /*If ability is meant to only output one kind of damage, then the other damage type will be set to -1
     * the attack method will check if either of the base damage fields are negative and will then
     * disregard that damage field for the champion.
     * 
     * i.e
     * if the ability is meant to only do magic damage then the field for base attack damage will be -1, and
     * the attack method will then disregard that champions attack damage when calculating the damage
     * output of the ability
     */
    
    boolean atk = true;
    // Checks if champion is stunned or not
    // If true, champion will not attack
    //if (champ.isStunned) {
    //  boolean atk = false;
    //}
    
    
    if (basedamage<0){
      //disregard champion specific damage stat
    }
    //add up champion stats to abilities base damages 
    
    //return damage array
   return damage; 
  }
}
