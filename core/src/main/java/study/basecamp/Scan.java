package study.basecamp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Scan {
    private static final Logger log = LoggerFactory.getLogger(Scan.class);

    public static Boolean  inputAnswer() {
        log.info("DO YOU WANT TO PLAY GUESS NUMBER GAME?  YES/NO");
        String  answerString;
        Scanner scanner = new Scanner(System.in);
        answerString = scanner.nextLine();
        boolean answer = answerString.equalsIgnoreCase("yes");

        return answer;
    }

    public static int inputGuess() {
        log.info("PLEASE INPUT YOUR GUESS");
        Scanner scanner = new Scanner(System.in);
        int guess = 0;
        try { guess = scanner.nextInt();
        } catch (InputMismatchException e) {
            log.info("INPUT A NUMBER !");
        }
        return guess;
    }

}
