package tgl;

import java.io.Serializable;
import java.util.*;

public class RockPaperScissors implements VillainGame, Serializable {
    private int bounty;
    public int winCounter;
    public int computerCounter;
    public Boolean checkGame;
    
    public RockPaperScissors() {
        bounty = 0;
        winCounter = 0;
        computerCounter = 0;
        checkGame = true;
    }

    public void playGame(Scanner input) {
        
        System.out.println("\nGet to 3 wins before your opponent");
        while (true) {
            String computer = computerChoice();

            System.out.println("Please input your choice (rock, paper, or scissor): ");
            String userChoice = input.nextLine();

            System.out.println("Your choice: " + userChoice);
            System.out.println("Computer choice: " + computer);

            if (userChoice.equals("rock") && computer.equals("rock")) {
                System.out.println("It is a draw");
                System.out.println("Score:\nYou: " + winCounter + "\nComputer: " + computerCounter);
                
            } else if (userChoice.equals("rock") && computer.equals("paper")) {
                System.out.println("Computer wins");
                computerCounter++;
                System.out.println("Score:\nYou: " + winCounter + "\nComputer: " + computerCounter);

            } else if (userChoice.equals("rock") && computer.equals("scissor")) {
                System.out.println("You win");
                winCounter++;
                System.out.println("Score:\nYou: " + winCounter + "\nComputer: " + computerCounter);

            } else if (userChoice.equals("scissor") && computer.equals("scissor")) {
                System.out.println("It is a draw");
                System.out.println("Score:\nYou: " + winCounter + "\nComputer: " + computerCounter);

            } else if (userChoice.equals("scissor") && computer.equals("rock")) {
                System.out.println("Computer wins");
                computerCounter++;
                System.out.println("Score:\nYou: " + winCounter + "\nComputer: " + computerCounter);

            } else if (userChoice.equals("scissor") && computer.equals("paper")) {
                System.out.println("You win");
                winCounter++;
                System.out.println("Score:\nYou: " + winCounter + "\nComputer: " + computerCounter);

            } else if (userChoice.equals("paper") && computer.equals("paper")) {
                System.out.println("It is a draw");
                System.out.println("Score:\nYou: " + winCounter + "\nComputer: " + computerCounter);

            } else if (userChoice.equals("paper") && computer.equals("scissor")) {
                System.out.println("Computer wins");
                computerCounter++;
                System.out.println("Score:\nYou: " + winCounter + "\nComputer: " + computerCounter);

            } else if (userChoice.equals("paper") && computer.equals("rock")) {
                System.out.println("You win");
                winCounter++;
                System.out.println("Score:\nYou: " + winCounter + "\nComputer: " + computerCounter);

            }
            checkWin();
            if(checkGame == false){
                break;
            }
        }
    }

    public void checkWin(){
        Random rand = new Random();
        if(winCounter == 3){
            int bountyIncrease = rand.nextInt(201) + 900;
            bounty += bountyIncrease;
            System.out.println("Great work! You've won and increased your bounty by " + bountyIncrease + " !");
            checkGame = false;
        }else if(computerCounter == 3){
            int bountyDecrease = rand.nextInt(101) + 900;
            bounty -= bountyDecrease;
            System.out.println("What a weak crew! You've lost and decreased your bounty by " + bountyDecrease + " !");
            checkGame = false;
        }
    }

    private String computerChoice() {
        int choice = new Random().nextInt(3);

        if (choice == 0) {
            return "rock";
        } else if (choice == 1) {
            return "paper";
        } else {
            return "scissor";
        }
    }

    public int changeBounty() {
        return bounty;
    }
}
