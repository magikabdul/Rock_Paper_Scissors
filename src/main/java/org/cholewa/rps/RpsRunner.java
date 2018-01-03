package org.cholewa.rps;

public class RpsRunner {

    public static void main(String[] args) {

        KeyboardScanner scanner = new KeyboardScanner();

        MessagingService.messageGameStart();

        String letter = scanner.processGetSelection();

        switch (letter) {
            case "1":
                MessagingService.messageSelectedGameConsole();
                new ApplicationConsole();
                break;
            case "2":
                MessagingService.messageSelectedGameWindows();
                new ApplicationWindows();
                break;
            default:
                MessagingService.messageExit();
                System.exit(0);
        }
    }
}
