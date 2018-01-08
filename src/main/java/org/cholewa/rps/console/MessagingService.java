package org.cholewa.rps.console;

public class MessagingService {
    private final static int MESSAGE_LINE_LENGTH = 45;

    public static void messageGameStart () {
        System.out.println("Select type of game:\n");
        System.out.println("\t 1. Console version");
        System.out.println("\t 2. Windows version");
        System.out.println("\n\t Any other key to exit");
        System.out.print("> ");
    }

    public static void messageSelectedGameConsole() {
        clearConsole();
        System.out.println("You chose the Console Version");
    }

    public static void messageEnterPlayerName() {
        System.out.println("\nPlease enter your NAME!");
        System.out.print("> ");
    }

    public static void messageGetRoundsNumber(String name) {
        System.out.println("\n" + name + " please enter NUMBER of game rounds!");
        System.out.print("> ");
    }

    public static void messageGameRoundHeader(int round, int numberOfRounds,
                                              String playerName,
                                              int playerScore, int computerScore) {

        clearConsole();
        drawTableHorizontalLine("=");
        drawTableHorizontalLine(" ");
        drawGameProgress(round, numberOfRounds);
        drawTableHorizontalLine(" ");
        drawGameScore(playerScore, computerScore, playerName);
        drawTableHorizontalLine(" ");
        drawTableHorizontalLine("=");
    }

    private static void drawGameProgress(int round, int numberOfRounds) {
        StringBuilder sb = new StringBuilder();

        sb.append("Round no. ")
                .append(round)
                .append(" of ")
                .append(numberOfRounds);

        drawCenteredString(sb.toString());
    }

    private static void drawGameScore(int playerScore, int computerScore, String playerName) {
        StringBuilder sb = new StringBuilder();

        sb.append("Computer ")
                .append(computerScore)
                .append(" : ")
                .append(playerScore)
                .append(" ")
                .append(playerName);
        drawCenteredString(sb.toString());
    }

    public static void messageGameRules() {
        System.out.println("\nPlease make your choice: ");
        System.out.println("\t 1. ROCK");
        System.out.println("\t 2. PAPER");
        System.out.println("\t 3. SCISSOR");
        System.out.println("\n\t 'x' - end game");
        System.out.println("\t 'n' - new game");
        System.out.print("> ");
    }

    public static void messageShowPlayersSelection(String  playerSelection, String computerSelection) {
        System.out.println("\nYour choice - \t" + playerSelection);
        System.out.println("Computer choice - \t" + computerSelection);
    }

    public static void messageNoRoundWinner() {
        System.out.println("\n No winner of this round, play again !!!");
    }

    public static void messageSelectedGameWindows() {
        clearConsole();
        System.out.println("You chose the Windows Version");
    }

    public static void messageShowGameWinner(int playerScore, int computerScore, String playerName) {
        clearConsole();
        drawTableHorizontalLine("=");
        drawCenteredString("Final Score");
        drawTableHorizontalLine("=");
        drawTableHorizontalLine(" ");
        drawCenteredString("Computer " + computerScore + " : " + playerScore + " " + playerName);
        drawTableHorizontalLine(" ");
        drawTableHorizontalLine("=");

        if (playerScore > computerScore) {
            drawCenteredString("Player wins");
        } else if (playerScore < computerScore) {
            drawCenteredString("Computer wins");
        } else {
            drawCenteredString("Game has no winner");
        }

        drawTableHorizontalLine("=");
    }

    public static void messageExit() {
        clearConsole();
        System.out.println("\n\n Bye. Thank you, hope to see you soon.");
    }

    private static void clearConsole() {
        for (int i=0; i < 25; i++) {
            System.out.println();
        }
    }

    private static void drawTableHorizontalLine(String s) {
        StringBuilder sb = new StringBuilder();
        int numberOfSpaces = MESSAGE_LINE_LENGTH - 2;

        sb.append("|");
        for (int i = 0; i < numberOfSpaces; i++) { sb.append(s); }
        sb.append("|");

        System.out.println(sb.toString());
    }

    private static void drawCenteredString(String s) {
        StringBuilder sb = new StringBuilder();
        int numberOfSpaces;

        sb.append("|");
        numberOfSpaces = (MESSAGE_LINE_LENGTH - s.length()) / 2;
        for (int i = 0 ; i < numberOfSpaces; i++) { sb.append(" "); }
        sb.append(s);
        numberOfSpaces = MESSAGE_LINE_LENGTH - 1 - sb.length();
        for (int i = 0 ; i < numberOfSpaces; i++) { sb.append(" "); }
        sb.append("|");
        System.out.println(sb.toString());
    }
}
