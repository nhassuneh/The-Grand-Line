
package tgl;

import java.util.*;

public class Ship extends Boat {

    public ArrayList<Boat> ships;
    public int pos;
    VillainGame game;

    public Ship(String crewName, String captain, int bounty) {
        super(crewName, captain, bounty);
        ships = new ArrayList<Boat>();
        this.pos = 0;
    }

    public boolean checkcrewName(String crewName) {
        if (ships.isEmpty()) {
            return false;
        }

        for (int i = 0; i < ships.size(); i++) {
            if (this.ships.get(i).crewName.equals(crewName)) {
                return true;
            }
        }
        return false;
    }

    public void crewRegistration(Scanner input2) {
        String crewName;

        while (true) {
            System.out.println("Enter Crew Name: ");
            crewName = input2.nextLine();
            if (checkcrewName(crewName)) {
                System.out.println("Error crew already exists");
            } else {
                break;
            }
        }

        System.out.println("Enter Captain Name: ");
        String captain = input2.nextLine();
        this.ships.add(new Boat(crewName, captain, 1));

        System.out.println("Success your crew has been registered in the marine database!");
    }

    public Boolean crewLogin(Scanner input) {

        System.out.println("Enter Crew Name: ");
        String crewName = input.nextLine();
        System.out.println("Enter Captain Name: ");
        String captain = input.nextLine();

        for (int i = 0; i < ships.size(); i++) {
            if (crewName.equals(ships.get(i).crewName) && captain.equals(ships.get(i).captain)) {
                pos = i;
                if(ships.get(pos).completedGame){
                    System.out.println("You have defeated the Grand Line and found the One Piece! Create a new Crew to sail once again!");
                    return false;
                }
                return true;
            }
        }
        System.out.println("Error Crew or Captain are incorrect");
        return false;

    }

    public void moveIsland(Map m) {
        Node i = m.getIsland();
        Random rand = new Random();
        int number = rand.nextInt(2);
        if (number == 0) {
            i = i.left;
        } else if (number == 1) {
            i = i.right;
        }
        ships.get(pos).currentIsland = i.island;
        System.out.println("Your log pose has led you to " + i.island.getName());
        m.setIsland(i);
        ships.get(pos).gameResult = false;
    }

    public void playGame(Scanner input) {
        Random rand = new Random();
        int number = rand.nextInt(4);
        while (true) {
            if (number == 0) {
                // Hangman
                if (ships.get(pos).currentIsland.getName().equals("Reverse Mountain")) {
                    System.out.println(ships.get(pos).currentIsland.getVillainName() + " has challenged you to a friendly match of Hangman! ");
                } else {
                    System.out.println(ships.get(pos).currentIsland.getVillainName() + " has challenged you to a grueling match of Hangman!");
                }
                game = new Hangman();
                game.playGame(input);
                break;
            } else if (number == 1) {
                // Guess the Number
                // Update game for 3 attempts
                System.out.println(ships.get(pos).currentIsland.getVillainName() + " has challenged you to guess a number within 3 attempts!");
                game = new GuessTheNumber();
                game.playGame(input);
                break;
            } else if (number == 2) {
                // Rock Paper Scissors
                System.out.println(ships.get(pos).currentIsland.getVillainName() + " has challenged you to a match of rock paper scissors! ");
                game = new RockPaperScissors();
                game.playGame(input);
                break;
            } else if (number == 3) {
                // Random Math
                System.out.println(ships.get(pos).currentIsland.getVillainName() + " has challenged you to a match of random math! ");
                game = new RandomMath();
                game.playGame(input);
                break;
            }
        }
        // Updates Total Bounty
        changeBounty(game.changeBounty());
        if (game.changeBounty() > 0) {
            ships.get(pos).gameResult = true;
        }

    }

    public void changeBounty(int newBounty) {
        ships.get(pos).bounty += newBounty;
    }

    public void viewBounty() {
        System.out.println("Your current bounty is " + ships.get(pos).bounty);
    }

    public void viewBountyBoard() {
        Boat temp = ships.get(pos);
        Collections.sort(ships, new SortByBounty());
        int size = ships.size();
        System.out.println("Top 4 Bounties on the Grand Line");
        if (size > 3) {
            System.out.println("1. " + ships.get(0));
            System.out.println("2. " + ships.get(1));
            System.out.println("3. " + ships.get(2));
            System.out.println("4. " + ships.get(3));
        } else if (size == 3) {
            System.out.println("1. " + ships.get(0));
            System.out.println("2. " + ships.get(1));
            System.out.println("3. " + ships.get(2));
        } else if (size == 2) {
            System.out.println("1. " + ships.get(0));
            System.out.println("2. " + ships.get(1));
        } else {
            System.out.println("1. " + ships.get(0));
        }
        for (int i = 0; i < ships.size(); i++) {
            if (temp.crewName.equals(ships.get(i).crewName)) {
                pos = i;
            }
        }
    }

    public void viewIslandPosition() {
        System.out.println("You are currently at " + ships.get(pos).currentIsland.getName());
    }

    public void deleteCrew() {
        this.ships.removeIf(s -> s.crewName.equals(ships.get(pos).crewName));
    }

    public int getBounty() {
        return this.ships.get(pos).bounty;
    }

    public Boolean getResult() {
        return this.ships.get(pos).gameResult;
    }

    
    public int getIslandPosition(){
        return this.ships.get(pos).currentIsland.getPosition();
    }
    public Map getMap(){
        return this.ships.get(pos).newMap;
    }

    public void setMap(Map newMap){
        this.ships.get(pos).newMap = newMap;
    }
}
