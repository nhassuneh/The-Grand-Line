package tgl;
import java.io.Serializable;
import java.util.*;

public class RandomMath implements VillainGame, Serializable{
    
    private int bounty;

    public RandomMath(){
        bounty = 0;
    }

    public void playGame(Scanner input){
        Random rand = new Random();
        System.out.println("Find the sum of the two numbers to win! ");
        int firstAdd = rand.nextInt(100);
        int secondAdd = rand.nextInt(100);
        System.out.println("What is " + firstAdd + " + " + secondAdd);
        int guess = Integer.parseInt(input.nextLine());
        int answer = firstAdd + secondAdd;
        if(guess == answer){
            int bountyIncrease = rand.nextInt(201) + 900;
            bounty += bountyIncrease;
            System.out.println("Great work! You've won and increased your bounty by " + bountyIncrease + " !");
        }else{
            int bountyDecrease = rand.nextInt(101) + 900;
            bounty -= bountyDecrease;
            System.out.println("What a weak crew! You've lost and decreased your bounty by " + bountyDecrease + " !");
        }
    }

    public int changeBounty(){
        return bounty;
    }
}
