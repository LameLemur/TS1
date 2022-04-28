package lab11;

import lab09.TestCase;
import org.junit.jupiter.api.Test;

public class MoodleE2ETest extends TestCase {
    @Test
    public void e2eTest() {
        new MoodleLoginPage(getDriver())
                .clickLogin()
                .fillUserName("username")
                .fillPassword("password")
                .clickLogin()
                .clickTest()
                .clickAttemptQuiz()
                .clickReattemptQuiz()
                .clickStartAttempt()
                .fillFirstAnswer("Stepan Stransky\nparalelka cislo 106")
                .fillSecondAnswer("86400")
                .selectThirdAnswer("Oberon")
                .selectFourthAnswer("Rumunsko")
                .clickFinish()
                .submitAndFinish()
                .finishReview()
                .clickLogOut()
                .clickContinue();
    }
}
