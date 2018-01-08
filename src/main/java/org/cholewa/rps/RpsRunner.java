package org.cholewa.rps;

import org.cholewa.rps.console.ApplicationConsole;
import org.cholewa.rps.console.KeyboardScanner;
import org.cholewa.rps.console.MessagingService;
import org.cholewa.rps.windows.ApplicationWindows;

public class RpsRunner {

    public static void main(String[] args) {

        KeyboardScanner scanner = new KeyboardScanner();

        MessagingService.messageGameStart();

        String letter = scanner.processGetSelectionAnyString();

        switch (letter) {
            case "1": {
                MessagingService.messageSelectedGameConsole();
                ApplicationConsole applicationConsole = new ApplicationConsole();
                applicationConsole.run();
                break;
            }
            case "2": {
                MessagingService.messageSelectedGameWindows();
                ApplicationWindows applicationWindows = new ApplicationWindows();
                applicationWindows.run();
                break;
            }
            default: {
                MessagingService.messageExit();
                System.exit(0);
            }
        }
    }
}
