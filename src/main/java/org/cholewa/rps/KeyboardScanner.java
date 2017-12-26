package org.cholewa.rps;

import java.util.InputMismatchException;
import java.util.Scanner;

public class KeyboardScanner {
    Scanner scanner = new Scanner(System.in);

    public String processGetSelection() {
        String mySing = "";

        try {
            mySing = scanner.next();
        } catch (InputMismatchException e) {
            System.out.println("Enter the correct value !!!");
            scanner.next();
        }
        return mySing;
    }

    public String processGetSelection(String[] letters) {
        boolean isCorrect = false;
        String mySing = "";

        while (!isCorrect) {
            try {
                mySing = scanner.next();
            } catch (InputMismatchException e) {
                System.out.println("Enter the correct value !!!");
                scanner.next();
            }

            for (String s : letters) {
                if (s.equals(mySing)) {
                    isCorrect = true;
                }
            }

            if (!isCorrect) {
                System.out.print("Wrong sing, please select again");
                for (String s : letters) {
                    System.out.print(s + ", ");
                }
                System.out.print("\b\b\n\n");
            }
        }
        return mySing;
    }

    public int processGetRoundsNumber() {
        boolean isCorrect = false;
        int numberOfRounds = 0;

        while (!isCorrect) {
            try {
                numberOfRounds = scanner.nextInt();
            } catch (InputMismatchException e) {
                scanner.next();
                System.out.println("Please enter valid numeric value");
            }

            if (numberOfRounds > 0) {
                isCorrect = true;
            }
        }

        return numberOfRounds;
    }
}
