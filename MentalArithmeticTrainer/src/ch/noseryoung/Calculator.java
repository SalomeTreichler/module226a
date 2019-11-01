package ch.noseryoung;

/**
 * The Calculator class is a simple Calculator with different operators, it calculates the exercises for the Trainer
 *
 * @author Salome Treichler
 */
public class Calculator {

    /**
     * Method that opens the right operation and returns the result
     *
     * @param number1
     * @param number2
     * @param operator
     * @return result of the Exercise
     * @throws UnallowedDivisionException
     */
    public int calculate(int number1, int number2, String operator) throws UnallowedDivisionException {
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

    /**
     * Method to add two numbers
     *
     * @param number1
     * @param number2
     * @return result
     */
    protected int add(int number1, int number2){
        return number1 + number2;
    }

    /**
     * Methos to subtract two numbers
     *
     * @param number1
     * @param number2
     * @return result
     */
    protected int subtract(int number1, int number2){
        return number1 - number2;
    }

    /**
     * Method to divide two numbers, it checks also if the division is allowed or not
     *
     * @param number1
     * @param number2
     * @return result
     * @throws UnallowedDivisionException
     */
    protected int divide(int number1, int number2) throws UnallowedDivisionException {
        if(number2 !=0 && number1>number2 && number1%number2 == 0){
            return number1 / number2;
        }else{
            throw new UnallowedDivisionException("This Division is not allowed");
        }
    }

    /**
     * Method to multiply two numbers
     *
     * @param number1
     * @param number2
     * @return result
     */
    protected int multiply(int number1, int number2){
        return number1 * number2;
    }
}
