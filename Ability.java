class Ability extends Champion{
  
  private String abilityName;
  private double manaCost;
  
  //This array willl store the total magic damage and total attack damage of the ability
  // Slot 0 is ad, slot 1 is md
  private double[] damage = new double[2];
  
  //counter may be used for abilities which deal more damage when used in sucession
  private int counter;
  private double boost;
  private double amplify;  
  
  Ability(String name){
    abilityName=name;
    ganerateValues(abilityName);
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
  
  public double getManaCost() {
    return manaCost;
  }
  
  //Setters
  public void setBaseMagic(double baseMagic){
    damage[1]=baseMagic;
  }
  
  public void setBaseAttack(double baseAttack){
    damage[0]=baseAttack;
  }

  public void setManaCost(double cost){
    manaCost=cost;
  }
  
  //Methods
  
  public double[] attack(Champion champion, Champion enemyChamp, Ability ability){
    
    // Champion physical damage is champions ad + ability base ad
    double championAttack = champion.getAtkDmg() + ability.getBaseAttack();
    
    // Champion magical damage is champions magic d + ability base magic d
    double championMagic = champion.getMagicDmg() + ability.getBaseMagic();
    
    // If champions attack is less than 0, make it 1
    if(champion.getAtkDmg() + ability.getBaseAttack() < 0){
      championAttack = 1;
    }
    
    else if(champion.getAtkDmg() + ability.getBaseAttack() < 0){
      championMagic = 1;
    }
    
    // Armor calculation, finds ad damage multiplier factor
    double percentArmor = 100 / (100 + enemyChamp.getArmor());
    
    // Magic res calculation, finds m damage multiplier factor
    double percentRes = 100 / (100 + enemyChamp.getMagicRes());
    
    // Calculates damage factors into both types of damage
    championAttack = championAttack * percentArmor;
    championMagic = championMagic * percentRes;
    
    // Adds champion attacks to damage array
    damage[0] = championAttack;
    damage[1] = championMagic;
    
    return damage; // Returns damage given to enemy champion
  }

  private void generateValues(String name){

    File file = new File("Abilities.csv");
    BufferedReader reader = new BufferedReader(new FileReader(file));

    //Used to help read the csv file
    String helper;

    while((helper=reader.readLine())!=null){

      if(helper.split(",")[0].equals(name)){

        //Populate damage array with basse stats from file
        setBaseAttack(helper.split(",")[1]);
        setBaseMagic(helper.split(",")[2]);
        //Set mana cost of ability form file values
        setManaCost(helper.split(",")[3]);

      }
    }

  }

}



