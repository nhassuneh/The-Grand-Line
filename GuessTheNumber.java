package tgl;

import java.io.Serializable;
import java.util.*;

public class GuessTheNumber implements VillainGame, Serializable {

    private int bounty;
    public GuessTheNumber() {
        bounty = 0;
    }

    public void playGame(Scanner input) {
        Random rand = new Random();
        int attempt = 3;
        boolean button = false;
        int number = rand.nextInt(9);
        number += 1;

        while(attempt > 0 && button == false){
            System.out.println("Guess a number between 1-9! ");
            System.out.println("You have " + attempt + " attempts remaining");
            boolean temp = false;
            int guess = Integer.parseInt(input.nextLine());
            if(guess == number){
                button = true;
                int bountyIncrease = rand.nextInt(201) + 900;
                bounty += bountyIncrease;
                System.out.println("Great work! You've guess the number and increased your bounty by " + bountyIncrease + " !");
            }
            if(temp == false){
                System.out.println("Incorrect guess try again! ");
                attempt--;
            }
            System.out.println();
        }
        if(attempt == 0){
            int bountyDecrease = rand.nextInt(101) + 900;
            bounty -= bountyDecrease;
            System.out.println("Incorrect the number was " + number);
            System.out.println("What a weak crew! You've lost and decreased your bounty by " + bountyDecrease + " !");
        }
    }

    public int changeBounty() {
        return bounty;
    }
}
