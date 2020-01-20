package League;

import java.util.*;
import java.io.*;

// Main method, runs the game
class LeagueMain {
  public static void main(String[] args) throws Exception {
    
    Champion champOnBoard = new Champion("", "", "", "", "", ""); // Temp champs that will be filled in by chosen champs
    Champion champ2OnBoard = new Champion("", "", "", "", "", "");
    boolean playerTurn = false; // If true, player 1 turn - if false, player 2 turn
    boolean gameState = true;
    
    ArrayList<Champion> championList = new ArrayList<Champion>(); // Champ list
    Team player1List = new Team("Player 1"); // Player 1 Champ list
    Team player2List = new Team("Player 2"); // Player 2 Champ list
    
    int championPick = 0; // Initialize champ selection variables
    int championPick2 = 0;
    
    Scanner reader = new Scanner(System.in);
    System.out.println("Type PVP");
    String mode = reader.nextLine();
    if (mode.equalsIgnoreCase("PVP")) {
      champIo(championList); // Reads the csv
      
      while (player2List.getChamps().size() < 3) { // While all champs are not selected yet
        System.out.println("\nPlayer 1 pick champ using their name:");
        String select = reader.nextLine();
        championPicker(select, player1List.getChamps(), championList); // Selects a champion
        
        System.out.println("\nPlayer 2 pick champ using their name:");
        String select2 = reader.nextLine();   
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
      catch (Exception e) { // Catches invalid input
        while (championPick != 1 && championPick != 2 && championPick != 3) {
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
      catch (Exception e) { // Catches invalid input
        while (championPick2 != 1 && championPick2 != 2 && championPick2 != 3) {
          System.out.println("Invalid input! Choose a valid champ.");
          championPick2 = reader.nextInt();
        }
      }
      
      // Chooses which player goes first by comparing atk spd
      playerTurn = compareSpd(champOnBoard, champ2OnBoard, playerTurn); 
      
      // Game runs true
      while (gameState = true) {
        
        // Player 1's turn
        while (playerTurn == true && player2List.getChamps().size() > 0) {
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
          
          while (choice == 3 && player1List.getChamps().size() == 1) {
            System.out.println("Can't select another champ.");
            choice = reader.nextInt();
          }
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
          
          if (champ2OnBoard.getHealth() <= 0) { // If other champion has died, remove from team
            player2List.getChamps().remove(champ2OnBoard);
            player2List.getChamps().trimToSize();
            System.out.println(champ2OnBoard.getName() + " has fallen!");
            
            
            // Checks for win
            if (player2List.getChamps().size() == 0) {
              System.out.println("Player 1 has won! GG.");
            }
            
            // Checks for if champ list is zero
            if (player2List.getChamps().size() == 0) {
              gameState = false;
              break;
            }
            
            System.out.println("Choose another champion."); // Picks another chmap
            for (int i = 0; i < player2List.getChamps().size(); i++) {
              int j = i + 1;
              System.out.println("Champion: " + j + ": " + player2List.getChamps().get(i).getName());
            }
            int switch2Choice = reader.nextInt();
            champ2OnBoard = player2List.getChamps().get(switch2Choice);
          }
          
          playerTurn = false; // Changes turn
          player1List.regen(champOnBoard); // Regenerates mana for champion
        }
        
        // Player 2's turn
        while (playerTurn == false && player1List.getChamps().size() > 0) {
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
          while (choice == 3 && player2List.getChamps().size() == 1) {
            System.out.println("Can't select another champ.");
            choice = reader.nextInt();
          }
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
          
          // Checks for other champion death
          if (champOnBoard.getHealth() <= 0) {
            player1List.getChamps().remove(champOnBoard);
            player1List.getChamps().trimToSize();
            System.out.println(champOnBoard.getName() + " has fallen!");
            
            // Checks for win
            if (player1List.getChamps().size() == 0) {
              System.out.println("Player 2 has won! GG.");
              break;
            }
            
            // Checks for if no more champs are left
            if (player1List.getChamps().size() == 0) {
              gameState = false;
              break;
            }
            
            System.out.println("Choose another champion."); // Picks another champ
            for (int i = 0; i < player1List.getChamps().size(); i++) {
              System.out.println("Champion: " + i + ": " + player1List.getChamps().get(i).getName());
            }
            int switchChoice = reader.nextInt();
            champOnBoard = player1List.getChamps().get(switchChoice);
          }
          
          playerTurn = true; // Changes turn
          player2List.regen(champ2OnBoard); // Regenerates mana for champion
        }
        
      }
      
    }
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
        System.out.println(champion.getName() + " is frozen!");
        playerTurn = false;
        champion.removeFrozen();
      }
    }
    if (playerTurn = false) { // Frozen check for player 2
      if (champion.isFrozen() == true) {
        System.out.println(champion.getName() + " is frozen!");
        playerTurn = true;
        champion.removeFrozen();
      }
    }
    if (champion.isPoisoned() == true) {
      System.out.println(champion.getName() + " is poisoned!");
      champion.setHealth(champion.getHealth() - 50); // If poisoned, reduce health by 50 each tick
      champion.removePoison();
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
        
        // Creates champ objects based on their type
        if (row[1].equals("Ranger")) { // Creates ranger champion object
          Ranger champion = new Ranger(row[0], row[1], row[2], row[16], row[17], row[18]);
          // sets champion stats
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
        
        else if (row[1].equals("Mage")) { // Creates mage champion object
          Mage champion = new Mage(row[0], row[1], row[2], row[16], row[17], row[18]);
          // sets champion stats
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
        
        else if (row[1].equals("Tank")) { // Creates tank champion object
          Tank champion = new Tank(row[0], row[1], row[2], row[16], row[17], row[18]);
          // sets champion stats
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
        
      }
      br.close();
    }
    
    // catch file exception
    catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }
  
  // Selects a champion
  public static void championPicker(String select, ArrayList<Champion> playerList, ArrayList<Champion> championList) {
    for (int i = 0; i < championList.size(); i++) {
      if (select.equalsIgnoreCase(championList.get(i).getName())) {
        playerList.add(championList.get(i));
        championList.remove(select);
        championList.trimToSize();
      }
    }
  }
  
  // applies tribal traits
  public static void trait(Champion champion, Champion enemy) {
    if (champion.getTribe().equals("Noxus")) {
      champion.setArmor(champion.getArmor() + 2);
    }
    else if (champion.getTribe().equals("Demacia")) {
      champion.setMagicRes(champion.getMagicRes() + 2);
    }
    else if (champion.getTribe().equals("Ionian")) {
      champion.setHealth(champion.getHealth() - 50);
      champion.setAtkDmg(champion.getAtkDmg() + 20);
      champion.setMagicDmg(champion.getMagicDmg() + 20);
    }
    else if (champion.getTribe().equals("Freljord")) {
      Random randomGen = new Random(); // Random generator
      int randomNum = randomGen.nextInt(100); // Random num between 0 and 99
      
      // If freljord, any ability has the chance to freeze the target
      if (randomNum <= 0 && randomNum >= 4) { // 5% to freeze
        enemy.addFrozen();
      }
    }
    else if (champion.getTribe().equals("Zaun")) {
      Random randomGen = new Random(); // Random generator
      int randomNum = randomGen.nextInt(100); // Random num between 0 and 99
      
      if (randomNum <= 0 && randomNum >= 39) { // 40% to poison
        enemy.addPoison();
      }
    }
  }
  
  
}