package ch.noseryoung;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        InputHandler inputHandler = InputHandler.getInstance();

        System.out.println("--------------------------------" +
                "\n          STAR MANAGER          " +
                "\n--------------------------------");

        int command = 0;
        do {
            System.out.println("\nMENU" +
                    "\n------------------------------------------" +
                    "\n1  Create a new star" +
                    "\n2  Print all registered actors" +
                    "\n3  Show all actors from one movie" +
                    "\n4  Remove an existing star" +
                    "\n0  Exit Program");

            System.out.print("Command: ");
            String inputString = scan.nextLine();

            try {
                command = Integer.parseInt(inputString);
                switch (command) {
                    case 0:
                        break;
                    case 1:
                        inputHandler.createStar();
                        break;
                    case 2:
                        inputHandler.printAllStars();
                        break;
                    case 3:
                        inputHandler.printStarsByMovie();
                        break;
                    case 4:
                        inputHandler.removeStar();
                        break;
                    default:
                        System.err.println("You haven't entered a correct command");
                }
            } catch (NumberFormatException e) {
                System.err.println("You haven't entered a correct command");
                command = -1;
            } catch (StarListEmptyException e) {
                System.err.println(e.getMessage());
            } catch (StarListFullException e) {
                System.err.println(e.getMessage());
            }
        } while (command != 0);

    }
}
