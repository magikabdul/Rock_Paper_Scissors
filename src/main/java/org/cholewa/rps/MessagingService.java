package org.cholewa.rps;

public class MessagingService {

    public static void messageGameStart () {
        System.out.println("Select type of game:\n");
        System.out.println("\t 1. Console version");
        System.out.println("\t 2. Windows version");
        System.out.println("\n\t Press 'x' to exit");
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

    public static void messageGameRoundHeader(int round, int numberOfRounds) {
        clearConsole();

        String main = "";
        for (int i = 0; i < 35; i++) {
            if (i == 0) {
                main = "|";
            } else if (i == 34) {
                main = main + "|";
            } else {
                if (i < 10 && i > 25) {
                    main = main + " ";
                } else if (i == 11) {
                    main = main + "             Round no. " + round + " of " + numberOfRounds + "             ";
                }
            }
        }

        System.out.println("|===========================================|");
        System.out.println("|                                           |");
        System.out.println(main);
        System.out.println("|                                           |");
        System.out.println("|===========================================|");
    }

    public static void messageGameRules() {
        System.out.println("Please make your choice: ");
        System.out.println("\t 1. ROCK");
        System.out.println("\t 2. PAPER");
        System.out.println("\t 3. SCISSOR");
        System.out.println("\n\t 'x' - end game");
        System.out.println("\t 'n' - new game");
    }

    public static void messageSelectedGameWindows() {
        clearConsole();
        System.out.println("You chose the Windows Version");
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
