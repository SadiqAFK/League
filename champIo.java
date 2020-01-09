import java.io.*;
import java.util.*;

public class champIo {
  
  public static void main(String[] args) throws Exception{
    
    String csvFile = "champList.csv";
    BufferedReader br;
    String line = "";
    String cvsSplitBy = ",";
    ArrayList<Champion> championList = new ArrayList<Champion>();
    
    try {
      br = new BufferedReader(new FileReader(csvFile));
      
      // Skip header lines
      br.readLine();
      while ((line = br.readLine()) != null) {
        
        // use comma as separator     
        String[] row = line.split(cvsSplitBy);      
        Champion champion = new Champion(row[0], row[2]);
        champion.setHealth(Integer.parseInt(row[6]));
        System.out.println(champion.getHealth());
        /*champion.setAtkSpd(Double.parseDouble(row[7]));
        champion.setAtkDmg(Double.parseDouble(row[8]));
        champion.setArmor(Double.parseDouble(row[9]));
        champion.setCrit(Double.parseDouble(row[10]));
        champion.setMagicDmg(Double.parseDouble(row[11]));
        champion.setMagicRes(Double.parseDouble(row[12]));
        champion.setMana(Double.parseDouble(row[13]));
        champion.setManaReg(Double.parseDouble(row[14]));
        champion.setMoveSpd(Double.parseDouble(row[15]));
        champion.setTenacity(Double.parseDouble(row[16]));
        */
        championList.add(champion);
        System.out.println(champion);
        System.out.println(Arrays.toString(row));
      }
    }
    
    catch (FileNotFoundException e) {
      e.printStackTrace();
    } 
    
    
  }
}