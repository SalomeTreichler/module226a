package ch.noseryoung;

public class Controller {
    private int exerciseAmt;
    private int difficulty;
    private int mode;

    public Controller() {
    }

    protected boolean checkCommand(String command, int lowestPossiblevalue, int highestPossibleValue) {
        try {
            int intMode = Integer.parseInt(command);
            if (intMode >= lowestPossiblevalue && intMode <= highestPossibleValue) {
                return true;
            } else {
                return false;
            }
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public void openTrainer() {
        Trainer trainer = new Trainer();
        trainer.setNumberRange(difficulty);
        String[] operators = {"+", "-", "/", "*"};
        StopWatch sw = new StopWatch();
        sw.start();
        for (int i = 0; i < exerciseAmt; i++) {
            switch (mode) {
                case 1:
                    trainer.doCalculations(operators[0]);
                    break;
                case 2:
                    trainer.doCalculations(operators[1]);
                    break;
                case 3:
                    trainer.doCalculations(operators[2]);
                    break;
                case 4:
                    trainer.doCalculations(operators[3]);
                    break;
                case 5:
                    int random = (int)(Math.random() * (3 + 1));
                    trainer.doCalculations(operators[random]);
                    break;
            }
        }
        sw.stop();
        System.out.println("\nCongratulations you finished your Training!");
        System.out.println("It took you " + sw.getElapsedTime().toSeconds() + "s to solve " + exerciseAmt + " Exercises, " + trainer.getAmtCorrectAnswers() + " of " + exerciseAmt + " Exercises were Correct");
    }

    public void setValues(String value, String valuename, int lowestPossiblevalue, int highestPossibleValue) throws IncompatibleSelectionException, NoSuchValueException{
        if (checkCommand(value, lowestPossiblevalue, highestPossibleValue)) {
            int intValue = Integer.parseInt(value);
            switch(valuename){
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
                    throw new NoSuchValueException("Error in Code: The Valuename you entered is no Attribute of this class");
            }
        } else {
            throw new IncompatibleSelectionException("Your Selection isn't valid");
        }
    }

    public void setExerciseAmt(int exerciseAmt) {
        this.exerciseAmt = exerciseAmt;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }
}
