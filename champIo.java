import java.io.*;
import java.util.*;

public class champIo {
  public static void main(String[] args) {
    
    String csvFile = "champList.csv";
    BufferedReader br = null;
    String line = "";
    String cvsSplitBy = ",";
    
    try {
      
      br = new BufferedReader(new FileReader(csvFile));
      while ((line = br.readLine()) != null) {
        // use comma as separator
        String[] row = line.split(cvsSplitBy);
        System.out.println(Arrays.toString(row));
      }
      
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (br != null) {
        try {
          br.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
    
  }
}