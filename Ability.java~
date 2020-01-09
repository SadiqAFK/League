class Ability extends Champion{
  
  private String abilityName;
  
  //This array willl store the total magic damage and totla attack damage of the ability
  private double[] damage=new double[2];
  
  //counter may be used for abilities which deal more damage when used in sucession
  private int counter;
  
  private int targetNum;
  private int damageSelection;
  private double boost;
  private double amplify;
    
  //private boolean combo;
    
  
  Ability(String name, double attack, double magic){
    
    abilityName=name;
    damage[0]=attack;
    damage[1]=magic;
  }
  
  Ability(String name, double attack, double magic,int targetNum, int damageSelection ){
    
    abilityName=name;
    damage[0]=attack;
    damage[1]=magic;
    this.targetNum=targetNum;
    this.damageselection=damagSelection;
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
  
  public double[] attack(){
    
    double championAttack=//get champino attack damge stat
    double championMagic=//get champion magic damage stat
      
    if(getBaseAttack()<0){
      championAttack=1;
    }
    else if(getBaseMagic()<0){
      championMagic=1;
    }
    
    damage[0]+=championAttack;
    damage[1]+=championMagic;
    
    return damage;
  }
}



