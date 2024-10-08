package test.ui.tests;

import main.ui.page.HomePage;
import main.ui.steps.LoginSteps;
import main.ui.utils.LoadHelper;
import main.ui.utils.Util;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.UnsupportedEncodingException;


public class HomePageTests {

    @Test
    public void loginWithNonLoggedInUser() throws UnsupportedEncodingException, InterruptedException {
        LoginSteps loginSteps = new LoginSteps();
        loginSteps.fillEmailAndSubmit(Util.generateEmail());
        String actualHeaderText = LoadHelper.getTextByLocator(HomePage.registrationByEmailHeaderLocator);
        Assertions.assertEquals(HomePage.expectedHeaderText, actualHeaderText);
        String actualBtnText = LoadHelper.getTextByLocator(HomePage.submitRegistrationBtnLocator);
        Assertions.assertEquals(HomePage.submitRegistrationBtnText, actualBtnText);
    }

    @Test
    public void newUserRegistration() throws UnsupportedEncodingException, InterruptedException {
        LoginSteps loginSteps = new LoginSteps();
        loginSteps.fillRegistrationFormAndSubmit(Util.generateEmail());
        String actualHeaderText = LoadHelper.getTextByLocator(HomePage.thanksForRegistrationHeaderLocator);
        Assertions.assertEquals(HomePage.expectedRegistrationHeaderText, actualHeaderText);
    }

    @Test
    public void incorrectEmailFormatInRegistration() throws UnsupportedEncodingException, InterruptedException {
        LoginSteps loginSteps = new LoginSteps();
        loginSteps.fillRegistrationFormAndSubmit("groenten");
        String actualErrorText = LoadHelper.getTextByLocator(HomePage.incorrectEmailErrorLocator);
        Assertions.assertEquals(HomePage.expectedErrorTextForIncorrectEmail, actualErrorText);
    }
}
