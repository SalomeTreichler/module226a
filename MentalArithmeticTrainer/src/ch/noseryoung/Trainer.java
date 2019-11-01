package ch.noseryoung;

import java.util.Scanner;

/**
 * The Trainer class creates Exercises for the User and checks them by delegating the Calculator
 *
 * @author Salome Treichler
 */
public class Trainer {
    private int numberRange;
    private int userAnswer;
    private int amtCorrectAnswers;

    /**
     * The main method if this class; It opens all the other protected methods in this class.
     * It creates two random numbers for the Exercise, then let the Claculator calculate the result, if it is a
     * unalowed division it takes two new random numbers until it finds two valid numbers.
     * <p>
     * If the random numbers can be used it opens the asignTask function
     * <p>
     * In the end it lets check the useranswer and prints out if its correct or not
     *
     * @param operator
     */
    public void createExercise(String operator) {
        Calculator calculator = new Calculator();
        boolean repeat;
        int random1, random2, result = 0;

        do {
            repeat = false;
            random1 = (int) (Math.random() * ((numberRange - 1) + 1)) + 1;
            random2 = (int) (Math.random() * (numberRange + 1));

            try {
                result = calculator.calculate(random1, random2, operator);
            } catch (UnallowedDivisionException e) {
                repeat = true;
            }
        } while (repeat);

        asignTask(random1, random2, operator);

        String output = (checkAnswer(result)) ? "Correct!" : "Worng, correct Answer: " + result;
        System.out.println(output);
    }

    /**
     * This method compares the Answer of the User with the correct solution and returns if it's true or false
     *
     * @param result
     * @return true or false
     */
    protected boolean checkAnswer(int result) {
        if (userAnswer == result) {
            amtCorrectAnswers++;
            return true;
        } else {
            return false;
        }
    }

    /**
     * This method asigns a task to the user. It prints the Exercise and scans the answer and sets it as an
     * attribute of the class
     *
     * @param random1
     * @param random2
     * @param operator
     */
    public void asignTask(int random1, int random2, String operator) {
        Scanner scan = new Scanner(System.in);
        boolean repeat;
        do {
            repeat = false;
            System.out.print(random1 + " " + operator + " " + random2 + " = ");
            String answer = scan.nextLine();
            try {
                setUserAnswer(Integer.parseInt(answer));
            } catch (NumberFormatException e) {
                System.out.println("You didn't enter a number please repeat");
                repeat = true;
            }
        } while (repeat);
    }

    /**
     * This setter sets the numberRange for the Exercise depending on which difficulty has been chosen
     *
     * @param difficulty
     */
    public void setNumberRange(int difficulty) {
        int numberRange = 0;
        switch (difficulty) {
            case 1:
                numberRange = 10;
                break;
            case 2:
                numberRange = 20;
                break;
            case 3:
                numberRange = 100;
                break;
            case 4:
                numberRange = 1000;
        }
        this.numberRange = numberRange;
    }

    /**
     * Setter for userAnswer
     * @param userAnswer
     */
    public void setUserAnswer(int userAnswer) {
        this.userAnswer = userAnswer;
    }

    /**
     * Getter vor amtCorrectAnswers
     *
     * @return the amount of Correct Answers
     */
    public int getAmtCorrectAnswers() {
        return amtCorrectAnswers;
    }
}
