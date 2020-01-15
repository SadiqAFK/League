import java.util.*;
import java.io.*;

// Main method, runs the game
class LeagueMain {
 
  static ArrayList<Champion> championList = new ArrayList<Champion>();
  static ArrayList<Champion> player1List = new ArrayList<Champion>();
  static ArrayList<Champion> player2List = new ArrayList<Champion>();
  static int player1Size = 0;
  static int player2Size = 0;
  boolean playerTurn = false;
  static int number = 0;
  
  public static void main(String[] args) throws Exception {
    Scanner reader = new Scanner(System.in);
    System.out.println("Type PVP or PVC");
    String choice = reader.nextLine();
    if (choice.equalsIgnoreCase("PVC")) {
      champIo(); // Reads the csv
      while (player1Size < 5 && player2Size < 5) {
        System.out.println("Type the corresponding number to the champion you want:");
        int select = reader.nextInt();   
        championPicker(select, player1List);
      }
    }
  }
  
  public static void champIo() throws Exception {
    String csvFile = "champList.csv";
    BufferedReader br;
    String line = "";
    String cvsSplitBy = ",";
    
    try {
      br = new BufferedReader(new FileReader(csvFile));
      
      // skip header lines
      br.readLine();
      while ((line = br.readLine()) != null) { // while csv has champions in its file
        
        // use comma as separator     
        String[] row = line.split(cvsSplitBy);
        
        // sets champion stats
        Champion champion = new Champion(row[0], row[2]);
        champion.setHealth(Double.parseDouble(row[3]));
        champion.setAtkSpd(Double.parseDouble(row[4]));
        champion.setAtkDmg(Double.parseDouble(row[5]));
        champion.setArmor(Double.parseDouble(row[6]));
        champion.setCrit(Double.parseDouble(row[7]));
        champion.setMagicDmg(Double.parseDouble(row[8]));
        champion.setMagicRes(Double.parseDouble(row[9]));
        champion.setMana(Double.parseDouble(row[10]));
        champion.setManaReg(Double.parseDouble(row[11]));
        champion.setMoveSpd(Double.parseDouble(row[12]));
        champion.setTenacity(Double.parseDouble(row[13]));
        
        // adds champion to list
        championList.add(champion);
        number++;
        System.out.println(number + ". " + champion);
      }
    }
    
    // catch file exception
    catch (FileNotFoundException e) {
      e.printStackTrace();
    } 
  }
 
  public static void championPicker(int select, ArrayList<Champion> playerList) {
    playerList.add(championList.get(select - 1));
    System.out.println(playerList.get(0));
  }
}