class Ability {
  
  private String abilityName;
  private double manaCost;
  
  //This array willl store the total magic damage and total attack damage of the ability
  // Slot 0 is ad, slot 1 is md
  private double[] baseStats = new double[2];
  
  //counter may be used for abilities which deal more damage when used in sucession
  private int counter;
  private double boost;
  private double amplify;  
  
  Ability(String name){
    abilityName=name;
    generateValues(abilityName);
  }
  
  //Getters
  public String getName(){
    return abilityName;
  }
  
  public double getBaseMagic(){
    return baseStats[1];
  }
  
  public double getBaseAttack(){
    return baseStats[0];
  }
  
  public double getManaCost() {
    return manaCost;
  }
  
  //Setters
  public void setBaseMagic(double baseMagic){
    baseStats[1]=baseMagic;
  }
  
  public void setBaseAttack(double baseAttack){
    baseStats[0]=baseAttack;
  }

  public void setManaCost(double cost){
    manaCost=cost;
  }
  
  //Methods
  
  public void attack(Champion champion, Champion enemyChamp){
    
    // Champion physical damage is champions ad + ability base ad
    double championAttack = champion.getAtkDmg() ;
    
    // Champion magical damage is champions magic d + ability base magic d
    double championMagic = champion.getMagicDmg() ;
    
    // If base stat is less than 0 then make champion corresponding stat to 1
    if(this.getBaseAttack() < 0){
      championAttack = 1;
    }
    
    else if(this.getBaseMagic() < 0){
      championMagic = 1;
    }

    //Addidng base ability stats to champion stats
    championAttack += this.getBaseAttack();
    championMagic += this.getBaseMagic();

    // Armor calculation, finds ad damage multiplier factor
    double percentArmor = 100 / (100 + enemyChamp.getArmor());
    
    // Magic res calculation, finds m damage multiplier factor
    double percentRes = 100 / (100 + enemyChamp.getMagicRes());
    
    // Calculates damage factors into both types of damage
    championAttack = championAttack * percentArmor;
    championMagic = championMagic * percentRes;

    //value to stor entire damage dealt
    double damageDealt = championAttack + championMagic;

    //Takes away health from enemy champion based on damage dealt
    enemyChamp.setHealth(enemyChamp.getHealth() - damageDealt);

    //Takes mana away from attacking champion based on mana cost of ability
    champion.setMana(champion.getMana() - manaCost);
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
        //Set mana cost of ability from file values
        setManaCost(helper.split(",")[3]);

      }
    }

  }

}



