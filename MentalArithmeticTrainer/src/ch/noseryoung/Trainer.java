package ch.noseryoung;

import java.util.Scanner;

public class Trainer {
    private int numberRange;
    private int userAnswer;
    private int amtCorrectAnswers;

    public Trainer() {
    }

    public void doCalculations(String operator) {
        Calculator calculator = new Calculator();
        boolean repeat;
        int random1, random2, result = 0;

        do{
            repeat = false;
            random1 = (int) (Math.random() * ((numberRange - 1) + 1)) + 1;
            random2 = (int) (Math.random() * (numberRange + 1));

            try{
                result = calculator.calculate(random1, random2, operator);
            }catch(DivisionNotPossibleException e){
                repeat = true;
            }
        }while(repeat);

        asignTask(random1, random2, operator);

        if(userAnswer == result){
            System.out.println("Correct!");
            amtCorrectAnswers++;
        }else{
            System.out.println("worng, correct Answer: " + result);
        }
    }

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
               repeat = true;
            }
        } while (repeat);
    }

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

    public void setUserAnswer(int userAnswer){
       this.userAnswer = userAnswer;
    }

    public int getAmtCorrectAnswers() {
        return amtCorrectAnswers;
    }
}
