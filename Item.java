import java.util.*;
import java.io.*;

class Item {
  //Checls if item has been used already
  boolean used=false;

  //Name of item
  private String name;
  
  //This 2D array will store the names of the stats to be modified, how much they will modified by, and how much they will be amplified by
  //Some stats may just be increased by a set amount, while other may be amplified by a factor(multiplied)
  String toChange[][]=new String[2][3];
  
  Item(String itemName)throws Exception{
    //Constructor will help specify which champion stat the item will modify and by how much or what factor
    name=itemName;
    
    //Getting the values of the item to store in the 2D array
    generateValues(itemName);
  }
  
  //Get name of item
  public String getName(){
    
    return name;
  }
  
  //Getter/method for "used" boolean to check if item has been used already
  public boolean isUsed(){
    return used;
  }
  
  
  
  //Applying the items stats to the champion
  public void apply(Champion champ){
    
    //Copy over champions stat names for reference
    String[] statNames=champ.getStatNames();
    
    //Copy over champion stat values to modify
    double[] statValues=champ.getStatValues();
    
    for(int i=0;i<statNames.length;i++){
      //Check if the name of the champion stat matches the first stat name of the item
      if(statNames[i].equalsIgnoreCase(toChange[0][0])){       
        
        //If the names match then apply the stat boost and amplifier to the corresponding value inn the champion stat Value array
        statValues[i]=(statValues[i]+Double.parseDouble(toChange[0][1]))*Double.parseDouble(toChange[0][2]);
      }
      
      //Check if the name of the champion stat matches the other stat name of the item
      else if(statNames[i].equalsIgnoreCase(toChange[1][0])){
        
        //If the names match then apply the stat boost and amplifier to the corresponding value inn the champion stat Value array
        statValues[i]=(statValues[i]+Double.parseDouble(toChange[1][1]))*Double.parseDouble(toChange[1][2]);
      }
      
    }
    
    //Transfer modified stats to the actual champions stats
    champ.setStatValues(statValues);
    
    //Item has now been used and applied and so cannot be used again
    used=true;
    
  }
  
  private void generateValues(String name) throws Exception{
    
    //Scanner reader=new Scanner("League items.csv");
    File file=new File("League items.csv");
    
    BufferedReader reader=new BufferedReader(new FileReader(file));
    
    //String to be used to help read csv file
    String helper;
    
    //While file isnt blank
    while ((helper=reader.readLine())!=null){
     
      //Split() function is used here because the first values show up with extra commas, so split is used to get just the values before the first comma
      if(helper.split(",")[0].equalsIgnoreCase(name)){
        
        //populating 2D array with values to be used to modify stats
        toChange[0]=reader.readLine().split(",");
        toChange[1]=reader.readLine().split(",");
        
      // NOTE:if the item is only to modify 1 stat, the second stat in the csv file will have a boost of 0 and amplify by 1 so as to not change anything
        break;
      }
      
    }
    reader.close();
  }
  
  //Testingngngngnggnngnngngngnggn  
  //Delete when submiting nigga               
  public void print(){
    
    for(int i=0;i<toChange.length;i++){
      for(int j=0;j<toChange[i].length;j++){
        System.out.print(toChange[i][j]);
      }
      System.out.println();
    }
    
    
    
  }
  
  
  
}