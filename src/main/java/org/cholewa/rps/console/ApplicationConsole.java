package org.cholewa.rps.console;

import org.cholewa.rps.common.GameEngine;
import org.cholewa.rps.common.Player;

public class ApplicationConsole {
    private KeyboardScanner scanner = new KeyboardScanner();
    private Player player;

    public void run() {
        player = setUpPlayer();
        GameEngine gameEngine = new GameEngine(player, setNumberOfRounds());
        gameEngine.play();
    }

    private Player setUpPlayer() {
        MessagingService.messageEnterPlayerName();
        return new Player(scanner.processGetSelectionAnyString());
    }

    private int setNumberOfRounds() {
        MessagingService.messageGetRoundsNumber(player.getName());
        return scanner.processGetRoundsNumber();
    }
}
