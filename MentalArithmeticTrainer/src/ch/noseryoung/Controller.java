package ch.noseryoung;

/**
 * The Controller handles the inputs of the User and delegates the Trainer class
 *
 * @author Salome Treichler
 */
public class Controller {
    private int exerciseAmt;
    private int difficulty;
    private int mode;

    /**
     * Checks if th value given is valid, if yes it sets it as an Attribute of the class else it throws an Exception
     *
     * @param value
     * @param attributeName
     * @param lowestPossibleValue
     * @param highestPossibleValue
     * @throws IncompatibleSelectionException
     * @throws NoSuchAttributeException
     */
    public void setAttribute(String value, String attributeName, int lowestPossibleValue, int highestPossibleValue) throws IncompatibleSelectionException, NoSuchAttributeException {
        if (checkValue(value, lowestPossibleValue, highestPossibleValue)) {
            int intValue = Integer.parseInt(value);
            switch (attributeName) {
                case "mode":
                    setMode(intValue);
                    break;
                case "difficulty":
                    setDifficulty(intValue);
                    break;
                case "exerciseAmt":
                    setExerciseAmt(intValue);
                    break;
                default:
                    throw new NoSuchAttributeException("Error in Code: The Valuename you entered is no Attribute of this class");
            }
        } else {
            throw new IncompatibleSelectionException("Your Selection isn't valid");
        }
    }

    /**
     * openTrainer() takes the information of the class attributes and delegates the Trainer to create
     * an exercise and tells him which operator to use
     */
    public void openTrainer() {
        Trainer trainer = new Trainer();
        trainer.setNumberRange(difficulty);
        String[] operators = {"+", "-", "/", "*"};
        StopWatch sw = new StopWatch();
        sw.start();
        System.out.println("Start!");
        for (int i = 0; i < exerciseAmt; i++) {
            switch (mode) {
                case 1:
                    trainer.createExercise(operators[0]);
                    break;
                case 2:
                    trainer.createExercise(operators[1]);
                    break;
                case 3:
                    trainer.createExercise(operators[2]);
                    break;
                case 4:
                    trainer.createExercise(operators[3]);
                    break;
                case 5:
                    int random = (int) (Math.random() * (3 + 1));
                    trainer.createExercise(operators[random]);
                    break;
            }
        }
        sw.stop();
        System.out.println("\nCongratulations you finished your Training!");
        System.out.println("It took you " + sw.getElapsedTime().toSeconds() + "s to solve " + exerciseAmt + " Exercises, " + trainer.getAmtCorrectAnswers() + " of " + exerciseAmt + " Exercises were Correct");
    }

    /**
     * Checks if Command is in Range of possible numbers and if it's a number, if yes returns true
     *
     * @param value
     * @param lowestPossibleValue
     * @param highestPossibleValue
     * @return
     */
    protected boolean checkValue(String value, int lowestPossibleValue, int highestPossibleValue) {
        try {
            int intMode = Integer.parseInt(value);
            if (intMode >= lowestPossibleValue && intMode <= highestPossibleValue) {
                return true;
            } else {
                return false;
            }
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Setter for exerciseAmt
     * @param exerciseAmt
     */
    public void setExerciseAmt(int exerciseAmt) {
        this.exerciseAmt = exerciseAmt;
    }

    /**
     * Setter for difficulty
     * @param difficulty
     */
    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    /**
     * Setter for mode
     * @param mode
     */
    public void setMode(int mode) {
        this.mode = mode;
    }
}
