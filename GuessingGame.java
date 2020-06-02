import java.util.Scanner;

public class GuessingGame {

    public static void main(String[] args) {
        while (!winCondition && !quitCondition) {
            int userGuess = getUserGuess();
            didYouWin(userGuess);
        }
        System.out.println("Goodbye!");
    }
    
    final static int randomNum = createRandomNumber();
    static boolean winCondition = false;
    static boolean quitCondition = false;
    static int attempts = 0;
    static Scanner scan = new Scanner(System.in);

    public static final int createRandomNumber() {
        return (int) (Math.random() * 100 + 1);
        // Have to typecast to int because Math.random() returns a double betwen 0.0 and 1.0
    }

    public static int getUserGuess() {
        System.out.println("--- --- ---");
        System.out.println("Provide a number between 1 and 100 or enter 0 to exit program.");
        System.out.println("The correct answer is " + randomNum);
        if (attempts > 0) {
            System.out.println("This is attempt #" + (attempts + 1));
        }
        int guess = scan.nextInt();
        return guess;
    }

    // Overload for testing purposes
    public int getUserGuess(int guess) {
        return guess;
    }

    public static void didYouWin(int guess) {
        if (guess == randomNum) {
            System.out.println("Congrats, you win!");
            winCondition = true;
            scan.close();
        } else if (guess == 0) {
            System.out.println("You quit. See you next time!");
            quitCondition = true;
        } else {
            attempts += 1;
            } if (attempts == 5) {
                System.out.println("You have ran out of attempts. Come back and try another time!");
                quitCondition = true;
            } else if (guess > randomNum) {
                System.out.println("Sorry, your guess is too high. Try again.");
            } else if (guess < randomNum) {
                System.out.println("Sorry, your guess is too low. Try again.");
            }
    }

    // Overload for testing
    public boolean didYouWin(int guess, int testNum) {
        if (guess == testNum) {
            return true;
        } else {
            return false;
        }
    }

    public int getAttempts(int attempts) {
        return attempts;
    }

}