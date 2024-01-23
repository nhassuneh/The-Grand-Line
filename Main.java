package tgl;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Ship ship = null;
        Map map = null;
        try {

            FileInputStream fileIn = new FileInputStream("tgl.ser");

            ObjectInputStream in = new ObjectInputStream(fileIn);

            ship = (Ship) in.readObject();

            in.close();

            fileIn.close();

        } catch (IOException i) {
            ship = new Ship("", "", 0);

        } catch (ClassNotFoundException l) {

        }
        while (true) {
            System.out.println("Welcome to the Grand Line!");
            System.out.println("Login or Register to begin");
            Scanner input = new Scanner(System.in);
            System.out.println("1. Login with Crew \n2. Register with Crew");
            String choice = input.nextLine();

            if (choice.equals("1")) {
                Boolean accountExists = ship.crewLogin(input);
                while (accountExists) {
                    map = ship.getMap();
                    if (ship.getIslandPosition() != 15) {
                        System.out.println("1- Move to next Island");
                        System.out.println("2- Play Island Game");
                        System.out.println("3- View Bounty");
                        System.out.println("4- View Bounty Board");
                        System.out.println("5- View Island Position");
                        System.out.println("6- Exit");
                        String crewChoice = input.nextLine();
                        if (crewChoice.equals("1")) {
                            if (ship.getResult()) {
                                ship.moveIsland(map);
                                ship.setMap(map);
                            } else {
                                System.out.println("Defeat the villain before sailing to the next island!");
                            }
                        } else if (crewChoice.equals("2")) {
                            if (ship.getResult() == false) {
                                ship.playGame(input);
                            } else {
                                System.out.println("You've already beaten the game move on!");
                            }
                        } else if (crewChoice.equals("3")) {
                            ship.viewBounty();
                        } else if (crewChoice.equals("4")) {
                            ship.viewBountyBoard();
                        } else if (crewChoice.equals("5")) {
                            ship.viewIslandPosition();
                            if (ship.getResult() == false) {
                                System.out.println("Villain Status: Not Defeated");
                            } else {
                                System.out.println("Villain Status: Defeated\nSail to the next island!");
                            }
                        } else if (crewChoice.equals("6")) {
                            saveGame(ship);
                            break;
                        }
                        System.out.println();
                        if (ship.getBounty() < 0) {
                            ship.deleteCrew();
                            System.out.println("Your crew has been wiped out. Gain more members, grow stronger and return to the Grand Line!");
                            saveGame(ship);
                            break;
                        }
                    } else {
                        System.out.println("Welcome to Laugh Tale!\nYou have conquered the Grand Line and found the One Piece!");
                        ship.changeBounty(1000000000);
                        saveGame(ship);
                        break;
                    }
                    saveGame(ship);
                }

            } else if (choice.equals("2")) {
                ship.crewRegistration(input);
                saveGame(ship);
            }
        }
    }

    public static void saveGame(Ship ship) {
        try {
            FileOutputStream fos = new FileOutputStream("tgl.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(ship);
            oos.close();
            fos.close();
        } catch (FileNotFoundException e) {

        } catch (IOException s) {
            s.printStackTrace();
        }
    }
}
