package League;

import java.util.*;
import java.io.*;

// Main method, runs the game
class LeagueMain {
  public static void main(String[] args) throws Exception {
    
    Champion champOnBoard = new Champion("temp", "temp", "temp", "temp", "temp", "temp"); // Temp champs that will be filled in by chosen champs
    Champion champ2OnBoard = new Champion("temp", "temp", "temp", "temp", "temp", "temp");
    boolean playerTurn = false; // If true, player 1 turn - if false, player 2 turn
    
    ArrayList<Champion> championList = new ArrayList<Champion>(); // Champ list
    Team player1List = new Team("Player 1"); // Player 1 Champ list
    Team player2List = new Team("Player 2"); // Player 2 Champ list
    
    int championPick = 0; // Initialize champ selection variables
    int championPick2 = 0;
    
    Scanner reader = new Scanner(System.in);
    System.out.println("Type PVP or PVC");
    String mode = reader.nextLine();
    if (mode.equalsIgnoreCase("PVP")) {
      champIo(championList); // Reads the csv
      
      while (player2List.getChamps().size() < 3) { // While all champs are not selected yet
        System.out.println("\nType the corresponding number of the champion you want:");
        int select = reader.nextInt();
        championPicker(select, player1List.getChamps(), championList); // Selects a champion
        
        int select2 = reader.nextInt();   
        championPicker(select2, player2List.getChamps(), championList);
        
        System.out.println("Player 1 Team:"); // Prints out player 1's team
        for(int i = 0; i < player1List.getChamps().size(); i++){
          System.out.println("Champion: " + i + ": " + player1List.getChamps().get(i).getName());
        }
        
        System.out.println("Player 2 Team:"); // Prints out player 2's team
        for(int i = 0 ; i< player2List.getChamps().size(); i++){
          System.out.println("Champion " + i + ": " + player2List.getChamps().get(i).getName());
        }
      }
      
      System.out.println("\nPlayer 1: Which champion do you wish to choose?");
      championPick = reader.nextInt(); // Chooses a champ from player 1 list
      try {
        System.out.println("You have chosen: " + player1List.getChamps().get(championPick).getName());
        champOnBoard = player1List.getChamps().get(championPick);
      }
      catch (Exception e) {
        while (championPick < player1List.getChamps().size() || championPick > player1List.getChamps().size()) {
          System.out.println("Invalid input! Choose a valid champ.");
          championPick = reader.nextInt();
        }
      }
      
      System.out.println("\nPlayer 2: Which champion do you wish to choose?");
      championPick2 = reader.nextInt(); // Chooses a champ from player 2 list
      try {
        System.out.println("You have chosen: " + player2List.getChamps().get(championPick2).getName());
        champ2OnBoard = player2List.getChamps().get(championPick);
      }
      catch (Exception e) {
        while (championPick2 < player2List.getChamps().size() || championPick2 > player2List.getChamps().size()) {
          System.out.println("Invalid input! Choose a valid champ.");
          championPick2 = reader.nextInt();
        }
      }
      
      // Chooses which player goes first
      playerTurn = compareSpd(champOnBoard, champ2OnBoard, playerTurn); 
      
      // Game runs while either player does not have a champ that has died
      while (player1List.getChamps().size() != 0 || player2List.getChamps().size() != 0) {
        
        // Player 1's turn
        while (playerTurn == true) {
          statusDisplay(champOnBoard); // Displays the current health and mana of champion
          statusCheck(champOnBoard, playerTurn);
          
          if (playerTurn == false) { // If after status effects, champ is frozen, end turn
            break;
          }
          
          System.out.println("\nIt is player 1's turn. What would you like to do?");
          System.out.println("1. Attack");
          System.out.println("2. Equip Items");
          System.out.println("3. Switch Champions");
          
          int choice = reader.nextInt();
          
          if (choice == 1) { // Attack move
            System.out.println("\n" + champOnBoard.getName() + " is currently attacking " 
                                 + champ2OnBoard.getName());
            System.out.println(champOnBoard.getName() + "'s moves: ");
            // display moves
            champOnBoard.printAbilities();
            System.out.println("\nSelect a move: ");
            int moveChoice = reader.nextInt(); // selects a move
            
            champOnBoard.attack(moveChoice, champOnBoard, champ2OnBoard); // Attacks the other champion
          }
          else if (choice == 2) { // Equip an item
            System.out.println("Which item would you like to equip?");
            for (int i = 0; i < player1List.getItemPool().size(); i++) {
              System.out.println(player1List.getItemPool().get(i));
            }
            String itemChoice = reader.nextLine();
            player1List.useItem(itemChoice, champOnBoard);
          }
          else if (choice == 3) { // Switch Champ
            System.out.println("Who would you like to select?");
            for (int i = 0; i < player1List.getChamps().size(); i++) {
              System.out.println("Champion: " + i + ": " + player1List.getChamps().get(i).getName());
            }
            int switchChoice = reader.nextInt();
            
            // While champ selected is equal to one on board
            while (player1List.getChamps().get(switchChoice).getName().equals(champOnBoard.getName())) { 
              System.out.println("You can't switch to your current champion!");
              switchChoice = reader.nextInt();
            }
            
            champOnBoard = player1List.getChamps().get(switchChoice);
          }
          
          if (champ2OnBoard.isDead()) {
            player2List.getChamps().remove(champ2OnBoard);
            player2List.getChamps().trimToSize();
          }
          
          System.out.println("yeet");
          playerTurn = false;
          player1List.regen();
        }
        
        // Player 2's turn
        while (playerTurn == false) {
          statusDisplay(champ2OnBoard); // Displays the current health and mana of champion
          statusCheck(champ2OnBoard, playerTurn);
          
          if (playerTurn == true) { // If after status effects, champ is frozen, end turn
            break;
          }
          
          System.out.println("\nIt is player 2's turn. What would you like to do?");
          System.out.println("1. Attack");
          System.out.println("2. Equip Items");
          System.out.println("3. Switch Champions");
          
          int choice = reader.nextInt();
          
          if (choice == 1) { // Attack move
            System.out.println("\n" + champ2OnBoard.getName() + " is currently attacking " 
                                 + champOnBoard.getName());
            System.out.println(champ2OnBoard.getName() + "'s moves: ");
            // display moves
            champ2OnBoard.printAbilities();
            System.out.println("\nSelect a move: ");
            int moveChoice = reader.nextInt(); // selects a move
            
            champ2OnBoard.attack(moveChoice, champ2OnBoard, champOnBoard); // Attacks the other champion
          }
          else if (choice == 2) { // Equip an item
            System.out.println("Which item would you like to equip?");
            for (int i = 0; i < player2List.getItemPool().size(); i++) {
              System.out.println(player2List.getItemPool().get(i));
            }
            String item2Choice = reader.nextLine();
            player2List.useItem(item2Choice, champ2OnBoard);
          }
          else if (choice == 3) { // Switch Champ
            System.out.println("Who would you like to select?");
            for (int i = 0; i < player2List.getChamps().size(); i++) {
              System.out.println("Champion: " + i + ": " + player2List.getChamps().get(i).getName());
            }
            int switchChoice = reader.nextInt();
            
            // While champ selected is equal to one on board
            while (player2List.getChamps().get(switchChoice).getName().equals(champ2OnBoard.getName())) { 
              System.out.println("You can't switch to your current champion!");
              switchChoice = reader.nextInt();
            }
            
            champ2OnBoard = player2List.getChamps().get(switchChoice);
          }
          if (champ2OnBoard.isDead()) {
            player1List.getChamps().remove(champOnBoard);
            player1List.getChamps().trimToSize();
          }
          System.out.println("yeet2");
          playerTurn = true;
          player2List.regen();
        }
      }
      
    }
    
    /*
     else if (mode.equalsIgnoreCase("PVC")) {
     champIo(championList); // Reads the csv
     Random randomgen = new Random();
     
     while (player2List.size() < 3) {
     System.out.println("Type the name of the champion you want:");
     int select = reader.nextInt();  
     championPicker(select, player1List, championList);
     
     int randomint = randomgen.nextInt(championList.size());
     championPicker(randomint, player2List, championList);
     
     System.out.println("Player 1 Team:");
     for(int i = 0; i < player1List.size(); i++){
     System.out.println("Champion: " + i + ": " + player1List.get(i).getName());
     }
     
     System.out.println("Player 2 Team:");
     for(int i = 0 ; i< player2List.size(); i++){
     System.out.println("Champion " + i + ": " + player2List.get(i).getName());
     }
     }
     }
     */
  }
  
  // Displays the current health and mana of champion
  public static void statusDisplay(Champion champion) {
    System.out.println("\n" + champion.getName() + " has: "
                         + "\nHealth: " + champion.getHealth()
                         + "\nMana: " + champion.getMana());
    System.out.println(champion.getName() + " is frozen: " + champion.isFrozen());
    System.out.println(champion.getName() + " is poisoned: " + champion.isPoisoned());
  }
  
  // Checks for any status effects on champion
  public static void statusCheck(Champion champion, boolean playerTurn) {
    if (playerTurn = true) { // Frozen check for player 1
      if (champion.isFrozen() == true) {
        playerTurn = false;
      }
    }
    if (playerTurn = false) { // Frozen check for player 2
      if (champion.isFrozen() == true) {
        playerTurn = true;
      }
    }
    if (champion.isPoisoned() == true) {
      champion.setHealth(champion.getHealth() - 50); // If poisoned, reduce health by 50 each tick
    }
  }
  
  // Compares the atkSpd values of both champions in play
  // Champion with higher atkSpd value will attack first
  public static boolean compareSpd(Champion champion, Champion champion2, boolean playerTurn) {
    if (champion.getAtkSpd() < champion2.getAtkSpd()) {
      return playerTurn = false;
    }
    else {
      return playerTurn = true;
    }
  }
  
  // Reads csv file
  public static void champIo(ArrayList<Champion> championList) throws Exception {
    String csvFile = "champList.csv";
    BufferedReader br;
    String line = "";
    String cvsSplitBy = ",";
    int number = 0;
    try {
      br = new BufferedReader(new FileReader(csvFile));
      
      // skip header lines
      br.readLine();
      while ((line = br.readLine()) != null) { // while csv has champions in its file
        
        // use comma as separator     
        String[] row = line.split(cvsSplitBy);
        
        // sets champion stats
        Champion champion = new Champion(row[0], row[1], row[2], row[16], row[17], row[18]);
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
        System.out.println(number + ". " + champion);
        number++;
      }
      br.close();
    }
    
    // catch file exception
    catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }
  
  // Selects a champion
  public static void championPicker(int select, ArrayList<Champion> playerList, ArrayList<Champion> championList) {
    playerList.add(championList.get(select));
    championList.remove(select);
    championList.trimToSize();
  }
  
  /*
  public static void applyType(Champion champion, Ability ability) {
    applyTrait(champion, ability);
  }
  
  public static void trait(Champion champion, Ability ability) {
    if (champion.getTribe().equals("Noxus")) {
      
    }
    else if (champion.getTribe().equals("Demacia")) {
      
    }
    else if (champion.getTribe().equals("Ionian")) {
      
    }
    else if (champion.getTribe().equals("Freljord")) {
      
    }
    else if (champion.getTribe().equals("Zaun")) {
      
    }
  }
  
  */
}