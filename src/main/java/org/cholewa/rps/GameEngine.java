package org.cholewa.rps;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public final class GameEngine {
    private static String GAME_OBJECT_ROCK = "ROCK";
    private static String GAME_OBJECT_PAPER = "PAPER";
    private static String GAME_OBJECT_SCISSOR = "SCISSOR";

    private List<String> GAME_OBJECTS = Arrays.asList(GAME_OBJECT_ROCK, GAME_OBJECT_PAPER, GAME_OBJECT_SCISSOR);

    private Player player;
    private int roundsToPlay = 0;
    private int round;
    private boolean end;

    private int playerScore = 0;
    private int computerScore = 0;

    public GameEngine(Player player, int roundsToPlay) {
        this.player = player;
        this.roundsToPlay = roundsToPlay;
        this.round = 1;
        this.end = false;
        play();
    }

    public void play() {
        MessagingService.messageGameRoundHeader(round, roundsToPlay);
        KeyboardScanner scanner = new KeyboardScanner();

        Random r = new Random();

        String playerSelection;
        String computerSelection;

        while (!end) {
            MessagingService.messageGameRules();
            

            playerSelection = "";

            switch (scanner.next().charAt(0)) {
                case '1': {
                    playerSelection = GAME_OBJECT_ROCK;
                    break;
                }
                case '2': {
                    playerSelection = GAME_OBJECT_PAPER;
                    break;
                }
                case '3': {
                    playerSelection = GAME_OBJECT_SCISSOR;
                    break;
                }
            }

            computerSelection = GAME_OBJECTS.get(r.nextInt(3));
            showSelections(playerSelection, computerSelection);

            if (playerSelection.equals(computerSelection)) {
                System.out.println("\n No winner of this round, play again");
            } else {
                if (isPlayerWinner(playerSelection, computerSelection)) {
                    playerScore++;
                } else {
                    computerScore++;
                }
                round++;
            }

            showScore(playerScore, computerScore);

            if (round > roundsToPlay) {
                end = true;

                if (playerScore > computerScore) {
                    System.out.println("\nPlayer wins !!!");
                } else if (computerScore > playerScore) {
                    System.out.println("\nComputer wins !!!");
                } else {
                    System.out.println("\nGame has no winner");
                }
            }
        }
    }

    public void showSelections(String playerSelection, String computerSelection) {
        System.out.println("Your choice - " + playerSelection);
        System.out.println("Computer choice - " + computerSelection);
    }

    public void showScore(int playerScore, int computerScore) {
        System.out.println("\n" + player.getName() + "  " + playerScore + ":" + computerScore + "  " + "Computer");
    }

    public boolean isPlayerWinner(String playerSelection, String computerSelection) {

        if (playerSelection.equals(GAME_OBJECT_ROCK)) {
            return (computerSelection.equals(GAME_OBJECT_SCISSOR));
        } else if (playerSelection.equals(GAME_OBJECT_PAPER)) {
            return (computerSelection.equals(GAME_OBJECT_ROCK));
        } else {
            return (computerSelection.equals(GAME_OBJECT_PAPER));
        }
    }
}
