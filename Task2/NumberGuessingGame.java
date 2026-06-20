import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        char playAgain;

        do {
            int secretNumber = random.nextInt(100) + 1;
            int maxAttempts = 7;
            int attempts = 0;
            int guess = 0;

            System.out.println("\n===== Number Guessing Game =====");
            System.out.println("I have selected a number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts to guess it.");

            while (attempts < maxAttempts) {

                System.out.print("Enter your guess: ");

                while (!sc.hasNextInt()) {
                    System.out.print("Invalid input! Enter a number: ");
                    sc.next();
                }

                guess = sc.nextInt();
                attempts++;

                if (guess < 1 || guess > 100) {
                    System.out.println("Please enter a number between 1 and 100.");
                } else if (guess < secretNumber) {
                    System.out.println("Too low!");
                } else if (guess > secretNumber) {
                    System.out.println("Too high!");
                } else {
                    System.out.println("Congratulations! You guessed the number in "
                            + attempts + " attempt(s).");
                    break;
                }

                System.out.println("Attempts remaining: " + (maxAttempts - attempts));
            }

            if (guess != secretNumber) {
                System.out.println("Game Over!");
                System.out.println("The correct number was: " + secretNumber);
            }

            System.out.print("Do you want to play again? (Y/N): ");
            playAgain = sc.next().charAt(0);

        } while (playAgain == 'Y' || playAgain == 'y');

        System.out.println("Thank you for playing!");

        sc.close();
    }
}