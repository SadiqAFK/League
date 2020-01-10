class Ability extends Champion{
  
  private String abilityName;
  private double manaCost;
  
  //This array willl store the total magic damage and totla attack damage of the ability
  private double[] damage=new double[2];
  
  //counter may be used for abilities which deal more damage when used in sucession
  private int counter;

  private double boost;
  private double amplify;
    
  //private boolean combo;
    
  Ability(String name, double attack, double magic){
    
    abilityName=name;
    damage[0]=attack;
    damage[1]=magic;
  }
  
  
  //Getters
  public String getName(){
    return abilityName;
  }
  
  public double getBaseMagic(){
    return damage[1];
  }
  
  public double getBaseAttack(){
    return damage[0];
  }
    
  
  //Setters
  public void setBaseMagic(double baseMagic){
    damage[1]=baseMagic;
  }
  
  public void setBaseAttack(double baseAttack){
    damage[0]=baseAttack;
  }
    
  //Methods
  
  public double[] attack(Champion champion){
    
    double championAttack = champion.getAtkDmg();
    double championMagic = champion.getMagicDmg();
      
    if(getBaseAttack() < 0){
      championAttack = 1;
    }
    
    else if(getBaseMagic()<0){
      championMagic = 1;
    }
    
    damage[0]+=championAttack;
    damage[1]+=championMagic;
    
    return damage;
  }
}



