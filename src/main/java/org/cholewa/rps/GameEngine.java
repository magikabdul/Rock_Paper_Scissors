package org.cholewa.rps;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

final class GameEngine {
    private static String GAME_OBJECT_ROCK = "ROCK";
    private static String GAME_OBJECT_PAPER = "PAPER";
    private static String GAME_OBJECT_SCISSOR = "SCISSOR";

    private List<String> GAME_OBJECTS = Arrays.asList(GAME_OBJECT_ROCK, GAME_OBJECT_PAPER, GAME_OBJECT_SCISSOR);

    private Player player;
    private int roundsToPlay;

    GameEngine(Player player, int roundsToPlay) {
        this.player = player;
        this.roundsToPlay = roundsToPlay;
        play();
    }

    private void play() {
        int round = 1;

        KeyboardScanner scanner = new KeyboardScanner();

        String playerSelection;
        String computerSelection;

        boolean end = false;

        int playerScore = 0;
        int computerScore = 0;


        while (!end) {
            MessagingService.messageGameRoundHeader(round, roundsToPlay, player.getName(), playerScore, computerScore);
            MessagingService.messageGameRules();

            String letter = scanner.processGetSelection(new String[]{"1", "2", "3", "x", "n"});
            playerSelection = "";

            switch (letter) {
                case "1": {
                    playerSelection = GAME_OBJECT_ROCK;
                    break;
                }
                case "2": {
                    playerSelection = GAME_OBJECT_PAPER;
                    break;
                }
                case "3": {
                    playerSelection = GAME_OBJECT_SCISSOR;
                    break;
                }
                case "x": {
                    MessagingService.messageExit();
                    System.exit(0);
                }
                case "n": {
                    play();
                }
            }

            computerSelection = getComputerSelection();
            MessagingService.messageShowPlayersSelection(playerSelection, computerSelection);

            if (playerSelection.equals(computerSelection)) {
                MessagingService.messageNoRoundWinner();
            } else {
                if ((isPlayerWinner(playerSelection, computerSelection))) {
                    playerScore++;
                } else {
                    computerScore++;
                }
                round++;
            }

            end = isGameFinished(round);

            if (!end) {
                System.out.println("Press any key !!!");
                scanner.processGetSelection();
            }
        }

        MessagingService.messageShowGameWinner(playerScore, computerScore, player.getName());
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
