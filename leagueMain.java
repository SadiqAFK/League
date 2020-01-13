import java.util.*;
import java.io.*;

// Main method, runs the game
class leagueMain {
 
  private static ArrayList<Champion> championList = new ArrayList<Champion>();
  private static ArrayList<Champion> player1List = new ArrayList<Champion>();
  private static ArrayList<Champion> player2List = new ArrayList<Champion>();
  
  public static void main(String[] args) throws Exception {
    champIo(); // Reads the csv
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
        System.out.println(champion);
        System.out.println(Arrays.toString(row));
      }
    }
    
    // catch file exception
    catch (FileNotFoundException e) {
      e.printStackTrace();
    } 
  }
  
  public static void championPicker() {
    Scanner picker = new Scanner(System.in);
    
    for (int i = 0; i < 15; i++) {
      championList.get(0).getName();
    }
  }
}