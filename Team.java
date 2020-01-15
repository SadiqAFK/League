//This class is used to make teams for actual gameplay

class Team {
  
  private Champion[] championPool = new Champion[3];
  
  private ArrayList<Item> itemPool = new ArrayList (Item);
  
  private String playerName;


  
  
  Team(String name){
    playerName=name;

    //fills item pool for team once team is made
    this.fillItemPool();
  }
  
  
  public String getName(){
    return playerName;
  }
  
  
  //Adds a copy of each item to a bank to be used
  private void fillItemPool(){
    File file =new File("League items.csv");
    BufferedReader reader = new BufferredReader(new FileReader(file));
    
    String helper;
    
    while((helper=reader.readLine())!=null){
      
      if(helper.split(",")[1]==null){
        
       itemPool.add(new Item( helper.split(",")[0]));
      }
      
    }  
    
  }
  
}
