import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GuessingGameTest {

    GuessingGame guessingGame;

    @Before // This method will be run before any of our tests
    public final void setup() {
        guessingGame = new GuessingGame();
    }

    @Test
    public final void testIfRandomNumberIsBetween1And100() {
        int num = GuessingGame.createRandomNumber();
        Assert.assertTrue(num <= 100 && num >= 1);
    }

    @Test
    public final void testDoesUserGuessExist() {
        int guess = guessingGame.getUserGuess(25);
        Assert.assertTrue(guess <= 100 && guess >= 1);
    }

    @Test
    public final void testDidUserWin() {
        int guess = guessingGame.getUserGuess(25);
        Assert.assertTrue(guessingGame.didYouWin(guess, 25));
        Assert.assertFalse(guessingGame.didYouWin(guess, 36));
    }

    @Test
    public final void testIfUserCanQuitTheGame() {
        int guess = guessingGame.getUserGuess(0);
        Assert.assertTrue(guessingGame.didYouWin(guess, 0));
    }

    @Test
    public final void testIfUserIsLimitedTo5Attempts() {
        int attempts = guessingGame.getAttempts(5);
        Assert.assertTrue(attempts <= 5);
    }
    
}