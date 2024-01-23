package tgl;


import java.io.Serializable;
import java.util.*;

public class Hangman implements VillainGame, Serializable {
    private int bounty;
    public String[] objWord = { "m", "a", "r", "v", "e", "l" };
    public String[] hangArray = { "_", "_", "_", "_", "_", "_" };

    public Hangman() {
        bounty = 0;
    }

    public void playGame(Scanner input) {
        int attempt = 5;
        boolean button = false;
        while (attempt > 0 && button == false) {
            String value = String.join("", hangArray);
            System.out.println("Word: " + value);
            System.out.println("Attempts remaining: " + attempt);
            System.out.print("Guess a letter: ");
            String userChar = input.nextLine();

            boolean temp = false;
            for (int h = 0; h < objWord.length; h++) {
                if (objWord[h].equalsIgnoreCase(userChar.toLowerCase())) {
                    hangArray[h] = objWord[h];
                    temp = true;
                }
            }
            if (temp == false) {
                System.out.println("Incorrect guess try again!");
                attempt--;
            }
            System.out.println();
            if (Arrays.equals(hangArray, objWord)) {
                Random rand = new Random();
                String value2 = String.join("", objWord);
                button = true;
                int bountyIncrease = rand.nextInt(201) + 900;
                bounty += bountyIncrease;
                System.out.println("Great Work strong one! You've guessed the word " + value2);
                System.out.println("Your bounty has increased by " + bountyIncrease + " !");
                
            }
        }
        if (attempt == 0) {
            Random rand = new Random();
            String value2 = String.join("", objWord);
            System.out.println("You failed! The word was " + value2 + " !");
            int bountyDecrease = rand.nextInt(101) + 900;
            bounty -= bountyDecrease;
            System.out.println("Your bounty has decreased by " + bountyDecrease + " !" );
            
        }
    }

    public int changeBounty() {
        return bounty;
    }
}
