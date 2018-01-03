package org.cholewa.rps;

class ApplicationConsole {
    private Player player;

    private KeyboardScanner scanner = new KeyboardScanner();

    ApplicationConsole() {
        player = setUpPlayer();
        new GameEngine(player, setNumberOfRounds());
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
