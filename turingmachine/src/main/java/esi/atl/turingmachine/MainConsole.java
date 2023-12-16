package esi.atl.turingmachine;

import esi.atl.turingmachine.controller.ControllerConsole;
/**
 * The main class which initialize game on console.
 */
public class MainConsole {
    public static void main(String[] args) {
        new ControllerConsole().run();
    }
}
