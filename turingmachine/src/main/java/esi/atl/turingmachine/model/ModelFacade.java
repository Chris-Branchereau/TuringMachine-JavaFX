package esi.atl.turingmachine.model;

import esi.atl.turingmachine.commands.Command;
import esi.atl.turingmachine.model.validators.Validator;
import esi.atl.turingmachine.view.console.ViewConsole;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ModelFacade {
    private static List<Command> history = new ArrayList<Command>();
    private static int actualUndoCommand = 0;
    private boolean gameStarted;
    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);
    private final List<Problem> problems = new ArrayList<Problem>();
    private Problem currentProblem;

    private static Game game;

    /**
     * Constructor of the ModelFacade
     */
    public ModelFacade() {
        createKnownProblem();
        gameStarted = false;
    }

    /**
     * called when a game start
     * this creates a new game object and modify "start" and "validators"
     * properties
     */
    public void startGame() {
        game = new Game(currentProblem.getCode(), currentProblem.getValidatorNB());
        gameStarted = true;
        pcs.firePropertyChange("start", false, gameStarted);
        pcs.firePropertyChange("validators", null, getValidator());
    }

    /**
     * this chose a problem in the list before the start of a game
     * call startgame()
     * @param number = number of a problem ( = 0 for a random)
     */
    public void chooseProblem(int number) {
        if (number == 0) number = ((int) (Math.random() * ((16 - 1) + 1))+1);
        currentProblem = problems.get(number-1);
        startGame();
    }

    /**
     * @return true if the game is started (and false if not)
     */
    public boolean isGameStarted(){
        return gameStarted;
    }

    /**
     * get the list of known problems
     * @return list of known problems
     */
    public List<Problem> getProblems() {
        return problems;
    }

    /**
     * call the game method to get list of validators from game
     * @return list of validators
     */
    public List<Validator> getValidator() {
        return game.getValidators();
    }

    /**
     * call the game method to set a code from input
     * @param code code to set
     */
    public void setCode(int code) {
        game.setCode(new Code(code));
    }

    /**
     * call the game method to pass to the next round
     */
    public void nextRound() {
        game.nextRound();
    }

    /**
     * call the game method to select a validator (and check the code pattern)
     * @param i = number of the validator selected
     */
    public void selectValidator(int i) {
        if (game.getCode() == null || game.getCode().getCode() == 000)
            throw new TuringException("You must enter a code before that");
        if (i >= game.getValidators().size() || i < 0)
            throw new TuringException("Invalid index Validator");
        game.selectValidator(i);
    }

    /**
     * call the game method to remove the last validator selected (for undo command)
     */
    public void removeLastValidator() {
        game.removeLastValidator();
    }

    /**
     * call the game method to get the total of rounds
     * @return the total of rounds
     */
    public int getTotalRound() {
        return game.getTotalRound();
    }

    /**
     * call the game method to get the total of validators used
     * @return the total of validators used
     */
    public int getScoreValidator() {
        return game.getTotalValidatorsUsed();
    }

    /**
     * compare the current code entered to the secret code from the current problem
     * this end the game
     * @return true if correct code and false if not
     */
    public boolean guessCode() {
        //if (game.getCode() == null || game.getCode().getCode() == 000) throw new TuringException("You must enter a code before that");
        gameStarted =false;
        pcs.firePropertyChange("start", true, gameStarted);
        //return game.getCode().getCode() == currentProblem.getCode().getCode();
        return false;
    }

    /**
     * this end the game (give up)
     */
    public void giveUp() {
        gameStarted=false;
        pcs.firePropertyChange("start", true, gameStarted);
    }

    /**
     * this executes a command
     * method for design pattern Commands
     * @param command = command to execute
     */
    public static void executeCommand(Command command) {
        try {
            history = history.subList(0, actualUndoCommand);
            actualUndoCommand = 0;
            history.add(command);
            command.execute();
        } catch (TuringException e) {
            ViewConsole.displayError(e.getMessage());
        }
    }

    /**
     * undo a command
     * method for design pattern Commands
     */
    public static void undoCommand() {
        try {
            if (actualUndoCommand < history.size()) {
                actualUndoCommand++;
                Command toUndo = history.get(history.size() - actualUndoCommand);
                toUndo.undo();
            } else {
                ViewConsole.displayMessages("0 undo found");
            }
        } catch (
                TuringException e) {
            ViewConsole.displayError(e.getMessage());
        }

    }
    /**
     * redo a command
     * method for design pattern Commands
     */
    public static void redoCommand() {
        try {
            if (actualUndoCommand > 0) {
                Command toRedo = history.get(history.size() - actualUndoCommand);
                toRedo.redo();
                actualUndoCommand--;
            } else {
                ViewConsole.displayMessages("0 redo found");
            }
        } catch (TuringException e) {
            ViewConsole.displayError(e.getMessage());
        }
    }

    /**
     * method to add Observer (OO DP)
     *
     * @param observer
     */
    public void addObserver(PropertyChangeListener observer) {
        pcs.addPropertyChangeListener(observer);
    }


    /**
     * Create a list of Problem from the file known_problems.csv
     */
    private void createKnownProblem() {
        InputStream is = getClass().getClassLoader().getResourceAsStream("known_problems.csv");
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        String line;
        List<String> lines = new ArrayList<>();
        try {
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 1; i < lines.size(); i++) {
            String[] args = lines.get(i).split(",");
            int[] validators = new int[args.length - 4];
            for (int j = 0; j < validators.length; j++) {
                validators[j] = Integer.parseInt(args[j + 4]);
            }
            problems.add(new Problem(Integer.parseInt(args[0]),
                    Integer.parseInt(args[1]),
                    Integer.parseInt(args[2]),
                    new Code(Integer.parseInt(args[3])), validators));
        }
    }
}
