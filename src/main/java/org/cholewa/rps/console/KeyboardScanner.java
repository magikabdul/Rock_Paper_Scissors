package org.cholewa.rps.console;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.stream.Collectors;

public class KeyboardScanner {
    private Scanner scanner = new Scanner(System.in);

    public String processGetSelectionAnyString() {
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
            mySing = processGetSelectionAnyString();
            isCorrect = validateSign(mySing, letters);

            if (!isCorrect) {
                informAboutCorrectSelection(letters);
            }
        }
        return mySing;
    }

    private boolean validateSign(String sign, String[] letters) {
        return Arrays.stream(letters).filter(s -> s.equals(sign)).count() > 0;
    }

    private void informAboutCorrectSelection(String[] letters) {
        System.out.print("Wrong sing, please select again ");
        System.out.println(Arrays.stream(letters).collect(Collectors.joining(",")));
        System.out.print("\n\n");
    }

    public int processGetRoundsNumber() {
        boolean isCorrect = false;
        int numberOfRounds = 0;

        while (!isCorrect) {
            try {
                numberOfRounds = scanner.nextInt();
            } catch (InputMismatchException e) {
                scanner.next();
                System.out.println("Please enter valid numeric value (larger then 0");
            }

            if (numberOfRounds > 0) {
                isCorrect = true;
            }
        }

        return numberOfRounds;
    }
}
