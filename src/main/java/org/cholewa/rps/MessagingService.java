package org.cholewa.rps;

public class MessagingService {

    public static void messageGameStart () {
        System.out.println("Select type of game:\n");
        System.out.println("\t 1. Console version");
        System.out.println("\t 2. Windows version");
        System.out.println("\n\t Any other key to exit");
    }

    public static void messageSelectedGameConsole() {
        clearConsole();
        System.out.println("You chose the Console Version");
    }

    public static void messageEnterPlayerName() {
        System.out.println("\nPlease enter your NAME!");
    }

    public static void messageGetRoundsNumber(String name) {
        System.out.println("\n" + name + " please enter NUMBER of game rounds!");
    }

    public static void messageGameRoundHeader(int round, int numberOfRounds,
                                              String playerName,
                                              int playerScore, int computerScore) {
        int numberOfSpaces;

        clearConsole();

        System.out.println("|===========================================|");
        System.out.println("|                                           |");

        String main = "Round no. " + round + " of " + numberOfRounds;

        String start = "|";
        numberOfSpaces = (45 - main.length()) / 2;
        for (int i = 1; i < numberOfSpaces; i++) {
            start = start + " ";
        }

        String end = "";

        if (numberOfRounds > 9) {
            numberOfSpaces--;
        }

        for (int i = 0; i < numberOfSpaces; i++) {
            end = end + " ";
        }
        end = end + "|";

        System.out.println(start + main+ end);
        System.out.println("|                                           |");

        main = "|";
        if (computerScore < 10) {
            main = main + "          Computer " + computerScore + " : " + playerScore + " " + playerName;
        } else {
            main = main + "         Computer " + computerScore + " : " + playerScore + " " + playerName;
        }

        numberOfSpaces = 45 - main.length() - 1;

        for (int i = 0; i < numberOfSpaces; i++) {
            main = main + " ";
        }

        main = main + "|";

        System.out.println(main);
        System.out.println("|                                           |");
        System.out.println("|===========================================|");
    }

    public static void messageGameRules() {
        System.out.println("\nPlease make your choice: ");
        System.out.println("\t 1. ROCK");
        System.out.println("\t 2. PAPER");
        System.out.println("\t 3. SCISSOR");
        System.out.println("\n\t 'x' - end game");
        System.out.println("\t 'n' - new game");
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
        System.out.println("|===========================================|");
        System.out.println("|                Final Score                |");
        System.out.println("|===========================================|");
        System.out.println("|                                           |");

        int numberOfSpaces;
        String main = "|";
        if (computerScore < 10) {
            main = main + "          Computer " + computerScore + " : " + playerScore + " " + playerName;
        } else {
            main = main + "         Computer " + computerScore + " : " + playerScore + " " + playerName;
        }

        numberOfSpaces = 45 - main.length() - 1;

        for (int i = 0; i < numberOfSpaces; i++) {
            main = main + " ";
        }

        main = main + "|";

        System.out.println(main);
        System.out.println("|                                           |");
        System.out.println("|===========================================|");

        if (playerScore > computerScore) {
            System.out.println("|                Player wins                |");
        } else if (playerScore < computerScore) {
            System.out.println("|               Computer wins               |");
        } else {
            System.out.println("|            Game has no winner             |");
        }

        System.out.println("|===========================================|");
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
}
