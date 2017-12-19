package org.cholewa.rps;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ApplicationConsole {
    private Player player;
    private int numberOfRounds;

    private Scanner scanner = new Scanner(System.in);

    public ApplicationConsole() {
        player = setUpPlayer();
        numberOfRounds = setNumberOfRounds();
        new GameEngine(player, numberOfRounds);
    }

    public Player setUpPlayer() {
        System.out.println("Please enter your name or press 'x' to exit the game");

        String name = scanner.nextLine();
        if (name.equals("x")) {
            System.exit(0);
        }

        return new Player(name);
    }

    public int setNumberOfRounds() {
        System.out.println(player.getName() + " please enter number of game rounds");
        int rounds = 0;

        try {
            rounds = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Number of rounds has to be a number");
        }

        return rounds;
    }
}
