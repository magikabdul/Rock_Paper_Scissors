package org.cholewa.rps;

public class ApplicationConsole {
    private Player player;
    private int numberOfRounds;

    private KeyboardScanner scanner = new KeyboardScanner();

    public ApplicationConsole() {
        player = setUpPlayer();
        numberOfRounds = setNumberOfRounds();
        new GameEngine(player, numberOfRounds);
    }

    private Player setUpPlayer() {
        MessagingService.messageEnterPlayerName();
        return new Player(scanner.processGetSelection());
    }

    private int setNumberOfRounds() {
        MessagingService.messageGetRoundsNumber(player.getName());
        return scanner.processGetRoundsNumber();
    }
}
