package ch.noseryoung;

import java.util.Scanner;

/**
 * This program is to practice mental arithmetic it can give the user different exercises,
 * stop the time the user needs to solve them and count how many were answered correctly
 *
 * @author Salome Treichler
 */
public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Controller controller = new Controller();

        System.out.println("--------------------------------------------------------");
        System.out.println("Mental Arithmetic Trainer");
        System.out.println("--------------------------------------------------------");

        boolean repeat;
        do {
            repeat = false;

            System.out.println("Mode:");
            System.out.println("----------------");
            System.out.println("1 Addition\n" +
                    "2 Subtraction\n" +
                    "3 Division\n" +
                    "4 Multiplication\n" +
                    "5 Random operations");
            System.out.print("Selection: ");
            String modeSelection = scan.nextLine();

            try {
                controller.setAttribute(modeSelection, "mode", 1,5);
            } catch (IncompatibleSelectionException e) {
                System.err.println(e.getMessage());
                repeat = true;
            } catch (NoSuchAttributeException e){
                e.printStackTrace();
            }
        } while (repeat);

        do {
            repeat = false;

            System.out.println("\nDifficulty:");
            System.out.println("----------------");
            System.out.println("1 Easy\n" +
                    "2 Medium\n" +
                    "3 Hard\n" +
                    "4 Ultra Hard");
            System.out.print("Selection: ");
            String difficultySelection = scan.nextLine();

            try {
                controller.setAttribute(difficultySelection, "difficulty", 1,4);
            } catch (IncompatibleSelectionException e) {
                System.err.println(e.getMessage());
                repeat = true;
            } catch (NoSuchAttributeException e){
                e.printStackTrace();
            }
        } while (repeat);

        do {
            repeat = false;

            System.out.print("\nAmount of exercises: ");
            String amountSelection = scan.nextLine();

            try {
                controller.setAttribute(amountSelection, "exerciseAmt", 1,100);
                controller.openTrainer();
            } catch (IncompatibleSelectionException e) {
                System.err.println(e.getMessage());
                repeat = true;
            } catch (NoSuchAttributeException e){
                e.printStackTrace();
            }
        } while (repeat);
    }
}
