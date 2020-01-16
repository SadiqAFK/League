//This class is used to make teams for actual gameplay

package League;

import java.util.*;
import java.io.*;

class Team {
  
  private ArrayList<Champion> championPool = new ArrayList<Champion>();
  private ArrayList<Item> itemPool = new ArrayList();
  private String playerName;

    //used to determine which champ is in play right now using index
  private int currentChamp=0;
  
  Team(String name) throws Exception{
    playerName=name;
    
    //fills item pool for team once team is made
    this.fillItemPool();
  }
  
  // Getters
  public ArrayList<Champion> getChamps() {
    return championPool;
  }
  
  public String getName(){
    return playerName;
  }

  public Champion getCurrentChamp (){
    return championPool.get(currentChamp);
  }

  //Setters

  public void setCurrentChamp(String champName){

    for(int i=0 ; i<championPool.size() ; i++){

      if(champName == championPool.get(i).getName()){
        currentChamp = i;
      }

    }

  }

  //Methods

  // Adds a champion to the team
  public void addChamp(Champion champion) {
    if (championPool.size() < 3) {
      championPool.add(champion);
    }
    else if (championPool.size() > 3) {
      System.out.println("You cannot select any more champions.");
    }
  }
  
  //Adds a copy of each item to a bank to be used
  private void fillItemPool()  throws Exception {
    File file =new File("League items.csv");
    BufferedReader reader = new BufferedReader(new FileReader(file));
    
    String helper;
    
    while((helper = reader.readLine())!=null){
      
      if(helper.split(",")[1]==null){
       itemPool.add(new Item( helper.split(",")[0]));
      }
      
    } 
    
  }
  
}
