import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int lowerBound = 1;
        int upperBound = 100;
        int attemptsLimit = 10;
        int rounds = 0;
        int totalAttempts = 0;
        int bestScore = Integer.MAX_VALUE;

        System.out.println("Welcome to the Number Guessing Game!");

        do {
            int numberToGuess = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            int attempts = 0;

            System.out.println("\nRound " + (rounds + 1));
            System.out.println("Guess a number between " + lowerBound + " and " + upperBound);

            while (attempts < attemptsLimit) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                attempts++;

                if (userGuess == numberToGuess) {
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                    totalAttempts += attempts;
                    bestScore = Math.min(bestScore, attempts);
                    break;
                } else if (userGuess < numberToGuess) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            if (attempts == attemptsLimit) {
                System.out.println("Sorry! You've reached the maximum number of attempts. The correct number was " + numberToGuess);
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.nextLine().toLowerCase();

            if (playAgain.equals("yes")) {
                rounds++;
            } else {
                break;
            }

        } while (true);

        System.out.println("\nGame Over!");
        System.out.println("Total rounds played: " + (rounds + 1));
        System.out.println("Total attempts: " + totalAttempts);
        System.out.println("Best Score: " + (bestScore == Integer.MAX_VALUE ? "N/A" : bestScore));
    }
}
