package ch.noseryoung;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest extends Calculator{

    int number1 = 3;
    int number2 = 5;

    @Test
    public void testCalculate(){
        String operator = "+";

        int expectedResult = number1 + number2;
        int actualResult = 0;
        try{
            actualResult = calculate(number1, number2, operator);
        }catch(DivisionNotPossibleException e){
            e.printStackTrace();
        }

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testAdd(){
        int expectedResult = number1 + number2;
        int actualResult = add(number1,number2);

        assertEquals(expectedResult,actualResult);
    }

    @Test
    public void testSubtract(){
        int expectedResult = number1 - number2;
        int actualResult = subtract(number1,number2);

        assertEquals(expectedResult,actualResult);
    }

    @Test
    public void testDivide(){
        int expectedResult = number1 / number2;
        int actualResult = 0;
        try{
            actualResult = divide(number1,number2);
        }catch(DivisionNotPossibleException e){
            e.printStackTrace();
        }
        assertEquals(expectedResult,actualResult);
    }

    @Test
    public void testMultiply(){
        int expectedResult = number1 * number2;
        int actualResult = multiply(number1,number2);

        assertEquals(expectedResult,actualResult);
    }
}
