package org.cholewa.rps;

public class RpsRunner {

    public static void main(String[] args) {

        KeyboardScanner scanner = new KeyboardScanner();

        MessagingService.messageGameStart();

        String letter = scanner.processGetSelection(new String[]{"1", "2", "x"});

        if (letter.equals("1")) {
            MessagingService.messageSelectedGameConsole();
            new ApplicationConsole();
        } else if (letter.equals("2")) {
            MessagingService.messageSelectedGameWindows();
            new ApplicationWindows();
        } else {
            MessagingService.messageExit();
            System.exit(0);
        }
    }
}
