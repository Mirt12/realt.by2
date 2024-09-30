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
        Util util = new Util();
        loginSteps.fillEmailAndSubmit(Util.generateEmail());
        String actualHeaderText = LoadHelper.getTextByLocator(HomePage.registrationByEmailHeaderLocator);
        Assertions.assertEquals(HomePage.expectedHeaderText, actualHeaderText);
    }

    @Test
    public void loginWithIncorrectLogin() throws UnsupportedEncodingException, InterruptedException {
        LoginSteps loginSteps = new LoginSteps();
        loginSteps.fillLoginFormAndSubmit("GGGGGG", "Mirt@gmail.com");
        String actualErrorText = LoadHelper.getTextByLocator(HomePage.errorLocator);
        Assertions.assertEquals(HomePage.expectedErrorText, actualErrorText);
    }

    @Test
    public void loginWithoutEmail() throws UnsupportedEncodingException, InterruptedException {
        LoginSteps loginSteps = new LoginSteps();
        loginSteps.fillLoginFormAndSubmit("Natalia", "");
        String actualErrorText = LoadHelper.getTextByLocator(HomePage.errorLocator);
        Assertions.assertEquals(HomePage.expectedErrorText, actualErrorText);
    }


}
