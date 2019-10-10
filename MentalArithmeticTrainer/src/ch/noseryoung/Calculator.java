package ch.noseryoung;

public class Calculator {

    public Calculator() {
    }

    public int calculate(int number1, int number2, String operator) throws DivisionNotPossibleException{
        switch (operator) {
            case "+":
                return add(number1, number2);
            case "-":
                return subtract(number1, number2);
            case "/":
                return divide(number1, number2);
            case "*":
                return multiply(number1, number2);
        }
        return 0;
    }

    private int add(int number1, int number2){
        return number1 + number2;
    }

    private int subtract(int number1, int number2){
        return number1 - number2;
    }

    private int divide(int number1, int number2) throws DivisionNotPossibleException{
        if(number2 !=0 && number1>number2 && number1%number2 == 0){
            return number1 / number2;
        }else{
            throw new DivisionNotPossibleException("This Division is not allowed");
        }
    }

    private int multiply(int number1, int number2){
        return number1 * number2;
    }
}
