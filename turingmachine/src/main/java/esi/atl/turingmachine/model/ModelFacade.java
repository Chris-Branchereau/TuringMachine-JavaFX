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

    public ModelFacade() {
        createKnownProblem();
        gameStarted = false;
    }

    public void startGame() {
        game = new Game(currentProblem.getCode(), currentProblem.getValidatorNB());
        gameStarted = true;
        pcs.firePropertyChange("start", false, gameStarted);
        pcs.firePropertyChange("validators", null, getValidator());
    }

    public void chooseProblem(int number) {

        if (number == 0) number = ((int) (Math.random() * ((16 - 1) + 1))+1);
        currentProblem = problems.get(number-1);
        startGame();
    }
    public boolean isGameStarted(){
        return gameStarted;
    }

    public List<Problem> getProblems() {
        return problems;
    }

    public List<Validator> getValidator() {
        return game.getValidators();
    }

    public void setCode(int code) {
        game.setCode(new Code(code));
    }

    public void nextRound() {
        game.nextRound();
    }

    // return validator
    public void selectValidator(int i) {
        if (game.getCode() == null || game.getCode().getCode() == 000)
            throw new TuringException("You must enter a code before that");
        if (i >= game.getValidators().size() || i < 0)
            throw new TuringException("Invalid index Validator");
        game.selectValidator(i);
    }

    public void removeLastValidator() {
        game.removeLastValidator();
    }

    public int getTotalRound() {
        return game.getTotalRound();
    }

    public int getScoreValidator() {
        return game.getTotalValidatorsUsed();
    }

    public boolean guessCode() {
        //if (game.getCode() == null || game.getCode().getCode() == 000) throw new TuringException("You must enter a code before that");
        gameStarted =false;
        pcs.firePropertyChange("start", true, gameStarted);
        //return game.getCode().getCode() == currentProblem.getCode().getCode();
        return false;
    }

    public void giveUp() {
        gameStarted=false;
        pcs.firePropertyChange("start", true, gameStarted);
    }


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
