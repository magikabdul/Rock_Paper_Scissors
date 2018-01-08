package org.cholewa.rps.common;

import org.cholewa.rps.console.KeyboardScanner;
import org.cholewa.rps.console.MessagingService;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public final class GameEngine {
    private KeyboardScanner scanner = new KeyboardScanner();
    private static String GAME_OBJECT_ROCK = "ROCK";
    private static String GAME_OBJECT_PAPER = "PAPER";
    private static String GAME_OBJECT_SCISSOR = "SCISSOR";

    private List<String> GAME_OBJECTS = Arrays.asList(GAME_OBJECT_ROCK, GAME_OBJECT_PAPER, GAME_OBJECT_SCISSOR);

    private Player player;
    private int roundsToPlay;

    public GameEngine(Player player, int roundsToPlay) {
        this.player = player;
        this.roundsToPlay = roundsToPlay;
    }

    public void play() {
        int round = 1;

        String playerSelection;
        String computerSelection;

        boolean end = false;

        int playerScore = 0;
        int computerScore = 0;


        while (!end) {
            MessagingService.messageGameRoundHeader(round, roundsToPlay, player.getName(), playerScore, computerScore);
            MessagingService.messageGameRules();

            playerSelection = getPlayerSelection();
            computerSelection = getComputerSelection();

            MessagingService.messageShowPlayersSelection(playerSelection, computerSelection);

            if (areSelectionsTheSame(playerSelection, computerSelection)) {
                MessagingService.messageNoRoundWinner();
            } else {
                if (isPlayerWinner(playerSelection, computerSelection)) {
                    playerScore++;
                } else {
                    computerScore++;
                }
                round++;
            }

            end = isGameFinished(round);

            if (!end) {
                System.out.println("Press any key !!!");
                scanner.processGetSelectionAnyString();
            }
        }

        MessagingService.messageShowGameWinner(playerScore, computerScore, player.getName());
    }

    private boolean areSelectionsTheSame(String playerSelection, String computerSelection) {
        return playerSelection.equals(computerSelection);
    }

    private String getPlayerSelection() {
        String s = scanner.processGetSelection(new String[]{"1", "2", "3", "x", "n"});

        switch (s) {
            case "1":
                return GAME_OBJECT_ROCK;
            case "2":
                return GAME_OBJECT_PAPER;
            case "3":
                return GAME_OBJECT_SCISSOR;
            case "n":
                play();
                break;
            default:
                MessagingService.messageExit();
                System.exit(0);
        }
        return "";
    }

    private String getComputerSelection() {
        Random r = new Random();

        return GAME_OBJECTS.get(r.nextInt(3));
    }

    private boolean isPlayerWinner(String playerSelection, String computerSelection) {

        if (playerSelection.equals(GAME_OBJECT_ROCK)) {
            return (computerSelection.equals(GAME_OBJECT_SCISSOR));
        } else if (playerSelection.equals(GAME_OBJECT_PAPER)) {
            return (computerSelection.equals(GAME_OBJECT_ROCK));
        } else {
            return (computerSelection.equals(GAME_OBJECT_PAPER));
        }
    }

    private boolean isGameFinished(int round) {
        return (round > roundsToPlay);
    }
}
