package org.cholewa.rps;

import java.util.Scanner;

public class RpsRunner {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Select type of game:");
        System.out.println("\t 1. Console version");
        System.out.println("\t 2. Windows version");
        System.out.println("\n Press any other key to exit");

        switch (scanner.next().charAt(0)) {
            case '1': {
                System.out.println("You chose the Console Version");
                //scanner.close();
                new ApplicationConsole();
                break;
            }
            case '2': {
                System.out.println("You chose the Windows Version");
                scanner.close();
                new ApplicationWindows();
                break;
            }
            default: {
                scanner.close();
                System.out.println(" Bye. Thank you, hope to see you soon.");
            }
        }
    }
}
