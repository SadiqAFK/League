//This class is used to make teams for actual gameplay

package League;

import java.util.*;
import java.io.*;

class Team {
  
  private ArrayList<Champion> championPool = new ArrayList<Champion>();
  private ArrayList<Item> itemPool = new ArrayList();
  private String playerName;
  
  Team(String name) throws Exception{
    playerName=name;
    
    //fills item pool for team once team is made
    fillItemPool();
  }
  
  // Getters
  public ArrayList<Champion> getChamps() {
    return championPool;
  }
  
  public String getName(){
    return playerName;
  }
  
  public ArrayList<Item> getItemPool() {
    return itemPool;
  }
  //Adds a copy of each item to a bank to be used
  public void fillItemPool()  throws Exception {
    File file = new File("League items.csv");
    BufferedReader reader = new BufferedReader(new FileReader(file));
    
    String helper = "";
    
    while((helper = reader.readLine())!=null){
      
      if(helper.split(",")[0]==null){
        
       itemPool.add(new Item(helper.split(",")[0]));
       System.out.println(itemPool.get(0));
      }
      
    } 
    
  }
  
  public void useItem (String itemName, Champion champion){

    //Variable used to  help specify which item in pool is being reffered to
    int helper = 0;

    for(int i = 0; i < itemPool.size(); i++){

      if(itemPool.get(i).getName().equals(itemName)){
        helper = i;
      }
    }

    //Appllys item to current champion
    itemPool.get(helper).apply(champion);

    //Removes item from pool after being used
    itemPool.remove(helper);
  }
  
  //Regenerate mana for champ on board
  public void regen (Champion champ){
    champ.setMana(champ.getMana() + 50);
  }
}
