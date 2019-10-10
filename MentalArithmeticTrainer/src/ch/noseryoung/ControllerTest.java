package ch.noseryoung;

import org.junit.Test;

import static org.junit.Assert.*;

public class ControllerTest extends Controller{

    @Test
    public void testCheckCommand(){
        String command = "2";
        int lowestPossibleValue = 1;
        int highestPossibleValue = 3;

        assertTrue(checkCommand(command, lowestPossibleValue, highestPossibleValue));
    }

}
