package org.cholewa.rps.console;

import org.cholewa.rps.common.GameEngine;
import org.cholewa.rps.common.Player;

public class ApplicationConsole {
    private KeyboardScanner scanner = new KeyboardScanner();

    public void run() {
        Player player = setUpPlayer();
        int numberOfRounds = setNumberOfRounds(player);
        GameEngine gameEngine = new GameEngine(player, numberOfRounds);
        gameEngine.play();
    }

    private Player setUpPlayer() {
        MessagingService.messageEnterPlayerName();
        return new Player(scanner.processGetSelectionAnyString());
    }

    private int setNumberOfRounds(Player player) {
        MessagingService.messageGetRoundsNumber(player.getName());
        return scanner.processGetRoundsNumber();
    }
}
